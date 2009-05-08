package org.jerrymouse.web.bean;

import java.util.List;

import junit.framework.TestCase;

public class GadgetTest extends TestCase {
	Gadget gadget;

	public void setUp() throws Exception {
		gadget = new Gadget();
	}

	public void testBuildJavascripts() throws Exception {
		String html = "\n<script type=\"text/javascript\" src=\"/dwr/interface/addService.js\"></script>\n<script type=\"text/javascript\">var addGadgetReply = function(data) { \n	$('addGadgetC').set('text', data); \n}\n</script>\n<script type=\"text/javascript\"\n\tsrc=\"/gadgets/add-gadget/js/add-gadget.js\"></script>\n<input type=\"text\" title=\"Will be converted to: double\" id=\"p00\" value=\"0.0\" size=\"10\" class=\"itext\">+<input type=\"text\" title=\"Will be converted to: double\" id=\"p01\" value=\"0.0\" size=\"10\" class=\"itext\">=";
		List<String> javascripts = gadget.buildJavascripts(html);
	}

	public void testBuildJavascriptSrc() throws Exception {
		String html = "\n<script type=\"text/javascript\" src=\"/dwr/interface/addService.js\"></script>\n<script type=\"text/javascript\">var addGadgetReply = function(data) { \n	$('addGadgetC').set('text', data); \n}\n</script>\n<script type=\"text/javascript\"\n\tsrc=\"/gadgets/add-gadget/js/add-gadget.js\"></script>\n<input type=\"text\" title=\"Will be converted to: double\" id=\"p00\" value=\"0.0\" size=\"10\" class=\"itext\">+<input type=\"text\" title=\"Will be converted to: double\" id=\"p01\" value=\"0.0\" size=\"10\" class=\"itext\">=";
		String javascripts = gadget.buildJavascriptSrc(html);
	}
}
