<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Struts Example</title>
<s:head id="head"/>
</head>
<body>
	<h1>
		<s:text name="greeting" />
	</h1>
	<p>
		<a href="<s:url action='hello'/>">Say hello </a>
	</p>
	<s:url action="hello" var="helloTo">
		<s:param name="userName">Bruce Phillips</s:param>
	</s:url>
	<p>
		<a href="${helloTo}">Say hello to Bruce Phillips</a>
	</p>

	<p>Get custom hello</p>
	<form action="hello.action" method="post">
		<label for="userName"><s:text name="sayHello"/>:</label>
		<input type="text" name="userName" id="userName"/>
		<input value="Submit" type="submit"/>
	</form>
	<s:url action="registerInput" var="regInput" />
	<p>
		<a href="${regInput}">Go to register</a>
	</p>

	<p>Registro español</p>
	<s:url action="registerInput" var="registerInputLinkES">
		<s:param name="request_locale">es</s:param>
	</s:url>
	<p>
		<a href="${registerInputLinkES}">Por favor, regístrese</a> para
		nuestro sorteo
	</p>
</body>
</html>