
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url var="loginUrl" value="/login" />
<c:url var="cancelUrl" value="/" />
<c:url var="registerUrl" value="/register" />


<div class="row">
	<div class="col-md-4 col-md-offset-4 col-sm-8 col-sm-offset-2">

		<form:errors path="email" />
		<form:errors path="password" />

		<div class="login-form">




			<form:form modelAttribute="siteUser" style="height: 270px"
				method="post">

				<h2 class="text-left">Register</h2>
				<div class="form-group">
					<form:input path="email" type="text" class="form-control"
						placeholder="Email" required="required" />
				</div>

				<div class="form-group">
					<form:input path="password" type="password" class="form-control"
						placeholder="Password" required="required" />
				</div>

				<div class="form-group">
					<div>
						<button id="cancel" type="submit"
							class="btn btn-primary btn-sm cancel" style="width: 100px"
							onclick="location.href='${cancelUrl}'">Cancel</button>


						<button type="submit" id="login" class="btn btn-primary btn-sm"
							style="width: 100px" value="Register">Register</button>
					</div>
				</div>

			</form:form>


		</div>
	</div>
</div>