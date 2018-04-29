<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Formulaire de création d'un nouveau besoin</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>

 	<div class="form-container">
 	
 	<h1>Création d'un nouveau besoin</h1>


	<h2> Patient : ${patient.firstName} ${patient.lastName} </h2>
	<form:form method="POST" action="${patient.id}" commandName="registerBesoin" class="form-horizontal">
		
		<!--  PARTICULARITE BESOIN  -->
		
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="userProfiles">Organes</label>
				<div class="col-md-7">
					<form:select path="listeBesoin" items="${organes}" multiple="true" itemValue="id" itemLabel="organe" class="form-control input-sm"/>
					<div class="has-error">
						<c:if test="${not empty error}">
						   <p style="color: red;">${error}</p>
						</c:if>
						<form:errors path="listeBesoin" class="help-inline"/>
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