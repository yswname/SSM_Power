<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	function toSave() {
		// 选择左边的所有选项
		/* selectAllOptionsExceptSome(document.getElementById('hasRoles'), 'key',
				'headerKey'); */
		// 获取表单的数据
		var _data = $("#deployRoleForm").serialize();
		
		// ajax请求
		//alert(_data);
		$.post("power/saveDeployedRoles", _data, function(result) {
			//待完善
			alert(result);
			var urId = $("input:hidden[name='urId']").val();
			
			toViewUserRole(urId);
		},"html");
	}
	
	 function toViewUserRole(_id){
	       	var _data = "urId="+_id;
	       	$.post("power/initDeployRole",_data,function(msg){
	       		$("#right").html(msg);
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
		<table width="98%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td align="center">给${user.urUserName }用户分配角色 <input type="button"
					name="button" id="button" value="保存" onclick="toSave()"/>
				</td>
				 <input type="hidden" name="urId" value="${user.urId }" />
			</tr>
			<tr>
				<td><table width="78%" border="0" align="center"
						cellpadding="0" cellspacing="0">
						<tr>
							<td width="39%" align="center">已分配角色</td>
							<td width="18%" align="center">&nbsp;</td>
							<td width="43%" align="center">未分配角色</td>
						</tr>
						<tr>
							<td align="center"><p>
								<c:forEach items="${ deployedRoles}" var="dRoles">
									<label> <input type="checkbox" name="rlIds" value="${dRoles.rlId }"
										id="${dRoles.rlId }" /> ${dRoles.rlName}
									</label><br/>
								</c:forEach>	
									 <br /> <br />
								</p></td>
							<td align="center"><p>
									<br /> <br /> <br />
								</p></td>
							<td align="center"><p>
							<c:forEach items="${ unDeployedRoles}" var="unRoles">
									<label> <input type="checkbox" name="rlIds"
										value="${unRoles.rlId }" id="${unRoles.rlId }" /> ${unRoles.rlName}
									</label><br /> 
							</c:forEach>
								</p></td>
						</tr>
					</table></td>
			</tr>
		</table>
	</form>
</div>

