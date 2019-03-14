
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

		<div class="login-form">

			<form action="${loginUrl}" method="post">

				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />

				<h2 class="text-left">Log in</h2>
				<div class="form-group">
					<input name="username" type="text" class="form-control"
						placeholder="Username" required="required">
				</div>
				<div class="form-group">
					<input name="password" type="password" class="form-control"
						placeholder="Password" required="required">
				</div>
				<div class="form-group">
					<div>
						<button id="cancel" type="submit"
							class="btn btn-primary btn-sm cancel" style="width: 100px"
							onclick="location.href='${cancelUrl}'">Cancel</button>
						<button id="login" type="submit" class="btn btn-primary btn-sm"
							style="width: 100px">Log in</button>
					</div>
				</div>

				<div class="clearfix" style="display: inline">
					<label class="pull-left checkbox-inline"> <input
						type="checkbox"> Remember me
					</label> <a href="#" class="pull-right"> Forgot Password?</a>
				</div>


				<div class="loginerror">
					<c:if test="${param.error != null}">
						<div class="loginerror">Incorrect username or password!</div>
					</c:if>
				</div>
			</form>
			<p class="text-center">
				<a href="${registerUrl}">Create an Account</a>
			</p>
		</div>



	</div>
</div>

