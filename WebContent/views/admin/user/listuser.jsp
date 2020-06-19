<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách nhân viên</title>
</head>
<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="page-content">
				<div class="page-header">
					<h1>Danh sách nhân viên</h1>
				</div>
				<!-- /.page-header -->

				<div class="row">
					<div class="col-xs-12">
						<!-- PAGE CONTENT BEGINS -->
						<div class="widget-box table-filter">
							<div class="table-btn-controls">
								<div class="pull-right tableTools-container">
									<div class="dt-buttons btn-overlap btn-group">
										<a flag="info"
											class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
											data-toggle="tooltip" title='Thêm bài viết'
											href='<c:url value="/admin-new?type=edit"/>'> <span>
												<i class="fa fa-plus-circle bigger-110 purple"></i>
										</span>
										</a>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12">
								<table id="simple-table"
									class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th class="center"><label class="pos-rel"> <input
													type="checkbox" class="ace" /> <span class="lbl"></span>
											</label></th>
											<th>Họ tên</th>
											<th>Email</th>
											<th class="hidden-480">Điện thoại</th>

											<th><i
												class="ace-icon fa fa-clock-o bigger-110 hidden-480"></i>
												Avatar</th>
											<th class="hidden-480">Action</th>
										</tr>
									</thead>

									<tbody>
										<tr>
											<td class="center"><label class="pos-rel"> <input
													type="checkbox" class="ace" /> <span class="lbl"></span>
											</label></td>

											<td><a href="#">Nguyễn Thành Long</a></td>
											<td class="hidden-480">Longzip113@gmail.com</td>

											<td class="hidden-480">0356614</td>

											<td>15.12.2013</td>
											<td><span class="label label-sm label-warning">Online</span></td>
										</tr>
									</tbody>
								</table>
							</div>
							<!-- /.span -->
						</div>
						<!-- /.row -->
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.page-content -->
		</div>
	</div>
</body>
</html>