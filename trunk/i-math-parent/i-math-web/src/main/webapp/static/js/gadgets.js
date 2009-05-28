dojo.require("dojo.parser");
dojo.require("dijit.form.Button");
dojo.require("dijit.Dialog");
dojo.require("dijit.form.ValidationTextBox");
dojo.require("dojox.validate.regexp");
dojo.require("dojox.widget.FisheyeLite");

var $j = jQuery.noConflict();

var test = false;
var mainContainer;
var tabIndex;
var user;
var allGadgets;

var init = function() {
	createGadgetContainer();
	updateSortable();
	initLogin();
};

var renderGadgets = function() {
	//	console.log("renderGadgets");
	gadgetRenderService.getLayout(loadContainer);
};

// container

var createGadgetContainer = function() {
	gadgetRenderService.getContainer(loadContainer);
};

var loadContainer = function(data) {
	mainContainer = data;
	createTabs();
	createTabContainer(0);
};

var createTabs = function() {
	var pos = 0;
	var buf = 135;
	var tabUL = $("tabs");
	var tabs = mainContainer.tabs;
	tabs.each( function(item, index) {
		var tab = new Element('div', {
			'class' : 'headLink'
		});
		tab.setStyle('left', pos + 'px');
		pos += buf;
		var fisheye = new Element('div', {
			'class' : 'fisheyeTarget'
		});
		var inner = new Element('div', {
			'class' : 'inner',
			'text' : item.title
		});

		tab.grab(inner);
		tab.grab(fisheye);
		tabUL.grab(tab);

		tab.addEvent('click', function() {
			createTabContainer(index);
		});
	});
	dojo.query('.headLink').forEach( function(n) {
		new dojox.widget.FisheyeLite( {
			properties : {
				height : {
					end : 42,
					unit : "px"
				}
			}
		}, n);
	});
};

var createTabContainer = function(index) {
	tabIndex = index;
	$('tabs').getChildren().each( function(item, i) {
		item.removeClass('activeTab');
		if (tabIndex == i) {
			item.addClass('activeTab');
		}
	});

	cleancolumns();
	writeColumn(mainContainer.tabs[index].leftGadget, "leftColumn");
	writeColumn(mainContainer.tabs[index].middleGadget, "middleColumn");
	writeColumn(mainContainer.tabs[index].rightGadget, "rightColumn");
	var gadgets = getGadgets(mainContainer.tabs[index]);
	createGadgets(gadgets);
};

// layout

var cleancolumns = function() {
	var left = $("leftColumn").empty();
	var mid = $("middleColumn").empty();
	$("rightColumn").empty();
};

var writeColumn = function(gadgets, columnId) {
	gadgets.each( function(item, index) {
		var gadgetDiv = new Element('li', {
			'class' : 'gadgets-gadget-chrome',
			'id' : item.htmlId
		});
		$(columnId).grab(gadgetDiv);
	});
};

var getGadgets = function(layoutData) {
	var gadgetList = new Array();
	gadgetList.combine(layoutData.leftGadget);
	gadgetList.combine(layoutData.middleGadget);
	gadgetList.combine(layoutData.rightGadget);
	return gadgetList;
};

var getAllGadgets = function() {
	var gadgetList = new Array();
	mainContainer.tabs.each( function(item, index) {
		gadgetList.combine(getGadgets(item));
	});
	return gadgetList;
}

// gadget

var createGadgets = function(gadgetList) {
	var urlbase = 'http://' + document.location.host;
	// getRemoveGadgetData;
	gadgetList.each( function(item, index) {
		if (item.html == null) {
			gadgets.createGadget(item.htmlId, (urlbase + item.relativeUrl)
					.toString());
		} else {
			loadGadget(item);
		}
	});
};

var Gadgets = new Class( {
	initialize : function() {
		this.parentUrl = 'http://' + document.location.host;
	},
	createTestGadget : function(url) {
		gadgetRenderService.renderGadget("test-gadget", url, loadGadget);
	},
	createGadget : function(id, url) {
		gadgetRenderService.renderGadget(id, url, saveLoadGadget);
	}
});

var saveLoadGadget = function(gadget) {
	var htmlId = gadget.htmlId;
	var gadgets = getAllGadgets();
	gadgets.each( function(item, index) {
		if (htmlId == item.htmlId) {
			item.html = gadget.html;
			item.javascripts = gadget.javascripts;
			item.javascriptSrc = gadget.javascriptSrc;
			item.title = gadget.title;
		}
	});
	loadGadget(gadget);
};

