<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div class="row">
	<div class="col-md-8 col-md-offset-2">

		<div class="panel panel-default">
			<div class="panel-heading">
				<div class="panel-title">Edit Status Update</div>
			</div>

			<div class="panel-body">
				<form:form modelAttribute="statusUpdate">
					<!-- hidden input control -->

					<form:input type="hidden" path="id" />
					<form:input type="hidden" path="added" />

					<!--Spring error message -->
					<div class="errors">
						<form:errors path="text">
						</form:errors>
						<form:errors path="id">
						</form:errors>
						<form:errors path="added">
						</form:errors>
					</div>

					<div class="form-group">
						<form:textarea path="text" rows="30" cols="50" name="text"></form:textarea>
					</div>

					<input type="submit" name="submit" value="Add Status" />
				</form:form>
			</div>
		</div>
	</div>
</div>



<script src="https://cloud.tinymce.com/5/tinymce.min.js"></script>
<script>
	tinymce.init({
		selector : 'textarea',
		plugins : 'link'

	});
</script>
