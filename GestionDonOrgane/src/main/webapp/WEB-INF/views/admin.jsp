<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Admin page</title>
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
			<p><a href="<c:url value='/newDocteur' />">Cr�er un nouveau docteur</a></p>
			<p><a href="<c:url value='/newHopital' />">Cr�er un nouveau hopital</a></p>
			<p><a href="<c:url value='/newTransporteur' />">Cr�er un nouveau transporteur</a></p>
		</article>
	</section>
	
	<section>
		<h2>Liste des hopitaux</h2>
		<article class="success">
			<table class="table table-over">
				<thead>
			      <tr>
			        <th>Nom</th>
			        <th>Ville</th>
			        <th>D�tail</th>
			      </tr>
			    </thead>
			  <c:forEach items="${hopitaux}" var="hopital">
			    <tr>
			      <td><c:out value="${hopital.nom}" /></td>
			      <td><c:out value="${hopital.adresse.city}" /></td>
			      <td><a href="<c:url value='/hopital/details/${hopital.id}' />"> D�tail</a></td>
			    </tr>
			  </c:forEach>
			</table>
		</article>
	</section>
	
	<section>
		<h2>Liste des transporteurs</h2>
		<article class="success">
			<table class="table table-over">
				<thead>
			      <tr>
			        <th>Nom</th>
			        <th>Ville</th>
			        <th>D�tail</th>
			      </tr>
			    </thead>
			  <c:forEach items="${transporteurs}" var="trans">
			    <tr>
			      <td><c:out value="${trans.nom}" /></td>
			      <td><c:out value="${trans.adresse.city}" /></td>
			      <td><a href="<c:url value='/transporteur/details/${trans.id}' />"> D�tail</a></td>
			    </tr>
			  </c:forEach>
			</table>
		</article>
	</section>
</body>
</html>