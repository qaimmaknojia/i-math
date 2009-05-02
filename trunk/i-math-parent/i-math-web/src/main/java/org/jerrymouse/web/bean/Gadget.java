package org.jerrymouse.web.bean;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jerrymouse.google.Debugger;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class Gadget extends GadgetInfo {
	private String html;
	private List<String> javascripts;
	private String title;

	private Document document;

	public Gadget() {
		super();
	}

	public Gadget(InputStream in) {
		loadFromInputStream(in);
		init();
	}

	public Gadget(URL url) throws IOException {
		URLConnection httpURLConnection = url.openConnection();
		httpURLConnection.setUseCaches(true);
		loadFromInputStream(httpURLConnection.getInputStream());
		init();
	}

	private void loadFromInputStream(InputStream in) {
		Debugger.log("loadStream..");
		try {
			byte[] str = IOUtils.toByteArray(in);
			IOUtils.closeQuietly(in);

			SAXReader reader = new SAXReader();
			document = reader.read(new ByteArrayInputStream(str));
			// Debugger.log("document:" + document.asXML());

		} catch (IOException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void init() {
		// Debugger.log("init..");
		if (document == null)
			return;
		Element root = document.getRootElement();
		name = root.attribute("id").getText();
		Element pref = root.element("ModulePrefs");
		title = pref.attributeValue("title");
		Element content = root.element("Content");
		html = buildHtml(content.getText());
		javascripts = buildJavascripts(content.getText());

	}

	public List<String> buildJavascripts(String html) {
		List<String> javascripts = new ArrayList<String>();
		Pattern pattern = Pattern.compile("<(?i)script.*?>");
		Matcher matcher = pattern.matcher(html);
		while (matcher.find()) {
			Pattern innerPattern = Pattern.compile("(?i)src=['\"].*?['\"]");
			Matcher innermatcher = innerPattern.matcher(matcher.group());
			if (innermatcher.find()) {
				String stringTemp = innermatcher.group();
				stringTemp = stringTemp.substring(5, stringTemp.length() - 1);
				javascripts.add(stringTemp);
			}

		}
		return javascripts;
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

	public String getHtml() {
		return html;
	}

	public String getTitle() {
		return title;
	}

	public List<String> getJavascripts() {
		return javascripts;
	}

}
