package org.jerrymouse.web.bean;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import org.apache.commons.io.IOUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jerrymouse.google.Debugger;

import com.google.appengine.api.datastore.Key;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Gadget {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key id;

	@NotPersistent
	private String htmlId;
	@Persistent
	private String name;
	@Persistent
	private String nickName;
	@Persistent
	private String relativeUrl;

	@NotPersistent
	private String html;
	@NotPersistent
	private List<String> javascripts;
	@NotPersistent
	private String javascriptSrc;
	@NotPersistent
	private String title;
	@NotPersistent
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
		setJavascriptSrc(buildJavascriptSrc(content.getText()));
	}

	String buildJavascriptSrc(String html) {
		StringBuilder sb = new StringBuilder();
		Pattern pattern = Pattern
				.compile("<script.+?</script>", Pattern.DOTALL);
		Matcher matcher = pattern.matcher(html);
		while (matcher.find()) {
			String jsAll = matcher.group();
			String innerJS = jsAll.substring(jsAll.indexOf(">") + 1, jsAll
					.lastIndexOf("<"));
			sb.append(innerJS);
		}
		return sb.toString();
	}

	List<String> buildJavascripts(String html) {
		List<String> javascripts = new ArrayList<String>();
		Pattern pattern = Pattern.compile("<(?i)script.+?>", Pattern.DOTALL);
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
		rootMap.put("name", name);
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

	public void setJavascriptSrc(String javascriptSrc) {
		this.javascriptSrc = javascriptSrc;
	}

	public String getJavascriptSrc() {
		return javascriptSrc;
	}

	public Key getId() {
		return id;
	}

	public void setId(Key id) {
		this.id = id;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public void setJavascripts(List<String> javascripts) {
		this.javascripts = javascripts;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Gadget(String name, String relativeUrl) {
		this.name = name;
		this.relativeUrl = relativeUrl;
	}

	public Gadget(String name, String nickName, String relativeUrl) {
		super();
		this.name = name;
		this.nickName = nickName;
		this.relativeUrl = relativeUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRelativeUrl() {
		return relativeUrl;
	}

	public void setRelativeUrl(String relativeUrl) {
		this.relativeUrl = relativeUrl;
	}

	public String getHtmlId() {
		if (htmlId == null) {
			htmlId = name
					+ new Integer((int) (Math.random() * 1000)).toString();
		}
		return htmlId;
	}

	public void setHtmlId(String htmlId) {
		this.htmlId = htmlId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

}
