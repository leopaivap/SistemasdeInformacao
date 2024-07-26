<jsp:directive.page contentType="text/html; charset=UTF-8" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<%@include file="base-head.jsp"%>
<title>CRUD Manager - Inserir Publicação</title>
</head>
<body>
	<%@include file="nav-menu.jsp"%>

	<div id="container" class="container-fluid">
		<h3 class="page-header">Adicionar Post</h3>

		<form action="${pageContext.request.contextPath}/post/${action}"
			method="POST">
			<input type="hidden" value="${post.getId()}" name="postId">
			<div class="row">
				<div class="form-group col-md-6">
					<label for="content">Conteúdo</label> <input type="text"
						class="form-control" id="content" name="content"
						autofocus="autofocus" placeholder="Conteúdo do post" required
						oninvalid="this.setCustomValidity('Por favor, informe o conteúdo do post.')"
						oninput="setCustomValidity('')" value="${post.getContent()}">
				</div>

				<div class="form-group col-md-6">
					<label for="user">Usuário</label> <select id="user"
						class="form-control selectpicker" name="user" required
						oninvalid="this.setCustomValidity('Por favor, informe o usuário.')"
						oninput="setCustomValidity('')">
						<option value=""disabled ${notemptypost ? "" : "selected"}>Selecione
							um usuário</option>
						<c:forEach var="user" items="${users}">
							<option value="${user.getId()}"
								${post.getUser().getId() == user.getId() ? "selected" : ""}>
								${user.getName()}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<hr />
			<div id="actions" class="row pull-right">
				<div class="col-md-12">
					<a href="${pageContext.request.contextPath}/posts"
						class="btn btn-default">Cancelar</a>
					<button type="submit" class="btn btn-primary">${not empty post ? "Alterar Post" : "Criar Post"}</button>
				</div>
			</div>
		</form>
	</div>

	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>
