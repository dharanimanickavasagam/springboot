<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div class="row">
	<div class="col-md-8 col-md-offset-2">

		<!--   
			To understand how the communication happens between the JSP and PageController, un-comment this
				
				1) When a .jsp is compiled, its converted to a .javaclass and a java obj is created for the .jsp
				
				2) In PageController.java, there is a GET Request and POST Request
				
				3) In both of these there is a statusUpdate Object added to the Model 
				
				4) When the .jsp is converted to a java object, everything inside the jsp will be run via a method. 
				   This method will contain some parameters, such as request,session etc. 
				   There are implicit objects
				   
				5) These implicit objects can be directly accessed within .jsp file
			
				6) request can be used to get the parameters that are part of the page which 
				   persists for a single request
				   
				7) When statusUpdate is added to the model, it ends up storing up in the request object 
				
							 
				Request statusUpdate attribute :
				<%=request.getAttribute("statusUpdate")%>
				<br/>
				
				JSP object :
				<%=this%>
				<br/> 
			-->

		<div class="panel panel-default">

			<div class="panel-heading">
				<div class="panel-title">Add a Status Update</div>
			</div>

			<div class="panel-body">


				<!--  Name of the model attribute under which the form object is exposed, 
					this is returned to the POST method of the form	 -->

				<form:form modelAttribute="statusUpdate">

					<!--Spring error message -->
					<div class="errors">
						<form:errors path="text">
						</form:errors>
					</div>

					<div class="form-group">

						<!--  path name should be the exact name of the setter method
							Here its getText(), so ignore get and convert T to small t 
							so finally it is text -->
						<form:textarea path="text" rows="30" cols="50" name="text"></form:textarea>

					</div>

					<input type="submit" name="submit" value="Add Status" />

				</form:form>
			</div>
		</div>


		<!--  latest status update -->
		<div class="panel panel-default">

			<div class="panel-heading">
				<div class="panel-title">
					Last Updated Status :
					<fmt:formatDate pattern="EEEE d MMMM YYYY 'at' HH:MM:s"
						value="${latest.added}" />
				</div>
			</div>

			<div class="panel-body">
				<!-- <c:out value="${latest.text}" /> -->
				${latest.text}
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

