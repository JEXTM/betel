<%@page import="beans.BeanMarca"%>
<%@page import="java.util.Vector"%>
<%int cantidad = (int)(request.getAttribute("cantidad"));
int total = (int)(request.getAttribute("total"));
Vector<BeanMarca> marcas = (Vector<BeanMarca>)request.getAttribute("marcas");
int idMarca = Integer.parseInt(request.getAttribute("idMarca").toString());
%>


<input type="hidden" id="porcentaje" value="<%=cantidad%>">
<input type="hidden" id="resto" value="<%=total%>">
<input type="hidden" id="nombre" value="<%=marcas.get(idMarca).getNombre()%>">
<div id="chartContainer"></div>

hola






<script src="js/vendor/canvasjs.min.js"></script>
<script type="text/javascript">
window.onload = function () {
	var porcentaje =  $('#porcentaje').val();
	var resto =  $('#resto').val();
	var total = ((resto - porcentaje)/resto)*100;
	var nombre =  $('#nombre').val();
	var chart = new CanvasJS.Chart("chartContainer",
	{
		title:{
			text: "Marca",
			fontFamily: "arial black"
		},
                animationEnabled: true,
		legend: {
			verticalAlign: "bottom",
			horizontalAlign: "center"
		},
		theme: "theme1",
		data: [
		{        
			type: "pie",
			indexLabelFontFamily: "Garamond",       
			indexLabelFontSize: 20,
			indexLabelFontWeight: "bold",
			startAngle:0,
			indexLabelFontColor: "MistyRose",       
			indexLabelLineColor: "darkgrey", 
			indexLabelPlacement: "inside", 
			toolTipContent: "{name}: {y}hrs",
			showInLegend: true,
			indexLabel: "#percent%", 
			dataPoints: [
				{  y: porcentaje, name: nombre, legendMarkerType: "triangle"},
				{  y: total, name: "Otros", legendMarkerType: "square"}
			]
		}
		]
	});
	chart.render();
}
</script>
