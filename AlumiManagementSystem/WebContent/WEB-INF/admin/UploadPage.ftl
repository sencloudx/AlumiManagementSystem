<div class="controltitle">当前操作：系统工具--->图片上传</div>
<form action = "uploadFile.action" name = "form1" id = "fileAddForm" method = "post" enctype="multipart/form-data" 
	onsubmit = "return uploadFile(this);" target="hidden_frame">
	<table class="tablefirst" id="radioSub">
		<col style="width:5%"/>
		<col style="width:20%"/>
		<tr>
		<th>操作明细</th><th>写入</th>
		</tr>
	   	<tr>
	   		<td>选择图片目录：</td>
	   		<td><input type = "file" name="upload" id = "upload">&nbsp;&nbsp;<font color = "red">*必须为zip文件</font></td>
	   	</tr>
	   	<tr>
	   		<td colspan="2"><input type = "submit" name = "uploadPhoto" value = "上传"></td>
	   	</tr>
	   	<tr>
	   		<td colspan="2">温馨提示：<font color = "red">[打包为zip文件，然后进行上传，上传成功后在进行照片的删选]</font></td>
	   	</tr>
	</table>
	<iframe name='hidden_frame' id="hidden_frame" style='display:none'></iframe>
</form>
<script type="text/javascript">
function uploadFile(form){
	var fileName = form.upload.value;
	if(fileName!="" && fileName.length>0){
		if(fileName.lastIndexOf(".")!=-1){
			var fileType = (fileName.substring(fileName.lastIndexOf(".")+1,
				 fileName.length)).toLowerCase();
			if(fileType != "zip"){
				alert("只能上传zip文件，不支持文件类型"+fileType);
				return false;
			}
		}else{
			alert("只能上传zip文件，不支持文件类型"+fileType);
			return false;
		}
	}else{
		alert("请选择上传的文件");
		return false;
	}
}
function callback(msg)    
	{    
	   alert(msg);
	}    
</script>
