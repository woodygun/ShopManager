<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf8">
	<title><spring:message code="label.title" /></title>
</head>
<body>
<h2><a href="/manager/Goods"><spring:message code="label.titlegoods" /></a><spring:message code="label.titlesale" /></h2>

<table>
<tr><td>
<form:form method="post" action="addSale" commandName="sale">
	
	<table>
		<tr>
			<td><form:label path="idGoods">
				<spring:message code="label.idGoods" />
			</form:label></td>
			<td>
			<p><select size="1" name="idGoods">
			<option disabled>Выберите товар</option>
    			<c:forEach items="${goodsList}" var="goods">
    				<option value=${goods.id}>${goods.nomination}</option>
    			</c:forEach>
   			</select></p></td>  
		</tr>
		<tr>
			<td><form:label path="amount">
				<spring:message code="label.amount" />
			</form:label></td>
			<td><form:input path="amount" /></td>
		</tr>
		<tr>
			<td colspan="3"><input type="submit"
				value="<spring:message code="label.addsale"/>" /></td>
		</tr>
	</table>	
</form:form>

<c:if test="${!empty saleList}">
	<table class="data">
		<tr>
			<th><spring:message code="label.nomination" /></th>
			<th><spring:message code="label.amount" /></th>
			<th><spring:message code="label.price" /></th>
			<th><spring:message code="label.data" /></th>
			<th>&nbsp;</th>
		</tr>
		<c:forEach items="${saleList}" var="sale">
			<c:forEach items="${goodsAllList}" var="goods">
				<c:if test="${sale.idGoods eq goods.id}" >
					<tr>
						<td><a href="/manager/Sale${goods.id}">${goods.nomination}</a></td>
						<td>${sale.amount}</td>
						<td>${sale.price}</td>
						<td>${sale.date}</td>
					</tr>
				</c:if>	
			</c:forEach>
		</c:forEach>
	</table>
</c:if>

</td>
<td>
<table>
	<tr>
		<h1>Информация о товарах:</h1>
	</tr>
	<tr>
		<th><spring:message code="label.nomination" /></th>
		<th><spring:message code="label.price" /></th>
	</tr>
	<tr>
		<td>${goods_nomination}</td>
		<td>${goods_price}</td>
	</tr>
</table>
</td></tr>
</table>
</body>
</html>