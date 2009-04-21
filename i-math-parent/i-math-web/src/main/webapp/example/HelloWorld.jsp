<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title><s:text name="HelloWorld.message" /></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>
<h2><s:property value="message" /></h2>

<h3>Languages</h3>
<ul>
	<li><s:url id="url" action="HelloWorld">
		<s:param name="request_locale">en</s:param>
	</s:url> <s:a href="%{url}">English</s:a></li>
	<li><s:url id="url" action="HelloWorld">
		<s:param name="request_locale">zh_CN</s:param>
	</s:url> <s:a href="%{url}">CHINA</s:a></li>
</ul>

</body>
</html>
