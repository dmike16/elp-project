<!DOCTYPE HTML>
<html>
<head>
<title>Add Product Form</title>
<style type="text/css">@import url(css/main.css);</style>
</head>
<body>

<div id="global">
<c:if test="${errors ne null}">
	<ul>
		<c:forEach var="error" items="${errors}">
			<li>${error}</li>
		</c:forEach>
	</ul>
</c:if>
<form action="product_save.action" method="post">
    <fieldset>
        <legend>Add a product</legend>
            <p>
                <label for="title">Title: </label>
                <input type="text" id="title" name="title" 
                    tabindex="1" value="${product.name}">
            </p>
            <p>
                <label for="isbn">ISBN: </label>
                <input type="text" id="isbn" 
                    name="isbn" tabindex="2" value="${product.description}">
            </p>
            <p>
                <label for="author">Author: </label>
                <input type="text" id="author" 
                    name="author" tabindex="3" value="${product.author}">
            </p>
            <p>
                <label for="price">Price: </label>
                <input type="text" id="price" name="price" 
                    tabindex="4" value="${product.price}">
            </p>
            <p id="buttons">
                <input id="reset" type="reset" tabindex="4">
                <input id="submit" type="submit" tabindex="5" 
                    value="Add Product">
            </p>
    </fieldset>
</form>
</div>
</body>
</html>
