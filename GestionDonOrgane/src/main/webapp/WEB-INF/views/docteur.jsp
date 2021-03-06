<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Panneau Docteur</title>
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
		<article class="success">
			<p><a href="<c:url value='/newPatient' />">Cr�er un nouveau patient</a></p>
		</article>
		<article class="success">
			<p><a href="<c:url value='/newDon' />">Cr�er un nouveau don</a></p>
		</article>
		
		<h2>Liste des patients</h2>
		<arcticle>
		<table class="table table-over">
	<thead>
      <tr>
        <th>Pr�nom</th>
        <th>Nom</th>
        <th>Options</th>
      </tr>
    </thead>
  <c:forEach items="${patients}" var="patient">
    <tr>
      <td><c:out value="${patient.firstName}" /></td>
      <td><c:out value="${patient.lastName}" /></td>
      <td> 
      	<a href="<c:url value='/patient/ajouterBesoin/${patient.id}' />"> Ajouter Besoin</a>
      	<a href="<c:url value='/patient/details/${patient.id}' />"> D�tail</a>
      </td>
    </tr>
  </c:forEach>
</table>
		</arcticle>
	</section>
	
	
	
</body>
</html>