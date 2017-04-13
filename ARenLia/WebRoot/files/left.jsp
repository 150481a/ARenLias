<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>项目管理系统 by www.865171.cn</title>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
</head>
<SCRIPT language=JavaScript>
function tupian(idt){
    var nametu="xiaotu"+idt;
    var tp = document.getElementById(nametu);
    tp.src="../images/ico05.gif";//图片ico04为白色的正方形
	
	for(var i=1;i<30;i++)
	{
	  
	  var nametu2="xiaotu"+i;
	  if(i!=idt*1)
	  {
	    var tp2=document.getElementById('xiaotu'+i);
		if(tp2!=undefined)
	    {tp2.src="../images/ico06.gif";}//图片ico06为蓝色的正方形
	  }
	}
}

function list(idstr){
	var name1="subtree"+idstr;
	var name2="img"+idstr;
	var objectobj=document.all(name1);
	var imgobj=document.all(name2);
	
	
	//alert(imgobj);
	
	if(objectobj.style.display=="none"){
		for(i=1;i<10;i++){
			var name3="img"+i;
			var name="subtree"+i;
			var o=document.all(name);
			if(o!=undefined){
				o.style.display="none";
				var image=document.all(name3);
				//alert(image);
				image.src="../images/ico04.gif";
			}
		}
		objectobj.style.display="";
		imgobj.src="../images/ico03.gif";
	}
	else{
		objectobj.style.display="none";
		imgobj.src="../images/ico04.gif";
	}
}

</SCRIPT>

