<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/showdate.js"></script>
<style>
.text_time{
	width: 250px;
	height: 20px;
	border:1px solid #7f9dc5;		
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
	function link(){
     var ds=document.getElementById("sxd");
     var xu_id=ds.innerText;
    document.getElementById("fom").action="renyuanzj_edits?xu_id="+xu_id;
    document.getElementById("fom").submit();
     alert('修改成功！');
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
<bobody class="ContentBody"> <s:form action="renyuanzj_edits"
	method="post" name="form">
	<s:hidden name="xu_id" value="%{#see.xu_id}"></s:hidden>
	<div class="MainDiv">
		<table width="99%" border="0" cellpadding="0" cellspacing="0"
			class="CContent">
			<tr>
				<th class="tablestyle_title">员工信息修改</th>
			</tr>
			<tr>
				<td class="CPanel">
					<table border="0" cellpadding="0" cellspacing="0"
						style="width:100%">
						<tr>
							<td align="left"><input type="submit" name="Submit"
								value="保存" class="button" onclick="alert('保存成功！');"/> <input
								type="reset" name="Submit2" value="返回" class="button"
								onclick="window.history.go(-1);" /></td>
						</tr>
						<TR>
							<TD width="100%"  >
								<fieldset style="height:100%;">
									<legend>员工信息修改</legend>
									<table border="0" cellpadding="2" cellspacing="1"
										style="width:100%">
										<tr>
											<td width="14%" align="right" nowrap="nowrap">员工编号:</td>
											<td width="36%" id="sxd"><s:property value="#see.xu_id"/></td>
											<td width="14%" align="right" nowrap="nowrap">登录账号:</td>
											<td width="36%"><input name="username" value="<s:property value="#see.xu_username"/>" style="width:154px;border:1px solid #7f9dc5;"/></td>
										</tr>
										<tr>
										    <td align="right">员工姓名:</td>
											<td><input class="text" name="name" type="text"
												style="width:154px" value="<s:property value="#see.xu_name"/>"/></td>
											<td align="right">密码:</td>
											<td><input class="text" name="userpwd" type="text"
												style="width:154px" value="<s:property value="#see.xu_password"/>" /></td>
										</tr>
										<tr>
											<td align="right">性别:</td>
											<td><s:radio list="%{#{'0':'男','1':'女'}}" value="" name="sex"><s:property value="#see.xu_sex"/></s:radio></td>
											<td align="right">确认密码:</td>
											<td><input class="text" name="userpwd1" type="password"
												style="width:154px" value="" /></td>
										</tr>
										<tr>
											<td align="right">人员简介:</td>
											<td><textarea class="text" name="content" type="text"
													style="width:154px" value=""><s:property value="#see.xu_content"/></textarea></td>
										    <td align="right">用户级别:</td>
											<td ><input name="isadmin" style="width:154px;border:1px solid #7f9dc5;" value="<s:property value="#see.xu_isadmin"/>" readonly="readonly"/></td>
										</tr>
										<tr >
										<td align="right">出生日期:</td>
										<td >
										   <input type="text" id="times"  name="birthday"  value="<s:property value="#see.xu_birthday"/>" style="width:154px"  onClick="return Calendar('times');" class="text_time"/>
										</tr>
										<tr>
										   <td align="right">创建时间:</td>
										   <td > <input name="reatetime" value="<s:property value="#see.xu_createtime"/>" style="width:154px"/></td>
										   <td align="right">修改时间:</td>
										   <td ><input name="edittime" style="width:154px;border:1px solid #7f9dc5;" value="<s:property value="#see.xu_edittime"/>"/></td>
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
				<TD colspan="2" align="center" height="50px">
				<input type="submit" name="Submit" value="保存" class="button" onclick="link();">
				<input type="reset" name="Submit2"
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
