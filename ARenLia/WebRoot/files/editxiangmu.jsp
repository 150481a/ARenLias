<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>项目管理系统 by www.865171.cn</title>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
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
	var sd=document.getElementById("jxd");
	var jids=sd.innerText;
		document.getElementById("fom").action = "joblist_edits?jids="+jids;
		document.getElementById("fom").submit();
		alert('修改成功！！');
	}
</SCRIPT>

<body>
	<s:form name="fom" id="fom" method="post" action="joblist_edits">
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
														应聘人员详细信息 &nbsp;</td>
												</tr>
												<tr bgcolor="#FFFFFF">
													<td width="15%" height="20" align="right">编号:</td>
													<td width="85%" align="left" id="jxd"><s:property value="#jobs.xj_id" /></td>
												</tr>
												<tr bgcolor="#FFFFFF">
													<td height="20" align="right">姓名:</td>
													<td idth="85%" align="left"><input name="name" value="<s:property
															value="#jobs.xj_name" />"/></td>
												</tr>
												<tr bgcolor="#FFFFFF">
													<td align="right">性别:</td>
											<td><s:radio list="%{#{'0':'男','1':'女'}}" value="" name="sex">
											<s:property value="#jobs.xj_sex"/></s:radio></td>
												</tr>
												<tr bgcolor="#FFFFFF">
													<td height="20" align="right">年龄:</td>
													<td><input name="age" value="<s:property value="#jobs.xj_age" />"/></td>
												</tr>
												<tr bgcolor="#FFFFFF">
													<td height="20" align="right">职位:</td>
													<td><input name="job" value="<s:property value="#jobs.xj_job" />"/></td>
												</tr>
												<tr bgcolor="#FFFFFF">
													<td align="right">身份证:</td>
													<td><input name="idcad" value="<s:property value="#jobs.xj_idcad" />"/></td>
												</tr>
												<tr bgcolor="#FFFFFF">
													<td align="right">专业:</td>
													<td><input name="specialty" value="<s:property value="#jobs.xj_specialty" />"/></td>
												</tr>
												<tr bgcolor="#FFFFFF">
													<td align="right">工作经验:</td>
													<td><input name="experience" value="<s:property value="#jobs.xj_experience"/>"/></td>
												</tr>
												<tr bgcolor="#FFFFFF">
													<td align="right">学历:</td>
													<td><input name="studyeffort" value="<s:property value="#jobs.xj_studyeffort" />"/></td>
												</tr>
												<tr bgcolor="#FFFFFF">
													<td align="right">毕业学校:</td>
													<td><input name="school" value="<s:property value="#jobs.xj_school"/>"/></td>
												</tr>
												<tr bgcolor="#FFFFFF">
													<td align="right">电话号码:</td>
													<td><input name="tel" value="<s:property value="#jobs.xj_tel" />"/></td>
												</tr>
												<tr bgcolor="#FFFFFF">
													<td align="right">Email:</td>
													<td><input name="email" value="<s:property value="#jobs.xj_email" />"/></td>
												</tr>
												<tr bgcolor="#FFFFFF">
													<td align="right">创建时间:</td>
													<td><input name="createtime"  readonly="readonly" value="<s:property value="#jobs.xj_createtime" />"/></td>
												</tr>
												<tr bgcolor="#FFFFFF">
													<td align="right">详细经历:</td>
													<td><input name="content" value="<s:property value="#jobs.xj_content" />"/></td>
												</tr>
												<tr bgcolor="#FFFFFF">
													<td align="right">入库:</td>
													<td><input name="isstock" value="<s:property value="#jobs.xj_isstock" />"/></td>
												</tr>
											</table></td>
									</tr>
									<TR>
										<TD colspan="2" align="center" height="50px">
										     <input type="submit" name="Submit" value="保存" class="button" onclick="link();"><a href="joblist_edits?jids=<s:property value="#jobs.xj_id"/>"></a>
											<input type="reset" name="Submit2" value="返回" class="button"
											onclick="window.history.go(-1);" /></TD>
									</TR>
								</table></td>
						</tr>
					</table></td>
			</tr>
		</table>
	</s:form>
</body>
</html>
