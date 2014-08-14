<input type = "hidden" id = "id" value = ${major.majorId}></input>
<p style="text-align:center; padding-top:15px">
	专业名称：<input type="text" id="majorName" value = ${major.majorName}>&nbsp;<font color = "red">*专业名称必填</font>
</p>
<p style="text-align:center; padding-top:15px">
	专业备注：<input type="text" id="majorRemarks" value = ${major.majorRemarks}>&nbsp;<font color = "red">*可选填</font>
</p>
<p style="text-align:center; padding-top:15px">
	<input type="button" value="修改" onclick="addMajor('majorUpdateAction.action', 'majorListAction.action');"/>
</p>