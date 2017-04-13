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
	border:1px solid #7f9dc5;		
}
</style>
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
<s:fielderror />
	<s:form action="educatelist_add" method="post"  name="form">
		<div class="MainDiv">
			<table width="99%" border="0" cellpadding="0" cellspacing="0"
				class="CContent">
				<tr>
					<th class="tablestyle_title">增加培训计划</th>
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
										<legend>培训计划录入</legend>
										<table border="0" cellpadding="2" cellspacing="1"
											style="width:100%">
											<tr>
												<td width="14%" align="right" nowrap="nowrap">培训名称:</td>
												<td width="36%"><input class="text" name="name" type="text"
													style="width:154px" value="">
												</td>
												<td align="right">培训目的:</td>
												<td><input type="text" name="purpose" style="width:154px;border:1px solid #7f9dc5;"/></td>
											</tr>
											<tr>
												<td align="right">培训开始时间:</td>
												<td>
												   <input type="text" id="time" name="begintime" value="选择时间" style="width:154px;"  onClick="return Calendar('time');" class="text_time"/>
												</td>
												<td align="right">培训结束时间:</td>
												<td>
												   <input type="text" id="times"  style="width:154px" name="endtime" value="选择时间" onClick="return Calendar('times');" class="text_time"/>
												</td>
											</tr>
											<tr>
												<td align="right">培训材料:</td>
												<td><textarea class="text" name="datum"
													style="width:154px" value="" type="text"></textarea></td>
											    <td align="right">讲师:</td>
												<td><input class="text" name="teacher"
													style="width:154px" value="" type="text" /></td>
											</tr>
											<tr>
												<td align="right">培训人员:</td>	
												<td><textarea class="text" name="student"
													style="width:154px" value="" type="text"></textarea></td>
											    <td align="right">是否完成:</td>
												<td><s:radio list="%{#{'0':'未完成','1':'完成'}}" name="educate" value="0" /></td>
											</tr>
											<tr>
												<td align="right">培训效果:</td>
												<td><input class="text" name="effect"
													style="width:154px" value="" /></td>
											<td align="right">培训总结:</td>
												<td><textarea class="text" name="summarize"
													style="width:154px" value="" ></textarea></td>
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
