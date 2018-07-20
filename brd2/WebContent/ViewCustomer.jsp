<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css" media="all" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Home Page</title>
</head>
<body>
<%@include file="menuBar.jsp" %>
<br>
<table id="example" >
        <thead>
            <tr>
                <th>Customer Code</th>
                <th>Customer Name</th>
                <th>Customer Address1</th>
                <th>Customer Address2</th>
                <th>Customer PinCode</th>
                <th>Customer Email Address</th>
                <th>Customer Contact Number</th>
                <th>Primary Contact Person</th>
                <th>Record Status</th>
                <th>Active Inactive flag</th>
                <th>Create Date</th>
                <th>Created By</th>
                <th>Modified Date</th>
             
                <th>Authorized Date</th>
                <th>Authorized By</th>
                
            </tr>
        </thead>
        <tfoot>
            <tr>
                 <th>Customer Code</th>
                <th>Customer Name</th>
                  <th>Customer Address1</th>
                <th>Customer Address2</th>
                <th>Customer PinCode</th>
                <th>Customer Email Address</th>
                <th>Customer Contact Number</th>
                <th>Primary Contact Person</th>
                <th>Record Status</th>
                <th>Active Inactive flag</th>
                <th>Create Date</th>
                <th>Created By</th>
                <th>Modified Date</th>
                
                <th>Authorized Date</th>
                <th>Authorized By</th>
            </tr>
        </tfoot>
        <tbody>
       
                <c:forEach items="${customers}" var="customer">
			   <tr>
                        <td>${customer.getCustomer_code()}</td>
                        <td>${customer.getCustomer_name()}</td>
                        <td>${customer.getCustomer_address1()}</td>
                        <td>${customer.getCustomer_address2()}</td>
                          <td>${customer.getCustomer_pinCode()}</td>
                           <td>${customer.getEmail_address()}</td>
                           <td>${customer.getContact_number()}</td>
                            <td>${customer.getPrimaryConatctPerson()}</td>
                           <td>${customer.getRecord_status()}</td>
                           <td>${customer.getActive_inactiveFlag()}</td>
                           <td>${customer.getCreate_date()}</td>
                           <td>${customer.getCreated_by()}</td>
                           <td>${customer.getModified_date()}</td>
               
                           <td>${customer.getAuthorized_date()}</td>
                           <td>${customer.getAuthorized_by()}</td>
                           
                    </tr>
			</c:forEach>
        </tbody>
        </table>
      

<script src="https://code.jquery.com/jquery-1.12.4.js" type="text/javascript"></script>
<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js" type="text/javascript"></script>
<script>
$(document).ready(function()
{
   var table =  $('#example').DataTable();
  	var info = table.page.info();
  	
  		$('#tableInfo').html(
    'Currently showing page '+(info.page+1)+' of '+info.pages+' pages.'
);
		
} );


</script>
</body>
</html>