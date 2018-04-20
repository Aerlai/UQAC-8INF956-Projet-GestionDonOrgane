<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>User Registration Form</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>

 	<div class="form-container">
 	
 	<h1>New User Registration Form</h1>

	<form:form method="POST" action="registerNewPatient" commandName="registerPatient" class="form-horizontal">
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="firstName">First Name</label>
				<div class="col-md-7">
					<form:input type="text" path="patient.firstName" id="firstName" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="patient.firstName" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="lastName">Last Name</label>
				<div class="col-md-7">
					<form:input type="text" path="patient.lastName" id="lastName" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="patient.lastName" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="ssoId">SSO ID</label>
				<div class="col-md-7">
					<form:input type="text" path="patient.ssoId" id="ssoId" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="patient.ssoId" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="password">Password</label>
				<div class="col-md-7">
					<form:input type="password" path="patient.password" id="password" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="patient.password" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="email">Email</label>
				<div class="col-md-7">
					<form:input type="text" path="patient.email" id="email" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="patient.email" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="birthday">Birthday</label>
				<div class="col-md-7">
					<form:input type="date" path="patient.birthday" id="birthday" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="patient.birthday" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>


		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="userProfiles">Roles</label>
				<div class="col-md-7">
					<form:select path="patient.userProfiles" items="${roles}" multiple="true" itemValue="id" itemLabel="type" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="patient.userProfiles" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		
		<!--  PARTICULARITE PATIENT  -->
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="groupe_sang">Groupe sanguain</label>
				<div class="col-md-7">
					<form:input type="text" path="patient.groupe_sang" id="groupe_sang" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="patient.groupe_sang" class="help-inline"/>
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
				<input type="submit" value="Register" class="btn btn-primary btn-sm"> or <a href="<c:url value='/docteur' />">Cancel</a>
			</div>
		</div>
	</form:form>
	</div>
</body>
</html>