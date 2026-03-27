function validateForm(){
	let name=document.getElementsById("name").value;
	let email=document.getElementById("email").value;
	let course=document.getElementById("course").value;
	
	if(name===" "||email===""|| course===""){
		alert("All  Fields are required !");
		return false;
	}
	 
	let emailPattern= /^[^ ]+@[^ ]+\.[a-z]{2,3}$/;
	if(!email.match(emailPattern)){
		alert("Enter valid email !");
		return false;
	}
	return true;
	
}