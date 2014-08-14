<input type = "hidden" id = "id" value = ${classes.classesId}></input>
<p style="text-align:center; padding-top:15px">
	班级名称：<input type="text" id="classesName" value = ${classes.classesName}>&nbsp;<font color = "red">*班级名称必填</font>
</p>
<p style="text-align:center; padding-top:15px">
	班级备注：<input type="text" id="classesRemarks" value = ${classes.classesRemarks}>&nbsp;<font color = "red">*可选填</font>
</p>
<p style="text-align:center; padding-top:15px">
	<input type="button" value="修改" onclick="add('classesUpdateAction.action', 'classesListAction.action');"/>
</p>