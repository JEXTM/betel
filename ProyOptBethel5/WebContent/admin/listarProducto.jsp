<%@page import="beans.BeanProducto"%>
<%@page import="beans.BeanMarca"%>
<%@page import="beans.BeantTipoProducto"%>
<%@page import="beans.BeanTipoDocIdent"%>
<%@page import="beans.BeanTipoUsuario"%>
<%@page import="beans.BeanUsuario"%>
<%@page import="java.util.Vector"%>
<%@ include file="cabeceraSystem.jsp" %>	
<%@ include file="menuSystem.jsp" %>	
<br>
<br>
<br>






<fielset>
<legend><strong>Listado De Productos</strong></legend>
<%if(request.getAttribute("mensaje")!=null){ 
			String mensaje = (String) request.getAttribute("mensaje");
		}%>
<%
Vector<BeanProducto> producto = (Vector<BeanProducto>)request.getAttribute("productos");
	if(producto.size()!=0){
		Vector<BeantTipoProducto> tipoProductos = (Vector<BeantTipoProducto>)request.getAttribute("tipoProductos");
		Vector<BeanMarca> marcas = (Vector<BeanMarca>)request.getAttribute("marcas");
		Vector<BeanProducto> productos = (Vector<BeanProducto>)request.getAttribute("productos");
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
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Descripcion</th>
					<th>Precio</th>
					<th>Stock</th>
					<th>Sku</th>
					<th>Foto Del Producto</th>
					<th>Marca</th>
					<th>Tipo</th>
				</tr>
			</thead>
			<tbody>
			<%for(int i=0;i<productos.size();i++){ %>
				 <tr>
					<td><%=productos.get(i).getNomProd()%></td>
					<td><%=productos.get(i).getDescripcion()%></td>
					<td><%=productos.get(i).getPrecio()%></td>
					<td><%=productos.get(i).getStock()%></td>
					<td><%=productos.get(i).getSku()%></td>
					<td><%=productos.get(i).getFotoProducto()%></td>
					<%
						for(int j=0;j<marcas.size();j++){
							if(productos.get(i).getIdMarca()==marcas.get(j).getIdMarca()){
					%>
					<td><%=marcas.get(j).getNombre() %></td>
					<%-- <td><%=tipoUsuarios.get(usuarios.get(i).getIdTipoUsuario()).getNombre()%></td> --%>
					<%} %>
					<%} %>
						<%
						for(int j=0;j<tipoProductos.size();j++){
							if(productos.get(i).getIdTipoProducto()==tipoProductos.get(j).getIdTipoProducto()){
					%>
					
					<td><%=tipoProductos.get(j).getNombre() %></td>
					<%-- <td><%=tipoDocIdents.get(usuarios.get(i).getIdTipoDocIdent()).getNombre()%></td> --%>
					<%} %>
					<%} %>
					<td><a href="modProducto?idProducto=<%=productos.get(i).getIdProducto()%>" style="text-decoration: none;">Modificar</a></td>
					<td><a href="producto?action=3&id=<%=productos.get(i).getIdProducto()%>" style="text-decoration: none;">Eliminar</a></td>
				</tr>
				<%}%>
				 </tbody>
		</table>
		
		



<%}else{%>
	<p class="alert alert-danger" style="text-align: center;"><strong>NO EXISTEN PRODUCTOS</strong></p>
<%} %>
</fielset>










<%@ include file="pieDePaginaSystem.jsp" %>  