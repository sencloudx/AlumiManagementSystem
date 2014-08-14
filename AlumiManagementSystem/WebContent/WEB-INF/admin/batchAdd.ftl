<div class="controltitle">当前操作：excel批量导入学生信息</div>
<div> 
<form action="excelUploadAction.action" method="post" enctype="multipart/form-data" id="uploadInfor"
		onSubmit="return validateuploadInforFile(this);">
			<input type="file" name="uploadExcel">
			<input type="submit" value="提交"/><a href = "download/stuExcel.xls">[点击下载excel样例]</a>
</form>
</div>
<div>
	<div>下面是导入的excel的样式<font color = "red">[上传的excel中的内容必须按照这个顺序就行排版，否则存储内容的位置会错乱的]</font></div>
	<table class="tablefirst" id="radioSubStyle">
		<tr>
			<th>姓名</th><th>学号</th><th>性别</th><th>籍贯</th><th>专业</th><th>学制</th><th>入学年份</th>
			<th>毕业年份</th><th>工作省市</th><th>工作单位</th><th>工作岗位</th><th>职务职称</th>
			<th>电话</th><th>手机</th><th>qq</th><th>邮箱</th><th>通信地址</th><th>家庭地址</th>
		</tr>
		<tr>
			<td>沈浪</td><td>1006010054</td><td>男</td><td>汉</td><td>眼7</td><td>7</td><td>2009-11-11</td>
			<td>2011-11-11</td><td>浙江</td><td>医院</td><td>临床</td><td>主任</td>
			<td>642</td><td>159</td><td>5449</td><td>544@qq.com</td><td>杭州</td><td>杭州</td>
		</tr>
		<tr>
			<td>沈浪</td><td>1006010024</td><td>男</td><td>汉</td><td>眼7</td><td>7</td><td>2009-11-11</td>
			<td>2011-11-11</td><td>浙江</td><td>医院</td><td>临床</td><td>主任</td>
			<td>642</td><td>159</td><td>5449</td><td>544@qq.com</td><td>杭州</td><td>杭州</td>
		</tr>
		<tr>
			<td>沈浪</td><td>1006010034</td><td>男</td><td>汉</td><td>眼7</td><td>7</td><td>2009-11-11</td>
			<td>2011-11-11</td><td>浙江</td><td>医院</td><td>临床</td><td>主任</td>
			<td>642</td><td>159</td><td>5449</td><td>544@qq.com</td><td>杭州</td><td>杭州</td>
		</tr>
	</table>
	<div><font color="red">注：①excel各列的顺序必须按样式的顺序，而内容可依实际内容而定；这里不支持照片的导入，照片可在修改中进行上传②性别只能为‘男’与‘女’，校友类型分3类：“普通校友”，“联络员”，“理事”；③专业和班级只能填写数字，具体需要可参见下面的对应表；否则会影响后面的查询</font></div>
</div>
<div id="excelUploadMsg"></div>
<div>以下是班级和专业的数字与名字对应表</div>
<table border = 1>
	<tr>
	<th>班级名称</th>
	<th>对应数字</th>
	</tr>
	<#if classesList?exists>
	<#list classesList as class>
	<tr>
		<td>${class.classesName}</td>
		<td>${class.classesId}</td>
	</tr>
	</#list>
	</#if>
</table>
<table border = 1>
	<tr>
	<th>专业名称</th>
	<th>对应数字</th>
	</tr>
	<#if majorList?exists>
	<#list majorList as major>
	<tr>
		<td>${major.majorName}</td>
		<td>${major.majorId}</td>
	</tr>
	</#list>
	</#if>
</table>
