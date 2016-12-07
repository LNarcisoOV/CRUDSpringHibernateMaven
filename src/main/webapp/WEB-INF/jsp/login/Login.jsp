<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<form action="<c:url value='/login/logar'/>" method="post">
		<h2>Login</h2>
		
		
		<br />
		---------------------------------------------------------------------------------------------------
		<br />
		
		Nome: Leonardo Narciso
		<br/>
		Tecnologias: java, jsp, spring, maven, hibernate
		<br/>
		Arquitetura Mvc
		
		<br/>
		<br/>
		
		Projeto com CRUD para seleção de DESENVOLVEDOR pela SOFTSITE - TOTALCROSS
		<br/>
		O CRUD foi todo feito em memória, com tratamentos em listas, pois não sabia
		<br/>
		quais bancos sao utilizados nas empresas que ofertam a vaga.
		
		<br/>
		<br/>
		
		
		Alguns métodos que utilizam laços na verdade eram para ser consultas no banco
		<br/>
		com filtragens, mas como tive pouco tempo para desenvolvimento, decidi tratar 
		<br/>
		memória, com listas em java.
		<br />
		<br />
		
		No menu principal, apenas podemos cadastrar e consultar produto, 
		<br />
		porém a edição e exclusão dos produtos é feita com links na tabela,
		<br /> 
		na listagem após a consulta.
		<br />
		---------------------------------------------------------------------------------------------------
		<br />
		<br />
		<br />
		
		<c:if test="${mensagemTitulo != null }">
			<br />
				${mensagemTitulo }
			<br /><br />
		</c:if>
		
		<br/>
		<br />
		PREENCHA USUÁRIO E SENHA COM QUALQUER VALOR PARA LOGAR.
		<br />
		<br />
		<br />
		<form:errors path="usuario.username" cssStyle="color:red"/>
		<br />
		Username: <input type="text" name="username" /> 
		<br /> 
		<form:errors path="usuario.senha" cssStyle="color:red"/>
		<br />
		Senha: <input type="password" name="senha" /> <br />
		<br /> 
		<input type="submit" value="Efetuar login" />
		<br/>
	</form>
</body>
</html>