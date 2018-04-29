<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Hopital Registration Form</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
	<nav>
		<ul>
			<li> 
				<a href="<c:url value='/' />">Accueil</a>
			</li>
			<security:authorize access="hasRole('ADMIN')">
				<li> 
					<a href="<c:url value="/admin"/>">Panneau Administrateur</a>
				</li>
			</security:authorize>
			<security:authorize access="hasRole('DOCTEUR')">
				<li> 
					<a href="<c:url value="/docteur"/>">Panneau Docteur</a>
				</li>
			</security:authorize>
			<security:authorize access="hasRole('PATIENT')">
				<li> 
					<a href="<c:url value="/patient"/>">Profil patient</a>
				</li>
			</security:authorize>
			<li>
				<security:authorize access="isAnonymous()">
					<a href="<c:url value="/login"/>">Connexion</a>
				</security:authorize>
				<security:authorize access="isAuthenticated()">
        			<a href="<c:url value="/logout"/>">Logout</a>
   				 </security:authorize>
			</li>
		</ul>
	</nav>
	<section>
		<article class="form-container">
			<h1>Formulaire d'ajout d'un transporteur</h1>

			<form:form method="POST" action="registerNewTransporteur" commandName="registerTransporteur" class="form-horizontal">
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="name">Nom</label>
						<div class="col-md-7">
							<form:input type="text" path="transporteur.Nom" id="name" class="form-control input-sm"/>
							<div class="has-error">
							<c:if test="${not empty error}">
							   <p style="color: red;">${error}</p>
							</c:if>
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
							<form:input type="text" path="adresse.address1" id="Address1" class="form-control input-sm"/>
							<div class="has-error">
								<form:errors path="adresse.address1" class="help-inline"/>
							</div>
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="Address2">Address2</label>
						<div class="col-md-7">
							<form:input type="text" path="adresse.address2" id="Address2" class="form-control input-sm"/>
							<div class="has-error">
								<form:errors path="adresse.address2" class="help-inline"/>
							</div>
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="Address3">Address3</label>
						<div class="col-md-7">
							<form:input type="text" path="adresse.address3" id="Address3" class="form-control input-sm"/>
							<div class="has-error">
								<form:errors path="adresse.address3" class="help-inline"/>
							</div>
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="City">City</label>
						<div class="col-md-7">
							<form:input type="text" path="adresse.city" id="City" class="form-control input-sm"/>
							<div class="has-error">
								<form:errors path="adresse.city" class="help-inline"/>
							</div>
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="State">State</label>
						<div class="col-md-7">
							<form:input type="text" path="adresse.state" id="State" class="form-control input-sm"/>
							<div class="has-error">
								<form:errors path="adresse.state" class="help-inline"/>
							</div>
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="Country">Country</label>
						<div class="col-md-7">
							<form:input type="text" path="adresse.country" id="adresse.Country" class="form-control input-sm"/>
							<div class="has-error">
								<form:errors path="adresse.country" class="help-inline"/>
							</div>
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="PostalCode">Postal Code</label>
						<div class="col-md-7">
							<form:input type="text" path="adresse.postalCode" id="PostalCode" class="form-control input-sm"/>
							<div class="has-error">
								<form:errors path="adresse.postalCode" class="help-inline"/>
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
		</article>
	</section>
</body>
</html>