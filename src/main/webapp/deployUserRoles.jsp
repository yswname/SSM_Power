<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript">
   function toSave(){
	   // 选择左边的所有选项
	   selectAllOptionsExceptSome(document.getElementById('hasRoles'), 'key', 'headerKey');
	   // 获取表单的数据
	   var _data = $("#deployRoleForm").serialize();
     //alert(_data);
	   // ajax请求
	   //alert(_data);
	   $.post("power/deployRoleAction!deployRoles.action",_data,function(result){
		   //待完善
       alert(result.message);
	   });
   }
</script>
         <div id="mynav" class="row">
            <ol class="breadcrumb">
              <li><a href="#">权限管理模块</a></li>
              <li>分配用户角色</li>
              <li class="active">显示用户角色</li>
            </ol>
         </div>
         
         <!--表单-->
         <div class="row">
            <form name="deployRoleForm" id="deployRoleForm">
            
            给${user.urUserName }分配角色 <button type='button' class="btn btn-primary" onclick="toSave()">保存</button><br/>
            <input type="hidden" name="user.urId" value="${user.urId }"/>
            <s:optiontransferselect
            id="hasRoles"
            name="deployedRoles.rlId" 
            leftTitle="已分配角色"
            rightTitle="未分配角色"
            list="user.dmRoles" 
            listKey="rlId"
            listValue="rlName"
            multiple="true"
            headerKey="headerKey"
            headerValue="--- Please Select ---"
            emptyOption="true"
            
            doubleList="undeployedRoles" 
            doubleListKey="rlId"
            doubleListValue="rlName"
            doubleName="noRoles"
            doubleHeaderKey="doubleHeaderKey"
            doubleHeaderValue="--- Please Select ---" 
            doubleEmptyOption="true"
            doubleMultiple="true" />
            
            
            </form>
         </div>
         
         