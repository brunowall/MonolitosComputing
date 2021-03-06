<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Monolitos Computing - Cadastro</title>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	<header>
		<div class="page-header">
			<div class="row">
				<h1 class="col-lg-offset-4">
					<a href="/">Monolitos computing</a>
				</h1>
			</div>
		</div>
	</header>
	<div class=row>

		<div class="panel panel-default col-lg-6 col-xs-12 col-lg-offset-3">
			<div class="panel-heading">
				<h3 class="panel-title">Cadastro</h3>
			</div>
			<div class="panel-body">
				<c:if test="${erros ne null}">
					<c:forEach var="error" items="${erros}">
						<div class="alert alert-danger" role="alert">${error.defaultMessage}</div>
					</c:forEach>
				</c:if>
				<form:form action="/cadastrar" method="POST" modelAttribute="form" id="formUsuario">


					<div class="form-group">
						<form:label path="username">Usuario</form:label>
						<form:input path="username" cssClass="form-control" required="required"/>
					</div>

					<div class="form-group">
						<form:label path="email">Email</form:label>
						<form:input path="email" cssClass="form-control" required="required"/>
					</div>

					<div class="form-group">
						<form:label path="fullname">Nome completo</form:label>
						<form:input path="fullname" cssClass="form-control" required="required"/>
					</div>

					<div class="form-group">
						<form:label path="password">Senha</form:label>
						<form:password path="password" cssClass="form-control" id="senha" required="required"/>
					</div>

					<div class="form-group">
						<p id="mensagem"></p>
						<label for="senha2">Confirmar senha</label> <input type="password"
							class="form-control" required="required" id="senha2">
					</div>

					<input type="submit" class="btn btn-primary" value="Cadastar">
				</form:form>
			</div>
		</div>
	</div>
	<script src="/js/jquery-3.2.1.js"></script>
	<script src="/js/bootstrap.min.js"></script>
	<script src="/js/formedit.js"></script>
</body>
</html>