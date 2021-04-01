<%@include file="/WEB-INF/views/template/header.jsp"%>
<div class="container-wrapper" style="padding-top: 5rem;">
	<div class="login-container">
		<div id="login-box">
			<h2>Login with Username and Password</h2>
			<c:if test="${not empty messge}">
				<div class="msg text-primary">${messge}</div>
			</c:if>
			<form name="loginForm" action="<c:url value="/j_spring_security_check" />" method="post">
				<c:if test="${not empty errorMessge}">
					<div class="error text-danger">${errorMessge}</div>
				</c:if>
				<div class="form-group">
					<label for="username">Login</label>
					<input type="text" id="username" name="username" class="form-control" />
				</div>
				<div class="form-group">
					<label for="password">Password</label>
					<input type="password" id="password" name="password" class="form-control" />
				</div>
				<input type="submit" value="submit" class="btn btn-success mt-2" />
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</form>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp"%>
