<%@page import="java.util.List,java.util.ArrayList" %>


<%@page import="java.util.ArrayList"%>
<%
	
	//response.setContentType("text/html");
	List<String> list = new ArrayList<String>();
	list.add("one");
	list.add("two");
	list.add("three");
	list.add("four");
	list.add("five...");
	
	for(String token:list)
		out.println(token+"<br>");

%>


