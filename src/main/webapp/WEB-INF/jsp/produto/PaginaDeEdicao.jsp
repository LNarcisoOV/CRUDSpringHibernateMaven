<%@ page language="java" isErrorPage="true"	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Edição de produto!</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/menu/Menu.jsp" />
	
	<h1>Edição de produto</h1>
	
	<form action="<c:url value='/produto/salvarEdicao'/>" method="post">
		<c:if test="${mensagemTituloProduto != null }">
			<br />
				${mensagemTituloProduto }
			<br /><br />
		</c:if>
		<input type="hidden" name = "id" value="${produto.id}"/>
		<br />
		Nome: <input type="text" name="nome" value="${produto.nome}"/> 
		<br /> 
		Descrição: <textarea name="descricao" rows="4" cols="50">${produto.descricao}</textarea><br />
		<br /> 
		Preço: <input type="text" name="preco" id="idPreco" class="valor_decimal" value="${produto.preco}"/> <br />
		<br />
		<input type="submit" value="Editar" />
		<br/>
	</form>
	
</body>
</html>