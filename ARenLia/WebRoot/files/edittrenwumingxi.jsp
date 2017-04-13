<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<title>项目管理系统 by www.865171.cn</title>

<link href="../css/css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/showdate.js"></script>
<style>
.text_time{
	width: 250px;
	height: 20px;
	border:1px solid #a9a9a9;		
}
</style>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
</head>
<SCRIPT language=JavaScript>
	function sousuo() {
		window
				.open(
						"gaojisousuo.jsp",
						"",
						"depended=0,alwaysRaised=1,width=800,height=510,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
	}
	function selectAll() {
		var obj = document.fom.elements;
		for (var i = 0; i < obj.length; i++) {
			if (obj[i].name == "delid") {
				obj[i].checked = true;
			}
		}
	}

	function unselectAll() {
		var obj = document.fom.elements;
		for (var i = 0; i < obj.length; i++) {
			if (obj[i].name == "delid") {
				if (obj[i].checked == true)
					obj[i].checked = false;
				else
					obj[i].checked = true;
			}
		}
	}

	function link() {
	var exd=document.getElementById("exds");
	var eid=exd.innerText;
		document.getElementById("fom").action = "educatelist_edits?eid="+eid;
		document.getElementById("fom").submit();
	}
</SCRIPT>

<body>
<s:fielderror />
	<s:form name="fom" id="fom" method="post" action="educatelist_edits">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td><table id="subtree1" style="DISPLAY: " width="100%"
						border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td><table width="95%" border="0" align="center"
									cellpadding="0" cellspacing="0">
									<tr>
										<td height="40" class="font42"><table width="100%"
												border="0" cellpadding="4" cellspacing="1" bgcolor="#464646"
												class="newfont03">
												<tr>
													<td height="20" colspan="9" align="center"
														bgcolor="#EEEEEE" class="tablestyle_title">
														&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														培训详细信息 &nbsp;</td>
												</tr>
												<tr bgcolor="#FFFFFF">
													<td width="15%" height="20" align="right">编号:</td>
													<td width="85%" align="left" id="exds"><s:property value="#educateQ.xe_id" /></td>
												</tr>
												<tr bgcolor="#FFFFFF">
													<td height="20" align="right">名称:</td>
													<td idth="85%" align="left"><input name="name" value="<s:property
															value="#educateQ.xe_name" />"/></td>
												</tr>
												<tr bgcolor="#FFFFFF">
													<td align="right">目的:</td>
											<td><input name="purpose" value="<s:property value="#educateQ.xe_purpose"/>"/></td>
												</tr>
												<tr bgcolor="#FFFFFF">
													<td height="20" align="right">开始时间:</td>
													<td>
													  <input type="text" id="time" name="begintime" value="<s:property value="#educateQ.xe_begintime" />" style="width:172px"  onClick="return Calendar('time');" class="text_time"/>
													</td>
												</tr>
												<tr bgcolor="#FFFFFF">
													<td height="20" align="right">结束时间:</td>
													<td>
													  <input type="text" id="times" name="endtime" value="<s:property value="#educateQ.xe_endtime"/>" style="width:172px"  onClick="return Calendar('times');" class="text_time"/>
													</td>
												</tr>
												<tr bgcolor="#FFFFFF">
													<td align="right">材料:</td>
													<td><input name="datum" value="<s:property value="#educateQ.xe_datum" />"/></td>
												</tr>
												<tr bgcolor="#FFFFFF">
													<td align="right">讲师:</td>
													<td><input name="teacher" value="<s:property value="#educateQ.xe_teacher" />"/></td>
												</tr>
												<tr bgcolor="#FFFFFF">
													<td align="right">培训人员:</td>
													<td><input name="student" value="<s:property value="#educateQ.xe_student"/>"/></td>
												</tr>
												<tr bgcolor="#FFFFFF">
													<td align="right">创建时间:</td>
													<td><input name="createtime" value="<s:property value="#educateQ.xe_createtime" />"/></td>
												</tr>
												<tr bgcolor="#FFFFFF">
													<td align="right">培训完成:</td>
													<td><input name="educate" value="<s:property value="#educateQ.xe_educate"/>"/></td>
												</tr>
												<tr bgcolor="#FFFFFF">
													<td align="right">培训效果:</td>
													<td><input name="effect" value="<s:property value="#educateQ.xe_effect" />"/></td>
												</tr>
												<tr bgcolor="#FFFFFF">
												    <td align="right">培训总结:</td>
													<td><input name="summarize" value="<s:property value="#educateQ.xe_summarize" />"/></td>
												</tr>
											</table></td>
									</tr>
									<TR>
										<TD colspan="2" align="center" height="50px">
										    <input type="submit" name="Submit" value="保存" class="button" onclick="link();">
											<input type="reset" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);" />
										</TD>
									</TR>
								</table></td>
						</tr>
					</table></td>
			</tr>
		</table>
	</s:form>
</body>
</html>
