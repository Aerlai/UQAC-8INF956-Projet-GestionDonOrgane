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
		<h2>${patient.firstName} ${patient.lastName}</h2>
		<article class="success">
			<p>Date de naissance : ${patient.birthday}</p>
			<p>Email : ${patient.email}</p>
			<p>Groupe sanguain : ${patient.groupe_sang}</p>
			<p>Docteur : Docteur ${patient.docteur.lastName}</p>
		</article>

		<h2>Etat besoins</h2>
		<article class="success">
			<table class="table table-over">
				<thead>
			      <tr>
			        <th>Organe</th>
			        <th>Rang</th>
			      </tr>
			    </thead>
			  <c:forEach items="${besoins}" var="besoin">
			    <tr>
			      <td><c:out value="${besoin.organe.organe}" /></td>
			      <td><c:out value="${besoin.rank}" /></td>
			    </tr>
			  </c:forEach>
			</table>
		</article>
	</section>
</body>
</html>