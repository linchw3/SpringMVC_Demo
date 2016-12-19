<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h2> ${enginemodel.enginename}</h2> 
  

       
       引擎状态：${enginemodel.enginestate} <br/>
        具体信息：${enginemodel.engineInfo}<br/>
        <br/>
        <a href="${pageContext.request.contextPath}/list">返回列表页</a><br/>

</body>
</html>