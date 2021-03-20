<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Product Name</th>
				<th>Category</th>
				<th>Condition</th>
				<th>Price</th>			
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${ product.name }</td>
				<td>${ product.category }</td>
				<td>${ product.condition }</td>
				<td>${ product.price }</td>			
			</tr>
		</tbody>
	</table>
</body>
</html>