<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<script type ="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js">

	$(document).ready(function validate(id, pass1, pass2) {
		print("lol");
		var regex = "/^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,}$/";
		//The above regex checks whether or not a password contains:
		//8 characters, 1 lower case, and 1 uppercase

		var password1 = document.forms[id].elements[pass1].value; //Fetches password1
		var password2 = document.forms[id].elements[pass2].value; //Fetches password 2

		if(password1 != password2) {
			alert("Your passwords do not match.");
			var password = document.forms[id].elements[pass].focus;
			return false;
		}

		if(reg.test(password) == false) {

			alert("You password doesn't meet the following requirements: 8 characters, 1 uppercase, 1 lowercase.");
			var password = document.forms[id].elements[pass].focus;
			return false;
		}
	});

</script>

	<form id = "registerform" action="LoginRegister" method = "post" onclick="javascript:return validate('registerform','password1', 'password2');">
		<table>
			<tr>
				<td>Name :</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>UserName :</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" id = "password1" name="password1"></td>
			</tr>
			<tr>
				<td>Re-Enter Password :</td>
				<td><input type="password" id = "password2" name="password2"></td>
			</tr>
			<tr> 
				<td></td>
				<td><input type="submit" name="submit" value="Register"></td>
				<td></td>
			</tr>
		</table>
	</form>
</body>
</html>