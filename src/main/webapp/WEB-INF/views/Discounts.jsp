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
<h2>
	<a href="/manager/Goods"><spring:message code="label.titlegoods" /></a>
	<a href="/manager/Sale"><spring:message code="label.titlesale" /></a>
	<spring:message code="label.DiscountsHistory" />
</h2>

<c:if test="${!empty DiscountsHistoryList}">
<h1>Информация о скидках</h1>
	<table class="data" border="1">
		<tr bgcolor=label.CapTablesColor>
			<th><spring:message code="label.DiscountsGoods" /></th>
			<th><spring:message code="label.DiscountsAmount" /></th>
			<th><spring:message code="label.DiscountsDateStart" /></th>
			<th><spring:message code="label.DiscountsDateFinish" /></th>
		</tr>
		<c:forEach items="${DiscountsHistoryList}" var="Discounts">
					<tr>
						<td>
							<c:forEach items="${goodsAllList}" var="goods">
								<c:if test="${Discounts.idGoods eq goods.id}" >
							${goods.nomination}
								</c:if>
							</c:forEach>
						</td>
						<td>${Discounts.discountAmount}%</td>
						<td>${Discounts.pricesStart}</td>
						<td>${Discounts.pricesEnd}</td>
					</tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>