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
	<h2>Patient : ${patient.firstName} ${patient.lastName} </h2>
		<article class="success">
			<table class="table table-striped">
			    <tbody>
			      <tr>
			        <td>Pr�nom</td>
			        <td>${patient.firstName}</td>
			      </tr>
			      <tr>
			        <td>Nom</td>
			        <td>${patient.lastName}</td>
			      </tr>
			      <tr>
			        <td>Groupe sangain</td>
			        <td>${patient.groupe_sang}</td>
			      </tr>
			    </tbody>
			 </table>
		</article>
		
		<h2>Liste des besoins</h2>
		
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
<a class="btn btn-primary btn-md" href="<c:url value="/docteur"/>">Retour</a>
	</section>
</body>
</html>