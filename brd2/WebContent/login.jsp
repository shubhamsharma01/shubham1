<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="css/style.css" media="screen">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>

<script type="text/javascript">
        window.history.forward();
        function noBack()
        {
            window.history.forward();
        }
</script>

<body >
<div class="container">
<div id="login">

<form action="LoginServlet" method="post">
<fieldset class="clearfix">
       
  <p><span class="fontawesome-user"></span>

<input type="text" name="user"  onBlur="if(this.value == '') this.value = 'Username'" onFocus="if(this.value == 'Username') this.value = ''" required></p>       
   <p><span class="fontawesome-lock">
</span>
<input type="password" name="pass"   onBlur="if(this.value == '') this.value = 'Password'" onFocus="if(this.value == 'Password') this.value = ''" required>
</p>
 
     <p><input type="submit" value="Login"></p>

    </fieldset>
</form>

</div>
</div>
</body>
</html>