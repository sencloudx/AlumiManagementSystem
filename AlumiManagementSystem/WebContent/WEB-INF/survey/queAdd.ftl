题干：
<p style="text-align:center; padding-top:15px">
	<textarea name = "title" id = "title" rows = "3" cols = "70" style = "overflow:hidden"></textarea>
</p>
选项：
<p style="text-align:center; padding-top:15px">
	<textarea name = "option" id = "option" rows = "3" cols = "70" style = "overflow:hidden"></textarea>
</p>
<p style="text-align:center; padding-top:15px">
	关键字：<input type="text" id="key_" /><font color = "red">*有助于你在搜索时快速定位</font>
</p>
<p style="text-align:center; padding-top:15px">
	题目类型：
	<select id="typeId">
    	<#if queTypeList_?exists>
    	<#list queTypeList_ as que >
    		<option value="${que.queTypeId}">${(que.typeName)?default("")}</option>
    	</#list>
    	</#if>
	</select>
</p>
<p style="text-align:center; padding-top:15px">
	<input type="button" value="保存" onclick="addQue('addQue.action', 'showQueBankList.action');"/>
</p>
