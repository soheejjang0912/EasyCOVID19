<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
	
<body>
	<br>
	<h3>👩👨댓글🧑👧</h3>
	<br>
	<table style="width: 700px">
		<c:forEach var="row" items="${list}">
			<tr>
				<td>
					🧑 : ${row.name} (<fmt:formatDate value="${row.regdate}"
						pattern="yyyy-MM-dd HH:mm:ss" />)
						<br> ${row.replytext}<br>
				</td> 
			</tr>
			
		</c:forEach> 
	</table>
	<br>
</body>
</html>