<%@page import="beans.BeanTipoDocIdent"%>
<%@page import="beans.BeanTipoUsuario"%>
<%@page import="beans.BeanUsuario"%>
<%@page import="java.util.Vector"%>
<%@ include file="cabeceraSystem.jsp" %>	
<%@ include file="menuSystem.jsp" %>	



<br>
<br>
<br>
<fieldset>
<legend>Lista De Personal</legend>


<%
Vector<BeanUsuario> usuario = (Vector<BeanUsuario>)request.getAttribute("usuarios");
	if(usuario.size()!=0){
		Vector<BeanUsuario> usuarios = (Vector<BeanUsuario>)request.getAttribute("usuarios");
		Vector<BeanTipoUsuario> tipoUsuarios= (Vector<BeanTipoUsuario>)request.getAttribute("tipoUsuarios");
		Vector<BeanTipoDocIdent> tipoDocIdents = (Vector<BeanTipoDocIdent>)request.getAttribute("tipoDocIdents");
		
		
		%>		
			<%if(request.getAttribute("mensaje")!=null){ 
			String mensaje = (String) request.getAttribute("mensaje");
			if(!mensaje.equals("No se Pudo Eliminar")){
		%>
		
		<p class="alert alert-success" style="text-align: center;"><strong><%=mensaje %></strong></p>
		<%}else{ %>
		<p class="alert alert-danger" style="text-align: center;"><strong><%=mensaje %></strong></p>
		<%}
			}%>
		<table class="table  table-hover table-responsive">
			<thead>
				<tr>
					<th>User Name</th>
					<th>Nombre</th>
					<th>Apellido Paterno</th>
					<th>Apellido Materno</th>
					<th>Direccion</th>
					<th>Correo</th>
					<th>Contacto</th>
					<th>Tipo De Usuario</th>
					<th>Documento De Identidad</th>
					<th>Numero De Documento</th>
					<th>Modificar</th>
					<th>Eliminar</th>
				</tr>
			</thead>
			<tbody>
			<%for(int i=0;i<usuarios.size();i++){ %>
				 <tr>
					<td><%=usuarios.get(i).getUsername()%></td>
					<td><%=usuarios.get(i).getNombre()%></td>
					<td><%=usuarios.get(i).getApePat()%></td>
					<td><%=usuarios.get(i).getApeMat()%></td>
					<td><%=usuarios.get(i).getDireccion()%></td>
					<td><%=usuarios.get(i).getCorreo()%></td>
					<td><%=usuarios.get(i).getContacto()%></td>
					<%
						for(int j=0;j<tipoUsuarios.size();j++){
							if(usuarios.get(i).getIdTipoUsuario()==tipoUsuarios.get(j).getIdTipoUsuario()){
					%>
					<td><%=tipoUsuarios.get(j).getNombre() %></td>
					<%-- <td><%=tipoUsuarios.get(usuarios.get(i).getIdTipoUsuario()).getNombre()%></td> --%>
					<%} %>
					<%} %>
						<%
						for(int j=0;j<tipoDocIdents.size();j++){
							if(usuarios.get(i).getIdTipoDocIdent()==tipoDocIdents.get(j).getIdTipoDocIdent()){
					%>
					
					<td><%=tipoDocIdents.get(j).getNombre() %></td>
					<%-- <td><%=tipoDocIdents.get(usuarios.get(i).getIdTipoDocIdent()).getNombre()%></td> --%>
					<%} %>
					<%} %>
					<td><%=usuarios.get(i).getDocIdent()%></td>
					<td><a href="modUsuario?id=<%=usuarios.get(i).getIdUsuario()%>" style="text-decoration: none;">Modificar</a></td>
					<td><a href="usuario?action=1&id=<%=usuarios.get(i).getIdUsuario()%>" style="text-decoration: none;">Eliminar</a></td>
				</tr>
				<%}%>
				 </tbody>
		</table>
		
		


<%}else{ %>

	<p class="alert alert-danger" style="text-align: center;"><strong>NO SE ENCONTRO PERSONAL</strong></p>

<%} %>

		
	

</fieldset>










<%@ include file="pieDePaginaSystem.jsp" %>  