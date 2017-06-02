<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Struts Example</title>
</head>
<body>
    <h1>Welcome to Struts 2</h1>
    <p><a href="<s:url action='hello'/>">Say hello
    </a></p>
    <s:url action="hello" var="helloTo">
    	<s:param name="userName">Bruce Phillips</s:param>
    </s:url>
    <p>
    	<a href="${helloTo}">Say hello to Bruce Phillips</a>
    </p>
    
    <p>Get custom hello</p>
    <s:form action="hello">
    	<s:textfield name="userName" label="Your Name"/>
    	<s:submit value="Submit"/>
    </s:form>
</body>
</html>