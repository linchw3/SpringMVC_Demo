<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Engine list page</title>
</head>
<body>

<table border="1" width="50%">
   <tr>
      <th>引擎名字</th>
      <th>状态</th>
      <th>操作</th>
   </tr> 
   <c:forEach items="${engineList}" var="engine">
   <tr>
      <td>${engine.enginename }</td>
      
      <td>${engine.enginestate }</td>
      <td>
          <a href="${pageContext.request.contextPath}/info/${engine.enginename}">详情</a>
          <a href="${pageContext.request.contextPath}/update/${engine.enginename}">更新</a>
          <a href="${pageContext.request.contextPath}/delete/${engine.enginename}">删除</a>
      </td>
   </tr>
   </c:forEach>   
</table>
<br/>
<a href="${pageContext.request.contextPath}/create">用户新增</a><br/>
</body>
</html>