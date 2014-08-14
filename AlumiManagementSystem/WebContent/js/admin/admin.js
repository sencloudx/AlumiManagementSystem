function addAdmin(tagAction, listTagAction){
	var adminId = $("#id").val();
	var adminNum = $("#adminNum").val();
	var adminPw = $("#adminPw").val();
	if(adminNum == null|| adminPw == ""){
		alert("将信息填写完整");
		return false;
	}
	if(adminId == undefined){
		adminId = 0;
	}
	var ids=new Array();
	if($("input[name='major']:checked").size()==0){
		alert("请选择普通管理员负责的部门");
		return false;
	}
	$("input[name='major']:checked").each(function(i,obj){
		ids[i]=$(obj).val();
	});
	var idStr=ids.join("-");
	//alert(idStr);
	$.ajax({
		url:tagAction,
		data:{
			sendTime:(new Date()).getTime(),
			adminNum: adminNum,
			adminPw: adminPw,
			tagId: adminId,
			idStr: idStr
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