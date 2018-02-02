<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
         <div>
         <script type="text/javascript">
         //分配权限项
         function tosavePowerItem(){
      	   var rlId= $("#rlIdOfPowerItem").val();
      	   var piIds= $("#powerItemId").val();
      	   var _data={rlId:rlId,piIds:piIds };
             $.post("role/deployPowerItem",_data,function(msg){
                
                 alert(message);
             },"html");
         }
 		function toViewDepeloyPowerItem(){
 			$("input:checkbox[value='${rlId}']").attr('checked','true');
 		}
         </script>
         <form  id="rolePowerItemForm" class=" form-horizontal">
            <div >
            	<label>给 ${role.rlName } 分配权限项</label>
            	<input id="rlIdOfPowerItem" type="hidden" value="role.rlId">
            	<input type="button"  onclick="tosavePowerItem()" value="保存">
            </div>
            
            <br/>
              <c:forEach items="${modulList }" var="_modul">
              <div id="title" class="row">${_modul.mdName }</div>
              <div id="list" class="row">
                <div class="col-md-1"></div>
                <div class="col-md-11">
                   <div class="row">
                      <div class="col-md-1">
                        选择
                      </div>
                      <div class="col-md-2">
                        权限项名称
                      </div>
                      <div class="col-md-9">
                        权限项URL
                      </div>
                   </div>
                   
                   <c:forEach items="${_modul.dmPowerItems }" var="_item">
                   <div class="row">
                      <div class="col-md-1">
                        <input type="checkbox" id="powerItemId" name="piId"  value="${_item.piId }"/>
                      </div>
                      <div class="col-md-2">
                         ${_item.piName }
                      </div>
                      <div class="col-md-9">
                        ${_item.piUrl }
                      </div>
                   </div>
                   </c:forEach>
                   
                </div>
              </div>
              </c:forEach>
              
            </form>
            
           </div>
