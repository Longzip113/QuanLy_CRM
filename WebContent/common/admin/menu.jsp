<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="sidebar" class="sidebar                  responsive">
            <script type="text/javascript">
                try {
                    ace.settings.check('sidebar', 'fixed')
                } catch (e) {}
            </script>
            <!-- /.sidebar-shortcuts -->

            <ul class="nav nav-list">
                <li class="">
                    <a href="index.html">
                        <i class="menu-icon fa fa-tachometer"></i>
                        <span class="menu-text"> Thanh điều khiển </span>
                    </a>

                    <b class="arrow"></b>
                </li>

                <li class="">
                    <a href="<c:url value='/admin-account'/>" class="">
                        <i class="menu-icon fa fa-desktop"></i>
                        <span class="menu-text">
								Danh sách thành viên
							</span>
                    </a>
                </li>
                <li class="">
                    <a href="<c:url value='/admin-group'/>" class="">
                        <i class="menu-icon fa fa-pencil-square-o"></i>
                        <span class="menu-text">Danh sách nhóm việc </span>
                    </a>
                </li>

            </ul>
            <!-- /.nav-list -->

            <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
                <i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
            </div>

            <script type="text/javascript">
                try {
                    ace.settings.check('sidebar', 'collapsed')
                } catch (e) {}
            </script>
        </div>