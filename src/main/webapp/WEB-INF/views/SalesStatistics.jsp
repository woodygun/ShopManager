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
	<a href="/manager/Discounts"><spring:message code="label.DiscountsHistory" /></a>
	<spring:message code="label.titleSalesStatistics" />
</h2>

<c:if test="${!empty SalesStatisticsList}">
	<table class="data" border="1">
		<tr bgcolor=label.CapTablesColor>
			<th><spring:message code="label.SalesStatisticsSalesStart" /></th>
			<th><spring:message code="label.SalesStatisticsSalesEnd" /></th>
			<th><spring:message code="label.SalesStatisticsAmount" /></th>
			<th><spring:message code="label.SalesStatisticsChecksTotalValue" /></th>
			<th><spring:message code="label.SalesStatisticsChecksAverageValue" /></th>
			<th><spring:message code="label.SalesStatisticsAmountOfDiscounts" /></th>
			<th><spring:message code="label.SalesStatisticsChecksDiscountsTotalValue" /></th>
			<th><spring:message code="label.SalesStatisticsChecksDiscountsAverageValue" /></th>
		</tr>
		<c:forEach items="${SalesStatisticsList}" var="SalesStatistics">
			<tr>
				<td>${SalesStatistics.salesStart}</td>
				<td>${SalesStatistics.salesEnd}</td>
				<td>${SalesStatistics.amount}</td>
				<td>${SalesStatistics.checksTotalValue}</td>
				<td>${SalesStatistics.checksAverageValue}</td>
				<td>${SalesStatistics.amountOfDiscounts}</td>
				<td>${SalesStatistics.checksDiscountsTotalValue}</td>
				<td>${SalesStatistics.checksDiscountsAverageValue}</td>
			</tr>
		</c:forEach>
	</table>
</c:if>

</body>
</html>