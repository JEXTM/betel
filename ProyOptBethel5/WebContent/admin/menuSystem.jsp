<header>
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button class="navbar-toggle" data-toggle="collapse" data-target="#menu">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a href="<%=request.getServletContext().getContextPath()%>/admin/home.jsp" class="navbar-brand ck-navbar-brand">
       				<div class="logo"></div>				
				</a>
			</div>
			<div class="collapse navbar-collapse" id="menu">
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">Productos <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="<%=request.getServletContext().getContextPath()%>/producto?action=1">Agregar Producto</a></li>
       						<li class="divider"></li>
       						<li><a href="<%=request.getServletContext().getContextPath()%>/producto?action=2">Listar Producto</a></li>					
						</ul>
					</li>
					<li><a href="<%=request.getServletContext().getContextPath()%>/venta">Venta</a></li>
					<li><a href="<%=request.getServletContext().getContextPath()%>/admin/comprobanteVenta.jsp">VentaTest</a></li>				
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">Usuarios <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="<%=request.getServletContext().getContextPath()%>/admin/agregarUsuario.jsp">Agregar Usuario</a></li>
							<li class="divider"></li>
							<li><a href="<%=request.getServletContext().getContextPath()%>/usuario?action=2">Listar Usuarios</a></li>					
						</ul>
					</li>
					<li><a href="#">Catalogo</a></li>					
					<li><a href="#">Reportes</a></li>
					<li><a href="#">Estadistica</a></li>
					<li><a href="<%=application.getContextPath() %>/login">Logout</a></li>
				</ul>
			</div>
		</div>		
	</nav>
</header>