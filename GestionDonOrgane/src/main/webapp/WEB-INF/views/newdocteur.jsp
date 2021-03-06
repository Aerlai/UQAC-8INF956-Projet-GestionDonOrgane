<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Formulaire de cr�ation de docteur</title>
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
			<h1>Cr�ation de docteur</h1>

	<form:form method="POST" action="registerNewDocteur" commandName="registerDocteur" class="form-horizontal">
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="firstName">Pr�nom</label>
				<div class="col-md-7">
					<form:input type="text" path="docteur.firstName" id="firstName" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="docteur.firstName" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="lastName">Nom</label>
				<div class="col-md-7">
					<form:input type="text" path="docteur.lastName" id="lastName" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="docteur.lastName" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="ssoId">Login</label>
				<div class="col-md-7">
					<form:input type="text" path="docteur.ssoId" id="ssoId" class="form-control input-sm"/>
					<div class="has-error">
						<c:if test="${not empty error}">
						   <p style="color: red;">${error}</p>
						</c:if>
						<form:errors path="docteur.ssoId" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="password">Mot de passe</label>
				<div class="col-md-7">
					<form:input type="password" path="docteur.password" id="password" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="docteur.password" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="email">Email</label>
				<div class="col-md-7">
					<form:input type="text" path="docteur.email" id="email" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="docteur.email" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="birthday">Date de naissance</label>
				<div class="col-md-7">
					<form:input type="date" path="docteur.birthday" id="birthday" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="docteur.birthday" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>


		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="userProfiles">Roles</label>
				<div class="col-md-7">
					<form:select path="docteur.userProfiles" items="${roles}" multiple="true" itemValue="id" itemLabel="type" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="docteur.userProfiles" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		
		<!--  PARTICULARITE DOCTEUR  -->
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="specialite">Specialite </label>
				<div class="col-md-7">
					<form:input type="text" path="docteur.specialite" id="specialite" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="docteur.specialite" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="userProfiles">Hopital</label>
				<div class="col-md-7">
					<form:select path="docteur.hopital" items="${hopitaux}" multiple="true" itemValue="nom" itemLabel="nom" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="docteur.hopital" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		
		

		<div class="row">
			<div class="form-actions floatRight">
				<input type="submit" value="Register" class="btn btn-primary btn-sm"> ou <a href="<c:url value='/admin' />">Annuler</a>
			</div>
		</div>
	</form:form>
		</article>
	</section>
</body>
</html>