<body>
<table width="198" border="0" cellpadding="0" cellspacing="0" class="left-table01">
  <tr>
    <TD>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
		  <tr>
			<td width="207" height="55" background="../images/nav01.gif">
				<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
				  <tr>
					<td width="25%" rowspan="2"><img src="../images/ico02.gif" width="35" height="35" /></td>
					<td width="75%" height="22" class="left-font01">您好，<span class="left-font02">${sessionScope.username}</span></td>
				  </tr>
				  <tr>
					<td height="22" class="left-font01">
						[&nbsp;<a href="../login.jsp" target="_top" class="left-font01">退出</a>&nbsp;]</td>
				  </tr>
				</table>
			</td>
		  </tr>
		</table>


		<!--  人员管理开始    -->
		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img8" id="img8" src="../images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="javascript:" target="mainFrame" class="left-font03" onClick="list('8');" >人员管理</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
		<table id="subtree8" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" 
				cellspacing="0" class="left-table02">
				<tr>
				  <td width="9%" height="20" ><img id="xiaotu20" src="../images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%"><a href="addrenyuanzj.jsp" target="mainFrame" class="left-font03" onClick="tupian('20');">人员信息录入</a></td>
				</tr>
				<tr>
				  <td width="9%" height="21" ><img id="xiaotu21" src="../images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%"><a href="renyuanzj_pag?currPageStr=1" target="mainFrame" class="left-font03" onClick="tupian('21');">人员信息查看</a></td>
				</tr>
      </table>
		<!--  人员管理结束    -->

		

		<!--  消息系统开始    -->
		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img7" id="img7" src="../images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="javascript:" target="mainFrame" class="left-font03" onClick="list('7');" >消息管理</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
		<table id="subtree7" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" 
				cellspacing="0" class="left-table02">
				<tr>
				  <td width="9%" height="20" ><img id="xiaotu17" src="../images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%">
						<a href="sendxiaoxi.jsp" target="mainFrame" class="left-font03" onClick="tupian('17');">发送信息</a></td>
				</tr>
				<tr>
				  <td width="9%" height="20" ><img id="xiaotu18" src="../images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%">
					<a href="Message_take?currPageStr=1" target="mainFrame" class="left-font03" onClick="tupian('18');">收件信息查看</a></td>
				</tr>
				<tr>
				  <td width="9%" height="20" ><img id="xiaotu19" src="../images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%">
						<a href="Message_send?currPageStr=1" target="mainFrame" class="left-font03" onClick="tupian('19');">发件信息查看
							</a></td>
				</tr>
				<tr>
				  <td width="9%" height="20" ><img id="xiaotu24" src="../images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%">
						<a href="Message_list?currPageStr=1" target="mainFrame" class="left-font03" onClick="tupian('24');">消息信息列表
							</a></td>
				</tr>
      </table>
		<!--  消息系统结束    -->


		<!--  招聘管理开始    -->
        <TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img1" id="img1" src="../images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="javascript:" target="mainFrame" class="left-font03" onClick="list('1');" >招聘管理</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
		<table id="subtree1" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" 
				cellspacing="0" class="left-table02">
				<tr>
				  <td width="9%" height="20" ><img id="xiaotu1" src="../images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%"><a href="addjihua.jsp" target="mainFrame" class="left-font03" onClick="tupian('1');">应聘信息录入</a></td>
				</tr>
				<tr>
				  <td width="9%" height="20" ><img id="xiaotu4" src="../images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%"><a href="joblist_list?currPageStr=1" target="mainFrame" class="left-font03" onClick="tupian('4');">应聘信息查看</a></td>
				</tr>
				<tr>
				  <td width="9%" height="20" ><img id="xiaotu2" src="../images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%"><a href="joblist_rc?currPageStr=1" target="mainFrame" class="left-font03" onClick="tupian('2');">人才库浏览库</a></td>
				</tr>
      </table>
		<!--  招聘管理结束    -->
		
		<!--  考勤系统开始    -->
	   <table width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29"><table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="8%" height="12"><img name="img4" id="img4" src="../images/ico04.gif" width="8" height="11" /></td>
                  <td width="92%"><a href="javascript:" target="mainFrame" class="left-font03" onClick="list('4');" >奖惩信息系统</a></td>
                </tr>
            </table></td>
          </tr>
      </table>
	  
	  <table id="subtree4" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" cellspacing="0" class="left-table02">
		<tr>
          <td width="9%" height="20" ><img id="xiaotu11" src="../images/ico06.gif" width="8" height="12" /></td>
          <td width="91%"><a href="addGongZiType.jsp" target="mainFrame" class="left-font03" onClick="tupian('11');">考勤信息录入</a></td>
        </tr>
	  	<tr>
          <td width="9%" height="20" ><img id="xiaotu12" src="../images/ico06.gif" width="8" height="12" /></td>
          <td width="91%"><a href="institutionlist_ck?currPageStr=1" target="mainFrame" class="left-font03" onClick="tupian('12');">员工考勤信息查看</a></td>
        </tr>
      </table>

      <!--  考勤系统结束    -->
      
      <!-- 薪资系统开始 -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29"><table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="8%"><img name="img5" id="img5" src="../images/ico04.gif" width="8" height="11" /></td>
                  <td width="92%"><a href="javascript:" target="mainFrame" class="left-font03" onClick="list('5');">薪资管理</a></td>
                </tr>
            </table></td>
          </tr>
      </table>

	  <table id="subtree5" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" cellspacing="0" class="left-table02">
        <tr>
          <td width="9%" height="20"><img id="xiaotu13" src="../images/ico06.gif" width="8" height="12" /></td>
          <td width="91%"><a href="addregister.jsp" target="mainFrame" class="left-font03" onClick="tupian('13');">薪资数据的添加</a></td>
        </tr>
        <tr>
          <td height="20"><img id="xiaotu14" src="../images/ico06.gif" width="8" height="12" /></td>
          <td><a href="stipendlist_ck?currPageStr=1" target="mainFrame" class="left-font03" onClick="tupian('14');">薪资数据的查看</a></td>
        </tr>
      </table>
	  <!-- 薪资系统结束-->
	  
	   <!--培训管理开始-->

		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img9" id="img9" src="../images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="javascript:" target="mainFrame" class="left-font03" onClick="list('9');" >培训计划</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>

		<table id="subtree9" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" 
				cellspacing="0" class="left-table02">
				<tr>
				  <td width="9%" height="22" ><img id="xiaotu22" src="../images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%"><a href="addgerenxinxi.jsp" target="mainFrame" class="left-font03" 
						onClick="tupian('22');">新增培训计划</a></td>
				</tr>
				<tr>
				  <td width="9%" height="23" ><img id="xiaotu23" src="../images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%"><a href="educatelist_ck?currPageStr=1" target="mainFrame" class="left-font03" 
						onClick="tupian('23');">培训计划查看</a></td>
				</tr>
      </table>
		<!--  培训管理结束    -->
		
	  </TD>
  </tr>
</table>
</body>
</html>
