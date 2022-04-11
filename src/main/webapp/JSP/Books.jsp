<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/bootstrap.min.css" rel="stylesheet">
<title>Library</title>
</head>
<body>
	<div class="container col-md-10 col-md-offset-1">
		<div class="panel panel-primary">
			<div class="panel-heading"><center>
			<h1 class="h1">Les livres disponnibles</h1>
		</center></div>
			<div class="panel-body">
					
		<form method="post" action="addtocard.do">
			<table class="table">
				<thead class="thead-light">
					<tr>
						<th scope="col">#</th>
						<th scope="col">SBN</th>
						<th scope="col">Title</th>
						<th scope="col">Price</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${library.books }" var="book">
					<tr>
						<td><input class="form-check-input mt-0" type="checkbox" name="checked"
							value="${book.SBN }" ></td>
						<td>${book.SBN }</td>
						<td>${book.title }</td>
						<td>${book.price }<span>   DH</span></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			<button type="submit" class="btn btn-primary">Add to Card</button>
		</form>

			</div>
		</div>
	</div>
</body>
</html>