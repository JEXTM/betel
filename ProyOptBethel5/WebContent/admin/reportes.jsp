<%@page import="beans.BeanMarca"%>
<%@page import="java.util.Vector"%>
<%@ include file="cabeceraSystem.jsp" %>
<%@ include file="menuSystem.jsp" %>
<%
 Vector<BeanMarca> marcas = (Vector<BeanMarca>)request.getAttribute("marcas");
%>
<style>
#resultado{
	width: 300px;
}
</style>
	<br/>
	<br/>
	<br/>
	<div class="container">
		
		<select id="select">
		<%for(int i=0;i<marcas.size();i++){ %>
			<option value="<%=marcas.get(i).getIdMarca()%>"><%=marcas.get(i).getNombre() %> </option>
			<%}%>
		</select>
		<button id="btn">click</button>
	
		
	
	
	
	<div id="resultado">
		
	</div>
	
	
	</div>
	
	
	

<%@ include file="pieDePaginaSystem.jsp" %>
<script>
$(document).ready(function() {
	$('#btn').click(function(event) {
		var marcaVar = $('#select').val();
		// Si en vez de por post lo queremos hacer por get, cambiamos el $.post por $.get
		$.post('reporte', {
			marca : marcaVar
		}, function(responseText) {
			$('#resultado').html(responseText);
		});
	});
});
</script>