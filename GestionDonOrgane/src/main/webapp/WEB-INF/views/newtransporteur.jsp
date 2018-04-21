<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Transporteur Registration Form</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>

 	<div class="form-container">
 	
 	<h1>New Transporteur Registration Form</h1>

	<form:form method="POST" action="registerNewTransporteur" commandName="registerTransporteur" class="form-horizontal">
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="name">Nom</label>
				<div class="col-md-7">
					<form:input type="text" path="transporteur.Nom" id="name" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="transporteur.nom" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="email">Email</label>
				<div class="col-md-7">
					<form:input type="text" path="transporteur.email" id="email" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="transporteur.email" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		
		
		
		<!-- ADRESSE -->
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="Address1">Address1</label>
				<div class="col-md-7">
					<form:input type="text" path="adresse.Address1" id="Address1" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="adresse.Address1" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="Address2">Address2</label>
				<div class="col-md-7">
					<form:input type="text" path="adresse.Address2" id="Address2" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="adresse.Address2" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="Address3">Address3</label>
				<div class="col-md-7">
					<form:input type="text" path="adresse.Address3" id="Address3" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="adresse.Address3" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="City">City</label>
				<div class="col-md-7">
					<form:input type="text" path="adresse.City" id="City" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="adresse.City" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="State">State</label>
				<div class="col-md-7">
					<form:input type="text" path="adresse.State" id="State" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="adresse.State" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="Country">Country</label>
				<div class="col-md-7">
					<form:input type="text" path="adresse.Country" id="adresse.Country" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="adresse.Country" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="PostalCode">Postal Code</label>
				<div class="col-md-7">
					<form:input type="text" path="adresse.PostalCode" id="PostalCode" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="adresse.PostalCode" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		

		<div class="row">
			<div class="form-actions floatRight">
				<input type="submit" value="Register" class="btn btn-primary btn-sm"> or <a href="<c:url value='/admin' />">Cancel</a>
			</div>
		</div>
	</form:form>
	</div>
</body>
</html>