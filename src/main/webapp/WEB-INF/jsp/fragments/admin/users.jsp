<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<section class="p-t-20">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h3 class="title-5 m-b-35">users list</h3>
				<div class="table-data__tool">
					<div class="table-data__tool-left">
						<div class="rs-select2--light rs-select2--md">
							<select class="js-select2" name="property">
								<option selected="selected">All Properties</option>
								<option value="">Option 1</option>
								<option value="">Option 2</option>
							</select>
							<div class="dropDownSelect2"></div>
						</div>
						<div class="rs-select2--light rs-select2--sm">
							<select class="js-select2" name="time">
								<option selected="selected">Today</option>
								<option value="">3 Days</option>
								<option value="">1 Week</option>
							</select>
							<div class="dropDownSelect2"></div>
						</div>
						<button class="au-btn-filter">
							<i class="zmdi zmdi-filter-list"></i>filters
						</button>
					</div>
					<div class="table-data__tool-right">
						<a class="au-btn au-btn-icon au-btn--green au-btn--small"
							href="/admin/users/add-form"> <i class="zmdi zmdi-plus"></i>add
							user
						</a>
						<div class="rs-select2--dark rs-select2--sm rs-select2--dark2">
							<select class="js-select2" name="type">
								<option selected="selected">Export</option>
								<option value="">Option 1</option>
								<option value="">Option 2</option>
							</select>
							<div class="dropDownSelect2"></div>
						</div>
					</div>
				</div>
				<div class="table-responsive table-responsive-data2">
					<table class="table table-data2">
						<thead>
							<tr>
								<th><label class="au-checkbox"> <input
										type="checkbox"> <span class="au-checkmark"></span></label></th>
								<th>user-name</th>
								<th>full-name</th>
								<th>enable</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${empty users}">
								<tr class="tr-shadow">
									<td colspan="5"><span class="desc block-email">There
											are no Users added yet, Please add from add button from the
											top.</span></td>
								</tr>
							</c:if>
							<c:forEach var="user" items="${users}">
								<tr class="tr-shadow">
									<td><label class="au-checkbox"> <input
											type="checkbox"> <span class="au-checkmark"></span>
									</label></td>
									<td><span class="block-email"><c:out
												value="${user.username}"></c:out></span></td>
									<td><span class="block-email"><c:out
												value="${user.name}"></c:out></span></td>
									<td class="desc"><label class="au-checkbox"> <input
											type="checkbox"
											<c:if test="${user.enabled}">checked="checked"</c:if> /> <span
											class="au-checkmark"></span></label></td>
									<td>
										<div class="table-data-feature">
											<button class="item" data-toggle="tooltip"
												data-placement="top" title="Send">
												<i class="zmdi zmdi-mail-send"></i>
											</button>
											<c:if test="${user.id != 1}">
												<button class="item" data-toggle="tooltip"
													data-placement="top" title="Edit">
													<i class="zmdi zmdi-edit"></i>
												</button>
												<button class="item" data-toggle="tooltip"
													data-placement="top" title="Delete">
													<i class="zmdi zmdi-delete"></i>
												</button>
											</c:if>
											<button class="item" data-toggle="tooltip"
												data-placement="top" title="More">
												<i class="zmdi zmdi-more"></i>
											</button>
										</div>
									</td>
								</tr>
								<tr class="spacer"></tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</section>