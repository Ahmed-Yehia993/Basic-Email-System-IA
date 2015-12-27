<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.basicemail.entity.User"%>
<%@page import="com.basicemail.service.UserServices"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/style.css" rel="stylesheet">
<title>profile</title>
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/jquery-1.11.3.min.js"></script>
</head>
<%
	UserServices use = new UserServices();
	Object userId = session.getAttribute("logedInUserId");
	String id = userId.toString();
	
	//out.print(id);

	User currentUser = use.getUserByID(id);
%>
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
				<form class="navbar-form navbar-left" role="search" >
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
				<form class="navbar-form navbar-left " role="profile"
					action="profile.jsp">
					<button type="submit" class="btn btn-default profile">
						<%
							out.print(session.getAttribute("logedInUseremail"));
						%>
					</button>
				</form>
				<form class="navbar-form navbar-left " role="logout"
					action="LogoutServelet">
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
				</a> <br> <br>
				<div class="list-group">
					<a href="home.jsp" class="list-group-item active"> Index </a> <a
						href="sent.jsp" class="list-group-item">Sent</a> <a
						href="archived.jsp" class="list-group-item">Archived</a> <a
						href="trach.jsp" class="list-group-item">Trach</a>
				</div>
			</div>
			<div class="col-md-9">
				<form class="form-horizontal" action="UpdateProfile" method="post">
					<div class="form-group ">
						<label for="firstName"
							class="col-md-3 .col-md-offset-3 control-label">First
							Name</label>
						<div class="col-md-3 .col-md-offset-3">
							<input type="text" class="form-control" name="firstName"
								id="firstName" placeholder="First Name" style="width: 300px"
								value="<%=currentUser.getFirstname() %>" required>
						</div>
					</div>
					<div class="form-group ">
					<label for="secondName"
						class="col-md-3 .col-md-offset-3 control-label">Last Name</label>
					<div class="col-md-3 .col-md-offset-3">
						<input type="text" class="form-control" name="secondName"
							id="secondName" placeholder="Last Name" style="width: 300px"
							value="<%=currentUser.getLastname() %>" required>
					</div>
				</div>
				<div class="form-group ">
					<label for="inputEmail3"
						class="col-md-3 .col-md-offset-3 control-label">Email</label>
					<div class="col-md-3 .col-md-offset-3">
						<input type="email" class="form-control" name="inputEmail3"
							id="inputEmail3" placeholder="Email" style="width: 300px"
							 value="<%=currentUser.getEmail() %>" required readonly="readonly">
					</div>
				</div>
				<div class="form-group ">
					<label for="inputPhone"
						class="col-md-3 .col-md-offset-3 control-label">Pone</label>
					<div class="col-md-3 .col-md-offset-3">
						<input type="number" class="form-control" name="inputPhone"
							id="inputPhone" placeholder="phone" style="width: 300px"
							 value="<%=currentUser.getPhone() %>">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-primary" onclick="alert('successfuly updated')">Update</button>
					</div>
				</div>
								
				</form>
			</div>
		</div>
	</div>

</body>
</html>