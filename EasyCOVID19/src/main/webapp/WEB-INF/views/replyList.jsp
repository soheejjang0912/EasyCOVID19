<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en"> 
<jsp:include page="header.jsp"/> 

<table style="width:700px">
	<tr>
		<td>
			${row.name}
			( <fmt:formatDate value="${row.regdate}" pattern="yyyy-MM-dd HH:mm:ss" />)
			<br>
			${row.replytext}
		</td>
	</tr>	
</table>
   
<jsp:include page="footer.jsp"/>    