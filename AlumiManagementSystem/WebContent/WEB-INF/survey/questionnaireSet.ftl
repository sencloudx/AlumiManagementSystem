
<div class="controltitle">当前操作：制定调查问卷</div>
<div id="r_top">
	<div id="t_left">
		<span class="sj_title">
		问卷名称：
		<textarea name = "title" id = "title" rows = "1" cols = "70" style = "overflow:hidden"></textarea>
		</span>
		<span class="sj_title">
		问卷描述：
		<textarea name = "describe" id = "describe" rows = "5" cols = "70" style = "overflow:hidden"></textarea>
	    </span>
	</div>
    <#--<div id="b_right2">
	          您总共已选取：
	    <input id="totalNum" value="0" disabled  style="width:40px;"/>题<br/>
	</div>-->
</div>
     
<div id="r_mid"></div>
<div id="b_left">
	<table  class="tablefirst2">
		<tr>
			<th>题目类型</th>
			<th>出题数量</th>
			<th>题库中该类题目总数</th>
			<th>筛选条件</th>
		</tr>
		<#if queTypeList_?exists>
			<#list queTypeList_ as que>
			<tr>
				<td>${(que.typeName)?default("")}</td>
	           	<td>
	           		<input name="singleSub" class="que" value="0" style="width:30px;" onkeyup="return checkQueNum(this);"/>题
	           	</td>
	           	<td>题库中共有
	           	 	<font color="#227700">${queBankService.getQueBankNums(que.queTypeId,"","")}</font>题
	           	</td>
	           	<td>
	           	 	无任何筛选
	           	</td>
	     	</tr>
			</#list>
		</#if>
    </table>	
</div>	

<div id="r_buttom">
<input type="submit" value="提交" onclick="addQuestionnaire()";/>
</div>
