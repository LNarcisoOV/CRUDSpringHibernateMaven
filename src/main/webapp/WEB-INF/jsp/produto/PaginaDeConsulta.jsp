<%@ page language="java" isErrorPage="true"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de produtos!</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/menu/Menu.jsp" />

	<h1>Consulta de produto</h1>

	<form action="<c:url value='/produto/consultarProdutos'/>"
		method="post">

		<input type="submit" value="Consultar" /> <br />
		
		<br/>
		
		<c:if test="${mensagemTituloProduto != null }">
			<br />
				${mensagemTituloProduto }
			<br /><br />
		</c:if>
		
		<br/>
		
		<table border = "1">
			<tr>
				<td>Id</td>
				<td>Nome</td>
				<td>Descricao</td>
				<td>Preco</td>
				<td>Editar</td>
				<td>Deletar</td>
			</tr>
			<c:forEach items="${listaDeProdutosCadastrados}" var="pro">
				<tr>
					<td>${pro.id}</td>
					<td>${pro.nome}</td>
					<td>${pro.descricao}</td>
					<td>${pro.preco}</td>
					<td><a href="<%= request.getContextPath() %>/produto/PaginaDeEdicao/${pro.id}">Editar</a></td>
					<td><a href="<%= request.getContextPath() %>/produto/Excluir/${pro.id}">Excluir</a></td>
				</tr>
			</c:forEach>
		</table>
	</form>


</body>
</html>