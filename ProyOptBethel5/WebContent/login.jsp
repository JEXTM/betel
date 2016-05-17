<%@ include file="cabecera.jsp" %>	
<%@ include file="menu.html" %>	
<%
String mensaje="";

if(session.getAttribute("usuario") != null){
	response.sendRedirect(request.getContextPath() + "/admin/home.jsp");
	return;
}
%>
<br>
<br>
<br>


	<div class="container">
	<div class="row">
	<div class="col-md-3"></div>
	<div class="col-md-6">
	<fieldset>
	<legend>Inicio De Sesion</legend>
	<%if(request.getAttribute("mensaje")!=null){
	mensaje=(String)request.getAttribute("mensaje");	
	%>	
	<p class="alert alert-danger" style="text-align: center"><%=mensaje %></p>
<%} %>	
	<form action="login" method="POST">
		<div class="form-group">
			<label class="label-control" for="txtUsername">Usuario</label>
			<input type="text" name="txtUsername" id="txtUsername" class="form-control">
		</div>
		<div class="form-group">
			<label class="label-control" for="txtPassword">Password</label>
			<input type="password" name="txtPassword" id="txtPassword" class="form-control">
		</div>
		
		<input type="submit" class="btn btn-default btn-block" value="Enviar">
	</form>
	</fieldset>
	</div>
	<div class="col-md-3"></div>
	</div>
	</div>




<%@ include file="pieDePagina.jsp" %>  