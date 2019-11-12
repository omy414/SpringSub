<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {

		$("h1").click(function() {
			/* $.ajax({    //XML 파싱방법
				url : "menu.get",
				success : function(xml) {
					$(xml).find("menu").each(function(i, m) { //each(function()) 반복문
						var name = $(this).find("m_name").text();
						var price = $(this).find("m_price").text();
						$(".menu").append(name);
						$(".menu").append(price);
					});
				}
			}); */
			
			$.ajax({ //json파싱방법
				url : "menu.get",
				success : function(json) {
					var ar = json.menu;
					$.each(ar, function(i,m){
						/* alert(ar[i].m_name);
						alert(m.m_price); */
						$("table").append(ar[i].m_name);
						$("table").append(m.m_price+"<br>");
					});
				}
			})
		});
	});
</script>
</head>
<body>
	<h1>Hello world!</h1>
	<table border="3px solid" width="800px;" height="1000px;">
		<c:forEach var="m" items="${menus}">
			<h1>${m.m_name}
				:
				<fmt:formatNumber value="${m.m_price}" type="currency" />
			</h1>
			<br>
		</c:forEach>
	</table>
	
	<div class="menu"></div>
</body>
</html>