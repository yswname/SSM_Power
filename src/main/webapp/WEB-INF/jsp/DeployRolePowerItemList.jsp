<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
         <div id="mynav" class="row">
            <ol class="breadcrumb">
              <li><a href="#">管理用户模块</a></li>
              <li class="active">分配权限项</li>
            </ol>
         </div>
         
         <!--表单-->
         <div class="row">
            <form name="deployRoleForm" id="deployRoleForm">
            
            给${role.rlName }分配分配权限 <button type='button' class="btn btn-primary" onclick="toSave()">保存</button><br/>
            <input type="hidden" name="user.urId" value="${role.rlId }"/>
            <s:optiontransferselect
            id="hasPowerItem"
            name="role.rlId" 
            leftTitle="已分配权限项"
            rightTitle="未分配权限项"
            list="role.dmPowerItems" 
            listKey="piId"
            listValue="piName"
            multiple="true"
            headerKey="headerKey"
            headerValue="--- Please Select ---"
            emptyOption="true"
            doubleList="undeployedPowerItem" 
            doubleListKey="piId"
            doubleListValue="piName"
            doubleName="noPowerItems"
            doubleHeaderKey="doubleHeaderKey"
            doubleHeaderValue="--- Please Select ---" 
            doubleEmptyOption="true"
            doubleMultiple="true" />
            
            
            </form>
         </div>