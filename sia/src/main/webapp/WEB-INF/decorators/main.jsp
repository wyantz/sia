<%
	request.setAttribute("contextName", request.getServletContext().getContextPath());
%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<!-- main.jsp //-->
<html>
<head>
	<title>SIA - <decorator:title/></title>
	<link rel="stylesheet" href="${contextName}/assets/bootstrap/css/bootstrap.min.css">
	<script src="${contextName}/assets/jquery/jquery-3.3.1.min.js"></script>
	<script src="${contextName}/assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="${contextName}/assets/js/default.js"></script>
	
	<decorator:head/>
</head>
<body>
	<div class="container">
		<div class="col-lg-6">Header</div>
		<div class="col-lg-6">
			<sec:authentication property="principal.username"/>&nbsp;|&nbsp;
			<sec:authorize access="isAuthenticated()"><a href="${contextName}/j_spring_security_logout">Logout</a></sec:authorize>
		</div>
	</div>
	<decorator:body/>
	<div>Copyright</div>
</body>
</html>