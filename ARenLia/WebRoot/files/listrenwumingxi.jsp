<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<link href="../css/css.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
.STYLE1 {
	color: #FF0000
}
-->
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
</SCRIPT>
<bobody class="ContentBody"> <s:form action="renyuanzj_See"
	method="post" name="form">
	<div class="MainDiv">
		<table width="99%" border="0" cellpadding="0" cellspacing="0"
			class="CContent">
			<tr>
				<th class="tablestyle_title">员工信息查看</th>
			</tr>
			<tr>
				<td class="CPanel">
					<table border="0" cellpadding="0" cellspacing="0"
						style="width:100%">
						<tr>
							<td align="left"><input
								type="reset" name="Submit2" value="返回" class="button"
								onclick="window.history.go(-1);" /></td>
						</tr>
						<TR>
							<TD width="100%">
								<fieldset style="height:100%;">
									<legend>员工信息查看</legend>
									<table border="0" cellpadding="2" cellspacing="1"
										style="width:100%">
										<tr>
											<td width="14%" align="right" nowrap="nowrap">员工编号:</td>
											<td width="36%"><s:property value="#see.xu_id"/></td>
											<td align="right">登录账号:</td>
											<td><s:property value="#see.xu_username"/></td>
										</tr>
										<tr>
											<td align="right">员工姓名:</td>
											<td><s:property value="#see.xu_name"/></td>
											<td align="right">性别:</td>
											<td><s:property value="#see.xu_sex"/></td>
										</tr>
										<tr>
											<td align="right">出生日期:</td>
											<td><s:property value="#see.xu_birthday"/></td>
											<td align="right">创建时间:</td>
											<td><s:property value="#see.xu_createtime"/></td>
										</tr>
										<tr>
											<td align="right">用户级别:</td>
											<td><s:property value="#see.xu_isadmin"/></td>
										    <td align="right">人员简介:</td>
											<td><s:property value="#see.xu_content"/></td>
										</tr>
										<tr>
										 <td align="right">修改时间:</td>
										   <td ><s:property value="#see.xu_edittime"/></td>
										</tr>
									</table>
									<br />
								</fieldset>
							</TD>
						</TR>
					</TABLE>
				</td>
			</tr>
			<TR>
				<TD colspan="2" align="center" height="50px"><input type="reset" name="Submit2"
					value="返回" class="button" onclick="window.history.go(-1);" /></TD>
			</TR>
		</TABLE>
		</td>
		</tr>
		</table>
	</div>
</s:form> 
</body>
</html>
