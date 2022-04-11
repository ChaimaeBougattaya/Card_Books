<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container col-md-10 col-md-offset-1">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<center>
					<h1 class="h1">Panier</h1>
				</center>
			</div>
			<div class="panel-body">

				<table class="table">
					<thead>
						<tr>
							<th scope="col">SBN</th>
							<th scope="col">Title</th>
							<th scope="col">Price</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${card.books }" var="book">
							<tr>
								<td>${book.SBN }</td>
								<td>${book.title }</td>
								<td>${book.price }</td>
								<td><a href="delete.do?SBN=${book.SBN }" class="btn btn-danger">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<a href="Books.do" class="btn btn-primary">library</a>
				<a href="deleteall.do" class="btn btn-danger">clear card</a>
			</div>
		</div>
	</div>
</body>
</html>