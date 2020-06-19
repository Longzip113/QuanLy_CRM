<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách thành viên</title>
</head>
<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="page-content">
				<div class="page-header">
					<h1>Danh sách thành viên</h1>
				</div>
				<!-- /.page-header -->
				<div class="alert alert-${alerts}" role="alert">${message}
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>

				<div class="row">
					<div class="col-xs-12">
						<!-- PAGE CONTENT BEGINS -->
						<div class="widget-box table-filter">
							<div class="table-btn-controls">
								<div class="pull-right tableTools-container">
									<div class="dt-buttons btn-overlap btn-group">
										<button type="button" class="btn btn-info" data-toggle="modal"
											data-target="#myModal" data-id="account-modal">Thêm
											thành viên</button>
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
											<th>Họ tên</th>
											<th>Email</th>
											<th>Điện thoại</th>
											<th>Địa chỉ</th>
											<th>Action</th>
										</tr>
									</thead>

									<tbody>
										<c:forEach items="${account}" var="item">
											<tr id="accountRow_${item.id}">
												<td>${item.fullName}</td>
												<td class="hidden-480">${item.email}</td>
												<td class="hidden-480">${item.phone}</td>
												<td>${item.addRess}</td>
												<td>
													<button type="button" class="btn btn-info btn-edit"
														data-toggle="modal" data-target="#myModal"
														data-id="${item.id}" title="Cập nhật bài viết">
														<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
													</button>

													<button type="button"
														class="dt-button buttons-html5 btn btn-white btn-primary btn-bold btnDelete"
														data-toggle="tooltip" data-id="${item.id}" title='Xóa bài viết'>
														<span> <i class="fa fa-trash-o bigger-110 pink"></i>
														</span>
													</button>
												</td>
											</tr>
										</c:forEach>
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

	<!-- Modal -->
	<div id="myModal" class="modal fade" role="dialog"
		data-id="account-modal">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Thông tin thành viên</h4>
				</div>
				<form action="<c:url value='/admin-account'/>" id="formLogin" method="post">
					<div class="modal-body">
						<div class="form-group">
							<label>Email</label> <input type="email" class="form-control"
								id="email" name="email">
						</div>
						<div class="form-group">
							<label>Mật khẩu</label> <input type="password"
								class="form-control" id="password" name="password">
						</div>
						<div class="form-group">
							<label>Nhập lại mật khẩu</label> <input type="password"
								class="form-control" id="confirm" name="confirm">
						</div>
						<div class="form-group">
							<label>Họ tên</label> <input type="text" class="form-control"
								id="fullname" name="fullname">
						</div>
						<div class="form-group">
							<label>Số điện thoại</label> <input type="text"
								class="form-control" id="phone" name="phone">
						</div>
						<div class="form-group">
							<label>Địa chỉ</label> <input type="text" class="form-control"
								id="address" name="address">
						</div>
						<input type=hidden class="form-control" id="account_id" value=""
							name="account_id">

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default btn-default_model" data-dismiss="modal"
							data-id="account-modal">Hủy</button>
						<input type="submit" value="Lưu" class="btn btn-default"
							data-id="account-modal">
					</div>
				</form>
			</div>

		</div>
	</div>

</body>
</html>