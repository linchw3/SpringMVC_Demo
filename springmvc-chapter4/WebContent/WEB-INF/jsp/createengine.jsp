<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>create a new engine</title>
</head>
<body>
<form:form modelAttribute="enginemodel" method="post">     
        引擎名字：<form:input path="enginename"/><br/>
        引擎状态：<form:input path="enginestate"/><br/>
        具体信息：<form:input path="engineInfo"/><br/>
        <input type="submit" value="Submit" />
    </form:form>  
</body>
</html>