<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <title>Struts Example</title>
</head>
<body>
	<h2><s:text name="thankyou"/></h2>
	<div>
		Your Value are:
		<p>
			<s:property value="personBean"/>
		</p>
		<p><a href="<s:url action='index'/>">Got To Home</a></p>
	</div>
</body>
</html>