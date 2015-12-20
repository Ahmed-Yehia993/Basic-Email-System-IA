<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/style.css" rel="stylesheet">
<title>Login</title>

</head>
<body class="login_body">
	<div class="container">
		<h1 style="margin-left: 28%; margin-top: 11%;">
			<strong>Basic</strong> Email
		</h1>
		<div class="login_form">
			<form class="form-horizontal">
				<br></br>
				<div class="form-group ">
					<label for="inputEmail3"
						class="col-md-3 .col-md-offset-3 control-label">Email</label>
					<div class="col-md-3 .col-md-offset-3">
						<input type="email" class="form-control " id="inputEmail3"
							placeholder="Email" style="width: 300px">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3"
						class="col-md-3 .col-md-offset-3 control-label">Password</label>
					<div class="col-md-3 .col-md-offset-3">
						<input type="password" class="form-control" id="inputPassword3"
							placeholder="Password" style="width: 300px">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<div class="checkbox">
							<label> <input type="checkbox"> Remember me
							</label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-primary">Log in</button>
					</div>
				</div>
				<button type="button" class="btn btn-link">
					<a href="signup.jsp">Register a new membership</a>
				</button>
				<br></br>
			</form>
		</div>
	</div>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/jquery-1.11.3.min.js"></script>
</body>
</html>