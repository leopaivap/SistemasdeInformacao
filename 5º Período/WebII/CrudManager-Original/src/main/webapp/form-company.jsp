<jsp:directive.page contentType="text/html; charset=UTF-8" />
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<%@include file="base-head.jsp"%>
</head>
<body>
	<%@include file="nav-menu.jsp"%>
	
	<div id="container" class="container-fluid">
		<h3 class="page-header">Adicionar Empresa</h3>
		
		<form action="${pageContext.request.contextPath}/company/${action}" 
			method="POST">
			
			<div class="row">
				<div class="form-group col-md-6">
					<label for="name">Nome</label>
					<input type="text" class="form-control" id="name" name="name" 
						   autofocus="autofocus" placeholder="Nome Empresa" 
						   required 
						   oninvalid="this.setCustomValidity('Por favor, informe o nome da empresa.')"
						   oninput="setCustomValidity('')" />
				</div>
				
				<div class="form-group col-md-6">
					<label for="role">Cargo</label>
					<input type="text" class="form-control" id="role" name="role" 
						   autofocus="autofocus" placeholder="Cargo ocupado" 
						   required 
						   oninvalid="this.setCustomValidity('Por favor, informe o cargo.')"
						   oninput="setCustomValidity('')" />
				</div>				
			</div>
			
			<div class="row">
				<div class="form-group col-md-4">
					<label for="start">Data início</label>
					<input type="date" class="form-control" id="start" name="start" 
						   autofocus="autofocus" placeholder="Data de início" 
						   required 
						   oninvalid="this.setCustomValidity('Por favor, informe a data de início.')"
						   oninput="setCustomValidity('')" />
				</div>
				
				<div class="form-group col-md-4">
					<label for="end">Data saída</label>
					<input type="date" class="form-control" id="end" name="end" 
						   autofocus="autofocus" placeholder="Data de saída"				    
						   oninvalid="this.setCustomValidity('Por favor, informe a data de saída')"
						   oninput="setCustomValidity('')" />
				</div>
				
				<div class="form-group col-md-4">
					<label for="user">Usuário</label>
					<select id="user" class="form-control selectpicker" name="user" 
						    required oninvalid="this.setCustomValidity('Por favor, informe o usuário.')"
						    oninput="setCustomValidity('')">
					  <option value="">Selecione um usuário</option>
					  <c:forEach var="user" items="${users}">
					  	<option value="${user.getId()}">
					  		${user.getName()}
					  	</option>	
					  </c:forEach>
					</select>
				</div>
			</div>
			
			<hr />
			<div id="actions" class="row pull-right">
				<div class="col-md-12">
					
					<a href="${pageContext.request.contextPath}/companies" 
					   class="btn btn-default">Cancelar</a>
					
					<button type="submit" 
						    class="btn btn-primary">Cadastrar Empresa</button>
				</div>
			</div>
		</form>
		
	</div>

</body>
</html>