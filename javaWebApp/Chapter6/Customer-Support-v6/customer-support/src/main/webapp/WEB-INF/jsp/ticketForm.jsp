<%--
  Created by IntelliJ IDEA.
  User: andrea
  Date: 24/04/16
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<template:basic pageTitle="Customer-Support" bodyTitle="Create A Ticket">
    <form method="post" action="store.action" enctype="multipart/form-data">
        <input type="hidden" name="action" value="createPost"/>
        <p>
            <label for="subject">
                Subject:
                <input id="subject" name="subject" type="text" value="" required/>
            </label>
        </p>
        <p>
            <label for="comment">Comment:</label>
            <textarea name="comment" id="comment" rows="5" cols="30"></textarea>
        </p>
        <p>
            <label for="attachment">Attachments</label>
            <input type="file" name="attachment" id="attachment"/>
        </p>
        <button type="submit">Create</button>
    </form>
</template:basic>
