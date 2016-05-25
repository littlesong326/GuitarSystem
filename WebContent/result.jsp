<%@ page import="java.util.*"%>  
<%@ page import="java.sql.*" %>  

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%  
        Class.forName("org.sqlite.JDBC");//加载驱动  
        Connection conn =  DriverManager.getConnection("jdbc:sqlite:GuitarSystem.db");//建立连接  
        Statement stmt = conn.createStatement();//创建执行者  
        ResultSet rs = stmt.executeQuery("select * from guitars ");//返回结果集（游标）  
    %>  
  
    <table cellpadding="0" cellspacing="0" border="1" width="500" >  
        <%  
            while (rs.next()) {  
        %>  
            <tr>  
                <td><%=rs.getString(1) %></td>  
                <td><%=rs.getString(2) %></td>  
            </tr>  
        <%  
            }  
        %>  
    </table>  
</body>
</html>