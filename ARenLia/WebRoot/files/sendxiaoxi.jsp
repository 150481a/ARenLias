<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
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
						"冲突页.jsp",
						"",
						"depended=0,alwaysRaised=1,width=800,height=400,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
	}

	function check() {
		document.getElementById("aa").style.display = "";
	}
</script>
</head>

<body class="ContentBody">
	<s:form action="Message_add" method="post"
		 name="form" >
		<div class="MainDiv">
			<table width="99%" border="0" cellpadding="0" cellspacing="0"
				class="CContent">
				<tr>
					<th class="tablestyle_title" style="ling_text:center">新建信息</th>
				</tr>
				<tr>
					<td class="CPanel">

						<table border="0" cellpadding="0" cellspacing="0"
							style="width:100%">
							<tr>
								<td align="left"><input type="button" name="Submit"
									value="发送" class="button" onclick="alert('发送成功！');" /> <input
									type="button" name="Submit2" value="返回" class="button"
									onclick="window.history.go(-1);" /></td>
							</tr>
							<TR>
								<TD width="100%">
									<fieldset style="height:100%;">
										<legend>新建信息</legend>
										<table border="0" cellpadding="2" cellspacing="1"
											style="width:100%">
											<tr>
												<td nowrap align="right" width="11%">消息标题:</td>
												<td width="27%"><input name='title' type="text"
													class="text" style="width:154px" value="" /></td>
												<td align="right" width="25%">&nbsp;</td>
												<td width="37%">&nbsp;</td>
											</tr>
											<tr>
												<td width="11%" align="right" nowrap>接收者:</td>
												<td colspan="3"><input name='accept' type="text"
													class="text" style="width:450px;" size="20" value="" />
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											        <select	name="priority">
														<option selected="selected">==选择==</option>
														<option value="0">低级</option>
														<option value="1">中级</option>
														<option value="2">高级</option>
												    </select>
												</td>
											</tr>
											<tr>
												<td width="11%" nowrap align="right">信息内容:</td>
												<td colspan="3"><textarea name="content"  cols="100"
														rows="20"></textarea></td>
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
					<TD colspan="2" align="center" height="50px"><input
						type="submit" name="Submit" value="发送" class="button" /> <input
						type="button" name="Submit2" value="返回" class="button"
						onclick="window.history.go(-1);" /></TD>
				</TR>
			</TABLE>
			</td>
			</tr>
			</table>
		</div>
	</s:form>
</body>
</html>