var loadGadget = function(gadget) {
	$(gadget.htmlId).innerHTML = gadget.html;
	for ( var i = 0; i < gadget.javascripts.length; i++) {
		loadJS(gadget.javascripts[i]);
	}
	loadJSSrc(gadget.javascriptSrc);
};

var loadJS = function(fileUrl) {
	var oHead = document.getElementsByTagName('HEAD').item(0);
	var oScript = document.createElement("script");
	oScript.type = "text/javascript";
	oScript.src = fileUrl;
	oHead.appendChild(oScript);
};

var loadJSSrc = function(src) {
	var oHead = document.getElementsByTagName('HEAD').item(0);
	var oScript = document.createElement("script");
	oScript.type = "text/javascript";
	oScript.text = src;
	oHead.appendChild(oScript);
};

var gadgets = new Gadgets();

var updateSortable = function() {
	$j(".column").sortable( {
		connectWith : $j('.column'),
		handle : '.gadgets-gadget-title-bar',
		placeholder : 'gadgets-placeholder',
		connectWith : '.column',
		forcePlaceholderSize : true,
		revert : 300,
		delay : 100,
		opacity : 0.8,
		stop : function(e, ui) {
			swichGadget(e, ui);
		}
	});
}

var runEffect = function(str) {
	var obj = $j(str);
	obj.toggle('blind');
};

var initLogin = function() {
	$('loginSubmitBtn').addEvent('click', function() {
		var e = $('loginEmail').value;
		var p = $('loginPassword').value;
		userService.verify(e, p, loginReply);
	});
	$('signInSubmitBtn').addEvent('click', function() {
		var e = $('signInEmail').value;
		var p = $('signInPassword').value;
		var n = $('signInNickName').value;
		userService.signIn(e, n, p, SignInReply);
	});
	$j("#add-content").click( function() {
		runAddGadetsDiv();
	});
	$('ensureAddButton').addEvent('click', function() {
		var s = getSelectNewOne();
		addGadget(s.getProperty('gName'));
	});

};

var loginReply = function(data) {
	if (data == null) {
		$('loginRes').set('text', '您输入的用户名或密码不正确');
	} else {
		user = data;
		var nickName = data.nickName;
		$$('#loginDiv .dijitDropDownButton').setStyle('visibility', 'hidden');
		$$('#loginDiv .dijitDropDownButton').setStyle('width', '0px');

		$('userInfo').set('text', nickName);
		$('userInfo').setStyle('visibility', 'visible');
		$('signOutBtn').setStyle('visibility', 'visible');
		var loginDialog = dijit.byId('loginDialog');
		loginDialog.onCancel();
	}
};

var runAddGadetsDiv = function() {
	$j("#allgadetsDiv").toggle("fold", loadAllGadgets());
};

var loadAllGadgets = function() {
	var d = $('allgadetsDiv').getStyle('display');
	if (d == 'none') {
		gadgetRenderService.getAllGadgets(replyAllGadgets);
	}
};
// 
var replyAllGadgets = function(data) {
	$("allgadetsUl").empty();
	allGadgets = data;
	data.each( function(item, index) {
		var newGadget = new Element('li', {
			'class' : 'newGadget ui-state-default',
			'text' : item.nickName,
			'gName' : item.name
		});
		newGadget.addEvent('click', function() {
			var select = getSelectNewOne();
			if (select != null)
				select.removeClass('ui-state-active');
			newGadget.addClass('ui-state-active');
		});
		$("allgadetsUl").grab(newGadget);
	});
};

var getSelectNewOne = function() {
	var s;
	$("allgadetsUl").getChildren().each( function(item, index) {
		var myProp = item.getProperty('class');
		if (item.hasClass('ui-state-active')) {
			s = item;
		}
	});
	return s;
};

var addGadget = function(str) {
	var vNum = Math.random() * 1000;
	vNum = Math.round(vNum);
	var id = str + vNum;
	var url;
	allGadgets.each( function(item, index) {
		if (item.name == str)
			url = item.relativeUrl;
	});

	var gadgetDiv = new Element('li', {
		'class' : 'gadgets-gadget-chrome',
		'id' : id
	});
	$("leftColumn").grab(gadgetDiv);
	var parentUrl = 'http://' + document.location.host;
	gadgetRenderService.renderGadget(id, parentUrl + url, loadGadget);
};

