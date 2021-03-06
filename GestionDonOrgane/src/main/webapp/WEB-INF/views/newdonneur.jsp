<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Formulaire de cr�ation d'un nouveau donneur</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>

 	<div class="form-container">
 	
 	<h1>Cr�ation d'un nouveau donneur</h1>

	<form:form method="POST" action="registerNewDonneur" commandName="donneur" class="form-horizontal">
		
		<!--  PARTICULARITE DONNEUR  -->
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="firstName">Nom</label>
				<div class="col-md-7">
					<form:input type="text" path="nom" id="firstName" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="nom" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="groupe_sang">Groupe sanguain</label>
				<div class="col-md-7">
					<form:input type="text" path="groupe_sang" id="groupe_sang" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="groupe_sang" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		
		
		

		<div class="row">
			<div class="form-actions floatRight">
				<input type="submit" value="Valider" class="btn btn-primary btn-sm"> ou <a href="<c:url value='/docteur' />">Annuler</a>
			</div>
		</div>
	</form:form>
	</div>
</body>
</html>