<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
	function fenye(cpage){
		$("[name='cpage']").val(cpage);
		$("form").submit();
	}
	$(function (){
		var typeId="${map.typeId}"
		var typeIds=typeId.split(",")
		//通过ajax 在后台获取类型列表
		$.ajax({
			url:"/typeList.do",
			type:"post",
			dataType:"json",
			success:function (obj){
				for(var i in obj){
					$("#type_list").append("<input type='checkbox' name='typeId'  value="+obj[i].id+">"+obj[i].typeName)
				}
				//回显操作
				$("[name='typeId']").each(function (){
					for(var j in typeIds){
						if($(this).val()==typeIds[j]){
							$(this).prop("checked",true)
						}
					}
				})
			}
		})
	})
	
	function toAdd(){
		location="/toadd.do";
	}
	function toupd(id){
		location="/toupd.do?id="+id;
	}
	function del(id){
		//ajax 单删
		$.ajax({
			url:"/del.do",
			data:{"id":id},
			type:"post",
			dataType:"json",
			success:function (obj){
				if(obj>0){
					location.reload();
				}
			}
		})
	}
	
	function dels(){
		var ids=$("[name='checkOne']:checked").map(function (){
						return $(this).val()
					}).get().join(",");
			$.ajax({
				url:"/dels.do",
				data:{"ids":ids},
				type:"post",
				dataType:"json",
				success:function (obj){
					if(obj>0){
						location.reload();
					}
				}
			})
		
	}
</script>
</head>
<body>
	<!-- 模糊及分页  模糊有文本框模糊     区间模糊  及下拉框模糊  -->
	<form action="list.do" method="post">
		<input type="hidden" name="cpage">
		商品名称：<input type="text" name="mohu1" value="${map.mohu1 }"></br>
		价格区间：<input type="text" name="price_start" value="${map.price_start }">--<input type="text" name="price_end" value="${map.price_end }"></br>
		品牌:<select name="mohu2">
				<option value="">请选择</option>
				<c:forEach items="${brandList }" var="b">
					<option value="${b.id }" ${b.id==map.mohu2? 'selected':'' } >${b.brandName }</option>
				</c:forEach>
			</select></br>
		类型:<div id="type_list">
			</div>
		<input type="submit" value="搜索">
	</form>
	<table>
			
		<tr>
			<td>
			<input type="checkbox" name="checkAll">
			</td>
			<td>商品名称</td>
			<td>英文名称</td>
			<td>商品品牌</td>
			<td>商品种类</td>
			<td>商品尺寸</td>
			<td>商品单价</td>
			<td>商品数量</td>
			<td>商品标签</td>
			<td>商品图片</td>
			<td>
				<input type="button" value="添加" onclick="toAdd()">
			
			</td>
		</tr>
		<c:forEach items="${list }" var="g">
				<tr>
					<td>
					<input type="checkbox" name="checkOne" value="${g.id }" >
					</td>
					<td>${g.goods_name }</td>
					<td>${g.english_name }</td>
					<td>${g.brand_name }</td>
					<td>${g.type_name }</td>
					<td>${g.goods_size }</td>
					<td>${g.goods_money }</td>
					<td>${g.goods_number }</td>
					<td>${g.goods_taglib}</td>
					<td>
						<img alt="" src="<%=request.getContextPath() %>/${g.goods_pic }" width="100px">
					</td>
					<td>
						<input type="button" value="修改" onclick="toupd(${g.id})">
						<input type="button" value="删除" onclick="del(${g.id})">
					</td>
				</tr>
		</c:forEach>
		<tr>
			<td colspan="11">
				<input type="button" value="批量删除" onclick="dels()">
				<input type="button" value="首页" onclick="fenye(1)">
				<input type="button" value="上一页" onclick="fenye(${pi.isIsFirstPage()?1:pi.getPrePage()})">
				<input type="button" value="下一页" onclick="fenye(${pi.isIsLastPage()?pi.getPages():pi.getNextPage()})">
				<input type="button" value="尾页" onclick="fenye(${pi.getPages()})">
			</td>
		</tr>
	</table>
</body>
</html>