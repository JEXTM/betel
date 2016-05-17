<%@page import="beans.BeanMarca"%>
<%@page import="beans.BeantTipoProducto"%>
<%@page import="java.util.Vector"%>
<%@ include file="cabeceraSystem.jsp" %>
<%@ include file="menuSystem.jsp" %>
<br>
<br>
<br>


<%if(request.getAttribute("mensaje")!=null){
	String mensaje =(String)request.getAttribute("mensaje");%>
	<p class="alert alert-danger" style="text-align: center;"><strong><%=mensaje%></strong></p>
<% } %>

<%
	Vector<BeantTipoProducto> tipoProductos = (Vector<BeantTipoProducto>)request.getAttribute("tipoProductos");
	Vector<BeanMarca> marcas = (Vector<BeanMarca>)request.getAttribute("marcas");
%>

<form action="producto" method="POST" class="form-horizontal" role="form">
	<fieldset>
	<legend><strong>Agregar Producto</strong></legend>
		
	<div class="col-sm-10 col-sm-offset-2">
		<div class="form-group">
			<label class="label-form">Nombre</label>
			<input type="text" name="nomProd" required class="form-control">
		</div>
		<div class="form-group">
			<label class="label-form">Descripcion</label>
			<input type="text" name="descripcion" required class="form-control">
		</div>
		<div class="form-group">
			<label class="label-form">Precio</label>
			<input type="text" name="precio" required class="form-control">
		</div>
		<div class="form-group">
			<label class="label-form">Stock</label>
			<input type="number" name="stock" required class="form-control">
		</div>
		<div class="form-group">
			<label class="label-form">Foto Del Producto</label>
			<input type="file" name="fotoProducto" required class="form-control">
		</div>
		<div class="form-group">
			<label class="label-form">Sku</label>
			<input type="text" name="sku" required class="form-control">
		</div>
		<div class="form-group">
			<label class="label-form">Marca</label>
			<select name="idMarca" class="form-control">
			<%for(int i=0;i<marcas.size();i++){ %>
			<option value="<%=marcas.get(i).getIdMarca()%>"><%=marcas.get(i).getNombre()%></option>
			<%} %>
			</select>
		</div>
		<div class="form-group">
			<label class="label-form">Tipo Producto</label>
			<select name="idTipoProducto" class="form-control">
			<%for(int i=0;i<tipoProductos.size();i++){ %>
			<option value="<%=tipoProductos.get(i).getIdTipoProducto()%>"><%=tipoProductos.get(i).getNombre() %></option>
			<%} %>
			</select>
		</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary">Agregar</button>
			</div>
	</div>
	</fieldset>
</form>





<%@ include file="pieDePaginaSystem.jsp" %>