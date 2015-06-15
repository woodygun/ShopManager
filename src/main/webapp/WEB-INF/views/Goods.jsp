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
<h2><spring:message code="label.titlegoods" /><a href="/manager/Sale"><spring:message code="label.titlesale" /></a></h2>

<table>
<tr>
<td>
<form:form method="post" action="addGoods" commandName="goods">
	
	<table>
		<tr>
			<td><form:label path="nomination">
				<spring:message code="label.nomination" />
			</form:label></td>
			<td><form:input path="nomination" /></td>
		</tr>
		<tr>
			<td><form:label path="price">
				<spring:message code="label.price" />
			</form:label></td>
			<td><form:input path="price" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit"
				value="<spring:message code="label.addgoods"/>" /></td>
		</tr>
	</table>	
</form:form>

	
<c:if test="${!empty goodsList}">
	<table class="data">
		<tr>
			<th><spring:message code="label.nomination" /></th>
			<th><spring:message code="label.price" /></th>
			<th></th>
			<th></th>
			<th><spring:message code="label.nomination" /></th>
			<th><spring:message code="label.price" /></th>
			<th>&nbsp;</th>
		</tr>
		<c:forEach items="${goodsList}" var="goods">
			<form:form method="post" action="updateGoods/${goods.id}" commandName="goods">
			<tr>
				<td><a href="/manager/Goods${goods.id}">${goods.nomination}</a></td>
				<td>${goods.price}</td>
				<td><a href="deleteGoods/${goods.id}"><spring:message code="label.delete" /></a></td>
				<td><input type="submit" value="<spring:message code="label.update"/>" /></td>
				<td><form:input path="nomination" /></td>
				<td><form:input path="price" /></td>
			</tr>
			</form:form>
		</c:forEach>	
	<tr>
	
    <c:forEach begin="1" end="${maxPages}" step="1" varStatus="i">            
		<c:choose>
            <c:when test="${page == i.index}">
                <span>${i.index}</span>
            </c:when>
            <c:otherwise>
                <c:url value="/GoodsPage" var="url">
                    <c:param name="page" value="${i.index}"/>
                </c:url>
                <a href='<c:out value="${url}" />'>${i.index}</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>
	
	</tr>		
	</table>
</c:if>
</td>
<td>
<c:if test="${!empty saleGoodsList}">
<h1>Информация о продажах ${goodsInfoList}</h1>
	<table class="data">
		<tr>
			<th><spring:message code="label.amount" /></th>
			<th><spring:message code="label.price" /></th>
			<th>&nbsp;</th>
		</tr>
		<c:forEach items="${saleGoodsList}" var="sale">
					<tr>
						<td>${sale.amount}</td>
						<td>${sale.price}</td>
					</tr>
		</c:forEach>
	</table>
</c:if>
</td>
</tr>
</table>
</body>
</html>