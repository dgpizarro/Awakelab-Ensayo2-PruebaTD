<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Factura</title>
<!-- Jquery -->
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
 <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    
<style type="text/css">
    #detalleOculto{
        display:none;
    }

</style>
</head>
<body class="bg-light">

    <main role="main" class="container pt-3">
    
    <input id="mostrar" type="hidden" value="${mostrar}">

        <div class="py-5 text-center">
            <h2>Simulación 2</h2>
        </div>

        <div class="row p-3 h-100">
            <div class="col-md-4 text-md-right mb-2 my-md-auto">
                <span>Factura ID:</span>
            </div>
                <form action="${pageContext.request.contextPath}/buscarFactura" method="GET" class="col-md-8">
	                <div class="form-row h-100">
	                    <div class="col-12 col-md-6 mb-3 my-md-auto">
	                        <input name="idfact" required class="form-control" value="${id}" />
	                    </div>
	                    <div class=" col-12 col-md-3 mb-3 my-md-auto">
	                        <button type="submit" class="btn btn-primary btn-block">Obtener</button>
	                    </div>
	                </div>
                </form>
            
            
<%--             <form:form action="${pageContext.request.contextPath}/buscarFactura" method="GET" class="col-md-8"> --%>
<!--                 <div class="row"> -->
<!--                     <div class="col-12 col-md-6 mb-3"> -->
<%--                         <form:input path="facturaid" required="true" class="form-control" /> --%>
<!--                     </div> -->
<!--                     <div class=" col-12 col-md-3 mb-3"> -->
<!--                         <button type="submit" class="btn btn-primary btn-block">Obtener</button> -->
<!--                     </div> -->
<!--                 </div> -->
<%--             </form:form> --%>
        </div>

        <div class="container" id="detalleOculto">
        
         <div class="row mb-3">
            <div class="col">
                <h5 class="font-weight-bold"> Detalle de Factura ID: <c:out value="${fact.getFacturaid()}" /> </h5>
            </div>
        </div>
        
        
        <div class="row mb-3">
            <div class="col">
                <span class="font-weight-bold"> Cliente: </span>
                <span><c:out value="${fact.getCliente()}" /></span>
            </div>
        </div>

        <div class="row mb-4">
            <div class="col">
                <span class="font-weight-bold"> Fecha: </span>
                <span><c:out value="${fact.getFecha()}" /></span>
            </div>
        </div>

        
            <div class="row mb-3">
                <div class="col">
                    <table class="table table-hover table-bordered table-sm">
                    <thead class="thead-light">
                        <tr>
                            <th>
                                Producto
                            </th>
                            <th>
                                Precio
                            </th>
                            <th>
                                Cantidad
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="p" items="${productos}">
                                <tr>
                                    <td><c:out value="${p.getProducto().getNombre()}" /> </td>
                                    <td><c:out value="${p.getProducto().getValor()}" /> </td>
                                     <td><c:out value="${p.getCantidad()}" /> </td>                              
                                </tr>
                      </c:forEach>
                    </tbody>
                    </table>
                </div>
            </div>
        

        <div class="row mb-3">
            <div class="col">
                <span class="font-weight-bold"> Subtotal: </span>
                <span>$<c:out value="${sub}" /></span>
            </div>
        </div>

        <div class="row mb-3">
            <div class="col">
                <span class="font-weight-bold"> Impuesto: </span>
                <span>$<c:out value="${iva}" /></span>
            </div>
        </div>

        <div class="row mb-3">
            <div class="col">
                <span class="font-weight-bold"> Total: </span>
                <span>$<c:out value="${tt}" /></span>
            </div>
        </div>

    </div>
    </main>

<script type="text/javascript">
$(document).ready(function () {
	var mostrar = $("#mostrar").val();
    if (mostrar === "ok") {
        $("#detalleOculto").css("display","block");
        console.log(mostrar);
   }
	
});

</script>

</body>
</html>