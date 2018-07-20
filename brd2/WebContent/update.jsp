<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
div.a {
    text-align: center;
}

.center {
    margin: auto;
    width: 20%;
    height: 30%;
 	border: 3px solid black;
    padding: 10px;
}
</style>
</head>

<script>
function Validate()
{
	
	 //Pincode
	var p = document.forms["update"]["pincode"].value;
	var q = p.toString();
	if(q.length != 6)
	{
		alert("Invalid Pincode");
		return false;
    }
	
	
	
	var x =document.forms["update"]["name"].value;

	//Name

    if(!(x.search(/[^a-zA-Z0-9]+/) === -1)) 
    {
    	alert("Invalid Customer Name");
    	return false;
    }

	if( x.length > 15 || x==" ")
	{	
		alert("Invalid Customer Name");
		return false;
	}

       //E-Mail
    var e = document.forms["update"]["email"].value;
    var t = new RegExp("^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$"); 
	if (t.test(e)) 
	{
   	 return true;
	} 
	else 
	{
    alert("Invalid Email Address");
    return false;
	}
   
	
	

 }
</script>

<body onload='document.update'>




<%@include file="menuBar.jsp" %>
<br>
<form name="update" action="CustomerController" method="post" onsubmit="return Validate();">
<div class="center">
<table>
<tr><td>Customer Code: </td><td><div style="color:grey"><input type="text" value= "${customer.getCustomer_code()}"  name="code" readonly /></div></td></tr>

<tr><td>Customer Name: </td><td><input type="text" value= "${customer.getCustomer_name()}" name="name" required/></td></tr>

<tr><td>Customer Address1: </td><td><input type="text" value= "${customer.getCustomer_address1()}" name="add1" required/></td></tr>

<tr><td>Customer Address2: </td><td><input type="text" value= "${customer.getCustomer_address2()}" name="add2" /></td></tr>

<tr><td>Customer Pincode: </td><td><input type="text" value= "${customer.getCustomer_pinCode()}" name="pincode" required/></td></tr>

<tr><td>Customer Email Address: </td><td><input type="text" value= "${customer.getEmail_address()}" name="email" required/></td></tr>

<tr><td>Contact Number: </td><td> <input type="text" value= "${customer.getContact_number()}" name="contact" /></td></tr>

<tr><td>Primary Contact Person: </td><td>  <input type="text" value= "${customer.getPrimaryConatctPerson()}" name="primary" required/><br></td></tr>


<tr><td><label for="record"> Record Status</label></td><td>
 <select value = "${customer.getRecord_status()}" name = "record" >

 	<option value="M">M</option>
      <option value="N">N</option>
      <option value="D">D</option>
      <option value="A">A</option>
      <option value="R"></option>
    </select></td></tr>

<tr><td><label for="flag">Flag Status</label></td><td>s
<select  value= "${customer. getActive_inactiveFlag()}" name="flag">
      <option value="A">A</option>
      <option value="I">I</option>
</select></td></tr>



<tr><td>Create Date </td><td><input type="text" value="${customer.getCreate_date()}" name="cdate"  readonly/></td></tr>

<tr><td>Create By  </td><td><input type="text" value="${customer.getCreated_by()}"  name="cby"  readonly /></td></tr>

</table>
</div>
<br>

 <div class="a"><input type="submit" value="Customerupdate" name="Customerupdate"/> </div>
</form>
</body>
</html>