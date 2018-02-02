<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<br/><br/>
         <table class="table table-striped">
             <thead>
               <th>序号</th>
               <th>用户名</th>
               <th>姓名</th>
             </thead>
             <tbody>
             <c:forEach items="${userList }" var="_user" varStatus="_status">
               <tr>
                  <td>${_status.index+1 }</td>
                  <td><a href="javascript:toViewUserRole(${_user.urId })">${_user.urUserName }</a></td>
                  <td>${_user.urUserName }</td>
               </tr>
             </c:forEach>
             
             </tbody>
           </table>
