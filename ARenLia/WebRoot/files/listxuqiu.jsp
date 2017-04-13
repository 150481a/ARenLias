<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>项目管理系统 by www.865171.cn</title>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/xiangmu.js"></script>
</head>
<SCRIPT language=JavaScript>
function sousuo(){
	window.open("gaojisousuo.jsp","","depended=0,alwaysRaised=1,width=800,height=510,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
}
function selectAll(){
	var obj = document.fom.elements;
	for (var i=0;i<obj.length;i++){
		if (obj[i].name == "delid"){
			obj[i].checked = true;
		}
	}
}

function unselectAll(){
	var obj = document.fom.elements;
	for (var i=0;i<obj.length;i++){
		if (obj[i].name == "delid"){
			if (obj[i].checked==true) obj[i].checked = false;
			else obj[i].checked = true;
		}
	}
}

function link(){
    document.getElementById("fom").action="addjihua.jsp";
   document.getElementById("fom").submit();
}

function on_load(){
	var loadingmsg=document.getElementById("loadingmsg");
	var mainpage=document.getElementById("mainpage");
	loadingmsg.style.display="";
	mainpage.style.display="none";
	
	loadingmsg.style.display="none";
	mainpage.style.display="";
}
function deletelink(){
	var delValue="";
    var flag=false;
    var de=document.getElementsByName("delid");
    for(var i=0;i<de.length;i++){
        if(de[i].checked){
                delValue+=","+de[i].value;
                flag= true;
        }
    }
   
    if(flag==false){
        alert("至少你要选择一个待删除记录");
        return false;
    }else{
    	document.getElementById("fom").action="joblist_deletes?delValue="+delValue;
   		document.getElementById("fom").submit();
   		return true;
    }
}
</SCRIPT>

<body onload="on_load()">
<s:fielderror/>
<s:form name="fom" id="fom" method="post" action="joblist_rc">
<table id="mainpage" width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
          	 <tr>
               <td height="20"><span class="newfont07">选择：<a href="#" class="right-font08" onclick="selectAll();">全选</a>-<a href="#" class="right-font08" onclick="unselectAll();">反选</a></span>
	              <input name="Submit" type="button" class="right-button08" value="删除所选信息" onclick="deletelink();" />
	              <input name="Submit2" type="button" class="right-button08" value="添加消息" onclick="link();"/></td>
          	 </tr>
              <tr>
                <td height="40" class="font42"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
					<tr>
                        <td height="20" colspan="13" align="center" bgcolor="#EEEEEE"class="tablestyle_title"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 人员信息列表 &nbsp;</td>
                    </tr>
                  <tr align="center" bgcolor="#EEEEEE">
				    <td width="5%" >选择</td>
                    <td width="10%" height="20" >姓名</td>
                    <td width="10%" >年龄</td>
                    <td width="10%" >职位</td>
                    <td width="5%" >身份证</td>
                    <td width="10%" >专业</td>
                    <td width="10%" >工作经验</td>
                    <td width="6%" >学历</td>
                    <td width="5%" >毕业学校</td>
                    <td width="10%" >操作</td>
                  </tr>
                 <s:iterator value="list" var="j">
                  <tr align="center" bgcolor="#FFFFFF">
				   <td ><input type="checkbox" name="delid" value="<s:property value="#j.xj_id"/>"/></td>
                    <td height="20" ><a href="joblist_query?jid=<s:property value="#j.xj_id"/>"><s:property value="#j.xj_name"/></a></td>
                    <td ><s:property value="#j.xj_age"/></td>
                    <td ><s:property value="#j.xj_job"/></td>
                    <td ><s:property value="#j.xj_idcad"/></td>
                    <td ><s:property value="#j.xj_specialty"/></td>
                    <td ><s:property value="#j.xj_experience"/></td>
                    <td ><s:property value="#j.xj_studyeffort"/></td>
                    <td ><s:property value="#j.xj_school"/></td>
                    <td ><a href="joblist_delete?jid=<s:property value="#j.xj_id"/>">删除</a>|<a href="joblist_edit?jid=<s:property value="#j.xj_id"/>">编辑</a>|<a href="joblist_query?jid=<s:property value="#j.xj_id"/>">查看</a></td>
                  </tr>
				  </s:iterator>
                </table></td>
              </tr>
            </table></td>
        </tr>
      </table>
      <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td height="6"><img src="../images/spacer.gif" width="1" height="1" /></td>
        </tr>
        <tr>
          <td height="33"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-font08">
              <tr>
               <td width="50%">共 <span class="right-text09"><s:property value="totalPage"/></span> 页 | 第 <span class="right-text09"><s:property value="currPage"/>|总记录数：<s:property value="totalCount"/>|每页显示：<s:property value="pageSize"/></span> 页</td>
               <td width="49%" align="right">[<s:if test="currPage !=1"><a href="joblist_rc?currPageStr=1" class="right-font08">首页</a> | <a href="joblist_rc?currPageStr=<s:property value="currPage-1"/>" class="right-font08">上一页</a></s:if><s:if test="currPage !=totalPage"><a href="joblist_rc?currPageStr=<s:property value="currPage+1"/>" class="right-font08">下一页</a> | <a href="joblist_rc?currPageStr=<s:property value="totalPage"/>" class="right-font08">末页</a></s:if>] 转至：</td>
                <td width="1%"><table width="20" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="1%"><input name="textfield3" type="text" class="right-textfield03" size="1" /></td>
                      <td width="87%"><input name="Submit23222" type="submit" class="right-button06" value=" " />
                      </td>
                    </tr>
                </table></td>
              </tr>
          </table></td>
        </tr>
      </table></td>
  </tr>
</table>
</s:form>

<div id="loadingmsg" style="width:100px; height:18px; top:0px; display:none;">
	<img src="file:///F|/项目管理相关资料/项目管理系统页面/images/loadon.gif" />
</div>

</body>
</html>
