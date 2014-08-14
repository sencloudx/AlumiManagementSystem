<div class="controltitle">当前操作：系统工具--->图片筛选与上传</div>
<span class="content_button_a_left" onclick="allSelect('stuIds')">全选</span>
<span class="content_button_a_left" onclick="invertSelect('stuIds')">反选</span>
<span class="content_button_a_left" onclick="select('selectAction.action', 'showSelectPage.action')">确定筛选</span>
<table class="tablefirst" id="radioSub">
	<col style="width:5%"/>
	<col style="width:20%"/>
	<tr>
	<th>操作明细</th><th>写入</th>
	</tr>
   	<tr>
   		<td colspan="2">选择需要图片上传的校友<font color = "red">[以下显示的校友为校友信息中已存储身份证号并且还未进行照片上传的]：</font></td>
   	</tr>
   	<tr>
   		<td colspan="2">
   			<table width="1100" style="font-size:12px;">
				<#if stuInforList?exists>
					<tr>
					<#list stuInforList as stu>
						<#if ((stu_index+1)%15 == 0)>
							<td style = "text-align:left;">
							<input type = "checkbox" name = "stuIds" id = "stuIds" value = ${stu.stuId}>${stu.stuName}
							</td></tr><tr>
						<#else>
							<td style = "text-align:left;">
							<input type = "checkbox" name = "stuIds" id = "stuIds" value = ${stu.stuId}>${stu.stuName}
							</td>
						</#if>
					</#list>
				<#else>
				未有符合条件的校友
				</#if>
			</table>
   		</td>
   	</tr>
</table>
<script type="text/javascript">
function select(tagAction, listTagAction){
	var oldPath = $("#oldPath").val();
	if(oldPath == ""|| oldPath == null){
		alert("请填写目标文件路径");
		return false;
	}
	var ids=new Array();
	if($("input[name='stuIds']:checked").size()==0){
		alert("请选择需要筛选照片的校友");
		return false;
	}
	$("input[name='stuIds']:checked").each(function(i,obj){
		ids[i]=$(obj).val();
	});
	var idStr=ids.join("-");
	$.ajax({
		url:tagAction,
		data:{
			sendTime:(new Date()).getTime(),
			idStr:idStr,
			oldPath:oldPath
		},
		type:"post",
		async:false,
		dataType:"json",
		success:function(data){
			if(data.success){
				$("#middle").load(listTagAction,
						{
							sendTime:(new Date()).getTime()
						}
				)
				alert("操作成功！！！");
			}else{
				alert("操作失败，请联系开发人员！！！");
			}
		}
	});
	}
</script>