<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title><tiles:insertAttribute name="title" /></title>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<link href="${contextRoot}/css/bootstrap.min.css" rel="stylesheet">
<link href="${contextRoot}/css/main.css" rel="stylesheet">


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="${contextRoot}/js/bootstrap.min.js"></script>

</head>


<body>
	<!-- Static navbar copied from bootstrap 3.3.6 -->
	<nav class="navbar navbar-default navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>

				<a class="navbar-brand" href="/">Spring Boot Tutorial</a>
			</div>


			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="${contextRoot}/">Home</a></li>
					<li><a href="${contextRoot}/about">About</a></li>

				</ul>

				<ul class="nav navbar-nav navbar-right">


					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">Status <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="${contextRoot}/addstatus">Add Status</a></li>
								<li><a href="${contextRoot}/viewstatus">View Status</a></li>
							</ul></li>
					</sec:authorize>


					<sec:authorize access="isAuthenticated()">
						<li><a href="javascript:$('#logoutForm').submit();">Logout</a></li>
					</sec:authorize>

					<sec:authorize access="!isAuthenticated()">
						<li><a href="/login">Login</a></li>
						<li><a href="/register">Register</a></li>
					</sec:authorize>

				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>

	<!--  /logout is predefined by spring. to log out you ned to submit csrf token as well  -->
	<c:url var="logoutLink" value="/logout" />
	<form id="logoutForm" method="post" action="${logoutLink}">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>



	<div class="container">

		<!--  check this out from apache tiles website -->
		<!--  this variates the content according to the tiles  -->
		<tiles:insertAttribute name="content" />

	</div>
</body>
</html>