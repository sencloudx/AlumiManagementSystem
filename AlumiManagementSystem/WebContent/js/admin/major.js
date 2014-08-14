//添加班级
function addMajor(tagAction, listTagAction){
	var majorId = $("#id").val();
	var majorName = $("#majorName").val();
	var majorRemarks = $("#majorRemarks").val();
	if(majorName == null|| majorName == ""){
		alert("专业名称是必填项");
		return false;
	}
	if(majorId == undefined){
		majorId = 0;
	}
	$.ajax({
		url:tagAction,
		data:{
			sendTime:(new Date()).getTime(),
			majorName: majorName,
			majorRemark: majorRemarks,
			tagId: majorId
		},
		type:"post",
		async:false,
		dataType:"json",
		success:function(data){
			if(data.success){
				$("#shield").fadeOut(400);
				$("#subDetailWrapper").fadeOut(400);
				$("#middle").load(listTagAction,
						{
							sendTime:(new Date()).getTime()
						}
				);
				alert(data.msg);
			}else{
				$("#shield").fadeOut(400);
				$("#subDetailWrapper").fadeOut(400);
				alert(data.msg);
			}
		}
	});
}