<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>项目管理系统 by www.865171.cn</title>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/showdate.js"></script>
<style>
.text_time{
	width: 250px;
	height: 20px;
	border:1px solid #a9a9a9;		
}
</style>
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
	var sxd=document.getElementById("sxds");
	var sid=sxd.innerText;
		document.getElementById("fom").action = "stipendlist_edits?sid="+sid;
		document.getElementById("fom").submit();
	}
</SCRIPT>

<body>
	<form name="fom" id="fom" method="post" action="stipendlist_edits">
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
														薪资信息表 &nbsp;</td>
												</tr>
												<tr bgcolor="#FFFFFF">
													<td width="15%" height="20" align="right" >薪金编号:</td>
													<td width="85%" align="left"  id="sxds"><s:property value="#stipendQ.xs_id"/></td>
												</tr>
												<tr bgcolor="#FFFFFF">
													<td height="20" align="right" >员工姓名:</td>
													<td ><input name="name" value="<s:property value="#stipendQ.xs_name"/>"/></td>
												</tr>
												<tr bgcolor="#FFFFFF">
													<td height="20" align="right" >发款人:</td>
													<td ><input name="person" value="<s:property value="#stipendQ.xs_person"/>"/></td>
												</tr>
												<tr bgcolor="#FFFFFF">
													<td height="20" align="right" >基本资金:</td>
													<td ><input name="basic" value="<s:property value="#stipendQ.xs_basic"/>"/></td>
												</tr>
												<tr bgcolor="#FFFFFF">
													<td height="20" align="right" >饭补:</td>
													<td ><input name="eat" value="<s:property value="#stipendQ.xs_eat"/>"/></td>
												</tr>
												<tr bgcolor="#FFFFFF">
													<td align="right" >房补:</td>
													<td ><input name="house" value="<s:property value="#stipendQ.xs_house"/>"/></td>
												</tr>
												<tr bgcolor="#FFFFFF">
													<td align="right" >赋税:</td>
													<td ><input name="duty" value="<s:property value="#stipendQ.xs_duty"/>"/></td>
												</tr>
												<tr bgcolor="#FFFFFF">
													<td align="right">全勤奖:</td>
													<td><input name="scot" value="<s:property value="#stipendQ.xs_scot"/>"/></td>
												</tr>
												<tr  bgcolor="#FFFFFF">
													<td align="right" >罚款:</td>
													<td ><input name="punishment" value="<s:property value="#stipendQ.xs_punishment"/>"/></td>
												</tr>
												<tr bgcolor="#FFFFFF">
													<td align="right" >额外补助:</td>
													<td ><input name="other" value="<s:property value="#stipendQ.xs_other"/>"/></td>
												</tr>
												<tr bgcolor="#FFFFFF">
													<td align="right" >工资发放日期:</td>
													<td >
													 <input type="text" id="times" readonly="readonly" name="granttime" value="<s:property value="#stipendQ.xs_granttime"/>" style="width:172px"  onClick="return Calendar('times');" class="text_time"/>
													</td>
												</tr>
												<tr bgcolor="#FFFFFF">
													<td align="right" >总薪资:</td>
													<td ><input name="totalize" value="<s:property value="#stipendQ.xs_totalize"/>"/></td>
												</tr >
												<tr bgcolor="#FFFFFF">
													<td align="right" >工资类型:</td>
													<td ><input name="remarks" value="<s:property value="#stipendQ.xs_remarks"/>"/></td>
												</tr >
											</table></td>
									</tr>
									<TR>
										<TD colspan="2" align="center" height="50px">
										    <input type="submit" name="Submit" value="保存" class="button"
											onclick="link();">
											<input type="reset" name="Submit2" value="返回" class="button"
											onclick="window.history.go(-1);" />
										</TD>
									</TR>
								</table></td>
						</tr>
					</table>
					</td>
			</tr>
		</table>
	</form>
</body>
</html>
