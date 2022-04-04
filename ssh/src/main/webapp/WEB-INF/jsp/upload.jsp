<%--
  Created by IntelliJ IDEA.
  User: ljh
  Date: 2022/4/4
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Upload</title>
</head>
<body>
<section>
    <form action="/upload" method="post" enctype="multipart/form-data">
        <label for="file">选择文件：</label>
        <input id="file" type="file" name="file">
        <input type="submit" value="upload">
    </form>
</section>
<section>
    <form action="/upload2" method="post" enctype="multipart/form-data">
        <label for="file2">选择文件：</label>
        <input id="file2" type="file" name="file">
        <input type="submit" value="upload">
    </form>
</section>
</body>
</html>
