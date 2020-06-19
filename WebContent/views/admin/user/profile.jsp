<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="page-content">

				<!-- /.ace-settings-container -->

				<div class="page-header">
					<h1>
						User Profile Page <small> <i
							class="ace-icon fa fa-angle-double-right"></i> 3 styles with
							inline editable feature
						</small>
					</h1>
				</div>
				<!-- /.page-header -->

				<div class="row">
					<div class="col-xs-12">
						<!-- PAGE CONTENT BEGINS -->

						<div>
							<div id="user-profile-1" class="user-profile row">
								<div class="col-xs-12 col-sm-3 center">
									<div>
										<span class="profile-picture"> <img id="avatar"
											class="editable img-responsive" alt="Alex's Avatar"
											src="template/assets/avatars/profile-pic.jpg" />
										</span>

										<div class="space-4"></div>

										<div
											class="width-80 label label-info label-xlg arrowed-in arrowed-in-right">
											<div class="inline position-relative">
												<a href="#" class="user-title-label dropdown-toggle"
													data-toggle="dropdown"> <i
													class="ace-icon fa fa-circle light-green"></i> &nbsp; <span
													class="white">Alex M. Doe</span>
												</a>

												<ul
													class="align-left dropdown-menu dropdown-caret dropdown-lighter">
													<li class="dropdown-header">Change Status</li>

													<li><a href="#"> <i
															class="ace-icon fa fa-circle green"></i> &nbsp; <span
															class="green">Available</span>
													</a></li>

													<li><a href="#"> <i
															class="ace-icon fa fa-circle red"></i> &nbsp; <span
															class="red">Busy</span>
													</a></li>

													<li><a href="#"> <i
															class="ace-icon fa fa-circle grey"></i> &nbsp; <span
															class="grey">Invisible</span>
													</a></li>
												</ul>
											</div>
										</div>
									</div>
									<div class="hr hr16 dotted"></div>
								</div>

								<div class="col-xs-12 col-sm-9">
									<div class="center">
										<span class="btn btn-app btn-sm btn-pink no-hover"> <span
											class="line-height-1 bigger-170"> 4 </span> <br /> <span
											class="line-height-1 smaller-90"> Projects </span>
										</span> <span class="btn btn-app btn-sm btn-grey no-hover"> <span
											class="line-height-1 bigger-170"> 23 </span> <br /> <span
											class="line-height-1 smaller-90"> Reviews </span>
										</span> <span class="btn btn-app btn-sm btn-success no-hover">
											<span class="line-height-1 bigger-170"> 7 </span> <br /> <span
											class="line-height-1 smaller-90"> Albums </span>
										</span>
									</div>

									<div class="space-12"></div>

									<div class="profile-user-info profile-user-info-striped">
										<div class="profile-info-row">
											<div class="profile-info-name">Username</div>

											<div class="profile-info-value">
												<span class="editable" id="username">alexdoe</span>
											</div>
										</div>

										<div class="profile-info-row">
											<div class="profile-info-name">Location</div>

											<div class="profile-info-value">
												<i class="fa fa-map-marker light-orange bigger-110"></i> <span
													class="editable" id="country">Netherlands</span> <span
													class="editable" id="city">Amsterdam</span>
											</div>
										</div>

										<div class="profile-info-row">
											<div class="profile-info-name">Age</div>

											<div class="profile-info-value">
												<span class="editable" id="age">38</span>
											</div>
										</div>

										<div class="profile-info-row">
											<div class="profile-info-name">Joined</div>

											<div class="profile-info-value">
												<span class="editable" id="signup">2010/06/20</span>
											</div>
										</div>

										<div class="profile-info-row">
											<div class="profile-info-name">Last Online</div>

											<div class="profile-info-value">
												<span class="editable" id="login">3 hours ago</span>
											</div>
										</div>

										<div class="profile-info-row">
											<div class="profile-info-name">About Me</div>

											<div class="profile-info-value">
												<span class="editable" id="about">Editable as WYSIWYG</span>
											</div>
										</div>
									</div>


								</div>
							</div>
						</div>
						<!-- PAGE CONTENT ENDS -->
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</div>
		</div>
	</div>
</body>
</html>