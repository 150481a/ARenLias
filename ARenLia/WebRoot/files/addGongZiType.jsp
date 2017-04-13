<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>项目管理系统 by www.865171.cn</title>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
<link href="../css/style.css" rel="stylesheet" type="text/css" />
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
</SCRIPT>

<bobody class="ContentBody">	
	<s:form action="institutionlist_add" method="post"  name="form">
		<div class="MainDiv">
			<table width="99%" border="0" cellpadding="0" cellspacing="0"
				class="CContent">
				<tr>
					<th class="tablestyle_title">考勤信息录入</th>
				</tr>
				<tr>
					<td class="CPanel">
						<table border="0" cellpadding="0" cellspacing="0"
							style="width:100%">
							<tr>
								<td align="left"><input type="submit" name="Submit"
									value="保存" class="button" onclick="alert('保存成功！');" /> <input
									type="reset" name="Submit2" value="返回" class="button"
									onclick="window.history.go(-1);" /></td>
							</tr>
							<TR>
								<TD width="100%">
									<fieldset style="height:100%;">
										<legend>考勤信息录入</legend>
										<table border="0" cellpadding="2" cellspacing="1"
											style="width:100%">
											<tr>
												<td width="14%" align="right" nowrap="nowrap">奖罚名称:</td>
												<td width="36%"><input class="text" name="name" type="text"
													style="width:154px" value="">
												</td>
											</tr>
											<tr>
												<td align="right">奖罚原因:</td>
												<td><textarea class="text" name="reason" type="text"
													style="width:154px" value=""></textarea></td>
												<td align="right">奖罚说明:</td>
												<td><textarea class="text" name="explains" type="text"
													style="width:154px" value=""></textarea></td>
											</tr>
										</table>
										<br/>
									</fieldset>
								</TD>
							</TR>
						</TABLE>
					</td>
				</tr>
				<TR>
					<TD colspan="2" align="center" height="50px"><input
						type="submit" name="Submit" value="保存" class="button"
						onclick="alert('保存成功！');" /> <input type="reset" name="Submit2"
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
