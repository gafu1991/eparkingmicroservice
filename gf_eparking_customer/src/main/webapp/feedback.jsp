<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="gf_eparking_customer.db.gf_DBManager"%>
<%@page import="gf_eparking_customer.model.gf_Customer" %>
<%@page import="gf_eparking_customer.model.gf_Captcha" %>
<%@page import="gf_eparking_customer_client.gf_customer_social_client" %>
<%@page import="gf_eparking_customer_client.gf_customer_social_customer" %>
<%@page import="gf_eparking_customer.model.gf_NetworkConversion" %>
<%@ page import="nl.captcha.Captcha" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/main.css">
</head>
<body>
<% 
Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
request.setCharacterEncoding("UTF-8"); // Do this so we can capture non-Latin chars
String answer = request.getParameter("answer");
gf_Captcha capobj = new gf_Captcha(answer,captcha);

gf_Customer customer = new gf_Customer(request.getParameter("titel"),request.getParameter("anrede"),request.getParameter("firstname"),request.getParameter("lastname"),request.getParameter("birthday"),request.getParameter("street"),request.getParameter("plz"),request.getParameter("city"),request.getParameter("email"),capobj,request.getParameter("agb"));
//out.println(customer.InsertCustomer_afterallChecks(customer));
String forward = "";


%>
<% if(!customer.InsertCustomer_afterallChecks(customer))
{
	   
	   forward = "registration_customer.jsp?inhalt_anrede=" + customer.getFehlermeldung()[0][1] + 
			   										"&inhalt_titel=" + customer.getFehlermeldung()[1][1] +
			   										"&inhalt_fname=" + customer.getFehlermeldung()[2][1] +
			   										"&inhalt_lname=" + customer.getFehlermeldung()[3][1] +
			   										"&inhalt_birthdate=" + customer.getFehlermeldung()[4][1] +
			   										"&inhalt_street=" + customer.getFehlermeldung()[5][1] +
			   										"&inhalt_plz=" + customer.getFehlermeldung()[6][1] +
			   										"&inhalt_city=" + customer.getFehlermeldung()[7][1] +
			   										"&inhalt_email=" + customer.getFehlermeldung()[8][1] +
			   										"&inhalt_double=" + customer.getFehlermeldung()[9][1] +
			   										"&inhalt_captcha=" + customer.getFehlermeldung()[10][1] +
			   										"&inhalt_agb=" + customer.getFehlermeldung()[11][1] +
			   										"&fehler_anrede="  + customer.getFehlermeldung()[0][0] + 
			   										"&fehler_titel=" + customer.getFehlermeldung()[1][0] + 
			   										"&fehler_fname=" + customer.getFehlermeldung()[2][0] + 
			   										"&fehler_lname=" + customer.getFehlermeldung()[3][0] + 
			   										"&fehler_birthdate=" + customer.getFehlermeldung()[4][0] + 
			   										"&fehler_street=" + customer.getFehlermeldung()[5][0] + 
			   										"&fehler_plz=" + customer.getFehlermeldung()[6][0] + 
			   										"&fehler_city=" + customer.getFehlermeldung()[7][0] + 
			   										"&fehler_email=" + customer.getFehlermeldung()[8][0] + 
			   										"&fehler_double=" + customer.getFehlermeldung()[9][0] + 
			   										"&fehler_captcha=" + customer.getFehlermeldung()[10][0] + 
			   										"&fehler_agb=" + customer.getFehlermeldung()[11][0] ;
}
else
{
	forward = "http://109.73.158.173:8080/vehicle/index.html?id=" + customer.getCustomerNr();
	

	gf_NetworkConversion networkconversion = new gf_NetworkConversion(customer.getStreet(),customer.getPlz(),customer.getCustomerNr(),customer.getLastname());
	
	
	gf_customer_social_customer customer_client = new gf_customer_social_customer(networkconversion.getUsername(), customer.getFirstname(), customer.getLastname(),networkconversion.getStreetName(),networkconversion.getStreetNumber(),networkconversion.getPlz(),customer.getCity(),networkconversion.getCountry(),customer.getEmail(),networkconversion.getCreditCardNumber(),networkconversion.getAblaufdatum());
			
	gf_customer_social_client.accessClient(customer_client);
			
			
}

response.setCharacterEncoding("UTF-8");
response.sendRedirect(forward);
%>
</body>
</html>