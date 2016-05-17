<%@ include file="cabeceraSystem.jsp" %>
<%@ include file="menuSystem.jsp" %>
<br/>
<br/>
<br/>
<div class="container">
	<form class="form-horizontal" action="<%=request.getServletContext().getContextPath()%>/usuario" method="GET">
	<input type="hidden" value="3" name="action">
		<fieldset>
			<legend>Datos del Cliente:</legend>
				<div class="form-group">
					<label for="docIdent" class="col-sm-2 control-label">Documento</label>
					<div class="col-sm-10">
						<input type="number" class="form-control" max="999999999999999" placeholder="55555555" required name="docIdent">
					</div>
				</div>
				<div class="form-group">
					<label for="nombre" class="col-sm-2 control-label">Nombres</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" maxlength="45" placeholder="Nombres" name="nombre" disabled>
					</div>
				</div>
				<div class="form-group">
					<label for="Apellido Paterno" class="col-sm-2 control-label">Apellido Paterno</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" maxlength="45" placeholder="Apellido Paterno" name="apePat" disabled>
					</div>
				</div>
				<div class="form-group">
					<label for="Apellido Materno" class="col-sm-2 control-label">Apellido Materno</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" maxlength="45" placeholder="Apellido Materno" name="apeMat" disabled>
					</div>
				</div>				
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<input class="btn btn-primary" type="submit" value="Buscar Cliente"/>
					</div>
				</div>
		</fieldset>
	</form>
	
	<form class="form-horizontal" action="<%=request.getServletContext().getContextPath()%>/producto" method="POST">
		<fieldset>
			<legend>Datos del Producto:</legend>
				<div class="form-group">
					<label for="sku" class="col-sm-2 control-label">Sku</label>
					<div class="col-sm-10">
						<input type="text" name="sku" id="sku" class="form-control">
					</div>	
				</div>
				<div class="form-group">
					<label for="nomProd" class="col-sm-2 control-label" >Nombre</label>
					<div class="col-sm-10">
						<input type="text" name="nomProd" id="nomProd" class="form-control" disabled>
					</div>	
				</div>
				<div class="form-group">
					<label for="idMarca" class="col-sm-2 control-label">Marca</label>
					<div class="col-sm-10">
						<select name="idMarca" id="idMarca" class="form-control" disabled>
							<option value=""></option>
					
						</select>
					</div>					
				</div>
				<div class="form-group">
					<label for="precio" class="col-sm-2 control-label">Precio</label>
					<div class="col-sm-10">
						<input type="text" name="precio" id="precio" class="form-control" disabled>
					</div>	
				</div>
				<div class="form-group">
					<label for="cantidad" class="col-sm-2 control-label">Cantidad</label>
					<div class="col-sm-10">
						<input type="number" name="cantidad" id="cantidad" class="form-control" disabled>
					</div>
				</div>		
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<input class="btn btn-primary" disabled type="submit" value="Buscar Producto"/>
						<a href="#" class="btn btn-default" >Agregar al Carrito</a>
					</div>
				</div>				
		</fieldset>
	</form>
</div>
<%@ include file="pieDePaginaSystem.jsp" %>