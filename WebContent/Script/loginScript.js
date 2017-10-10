function validateform() {
		console.log('validate');
		var name = document.myform.name.value;
		var password = document.myform.password.value;
		var phoneNumber = document.myform.phoneNumber.value;
		var email = document.myform.email.value;
		if (name == null || name == "") {
			alert("Name can't be blank !!!");
			return false;
		}else if(name!=null){
			var symbols=/^[a-zA-Z]+$/;
			if(name.value.match(symbols))
				return true;
			else{
				alert("no symbols and numbers allowed!!!");
				return false;
			}
			return true;
			}		
		else if (email == null || email == "") {
			alert("invalid email !!!");
			return false;
		} else if (phoneNumber.length != 10) {
			alert("enter valid 10 digit phone number!!!");
			return false;
		} else if (password.length < 6) {
			alert("Password must be at least 6 characters long !!!");
			return false;
		}
	}