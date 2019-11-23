<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form action="/admin/buildings/add" method="post">
	<section class="p-t-20">
		<div class="container">
			<div class="row">
				<div class="card col-sm-6" style="padding: 0px; margin-left: 25%">
					<div class="card-header">
						<strong>Add</strong> Building
					</div>
					<div class="card-body card-block">
						<%-- <p class="error-message" th:if="${#fields.hasErrors('name')}"
							th:errors="*{name}">Validation error</p>
						<p class="error-message" th:if="${#fields.hasErrors('code')}"
							th:errors="*{code}">Validation error Code</p> --%>
						<div class="row form-group">
							<div class="col col-md-3">
								<label for="code" class=" form-control-label">Code</label>
							</div>
							<div class="col-12 col-md-9">
								<input type="text" id="code" name="code"
									placeholder="Enter Code..." class="form-control"
									value="${building.code}">
								<!-- <span class="help-block">Please enter your email</span> -->
							</div>
						</div>
						<div class="row form-group">
							<div class="col col-md-3">
								<label for="name" class=" form-control-label">Name</label>
							</div>
							<div class="col-12 col-md-9">
								<input type="text" id="name" name="name"
									placeholder="Enter Name..." class="form-control"
									value="${building.name}">
								<!-- <span class="help-block">Please enter your password</span> -->
							</div>
						</div>
						<div class="row form-group">
							<div class="col col-md-3">
								<label for="note" class=" form-control-label">Note</label>
							</div>
							<div class="col-12 col-md-9">
								<input type="text" id="note" name="note"
									placeholder="Enter Note..." class="form-control"
									value="${building.note}">
								<!-- <span class="help-block">Please enter your password</span> -->
							</div>
						</div>
					</div>
					<div class="card-footer">
						<button type="submit" class="btn btn-primary btn-success btn-sm">
							<i class="fa fa-dot-circle-o"></i> Save
						</button>
						<button type="reset" class="btn btn-danger btn-sm">
							<i class="fa fa-ban"></i> Reset
						</button>
					</div>
				</div>
			</div>
		</div>
	</section>
</form>