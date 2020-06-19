<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta charset="UTF-8">

		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Tables - Ace Admin</title>

		<meta name="description" content="Static &amp; Dynamic Tables" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="<c:url value='/template/assets/css/bootstrap.min.css' />" />
		<link rel="stylesheet" href="<c:url value='/template/assets/font-awesome/4.2.0/css/font-awesome.min.css' />" />

		<!-- page specific plugin styles -->

		<!-- text fonts -->
		<link rel="stylesheet" href="<c:url value='/template/assets/fonts/fonts.googleapis.com.css' />" />

		<!-- ace styles -->
		<link rel="stylesheet" href="<c:url value='/template/assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style' />" />

		<script src="<c:url value='/template/assets/js/ace-extra.min.js' />"></script>
</head>
<body>
		<!-- header -->
	<%@ include file="/common/admin/header.jsp"%>
	<!-- header -->

	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>

		<!-- menu -->
		<%@ include file="/common/admin/menu.jsp"%>
		<!-- menu -->

		<dec:body />

		<!-- footer -->
		<%@ include file="/common/admin/footer.jsp"%>
		<!-- footer -->

		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse display"> <i
			class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>
	</div>
	
	<script src="<c:url value='/template/assets/js/jquery.2.1.1.min.js' />"></script>
		<script src="<c:url value='/template/assets/js/bootstrap.min.js' />"></script>
		<!-- page specific plugin scripts -->
		<script src="<c:url value='/template/assets/js/jquery.dataTables.min.js' />"></script>
		<script src="<c:url value='/template/assets/js/jquery.dataTables.bootstrap.min.js' />"></script>
		<script src="<c:url value='/template/assets/js/dataTables.tableTools.min.js' />"></script>
		<script src="<c:url value='/template/assets/js/dataTables.colVis.min.js' />"></script>

		<!-- ace scripts -->
		<script src="<c:url value='/template/assets/js/ace-elements.min.js' />"></script>
		<script src="<c:url value='/template/assets/js/ace.min.js' />"></script>
</body>
</html>