<%@ include file="cabeceraSystem.jsp" %>	
<%@ include file="menuSystem.jsp" %>	

<%
	
if(request.getAttribute("mensaje")!=null){
	String mensaje = (String)request.getAttribute("mensaje");
%>
<br>
<br>
<br>
	<p class="alert alert-success" style="text-align: center;"><strong><%=mensaje%></strong></p>
<%}%>
	







<%@ include file="pieDePaginaSystem.jsp" %>  