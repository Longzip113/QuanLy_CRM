<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách nhóm việc</title>
</head>
<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="page-content">
				<div class="page-header">
					<h1>NHÓM VIỆC</h1>
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
											data-target="#myModal" data-id="group-modal">Thêm
											nhóm việc</button>
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
											<th>Mã nhóm việc</th>
											<th>Tên nhóm việc</th>
											<th>Mô tả</th>
											<th>Action</th>
										</tr>
									</thead>

									<tbody>
										<c:forEach items="${group}" var="item">
											<tr id="group_${item.id}">
												<td>${item.id}</td>
												<td class="hidden-480">${item.name}</td>
												<td class="hidden-480">${item.description}</td>
												<td>
													<button type="button" class="btn btn-info btn-group-edit"
														data-toggle="modal" data-target="#myModal"
														data-id="${item.id}" title="Cập nhật bài viết">
														<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
													</button>

													<button type="button"
														class="dt-button buttons-html5 btn btn-white btn-primary btn-bold btn_group_Delete"
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
		data-id="group-modal">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Thêm nhóm việc</h4>
				</div>
				<form action="<c:url value='/admin-group'/>" id="formGroup" method="post">
					<div class="modal-body">
						<div class="form-group">
							<label>Tên nhóm việc</label> <input type="text" class="form-control"
								id="group_name" name="group_name">
						</div>
						
						<div class="form-group">
							<label>Mô tả</label> <textarea
								class="form-control" row="5" id="description" name="description"></textarea>
						</div>
						<input type=hidden class="form-control" id="group_id" value=""
							name="group_id">

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default btn-default_model" data-dismiss="modal"
							data-id="group-modal">Hủy</button>
						<input type="submit" value="Lưu" class="btn btn-default"
							data-id="group-modal">
					</div>
				</form>
			</div>

		</div>
	</div>

</body>
</html>