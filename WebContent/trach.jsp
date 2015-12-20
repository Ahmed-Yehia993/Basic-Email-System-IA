<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/style.css" rel="stylesheet">
<title>trach</title>

</head>
<body class="login_body">
	<div class="container">
		<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Basic Email</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<div class="nav navbar-nav"></div>
				<form class="navbar-form navbar-left" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
				<form class="navbar-form navbar-left " role="profile">
					<button type="submit" class="btn btn-default profile">profile</button>
				</form>
				<form class="navbar-form navbar-left " role="logout">
					<button type="submit" class="btn btn-default log_out">logout</button>
				</form>

			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid --> </nav>
		<div class="row">
			<div class="col-md-3">
				<a href="compose.jsp">
					<button type="button" class="btn btn-primary" style="width: 100%">
						Compose</button>
				</a>
				<br> <br>
				<div class="list-group">
					<a href="home.jsp" class="list-group-item "> Index </a> <a href="sent.jsp"
						class="list-group-item ">Sent</a> <a href="archived.jsp"
						class="list-group-item ">Archived</a> <a href="trach.jsp"
						class="list-group-item active">Trach</a>
				</div>
			</div>
			<div class="col-md-9">
				<table class="table table-striped table-bordered">
					<thead>
						<tr class="infoo">
							<td style="color: white">Sender</td>
							<td style="color: white">subject</td>
							<td style="color: white">Time</td>
							<td style="color: white">Delete</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><a href="#">ahmed</a></td>
							<td>hello</td>
							<td>10-12-2015</td>
							<td>
								<button class="btn btn-danger">delete</button>
							</td>
						</tr>
						<tr>
							<td><a href="#">ahmed</a></td>
							<td>hello</td>
							<td>10-12-2015</td>
							<td>
								<button class="btn btn-danger">delete</button>
							</td>
						</tr>
						<tr>
							<td><a href="#">ahmed</a></td>
							<td>hello</td>
							<td>10-12-2015</td>
							<td>
								<button class="btn btn-danger">delete</button>
							</td>
						</tr>
						<tr>
							<td><a href="#">ahmed</a></td>
							<td>hello</td>
							<td>10-12-2015</td>
							<td>
								<button class="btn btn-danger">delete</button>
							</td>
						</tr>
						<tr>
							<td><a href="#">ahmed</a></td>
							<td>hello</td>
							<td>10-12-2015</td>
							<td>
								<button class="btn btn-danger">delete</button>
							</td>
						</tr>
						<tr>
							<td><a href="#">ahmed</a></td>
							<td>hello</td>
							<td>10-12-2015</td>
							<td>
								<button class="btn btn-danger">delete</button>
							</td>
						</tr>
						<tr>
							<td><a href="#">ahmed</a></td>
							<td>hello</td>
							<td>10-12-2015</td>
							<td>
								<button class="btn btn-danger">delete</button>
							</td>
						</tr>
						<tr>
							<td><a href="#">ahmed</a></td>
							<td>hello</td>
							<td>10-12-2015</td>
							<td>
								<button class="btn btn-danger">delete</button>
							</td>
						</tr>
						<tr>
							<td><a href="#">ahmed</a></td>
							<td>hello</td>
							<td>10-12-2015</td>
							<td>
								<button class="btn btn-danger">delete</button>
							</td>
						</tr>
						<tr>
							<td><a href="#">ahmed</a></td>
							<td>hello</td>
							<td>10-12-2015</td>
							<td>
								<button class="btn btn-danger">delete</button>
							</td>
						</tr>
						<tr>
							<td><a href="#">ahmed</a></td>
							<td>hello</td>
							<td>10-12-2015</td>
							<td>
								<button class="btn btn-danger">delete</button>
							</td>
						</tr>
						<tr>
							<td><a href="#">ahmed</a></td>
							<td>hello</td>
							<td>10-12-2015</td>
							<td>
								<button class="btn btn-danger">delete</button>
							</td>
						</tr>

					</tbody>
					<tfoot>
						<tr class="infoo">
							<td style="color: white">Sender</td>
							<td style="color: white">subject</td>
							<td style="color: white">Time</td>
							<td style="color: white">Delete</td>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
		<script src="resources/js/bootstrap.min.js"></script>
		<script src="resources/js/jquery-1.11.3.min.js"></script>
</body>
</html>