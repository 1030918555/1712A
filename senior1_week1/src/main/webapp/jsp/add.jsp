<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="/add.do" method="post" modelAttribute="goods" enctype="multipart/form-data" >
		商品名称：<form:input path="goodsName"/>
		<form:errors path="goodsName"></form:errors>
		<br>
		商品英文名称：<form:input path="englishName"/><br>
		商品尺寸：<form:input path="goodsSize"/><br>
		商品价格：<form:input path="goodsMoney"/><br>
		商品数量:<form:input path="goodsNumber"/>
		<form:errors path="goodsNumber"></form:errors><br>
		商品标签:<form:input path="goodsTaglib"/><br>
		商品图片：<input type="file" name="file"><br>
		商品品牌：<form:select path="goodsBrand.id">
					<form:option value="">请选择</form:option>
					<form:options items="${brandList }" itemValue="id" itemLabel="brandName"/>
				</form:select>
				<form:errors path="goodsBrand.id"></form:errors>
				<br> 
		商品类型：<form:select path="goodsType.id">
					<form:option value="">请选择</form:option>
					<form:options items="${typeList }" itemValue="id" itemLabel="typeName"/>
				</form:select>
				<form:errors path="goodsType.id"></form:errors>
				<br>
		<input type="submit" value="提交">
	</form:form >
</body>
</html>