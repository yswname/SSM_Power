<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
            <div>
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
                        <input type="radio" name="piId" onclick="toSearchItem(${_item.piId })" value="${_item.piId }"/>
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
           </div>