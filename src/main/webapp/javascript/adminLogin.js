	function go(url){
		var x=document.getElementsByTagName("input")[0].value;
		var y=document.getElementsByTagName("input")[1].value;
		
		if(x=="karthik" && y=="password"){
			document.getElementsByTagName("form")[0].action="adminHome.jsp";
			document.getElementsByTagName("form")[0].submit();
		}
		
	}