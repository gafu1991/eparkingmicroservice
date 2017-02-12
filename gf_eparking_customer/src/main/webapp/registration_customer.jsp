<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Customer Registration</title>
        <meta name="description" content="Das ist die Website zur Kundenregistierung im E-Parking ystem.">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="apple-touch-icon.png">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <style>
            body {
                padding-top: 15px;
                padding-bottom: 15px;
            }
        </style>
        <link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="css/main.css">

    </head>
<body>
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
     
     <div class="container">
        <div class="navbar-header">
            
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
            
            <a class="navbar-brand" href="#">ePark</a>
         </div>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            
            
        </div><!--/.navbar-collapse -->
      
    </nav>
    
   
     <div class="jumbotron">   
     <div class="container">
        <h1>Hol dir dein Ticket in nur wenigen Schritten</h1>
        <p>Registriere dich als Kunde und hole dir dein Parkticket - günstig, schnell und einfach. . .</p>
    </div>
    </div>
   
<div class="container">
<form action="feedback.jsp" method="post">
<div class = "form-group">
<label for="anrede">Anrede</label>
<select name="anrede" class="form-control">
<option value="Herr" <% if(String.valueOf(request.getParameter("inhalt_anrede")).equals("Herr")) out.println("selected");  %>>Herr</option>
<option value="Frau" <% if(String.valueOf(request.getParameter("inhalt_anrede")).equals("Frau")) out.println("selected");  %>>Frau</option>
</select>
<% request.setCharacterEncoding("UTF-8");
if(request.getParameter("fehler_anrede") == null || (String.valueOf(request.getParameter("fehler_anrede")).equals(""))) { out.println(""); } else { out.println("<div class=\"error_message\">" + request.getParameter("fehler_anrede") + "</div>"); } ;  %> 
</div>

<div class = "form-group">
<label for="titel">Titel</label>
<input type="text" class="form-control" name="titel" placeholder="Geben Sie den Titel ein" value="
<%= request.getParameter("inhalt_titel") == null ? "" : request.getParameter("inhalt_titel")
 %>" autofocus/>
 </div>
 
 <div class ="form-group">
<label for="firstname">Vorname</label>
<input type="text" name="firstname" class="form-control" placeholder="Geben Sie den Vornamen an" value="
<%= request.getParameter("inhalt_fname") == null ? "" : request.getParameter("inhalt_fname")
 %>" 
required/>
<% if(request.getParameter("fehler_fname") == null || (String.valueOf(request.getParameter("fehler_fname")).equals(""))) { out.println(""); } else { out.println("<div class=\"error_message\">" + request.getParameter("fehler_fname") + "</div>"); } ;  %> 
</div>

<div class = "form-group">
<label for="lastname">Nachname</label>
<input type="text" name="lastname" class="form-control" placeholder="Geben Sie den Nachname an" value="<%=request.getParameter("inhalt_lname") == null ? "" : request.getParameter("inhalt_lname") %>" required/>
<% if(request.getParameter("fehler_lname") == null || (String.valueOf(request.getParameter("fehler_lname")).equals(""))) { out.println(""); } else { out.println("<div class=\"error_message\">" + request.getParameter("fehler_lname") + "</div>"); } ;  %> 
</div>

<div class ="form-group">
<label for="birthday">Geburtsdatum</label>
<input type="date" class="form-control" name="birthday" placeholder="Geburtsdatum" value="<%=request.getParameter("inhalt_birthdate") == null ? "" : request.getParameter("inhalt_birthdate") %>" required/>
<% if(request.getParameter("fehler_birthdate") == null || (String.valueOf(request.getParameter("fehler_birthdate")).equals(""))) { out.println(""); } else { out.println("<div class=\"error_message\">" + request.getParameter("fehler_birthdate") + "</div>"); } ;  %> 
</div>

<div class="form-group">
<label for="street">Strasse</label>
<input type="text" class="form-control" name="street" placeholder="Geben Sie die Strasse an" value="<%=request.getParameter("inhalt_street") == null ? "" : request.getParameter("inhalt_street") %>" required/>
<% if(request.getParameter("fehler_street") == null || (String.valueOf(request.getParameter("fehler_street")).equals(""))) { out.println(""); } else { out.println("<div class=\"error_message\">" + request.getParameter("fehler_street") + "</div>"); } ;  %> 
</div>

<div class="form-group">
<label for="plz">PLZ</label>
<input type="number" class="form-control" name="plz" placeholder="PLZ" value="<%=request.getParameter("inhalt_plz") == null ? "" : request.getParameter("inhalt_plz") %>" required />
<% if(request.getParameter("fehler_plz") == null || (String.valueOf(request.getParameter("fehler_plz")).equals(""))) { out.println(""); } else { out.println("<div class=\"error_message\">" + request.getParameter("fehler_plz") + "</div>"); } ;  %> 
</div>

<div class="form-group">
<label for="city">Ort</label>
<input type="text" class="form-control" name="city" placeholder="Ort" value="<%=request.getParameter("inhalt_city") == null ? "" : request.getParameter("inhalt_city") %>" required />
<% if(request.getParameter("fehler_city") == null || (String.valueOf(request.getParameter("fehler_city")).equals(""))) { out.println(""); } else { out.println("<div class=\"error_message\">" + request.getParameter("fehler_city") + "</div>"); } ;  %> 
</div>


<div class="form-group">
<label for="email">E-Mail</label>
<input type="email" class="form-control" name="email" placeholder="Geben Sie die E-Mail an" value="<%=request.getParameter("inhalt_email") == null ? "" : request.getParameter("inhalt_email") %>" required/>
<% if(request.getParameter("fehler_email") == null || (String.valueOf(request.getParameter("fehler_email")).equals(""))) { out.println(""); } else { out.println("<div class=\"error_message\">" + request.getParameter("fehler_email") + "</div>"); } ;  %> 
</div>

<div class="form-group">
<img src="./stickyImg" />
<input class="form-control" name="answer" placeholder="Bitte geben Sie die Werte vom Bild ein" />
<% if(request.getParameter("fehler_captcha") == null || (String.valueOf(request.getParameter("fehler_captcha")).equals(""))) { out.println(""); } else { out.println("<div class=\"error_message\">" + request.getParameter("fehler_captcha") + "</div>"); } ;  %> 
</div>

<div class="checkbox">
<label>
<input type="checkbox" name="agb" required />akzeptiere die AGB</label>
<% if(request.getParameter("fehler_agb") == null || (String.valueOf(request.getParameter("fehler_agb")).equals(""))) { out.println(""); } else { out.println("<div class=\"error_message\">" + request.getParameter("fehler_agb") + "</div>"); } ;  %> 
</div>

<input type="submit" class="btn-primary" value="Registrieren" />
</form>
<% if(request.getParameter("fehler_double") == null || (String.valueOf(request.getParameter("fehler_double")).equals(""))) { out.println(""); } else { out.println("<div class=\"error_message\">" + request.getParameter("fehler_double") + "</div>"); } ;  %> 
</div>
</body>
</html>