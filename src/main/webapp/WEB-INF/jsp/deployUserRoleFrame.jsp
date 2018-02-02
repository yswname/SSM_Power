<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
    function toSearchUsers(){
    	
    	var _data = $("#searchUserForm").serialize();
    	$.post("power/searchUsers",_data,function(msg){
    		//alert(msg);
    		$("#piList").html(msg);
    	});
    }
</script>
         <div id="mynav" class="row">
            <ol class="breadcrumb">
              <li><a href="#">权限管理模块</a></li>
              <li>分配用户角色</li>
              <li class="active">用户列表</li>
            </ol>
         </div>
         
         <!--表单-->
         <div class="row">
            <form id="searchUserForm" class="form-inline">
              <div class="form-group">
                 <label for="userName">用户名：</label>
                 <input type="text" class="form-control" id="urUserName" name="urUserName">

              </div>
              <div class="form-group">
                 <label for="name">姓名：</label>
                 <input type="text" class="form-control" id="urName" name="urName">

              </div>
              <button type="button" class="btn btn-default" onclick="toSearchUsers()">查询</button>

            </form>
         </div>
         
         <!--列表-->
         <div id="piList" class="row">
           
          
         </div>
  <script type="text/javascript">
     toSearchUsers();
  </script>