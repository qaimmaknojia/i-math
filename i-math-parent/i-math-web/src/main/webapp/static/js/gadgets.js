//dojo
dojo.require("dojox.widget.FisheyeLite");
dojo.require("dojox.fx.easing");

var test = false;
var mainContainer;

var init = function() {
	createGadgetContainer();
	updateSortable();
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
	var tabUL = $("tabs");
	var tabs = mainContainer.tabs;
	tabs.each( function(item, index) {
		var tab = new Element('li', {
			'text' : item.title
		});
		tabUL.grab(tab);
//		new dojox.widget.FisheyeLite( {
//			properties : {
//				fontSize : 1.75
//			},
//			easeOut : dojox.fx.easing.backInOut,
//			durationOut : 500
//		}, tab);
		tab.addEvent('click', function() {
			createTabContainer(index);
		});
	});
};

var createTabContainer = function(index) {
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
		forcePlaceholderSize : true,
		revert : 300,
		delay : 100,
		opacity : 0.8,
	});
}