var SignInReply = function(data) {
	user = data;
	var nickName = data.nickName;
	$$('#loginDiv .dijitDropDownButton').setStyle('visibility', 'hidden');
	$$('#loginDiv .dijitDropDownButton').setStyle('width', '0px');

	$('userInfo').set('text', nickName);
	$('userInfo').setStyle('visibility', 'visible');
	$('signOutBtn').setStyle('visibility', 'visible');
	var loginDialog = dijit.byId('signInDialog');
	loginDialog.onCancel();
};

var colseGadget = function(id) {
	var g = $(id);
	var selectedEffect = 'scale';
	var options = {
		percent : 0
	}
	$j('#' + id).hide(selectedEffect, options, 500);
};

var swichGadget = function(e, ui) {
	var g = ui.item;
	var id = ui.item.attr('id');
	var from = e.target;
	var to = getGadgetFromHtml(id);

	var gModel = getGadgetMode(id, getGadgetFromName(from.getProperty('id')));

	modelAdd(gModel, getGadgetFromName(to.getProperty('id')));

	modelRemove(id, getGadgetFromName(from.getProperty('id')));
};

var getGadgetMode = function(id, container) {
	for ( var i = 0; i < container.length; i++) {
		var item = container[i];
		if (item.htmlId == id) {
			return item;
		}
	}
};

var getGadgetFromName = function(str) {
	var tab = mainContainer.tabs[tabIndex];
	if (str == 'leftColumn')
		return tab.leftGadget;
	if (str == 'middleColumn')
		return tab.middleGadget;
	if (str == 'rightColumn')
		return tab.rightGadget;
};

var getGadgetFromHtml = function(id) {
	var to;
	to = seachGadgetIn('leftColumn', id);
	if (to != null) {
		return to;
	}
	to = seachGadgetIn('middleColumn', id);
	if (to != null) {
		return to;
	}
	to = seachGadgetIn('rightColumn', id);
	if (to != null) {
		return to;
	}
};

var seachGadgetIn = function(str, id) {
	var list = $(str).getChildren();
	if (list != null) {
		for ( var i = 0; i < list.length; i++) {
			var nid = list[i].getProperty('id');
			if (nid == id)
				return $(str);
		}
	}
	return null;
};
var updateModel = function() {
	var tab = mainContainer.tabs[tabIndex];
	updateColumn('leftColumn', tab.leftGadget);
	updateColumn('middleColumn', tab.middleGadget);
	updateColumn('rightColumn', tab.rightGadget);
};

var updateColumn = function(name, column) {
	var list = $(name).getChildren();
	if (list != null) {
		for ( var i = 0; i < list.length; i++) {
			var id = list[i].getProperty('id');
			if (!modelHas(id, column)) {
				modelAdd(id, column);
			}
		}
	}
	if (column != null) {
		for ( var i = 0; i < column.length; i++) {
			var item = column[i];
			var id = item.htmlId;
			if (!viewHas(name, id)) {
				modelRemove(id, column);
			}
		}
	}
};

var modelHas = function(id, model) {
	var v = false;
	if (model == null)
		return false;
	model.each( function(item, index) {
		if (item.htmlId == id) {
			v = true;
		}
	});
	return v;
};

var viewHas = function(name, id) {
	var v = false;
	$(name).getChildren().each( function(item, index) {
		var hId = item.getProperty('id');
		if (hId == id) {
			v = true;
		}
	});
	return v;
};

var modelAdd = function(newG, model) {
	var g = new Object();
	g.htmlId = newG.htmlId;
	g.name = newG.name;
	g.nickName = newG.nickName;
	g.relativeUrl = newG.relativeUrl;
	model.push(g);
};

var modelRemove = function(id, model) {
	for ( var i = 0; i < model.length; i++) {
		var item = model[i];
		if (item.htmlId == id) {
			model.erase(item);
		}
	}
};

var getFromMainContainer = function(id) {
	var gs = getAllGadgets();
	for ( var i = 0; i < gs.length; i++) {
		var item = gs[i];
		if (item.htmlId == id) {
			return item;
		}
	}
};
