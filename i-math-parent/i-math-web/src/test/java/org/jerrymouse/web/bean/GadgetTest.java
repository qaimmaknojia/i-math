package org.jerrymouse.web.bean;

import static org.junit.Assert.*;

import java.io.File;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

import org.jerrymouse.util.ApplicationContextAwareImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GadgetTest {
	Gadget gadget;

	@Before
	public void setUp() throws Exception {
		gadget = new Gadget();
	}

	@Test
	public void testBuildJavascripts() throws Exception {
		String html = "\n<script type=\"text/javascript\" src=\"/dwr/interface/addService.js\"></script>\n<script type=\"text/javascript\">var addGadgetReply = function(data) { \n	$('addGadgetC').set('text', data); \n}\n</script>\n<script type=\"text/javascript\"\n\tsrc=\"/gadgets/add-gadget/js/add-gadget.js\"></script>\n<input type=\"text\" title=\"Will be converted to: double\" id=\"p00\" value=\"0.0\" size=\"10\" class=\"itext\">+<input type=\"text\" title=\"Will be converted to: double\" id=\"p01\" value=\"0.0\" size=\"10\" class=\"itext\">=";
		List<String> javascripts = gadget.buildJavascripts(html);
	}

	@Test
	public void testBuildJavascriptSrc() throws Exception {
		String html = "\n<script type=\"text/javascript\" src=\"/dwr/interface/addService.js\"></script>\n<script type=\"text/javascript\">var addGadgetReply = function(data) { \n	$('addGadgetC').set('text', data); \n}\n</script>\n<script type=\"text/javascript\"\n\tsrc=\"/gadgets/add-gadget/js/add-gadget.js\"></script>\n<input type=\"text\" title=\"Will be converted to: double\" id=\"p00\" value=\"0.0\" size=\"10\" class=\"itext\">+<input type=\"text\" title=\"Will be converted to: double\" id=\"p01\" value=\"0.0\" size=\"10\" class=\"itext\">=";
		String javascripts = gadget.buildJavascriptSrc(html);
	}
}
