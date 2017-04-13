<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>项目管理系统 by www.865171.cn</title>
<link rel="stylesheet" rev="stylesheet" href="../css/style.css"
	type="text/css" media="all" />
<script language="JavaScript" type="text/javascript">
	function tishi() {
		var a = confirm('数据库中保存有该人员基本信息，您可以修改或保留该信息。');
		if (a != true)
			return false;
		window
				.open(
						"冲突页.htm",
						"",
						"depended=0,alwaysRaised=1,width=800,height=400,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
	}

	function check() {
		document.getElementById("aa").style.display = "";
	}
</script>
</head>
<body class="ContentBody">	
	<s:form action="joblist_add" method="post"  name="form">
		<div class="MainDiv">
			<table width="99%" border="0" cellpadding="0" cellspacing="0"
				class="CContent">
				<tr>
					<th class="tablestyle_title">员工基本信息录入</th>
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
										<legend>员工信息</legend>
										<table border="0" cellpadding="2" cellspacing="1"
											style="width:100%">
											<tr>
												<td width="14%" align="right" nowrap="nowrap">姓名:</td>
												<td width="36%"><input class="text" name="name" type="text"
													style="width:154px" value="">
												</td>
											</tr>
											<tr>
												<td align="right">性别:</td>
												<td><s:radio list="%{#{'0':'男','1':'女'}}" name="sex" value="0"/></td>
												<td align="right">年龄:</td>
												<td><input style="width:154px; border:1px solid #7f9dc5;"  name="age"/></td>
											</tr>
											<tr>
												<td align="right">身份证号码:</td>
												<td><input class="text" name="idcad"
													style="width:154px" value="" type="text" /></td>
												<td align="right">所学专业:</td>
												<td><input class="text" name="specialty"
													style="width:154px" value="" type="text" /></td>
											</tr>
											<tr>
											    <td align="right">工作经验:</td>
												<td><input class="text" name="experience"
													style="width:154px" value="" type="text" /></td>
												<td align="right">学历:</td>	
												<td><input class="text" name="studyeffort"
													style="width:154px" value="" type="text" /></td>
											</tr>
											<tr>
											    <td align="right">学校:</td>	
												<td><input class="text" name="school"
													style="width:154px" value="" type="text" /></td>
												<td align="right">电子邮箱:</td>
												<td><input class="text" name="email"
													style="width:154px" value="" /></td>
											</tr>
											<tr>
											<td align="right">电话号码:</td>
												<td><input class="text" name="tel"
													style="width:154px" value="" /></td>
												<td align="right">职位:</td>
												<td><input class="text" name="job"
													style="width:154px" value="" /></td>
											</tr>
											<tr>
												<td align="right">人员存库:</td>
											    <td><s:radio list="%{#{'1':'存储','0':'未存'}}" value="0" name=
											    "isstock"/></td>
												<td align="right">详细经历:</td>
												<td><textarea class="text" name="content"
													style="width:154px" value="" type=""></textarea></td>
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
