<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />	
		<title>Order Params</title>
	</head>
	<body>
		<section>
			<h1>Order Params</h1>
			<ul>
				<li>
					<p> Name: ${requestScope.order.name}</p>
				</li>
				<li>
					<p> Addre: ${requestScope.order.address}</p>
				</li>
				<li>
					<p> Countr: ${requestScope.order.country}</p>
				</li>
				<li>
					<p> Deliver Method: ${requestScope.order.delivery}</p>
				</li>
				<li>
					<p> Payment: ${requestScope.order.payment}</p>
				</li>
				<li>
					<p> Comment: ${requestScope.order.comment}</p>
				</li>
			</ul>
		</section>
	</body>
</html>