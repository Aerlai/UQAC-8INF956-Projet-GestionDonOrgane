<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Patient</title>
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
	<h2>Hopital :${hopital.nom} </h2>
		<article class="success">
			<table class="table table-striped">
			    <tbody>
			    <tr>
			        <td>Adresse email</td>
			        <td>${hopital.email}</td>
			      </tr>
			      <tr>
			        <td>Adresse 1</td>
			        <td>${hopital.adresse.address1}</td>
			      </tr>
			      <tr>
			        <td>Adresse 2</td>
			        <td>${hopital.adresse.address2}</td>
			      </tr>
			      <tr>
			        <td>Adresse 3</td>
			        <td>${hopital.adresse.address3}</td>
			      </tr>
			      <tr>
			        <td>Ville</td>
			        <td>${hopital.adresse.city}</td>
			      </tr>
			      <tr>
			        <td>Code postal</td>
			        <td>${hopital.adresse.postalCode}</td>
			      </tr>
			      <tr>
			        <td>Région</td>
			        <td>${hopital.adresse.state}</td>
			      </tr>
			      <tr>
			        <td>Pays</td>
			        <td>${hopital.adresse.country}</td>
			      </tr>
			    </tbody>
			 </table>
		</article>
		
		<h2>Liste des médecins</h2>
		
		<article class="success">
			<table class="table table-over">
				<thead>
			      <tr>
			        <th>Nom</th>
			        <th>Spécialité</th>
			      </tr>
			    </thead>
			  <c:forEach items="${docteurs}" var="med">
			    <tr>
			      <td><c:out value="${med.firstName} ${med.lastName}" /></td>
			      <td><c:out value="${med.specialite}" /></td>
			    </tr>
			  </c:forEach>
			</table>
		</article>
		
<a class="btn btn-primary btn-md" href="<c:url value="/admin"/>">Retour</a>
	</section>
</body>
</html>