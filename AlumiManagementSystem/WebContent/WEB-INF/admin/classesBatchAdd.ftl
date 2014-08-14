<div class="controltitle">当前操作：excel批量导入班级</div>
<div> 
<form action="classesExcelUploadAction.action" method="post" enctype="multipart/form-data" id="uploadInfor"
		onSubmit="return validateuploadInforFile(this);">
			<input type="file" name="uploadExcel">
			<input type="submit" value="提交"/><a href = "download/classesExcel.xls">[点击下载excel样例]</a>
</form>
</div>
<div>
	<div>下面是导入的excel的样式<font color = "red">[上传的excel中的内容必须按照这个顺序就行排版，否则存储内容的位置会错乱的]</font></div>
	<table class="tablefirst" id="radioSubStyle">
		<tr>
			<th>班级名称</th><th>班级备注</th>
		</tr>
		<tr>
			<td>眼视光博士</td><td>博士</td>
		</tr>
		<tr>
			<td>眼视光七年制</td><td>就读7年</td>
		</tr>
		<tr>
			<td>眼视光硕士</td><td>硕士</td>
		</tr>
	</table>
	<div><font color="red">注：①excel各列的顺序必须按样式的顺序，而内容可依实际内容而定；</font></div>
</div>
<div id="excelUploadMsg"></div>
