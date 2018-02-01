<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
    function toSearch(){
    	$.post('role/initRole',function(result){
    		$("#roleList").html(result);
    	});
    }
    function toSearchByCondition(){
    	var _data = $("#RoleForm").serialize();
    	$.post("role/searchRoles",_data,function(result){
    		$("#roleList").html(result);
    	});
    }
    function toAdd(){
    	var _data = $("#RoleForm").serialize();
    	alert(_data);
    	$.post("role/addRole",_data,function(msg){
    		alert(msg);
    		toSearch();
    	},"html");
    }
    function toSearchRole(_id){
        var _data = "rlId=" + _id;
        $.post('role/searchRoleById', _data, function(data) {

            $("#rlId").val(data.rlId);
            $("#rlName").val(data.rlName);
            $("#rlRemark").val(data.rlRemark);

        },"json");
    }
    function toEdit(){
        var _data = $("#RoleForm").serialize();
        $.post("role/updateRole",_data,function(msg){
            toSearchByCondition();
            alert(message);
        },"html");
    }
    function toDelete(){
        var _id = $("#rlId").val();
        if(!_id || parseInt(_id)<=0){
            alert("请选择要删除的角色");
        }else{
            var _data = $("#RoleForm").serialize();
            $.post("role/deleteRole",_data,function(msg){
                toSearch();
                alert(msg);
            },"html");
        }
    }

</script>
<div id="mynav" class="row">
            <ol class="breadcrumb">
              <li><a href="#">管理角色</a></li>
              <li class="active">管理角色</li>
            </ol>
         </div>
         
         <!--表单-->
         <div class="row">
            <form id="RoleForm" class=" form-horizontal">
                <input type="hidden" name="rlId" id="rlId" value="0">

            <div class="form-group">
               <label for="rlName" class="col-md-2 control-label">角色名称</label>
                <div class="col-md-4">
                  <input type="text" name="rlName" id="rlName" class="form-control"/>
                </div>
            </div>
            
            <div class="form-group">
               <label for="rlRemark" class="col-md-2 control-label">角色描述</label>
                <div class="col-md-4">
                  <input type="text" name="rlRemark" id="rlRemark" class="form-control"/>
                </div>
            </div>
            <div class="form-group">
              <div class="col-md-2"></div>
              <div class="col-md-10">
                 <button type="button" class="btn btn-primary" onclick="toAdd()">添加</button>
                 <button type="button" class="btn btn-primary" onclick="toEdit()">修改</button>
                 <button type="button" class="btn btn-primary" onclick="toDelete()">删除</button>
                 <button type="button" class="btn btn-primary" onclick="toSearchByCondition()">查询</button>
                 <button type="button" class="btn btn-primary" onclick="todeployRole()">分配权限项</button>
              </div>
            </div>
            </form>
         </div>
         
         <!--列表-->
         <div id="roleList" class="row">
           
          
         </div>
<script type="text/javascript">
    toSearch();
</script>