<%@ page language="java" import="rail_likhita.*,java.util.*"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>prev</title>
<h1>preview</h1>
</head>
<body>
	<h1>preview</h1>
	<%Ticket tt = (Ticket) request.getAttribute("tic");
ArrayList<Passenger> p = new ArrayList<>();
p = tt.getTl();%>
		
<p>Train name :<%=tt.getTname()%></p>
<p>From :<%=tt.getFrom()%>
			</p>
			<p>to:
		<%=tt.getTo()%>
			</p><p>booking class :
		<%=tt.getClas()%>
			</p>

<table>
<tr><th>Name</th><th>Age</th><th>Gender</th></tr>
		<%for (Passenger x : p) {%>
			<tr><td>
		<%=x.getName()%>
			</td>
<td>
		<%=x.getAge()%>
			</td>
<td>
		<%=x.getGender()%>
			</td>

</tr>
		<%}%>
			</table>
	<button id="confirm" onclick=confirm()>confirm</button>
	<script>
	function confirm(){
		console.log("confirm");
		var xhr=new XMLHttpRequest();
		var url="Dup3";
		xhr.open("GET",url,true);
		xhr.onreadyreadystate=function(){
			if(xhr.status===200 && xhr.state===4){
				
			} ;
			xhr.send();
		}
	}

	</script>
	
	

</body>
</html>