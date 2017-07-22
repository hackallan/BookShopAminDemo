<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>

	<input type="hidden" id="hi" value="no" />
</body>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script>
	$(function() {
		var v = $("#hi").val();
		if (v == "no") {
			$.ajax({
				url : "BookServlet",
				type : "GET",
				dataType:'json',
				data:{'name':'you'},
				success : function(data) {
					 console.log(data);
					 var json=eval(data);
				},
				error : function(e) {
					alert(e);
				}
			});
		}
	})
</script>
</html>