//添加班级
function add(tagAction, listTagAction){
	var classesId = $("#id").val();
	var classesName = $("#classesName").val();
	var classesRemarks = $("#classesRemarks").val();
	if(classesName == null|| classesName == ""){
		alert("班级名称是必填项");
		return false;
	}
	if(classesId == undefined){
		classesId = 0;
	}
	$.ajax({
		url:tagAction,
		data:{
			sendTime:(new Date()).getTime(),
			classesName: classesName,
			classesRemarks: classesRemarks,
			tagId: classesId
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