<%@ include file="cabeceraSystem.jsp" %>
<%@ include file="menuSystem.jsp" %>
	<br/>
	<br/>
	<br/>
	<div class="container">
		<h1>
			Agregar Usuario
		</h1>
		<br/>
		<form class="form-horizontal" action="<%=request.getServletContext().getContextPath()%>/usuario" method="POST">
		<%
			if(request.getAttribute("mensaje")!=null){
				String mensaje = (String) request.getAttribute("mensaje");
				%>
				<p class="alert alert-danger" style="text-align: center;"><strong><%=mensaje%></strong></p>		
			<%} %>
		
			<div class="form-group">
				<label for="User Name" class="col-sm-2 control-label">User Name</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" maxlength="30" placeholder="Usuario" name="username" required>
				</div>	
			</div>
			<div class="form-group">
				<label for="Password" class="col-sm-2 control-label">Password</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" maxlength="15" placeholder="Password" name="password" required>
				</div>
			</div>
			<div class="form-group">
				<label for="Nombres" class="col-sm-2 control-label">Nombres</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" maxlength="45" placeholder="Nombres" name="nombre" required>
				</div>
			</div>
			<div class="form-group">
				<label for="Apellido Paterno" class="col-sm-2 control-label">Apellido Paterno</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" maxlength="45" placeholder="Apellido Paterno" name="apePat" required>
				</div>
			</div>
			<div class="form-group">
				<label for="Apellido Materno" class="col-sm-2 control-label">Apellido Materno</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" maxlength="45" placeholder="Apellido Materno" name="apeMat" required>
				</div>
			</div>
			<div class="form-group">
				<label for="Direccion" class="col-sm-2 control-label">Direccion</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" maxlength="50" placeholder="Direccion" name="direccion" required>
				</div>
			</div>
			<div class="form-group">
				<label for="Correo" class="col-sm-2 control-label">Correo</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" maxlength="45" placeholder="Correo" name="correo" required>
				</div>
			</div>
			<div class="form-group">
				<label for="Contacto" class="col-sm-2 control-label">Contacto</label>
				<div class="col-sm-10">
					<input type="text" class="form-control"  placeholder="Contacto" maxlength="9" name="contacto" required>
				</div>
			</div>
			<div class="form-group">
				<label for="Tipo" class="col-sm-2 control-label">Tipo</label>
				<div class="col-sm-10">
					<select class="form-control" name="tipoUsu">
						<option value="1" selected="selected">Cliente</option>
						<option value="2">Administrador</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="Documento de Identidad" class="col-sm-2 control-label">Documento de Identidad</label>
				<div class="col-sm-10">
					<select class="form-control" name="tipoDoc">
						<option value="1" selected="selected">DNI</option>
						<option value="2" >RUC</option>
						<option value="3">Carnet Extranjeria</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="Documento" class="col-sm-2 control-label">Documento</label>
				<div class="col-sm-10">
					<input type="number" class="form-control" max="999999999999999" placeholder="55555555" required name="docIdent">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input class="btn btn-primary" type="submit" value="Enviar"/>
				</div>
			</div>
		</form>
	</div>
<%@ include file="pieDePaginaSystem.jsp" %>