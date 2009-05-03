//dojo

var test = false;
var layout;

var renderGadgets = function() {
	console.log("renderGadgets");
	createGadgetLayout();
};

// layout
var createGadgetLayout = function() {
	gadgetRenderService.getLayout(loadLayout);
};

var loadLayout = function(layoutData) {
	layout = layoutData;
	writeColumn(layoutData.leftGadget, "leftColumn");
	writeColumn(layoutData.middleGadget, "middleColumn");
	writeColumn(layoutData.rightGadget, "rightColumn");
	createGadgets(getGadgets(layoutData))
};

var writeColumn = function(gadgets, columnId) {
	gadgets.each( function(item, index) {
		var id = item.name.toString();
		var gadgetDiv = new Element('div', {
			'class' : 'gadgets-gadget-chrome',
			'id' : id
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

// gadget

var createGadgets = function(gadgetList) {
	var urlbase = 'http://' + document.location.host;
	gadgetList.each( function(item, index) {
		gadgets.createGadget((urlbase + item.relativeUrl).toString());
	});
};

var Gadgets = new Class( {
	initialize : function() {
		this.parentUrl = 'http://' + document.location.host;
	},
	createTestGadget : function(url) {
		test = true;
		gadgetRenderService.renderGadget(url, loadGadget);
	},
	createGadget : function(url) {
		gadgetRenderService.renderGadget(url, loadGadget);
	}
});

var loadGadget = function(gadget) {
	if (test) {
		gadget.name = "testGadget";
	}
	$(gadget.name).innerHTML = gadget.html;
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
