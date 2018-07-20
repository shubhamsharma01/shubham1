<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add</title>
<style>
div.a {
	position: absolute
   
     top: 300px;
 	left: 800px;
    margin: auto; 
    width: auto;
    padding: 10px;
}

.center {
  position: absolute;
 top: 300px;
 left: 400px;
    margin: auto; 
    width: auto;
     border:  3px solid black;
    padding: 10px;
}

.heading {
  position: absolute;
 top: 200px;
 left: 550px;
 margin: auto; 
 width: auto;
 padding: 10px;
}

</style>
</head>

<script>
function Validate()
{
	
	 //Pincode
	var p = document.forms["addForm"]["pincode"].value;
	var q = p.toString();
	if(q.length != 6)
	{
		alert("Invalid Pincode");
		return false;
    }
	var x =document.forms["addForm"]["name"].value;
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
    var e = document.forms["addForm"]["email"].value;
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

<body onload='document.addForm'>

<%@include file="menuBar.jsp" %>
<br>
<div class="heading"><h1>Enter the details</h1></div>
<form  name="addForm" action="CustomerController" method="post"  onsubmit="return Validate();">
<div class="center">
<table  border="1">

<tr><td>Customer Code</td><td><input type="text" name="code" required="required"/></td>

<td>Customer Name</td><td><input type="text" name="name" required/></td></tr>

<tr><td>Customer address1</td><td><input type="text" name="add1" required/></td>

<td>Customer address2</td><td> <input type="text" name="add2" /></td></tr>

<tr><td>Customer Pincode</td><td><input type="number" name="pincode" required/></td>

<td>Customer Email Address</td><td><input type="email" name="email"required/></td></tr>

<tr><td>Contact number</td><td><input type="number" name="contact" /></td>

<td>Primary Contact Person</td><td><input type="text" name="primary" required/></td></tr>
<tr><td>
<label for="record">Record Status</label></td><td>
<select id="record" name="record">
      <option value="M">M</option>
      <option value="N">N</option>
      <option value="D">D</option>
      <option value="A">A</option>
      <option value="R"></option>
    </select></td>
    
<td><label for="flag">Flag Status</label></td><td>
<select id="flag" name="flag">
      <option value="A">A</option>
      <option value="I">I</option>
</select></td></tr>

</table>
<div class="a"><input type="submit" value="add" name="add" /></div>
</div><br>

</form>
</body>
</html>