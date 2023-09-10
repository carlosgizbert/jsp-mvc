<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
Bem vindo ao nosso gerenciador de empresas!<br/>

<c:if test="${not empty usuarioLogado}">
 Logado como ${usuarioLogado.email}
</c:if>

<form action="executa" method="POST">
	<input type="hidden" name="tarefa" value="NovaEmpresa" />
    Nome: <input type="text" name="nome" />
    <button type="submit">Cadastrar</button>
</form>

<form action="login" method="POST">
	Email: <input type="email" name="email">
	Senha: <input type="senha" name="senha">
	<button type="submit">Entrar</button>
</form>

<form action="executa" method="POST">
	<input type="hidden" name="tarefa" value="logout"/>
	<input type="submit" value="Deslogar">
</form>

</body>
</html>