<#import "common/tableCommon.ftl" as common>
<div class="controltitle">当前操作：信息管理——>[${classes.classesName}]学生信息列表</div>
	&nbsp;&nbsp;&nbsp;&nbsp;<b>视图切换:</b>
	<select name = "showType" id = "showType" onchange = "return showChange('sameClassesInforListAction.action');">
    		<option value="0" selected="selected">正常</option>
			<option value="回收站" <#if "回收站" == showType> selected = "selected" </#if>>回收站</option>
			<option value="全部" <#if "全部" == showType> selected = "selected" </#if>>全部</option>
	</select>&nbsp;&nbsp;&nbsp;&nbsp;
	<select name = "sourceCity" id = "sourceCity" onchange = "return showChange('sameClassesInforListAction.action');">
    		<option value="0" selected="selected">生源省市(全)</option>
			<option value="北京" <#if "北京" == sourceCity> selected = "selected" </#if>>北京</option>
			<option value="吉林" <#if "吉林" == sourceCity> selected = "selected" </#if>>吉林</option>
			<option value="内蒙古" <#if "内蒙古" == sourceCity> selected = "selected" </#if>>内蒙古</option>
			
			<option value="西藏" <#if "西藏" == sourceCity> selected = "selected" </#if>>西藏</option>
			<option value="四川" <#if "四川" == sourceCity> selected = "selected" </#if>>四川</option>
			<option value="重庆" <#if "重庆" == sourceCity> selected = "selected" </#if>>重庆</option>
			<option value="广东" <#if "广东" == sourceCity> selected = "selected" </#if>>广东</option>
			<option value="贵州" <#if "贵州" == sourceCity> selected = "selected" </#if>>贵州</option>
			<option value="海南" <#if "海南" == sourceCity> selected = "selected" </#if>>海南</option>
			<option value="黑龙江" <#if "黑龙江" == sourceCity> selected = "selected" </#if>>黑龙江</option>
			<option value="浙江" <#if "浙江" == sourceCity> selected = "selected" </#if>>浙江</option>
			<option value="安徽" <#if "安徽" == sourceCity> selected = "selected" </#if>>安徽</option>
			<option value="山东" <#if "山东" == sourceCity> selected = "selected" </#if>>山东</option>
			<option value="云南" <#if "云南" == sourceCity> selected = "selected" </#if>>云南</option>
			<option value="青海" <#if "青海" == sourceCity> selected = "selected" </#if>>青海</option>
			
			<option value="甘肃" <#if "甘肃" == sourceCity> selected = "selected" </#if>>甘肃</option>
			<option value="宁夏" <#if "宁夏" == sourceCity> selected = "selected" </#if>>宁夏</option>
			<option value="湖南" <#if "湖南" == sourceCity> selected = "selected" </#if>>湖南</option>
			<option value="江西" <#if "江西" == sourceCity> selected = "selected" </#if>>江西</option>
			<option value="江苏" <#if "江苏" == sourceCity> selected = "selected" </#if>>江苏</option>
			<option value="上海" <#if "上海" == sourceCity> selected = "selected" </#if>>上海</option>
			<option value="澳门" <#if "澳门" == sourceCity> selected = "selected" </#if>>澳门</option>
			<option value="香港" <#if "香港" == sourceCity> selected = "selected" </#if>>香港</option>
			<option value="辽宁" <#if "辽宁" == sourceCity> selected = "selected" </#if>>辽宁</option>
			<option value="河北" <#if "河北" == sourceCity> selected = "selected" </#if>>河北</option>
			<option value="山西" <#if "山西" == sourceCity> selected = "selected" </#if>>山西</option>
			<option value="天津" <#if "天津" == sourceCity> selected = "selected" </#if>>天津</option>
			
			<option value="新疆" <#if "新疆" == sourceCity> selected = "selected" </#if>>新疆</option>
			<option value="湖北" <#if "湖北" == sourceCity> selected = "selected" </#if>>湖北</option>
			<option value="陕西" <#if "陕西" == sourceCity> selected = "selected" </#if>>陕西</option>
			<option value="河南" <#if "河南" == sourceCity> selected = "selected" </#if>>河南</option>
			<option value="福建" <#if "福建" == sourceCity> selected = "selected" </#if>>福建</option>
			<option value="台湾" <#if "台湾" == sourceCity> selected = "selected" </#if>>台湾</option>
			<option value="广西" <#if "广西" == sourceCity> selected = "selected" </#if>>广西</option>
	</select>&nbsp;&nbsp;&nbsp;&nbsp;
	<select name = "address" id = "address" onchange = "return showChange('sameClassesInforListAction.action');">
    		<option value="0" selected="selected">就业省市(全)</option>
			<option value="北京" <#if "北京" == address> selected = "selected" </#if>>北京</option>
			<option value="吉林" <#if "吉林" == address> selected = "selected" </#if>>吉林</option>
			<option value="内蒙古" <#if "内蒙古" == address> selected = "selected" </#if>>内蒙古</option>
			
			<option value="西藏" <#if "西藏" == address> selected = "selected" </#if>>西藏</option>
			<option value="四川" <#if "四川" == address> selected = "selected" </#if>>四川</option>
			<option value="重庆" <#if "重庆" == address> selected = "selected" </#if>>重庆</option>
			<option value="广东" <#if "广东" == address> selected = "selected" </#if>>广东</option>
			<option value="贵州" <#if "贵州" == address> selected = "selected" </#if>>贵州</option>
			<option value="海南" <#if "海南" == address> selected = "selected" </#if>>海南</option>
			<option value="黑龙江" <#if "黑龙江" == address> selected = "selected" </#if>>黑龙江</option>
			<option value="浙江" <#if "浙江" == address> selected = "selected" </#if>>浙江</option>
			<option value="安徽" <#if "安徽" == address> selected = "selected" </#if>>安徽</option>
			<option value="山东" <#if "山东" == address> selected = "selected" </#if>>山东</option>
			<option value="云南" <#if "云南" == address> selected = "selected" </#if>>云南</option>
			<option value="青海" <#if "青海" == address> selected = "selected" </#if>>青海</option>
			
			<option value="甘肃" <#if "甘肃" == address> selected = "selected" </#if>>甘肃</option>
			<option value="宁夏" <#if "宁夏" == address> selected = "selected" </#if>>宁夏</option>
			<option value="湖南" <#if "湖南" == address> selected = "selected" </#if>>湖南</option>
			<option value="江西" <#if "江西" == address> selected = "selected" </#if>>江西</option>
			<option value="江苏" <#if "江苏" == address> selected = "selected" </#if>>江苏</option>
			<option value="上海" <#if "上海" == address> selected = "selected" </#if>>上海</option>
			<option value="澳门" <#if "澳门" == address> selected = "selected" </#if>>澳门</option>
			<option value="香港" <#if "香港" == address> selected = "selected" </#if>>香港</option>
			<option value="辽宁" <#if "辽宁" == address> selected = "selected" </#if>>辽宁</option>
			<option value="河北" <#if "河北" == address> selected = "selected" </#if>>河北</option>
			<option value="山西" <#if "山西" == address> selected = "selected" </#if>>山西</option>
			<option value="天津" <#if "天津" == address> selected = "selected" </#if>>天津</option>
			
			<option value="新疆" <#if "新疆" == address> selected = "selected" </#if>>新疆</option>
			<option value="湖北" <#if "湖北" == address> selected = "selected" </#if>>湖北</option>
			<option value="陕西" <#if "陕西" == address> selected = "selected" </#if>>陕西</option>
			<option value="河南" <#if "河南" == address> selected = "selected" </#if>>河南</option>
			<option value="福建" <#if "福建" == address> selected = "selected" </#if>>福建</option>
			<option value="台湾" <#if "台湾" == address> selected = "selected" </#if>>台湾</option>
			<option value="广西" <#if "广西" == address> selected = "selected" </#if>>广西</option>
	</select>
	<span style="float:right; margin-right:10px; margin-top:-25px">
	<table border="0" cellpadding="0" cellspacing="0" class="tab_search">
			<tr>
				<td>
					<input type="text" name="content" title="Search" class="searchinput" id="searchinput" <#if searchContext?exists && searchContext != "0">value=${searchContext}</#if> onkeydown="if (event.keyCode == 13) {}" onblur="if(this.value=='')value='- - -关键字- - -';" onfocus="if(this.value=='- - -关键字- - -')value='';" value="- - -关键字- - -" size="10" />
				</td>
				<td>
					<input type="image" width="21" height="17" class="" onclick = "searchInfor('sameClassesInforListAction.action');" alt="Search" src="/AlumiManagementSystem/images/admin/search.gif" border="0" hspace="2"/>
				</td>
			</tr>
	</table>
	</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<span style="float:right; margin-right:30px; margin-top:-25px">
	<b>信息检索：</b>
	<select name = "searchType" id = "searchType">
    		<option value=0 selected="selected">学生姓名</option>
			<option value=1 <#if 1 == searchType> selected = "selected" </#if>>学生学号</option>
			<option value=2 <#if 2 == searchType> selected = "selected" </#if>>学生专业</option>
			<option value=3 <#if 3 == searchType> selected = "selected" </#if>>专业学制</option>
			<option value=4 <#if 4 == searchType> selected = "selected" </#if>>就业省市</option>
	</select>
	</span>
	<hr/>
	<p>
	<span class="content_button_a_left" onclick="commonShow(this, 650, 580, 'showExportExcelAction.action')">发送邮件</span>
	
	<span class="content_button_a_right" onclick="commonShow(this, 650, 580, 'showExportExcelAction.action')">信息导出[excel]</span>
	<span class="content_button_a_right" onclick="showPrint('showPrintAction.action');">信息导出[打印机]</span>
	</p>
	<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<hr/>
	<p>
	<span >&nbsp;&nbsp;<b>当前视图：</b><font color = "red">
	[<#if showType == "0">现存学生<#elseif showType == "回收站">${showType}<#else>${showType}学生</#if>]
	&nbsp;&nbsp;&nbsp;&nbsp;[<#if address == "0">全部省份<#else>${address}</#if>]
	&nbsp;&nbsp;&nbsp;&nbsp;[<#if sourceCity == "0">全部省市<#else>${sourceCity}</#if>]
	</font></span>
	<br>
	<span>
	&nbsp;&nbsp;<b>视图人数：</b><font color = "red">[${totalRecord}]</font>
	&nbsp;&nbsp;<b>眼博：</b><font color = "red">[${eyeb}]</font>
	&nbsp;&nbsp;<b>眼硕：</b><font color = "red">[${eyes}]</font>
	&nbsp;&nbsp;<b>眼7：</b><font color = "red">[${eye7}]</font>
	&nbsp;&nbsp;<b>眼5：</b><font color = "red">[${eye5}]</font>
	&nbsp;&nbsp;<b>眼3：</b><font color = "red">[${eye3}]</font>
	&nbsp;&nbsp;<b>教职工：</b><font color = "red">[${eyetea}]</font>
	&nbsp;&nbsp;<b>继续教育：</b><font color = "red">[${eyejx}]</font>
	</span>
	<@common.pageList actionName="sameClassesInforListAction.action"></@common.pageList>
	</p>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<div id = "div_print">
	<table class="tablefirst" id="radioSub">
			<col style="width:3%"/>
			<col style="width:3%"/>
   			<col style="width:5%"/>
    		<col style="width:5%"/>
    		<col style="width:8%"/>
    		<col style="width:8%"/>
    		<col style="width:10%"/>
    		<col style="width:10%"/>
    		<col style="width:10%"/>
    		<tr>
    		<th></th><th>序号</th><th>学生学号</th><th>学生姓名</th><th>所属专业</th><th>毕业年份</th><th>工作单位</th><th>就业省市</th><th>操作</th>
    		</tr>
			<#if inforList?exists>
		   	<#list inforList as infor>
		   	<tr <#if infor.deleteType == "1">onmouseover="bgColor='#9ad6fb'" onmouseout="bgColor='#ffffff'"<#else>bgColor='#cccccc'</#if>>
		   		<td><input type="checkbox" name="id" value="${infor.stuId}"/></td>
		   		<td>${infor_index+1}</td>
	            <td>${infor.stuNum}</td>
	            <td>${infor.stuName}</td>
	            <td>${infor.major.majorName}</td>
	            <td>${infor.stuEndTime}</td>
	            <td>${infor.stuWorkPlace}</td>
	            <td>${infor.stuWorkAddress}</td>
	            <td>
	            	<span class="editspan" onclick="seeDetail('${infor.stuId}',this,650, 580,'showInforDetailAction.action')">信息详情</span>&nbsp;&nbsp;&nbsp;&nbsp;
	            	<span class="editspan" onclick="seeDetail('${infor.stuId}',this,650, 580,'showInforUpdateAction.action')">修改</span>&nbsp;&nbsp;&nbsp;&nbsp;
	            </td>
		   	</tr>
		   	</#list>
		   	</#if>
</table>
</div>
<@common.pageList actionName="sameClassesInforListAction.action"></@common.pageList>
<div class="shadeHiddenBlock" id="subDetail" style="dispaly:none;"></div>
