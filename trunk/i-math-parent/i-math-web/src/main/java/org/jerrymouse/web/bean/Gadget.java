package org.jerrymouse.web.bean;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class Gadget {
	private String id;
	private String html;
	private String title;

	private Document document;

	public Gadget(InputStream in) {
		loadFromInputStream(in);
		init();
	}

	public Gadget(URL url) throws IOException {
		this(url.openStream());
	}

	private void loadFromInputStream(InputStream in) {
		try {
			SAXBuilder builder = new SAXBuilder();
			document = builder.build(in);
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void init() {
		if (document == null)
			return;
		Element module = document.getRootElement();
		id = module.getAttributeValue("id");
		Element modulePrefs = module.getChild("ModulePrefs");
		title = modulePrefs.getAttributeValue("title");
		Element content = module.getChild("Content");
		html = buildHtml(content.getText());
	}

	private String buildHtml(String text) {
		Reader reader = null;
		Map<String, String> rootMap = new HashMap<String, String>();
		rootMap.put("title", title);
		rootMap.put("content", text);
		StringWriter out = null;
		String html = null;
		try {
			out = new StringWriter();
			reader = new InputStreamReader(this.getClass().getResourceAsStream(
					"/org/jerrymouse/gadget-template.flt"));
			Template t = new Template("gadget-template", reader,
					new Configuration());
			t.process(rootMap, out);
			html = out.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(reader);
			IOUtils.closeQuietly(out);

		}
		return html;
	}

	private void loadFromFile(File file) {
		try {
			SAXBuilder builder = new SAXBuilder();
			document = builder.build(file);
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getId() {
		return id;
	}

	public String getHtml() {
		return html;
	}

	public String getTitle() {
		return title;
	}

}
