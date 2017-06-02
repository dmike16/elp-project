<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Struts Example</title>
</head>
<body>
    <h2>
    	<s:property value="messageStore.message"/>
    </h2>
    <p>
    	<s:property value="messageStore"/>
    </p>
</body>
</html>