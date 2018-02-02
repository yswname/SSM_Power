<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
            <div>
              
              <div id="list" class="row">
                <div class="col-md-1"></div>
                <div class="col-md-11">
                   <div class="row">
                      <div class="col-md-1">
                        序号
                      </div>
                      <div class="col-md-2">
                        选择
                      </div>
                      <div class="col-md-9">
                        名称
                      </div>
                   </div>
                   
                   <c:forEach items="${roleList }" var="_item" varStatus="index">
                   <div class="row">
                      <div class="col-md-1">
                       ${index.index }
                      </div>
                      <div class="col-md-2">
                          <input type="radio" name="rlId" id="rlId" onclick="toSearchRole(${_item.rlId})" value="${_item.rlId }"/>
                      </div>
                      <div class="col-md-9">
                        ${_item.rlName }
                      </div>
                   </div>
                   </c:forEach>
                   
                </div>
              </div>
              
           </div>