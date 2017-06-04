<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <title>Struts Example</title>
    <s:head/>
</head>
<body>
	<h3>Get Person</h3>
    <s:form action="person" validate="true">
    	<s:textfield key="personBean.userName"/>
    	<s:textfield key="personBean.email"/>
    	<s:textfield key="personBean.age"/>
    	<s:select key="personBean.sport" list="sports"/>
    	<s:radio key="personBean.gender" list="genders"/>
    	<s:select key="personBean.residency" list="states" listKey="abbr" listValue="name"/>
    	<s:checkbox key="personBean.over21"/>
    	<s:checkboxlist key="personBean.carModels" list="carModels"/>
    	<s:submit key="submit"/>
    </s:form>
</body>
</html>