<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<!-- Required meta tags-->
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="au theme template">
<meta name="author" content="Hau Nguyen">
<meta name="keywords" content="au theme template">

<!-- Title Page-->
<title>Login</title>

<jsp:include page="imports/imports-css.jsp"></jsp:include>
</head>

<body class="animsition">
	<div class="page-wrapper">
		<div class="page-content--bge5">
			<div class="container">
				<div class="login-wrap">
					<div class="login-content">
						<div class="login-logo">
							<a href="#"> <img src="/images/icon/logo.png" alt="CoolAdmin">
							</a>
						</div>
						<div class="login-form">
							<form action="/app-login" method="POST">
								<div class="form-group">
									<label>Email Address</label> <input
										class="au-input au-input--full" type="email" name="username"
										placeholder="Email">
								</div>
								<div class="form-group">
									<label>Password</label> <input class="au-input au-input--full"
										type="password" name="password" placeholder="Password">
								</div>
								<div class="login-checkbox">
									<label> <input type="checkbox" name="remember">Remember
										Me
									</label> <label> <a href="#">Forgotten Password?</a>
									</label>
								</div>
								<button class="au-btn au-btn--block au-btn--green m-b-20"
									type="submit">sign in</button>
							</form>
							<div class="register-link">
								<p>
									Don't you have account? <a href="/registration">Sign Up
										Here</a>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="fragments/footer.jsp"></jsp:include>
	</div>
	<jsp:include page="imports/imports-js.jsp"></jsp:include>
</body>

</html>
<!-- end document-->