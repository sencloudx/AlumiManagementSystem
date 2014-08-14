<div class="controltitle">当前操作：信息管理——>显示毕业生就业地区分布图--->浙江分布</div>
<style>
body {margin:0;padding:0;}
#zjMap {position:relative;margin:0 auto;width:552px;height:447px;font-size:12px;background:url(/AlumiManagementSystem/images/map/zjmap.jpg) no-repeat left top;}

#zjMap span {position:absolute;}

#zjMap a {display:block;padding-left:20px;line-height:1.8;text-decoration:none;color:#000;background:url(/AlumiManagementSystem/images/map/focus.gif) no-repeat left 4px;}

#zjMap a:hover,#zjMap a:active {color:#f00;background-position:left bottom;}

#zjMap a.hotcity {color:#f00;font-weight:700;}

#zjMap em {display:none;}

.zjTip {display:none;position:absolute;z-index:9999;font-size:12px;padding:3px;border:1px solid #000;background-color:#ffc;}

</style>

<script>
$(function(){
	$("#zjMap a").mousemove(
		function(e){
			var city = $(this).next().html();
			//alert(city);
			$.ajax({
				url:'majorStuNumAction.action',
				data:{
					sendTime:(new Date()).getTime(),
					city:city
				},
				type:"post",
				async:false,
				dataType:"json",
				success:function(data){
					if(data.success){
						$("#zjTip").html("工作在"+city+"各专业人数：<br/>"+data.tip).css({"left":e.pageX+10+"px","top":e.pageY-15+"px"}).show();
					
					}else{
						$("#zjTip").html("无法显示，请刷新后重试");
					}
				}
			});
		}).mouseout(function(){$("#zjTip").hide();});
})
</script>
<center>
	<div id="zjMap">
		<span style="top:40px;left:135px"><a href="javascript:show('showSpreadByCityAction.action', '湖州', '0')" class="hotcity">[${stuInforService.getWorkNumsByCity(0, "湖州")}]</a>
		<em>
		湖州
		</em></span>
		<span style="top:50px;left:230px"><a href="javascript:show('showSpreadByCityAction.action', '嘉兴', '0')" class="hotcity">[${stuInforService.getWorkNumsByCity(0, "嘉兴")}]</a>
		<em>
		嘉兴
		</em></span>
		
		<span style="top:200px;left:30px"><a href="javascript:show('showSpreadByCityAction.action', '衢州', '0')" class="hotcity">[${stuInforService.getWorkNumsByCity(0, "衢州")}]</a>
		<em>
		衢州
		</em></span>
		
		<span style="top:290px;left:120px"><a href="javascript:show('showSpreadByCityAction.action', '丽水', '0')" class="hotcity">[${stuInforService.getWorkNumsByCity(0, "丽水")}]</a>
		<em>
		丽水
		</em></span>

		<span style="top:202px;left:180px"><a href="javascript:show('showSpreadByCityAction.action', '金华', '0')" class="hotcity">[${stuInforService.getWorkNumsByCity(0, "金华")}]</a>
		<em>
		金华
		</em></span>
		
		<span style="top:100px;left:350px"><a href="javascript:show('showSpreadByCityAction.action', '舟山', '0')" class="hotcity">[${stuInforService.getWorkNumsByCity(0, "舟山")}]</a>
		<em>
		舟山
		</em></span>
		
		<span style="top:140px;left:300px"><a href="javascript:show('showSpreadByCityAction.action', '宁波', '0')" class="hotcity">[${stuInforService.getWorkNumsByCity(0, "宁波")}]</a>
		<em>
		宁波
		</em></span>
		
		<span style="top:240px;left:250px"><a href="javascript:show('showSpreadByCityAction.action', '台州', '0')" class="hotcity">[${stuInforService.getWorkNumsByCity(0, "台州")}]</a>
		<em>
		台州
		</em></span>
		
		<span style="top:360px;left:200px"><a href="javascript:show('showSpreadByCityAction.action', '温州', '0')" class="hotcity">[${stuInforService.getWorkNumsByCity(0, "温州")}]</a>
		<em>
		温州
		</em></span>
		
		<span style="top:165px;left:200px"><a href="javascript:show('showSpreadByCityAction.action', '绍兴', '0')" class="hotcity">[${stuInforService.getWorkNumsByCity(0, "绍兴")}]</a>
		<em>
		绍兴
		</em></span>
		<span style="top:130px;left:125px"><a href="javascript:show('showSpreadByCityAction.action', '杭州', '0')" class="hotcity">[${stuInforService.getWorkNumsByCity(0, "杭州")}]</a>
		<em>
		杭州
		</em></span>
	</div>
	<div id="zjTip" class="zjTip"></div>
	</center>
