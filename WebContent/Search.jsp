<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>吉他销售</title>
</head>
<body>
<form name="guitarfeature" action="searchguitar" method="post">
<table>
<tr><td>制造商</td><td><input name="builder" type="text"></td></tr>
<tr><td>风格</td><td><input name="model" type="text"></td></tr>
<tr><td>类型</td><td><input name="type" type="text"></td></tr>
<tr><td>后板木材</td><td><input name="backwood" type="text"></td></tr>
<tr><td>前板木材</td><td><input name="topwood" type="text"></td></tr>
<tr><td><input name="submit" type="submit" value="搜索"></td></tr>
</table>
</form>
</body>
</html>