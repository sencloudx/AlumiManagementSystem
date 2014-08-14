//添加题目
function addQue(tagAction, listTagAction){
	var title = $("#title").val();  
	var option = $("#option").val();  
	var key_ = $("#key_").val();  
	var typeId = $("#typeId").val();
	alert(title+option+key_+typeId);
	$.ajax({
		url:tagAction,
		data:{
			sendTime:(new Date()).getTime(),
			title:title,
			option:option,
			key_:key_,
			typeId:typeId
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
				)
				alert(data.msg);
			}else{
				alert(data.reason);
			}
		}
	});
}
//检查选中的题数
function checkQueNum(obj){
	var patrn=/^[0-9]{1,20}$/;
	if(!patrn.exec(obj.value)){
		alert("所选题目数量必须为整数！");
		$(obj).val("0");
	}
	//题库中题目数
	var obj1=$(obj).parent().parent().children("td:has(font)").children("font").html();
	var num1=new Number(obj1);
	//选中题目数
	var num2=new Number(obj.value);
	if(num1<num2){
		$(obj).parent().parent().children("td:has(font)").children("font").attr("color","#FF0000");
	}else{
		$(obj).parent().parent().children("td:has(font)").children("font").attr("color","#227700");
	}
}
//添加练习卷
function addQuestionnaire(){
	var title = $("#title").val();
	var describe = $("#describe").val();
	if(title == ""){
		alert("请您先输入问卷名称");
		$("#title").focus();
		return false;
	}
	if(describe == ""){
		alert("请您先输入问卷描述");
		$("#describe").focus();
		return false;
	}
	var sFlag=1;
	$("font").each(function(index,eObj){
		if($(eObj).attr("color").toUpperCase()=="#FF0000"){
			sFlag=0;
			return false;
		}
	});
	if(sFlag==0){
		alert("题库中题量不足！！！");
		return false;
	}
	
	var queList = new Array();	//题目数
	$("input[class='que']").each(function(index,obj){
		queList[index]=$(obj).val();
	});
	
	var queStr = queList.join("-");
	$.ajax({
		url:"addQuestionnaire.action",
		data:{
			sendTime: new Date().getTime(),
			queStr: queStr,
			describe: describe,
			title: title
		},
		type:"post",
		asyn:false,
		dataType:"json",
		success:function(data){
			if(data.success){
				alert(data.msg);
			}else{
				alert(data.reason);
			}
		}
		
	});
}