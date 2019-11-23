<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags-->
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="au theme template">
<meta name="author" content="Hau Nguyen">
<meta name="keywords" content="au theme template">

<!-- Title Page-->
<title>Administration</title>

<jsp:include page="imports/imports-css.jsp"></jsp:include>
</head>

<body class="animsition">
	<div class="page-wrapper">
		<!-- HEADER DESKTOP-->
		<header class="header-desktop3 d-none d-lg-block">
			<jsp:include page="fragments/admin/header.jsp"></jsp:include>
		</header>
		<!-- END HEADER DESKTOP-->

		<!-- HEADER MOBILE-->
		<header class="header-mobile header-mobile-2 d-block d-lg-none">
			<jsp:include page="fragments/admin/header-mobile.jsp"></jsp:include>
		</header>
		<jsp:include page="fragments/admin/sub-header-mobile.jsp"></jsp:include>
		<!-- END HEADER MOBILE -->

		<!-- PAGE CONTENT-->
		<div class="page-content--bgf7">
			<jsp:include page="fragments/${fragment}.jsp"></jsp:include>
			
			<jsp:include page="fragments/footer.jsp"></jsp:include>
		</div>
	</div>

	<jsp:include page="imports/imports-js.jsp"></jsp:include>
</body>

</html>
<!-- end document-->
