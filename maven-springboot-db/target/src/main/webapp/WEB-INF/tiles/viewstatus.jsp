<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<!--  

<h3>View status updates here</h3>
<br>

Page Number using param : ${param.p}
<br>

Page Number using SPEL :
<c:out value=" ${param.p}" />
<br>
<br>
-->

<c:url var="url" value="/viewstatus" />

<div class="row">
	<div class="col-md-8 col-md-offset-2">

		<tag:pagination url="${url}" page="${page}" size="10" />


		<!--  getContent() method of the page object -->
		<c:forEach var="statusUpdate" items="${page.content}">

			<c:url var="editLink" value="/editstatus?id=${statusUpdate.id}" />
			<c:url var="deleteLink" value="/deletestatus?id=${statusUpdate.id}" />


			<div class="panel panel-default">

				<div class="panel-heading">
					<div class="panel-title">
						Last Updated Status :
						<fmt:formatDate pattern="EEEE d MMMM YYYY 'at' HH:MM:s"
							value="${statusUpdate.added}" />
					</div>
				</div>

				<div class="panel-body">

					<div>
						${statusUpdate.text}
						<!--  
						<div class="edit-links">
							<a href="${editLink}">Edit</a> | <a href="${deleteLink}"
								onclick="return confirm('Are you sure to delete ?')">Delete</a>
						</div>
						-->



						<!--  Delete Button -->
						<!--  Trigger button -->
						<button id="delete" type="button" class="btn btn-primary btn-sm"
							data-toggle="modal" data-target="#myModal">Delete</button>

						<!-- Modal -->
						<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
							aria-labelledby="myModalLabel">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h4 class="modal-title" id="myModalLabel">Delete Status
											Update</h4>
									</div>

									<div class="modal-body">Are you sure to delete ?</div>
									<div class="modal-footer">
										<button id="innercancel" type="button" class="btn btn-default"
											data-dismiss="modal">Cancel</button>
										<button id="innerdelete" type="button" class="btn btn-primary"
											onclick="location.href='${deleteLink}'">Delete</button>
									</div>
								</div>
							</div>
						</div>


						<!--  Edit control -->
						<button type="button" class="btn btn-primary btn-sm edit"
							data-toggle="modal" data-target="#myModal"
							onclick="location.href='${editLink}'">Edit</button>



					</div>
					<!-- <c:out value=" ${statusUpdate.text}" /> -->

				</div>

			</div>
		</c:forEach>
	</div>
</div>