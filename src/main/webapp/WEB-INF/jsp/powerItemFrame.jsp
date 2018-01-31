<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
    function toSearch(){
    	$.post('power/searchItems',function(result){
    		$("#piList").html(result);
    	});
    }
    function toSearchByCondition(){
    	var _data = $("#powerItemForm").serialize();
    	$.post("power/searchItems",_data,function(result){
    		$("#piList").html(result);
    	});
    }
    function toAdd(){
    	var _data = $("#powerItemForm").serialize();
    	alert(_data);
    	$.post("power/addPowerItem",_data,function(msg){
    		alert(msg);
    		toSearch();
    	},"html");
    }
    function toSearchItem(_id){
        var _data = "piId=" + _id;
        $.post('power/searchItemById', _data, function(data) {
            // powerItem json
            $("#piId").val(data.piId);
            $("#modul").val(data.dmModul.mdId);
            $("#piName").val(data.piName);
            $("#piUrl").val(data.piUrl);
            $("#piRemark").val(data.piRemark);
        },"json");
    }
    function toEdit(){
        var _data = $("#powerItemForm").serialize();
        $.post("power/updateItem",_data,function(msg){
            toSearchByCondition();
            alert(message);
        },"html");
    }
    function toDelete(){
        var _id = $("#piId").val();
        if(!_id || parseInt(_id)<=0){
            alert("请选择要删除的权限项");
        }else{
            var _data = $("#powerItemForm").serialize();
            $.post("power/deleteItem",_data,function(msg){
                toSearch();
                alert(msg);
            },"html");
        }
    }
</script>
<div id="mynav" class="row">
            <ol class="breadcrumb">
              <li><a href="#">权限管理模块</a></li>
              <li class="active">管理权限项</li>
            </ol>
         </div>
         
         <!--表单-->
         <div class="row">
            <form id="powerItemForm" class=" form-horizontal">
                <input type="hidden" name="piId" id="piId" value="0">
            <div class="form-group">
               <label for="modul" class="col-md-2 control-label">权限模块</label>
                <div class="col-md-4">
                  <select name="dmModul.mdId" id="modul" class="form-control">
                     <option value="-1">请选择模块</option>
                    <c:forEach items="${modulList }" var="_modul">
                     <option value="${_modul.mdId }">${_modul.mdName }</option>
                    </c:forEach>
                  </select>
                </div>
            </div>
            
            <div class="form-group">
               <label for="piName" class="col-md-2 control-label">权限名称</label>
                <div class="col-md-4">
                  <input type="text" name="piName" id="piName" class="form-control"/>
                </div>
            </div>
            
            <div class="form-group">
               <label for="piUrl" class="col-md-2 control-label">权限URL</label>
                <div class="col-md-4">
                  <input type="text" name="piUrl" id="piUrl" class="form-control"/>
                </div>
            </div>
            
            <div class="form-group">
               <label for="piRemark" class="col-md-2 control-label">权限说明</label>
                <div class="col-md-4">
                  <textarea name="piRemark" id="piRemark" class="form-control"></textarea>
                </div>
            </div>
            <div class="form-group">
              <div class="col-md-2"></div>
              <div class="col-md-10">
                 <button type="button" class="btn btn-primary" onclick="toAdd()">添加</button>
                 <button type="button" class="btn btn-primary" onclick="toEdit()">修改</button>
                 <button type="button" class="btn btn-primary" onclick="toDelete()">删除</button>
                 <button type="button" class="btn btn-primary" onclick="toSearchByCondition()">查询</button>
              </div>
            </div>
            </form>
         </div>
         
         <!--列表-->
         <div id="piList" class="row">
           
          
         </div>
<script type="text/javascript">
    toSearch();
</script>