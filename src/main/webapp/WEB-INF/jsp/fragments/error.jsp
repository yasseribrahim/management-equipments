<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="p-t-20">
	<div class="container">
		<div class="row">
			<div class="card col-sm-6" style="padding: 0px; margin-left: 25%">
				<div class="card-header">
					<strong><font color="red">Error</font></strong>
				</div>
				<div class="card-body card-block">
					<p class="error-message">
						<font color="red"><c:out value="${message}"></c:out></font>
					</p>
				</div>
			</div>
		</div>
	</div>
</section>