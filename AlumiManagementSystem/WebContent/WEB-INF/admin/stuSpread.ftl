<div class="controltitle">当前操作：信息管理——>显示毕业生<font color = "red">就业</font>地区分布图</div>
<style>
body {margin:0;padding:0;}

#dataMap {position:relative;margin:0 auto;width:552px;height:447px;font-size:12px;background:url(/AlumiManagementSystem/images/map/map.gif) no-repeat left top;}

#dataMap span {position:absolute;}

#dataMap a {display:block;padding-left:20px;line-height:1.8;text-decoration:none;color:#000;background:url(/AlumiManagementSystem/images/map/focus.gif) no-repeat left 4px;}

#dataMap a:hover,#dataMap a:active {color:#f00;background-position:left bottom;}

#dataMap a.hotcity {color:#f00;font-weight:700;}

#dataMap em {display:none;align:left;}

.dataTip {display:none;position:absolute;z-index:9999;font-size:12px;padding:3px;border:1px solid #000;background-color:#ffc;}

</style>

<script>
$(function(){
	$("#dataMap a").mousemove(
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
						$("#dataTip").html("工作在"+city+"各专业人数：<br/>"+data.tip).css({"left":e.pageX+10+"px","top":e.pageY-15+"px"}).show();
					
					}else{
						$("#dataTip").html("无法显示，请刷新后重试");
					}
				}
			});
		}).mouseout(function(){$("#dataTip").hide();});
})
</script>
<center>
	<div id="dataMap">

		<span style="top:162px;left:392px"><a href="javascript:show('showSpreadByCityAction.action', '北京', '0')" class="hotcity">北京[${stuInforService.getWorkNumsByCity(0, "北京")}]</a>
		<em>
		北京
		</em></span>
		
		<span style="top:110px;left:465px;"><a href="javascript:show('showSpreadByCityAction.action', '吉林', '0')">吉林[${stuInforService.getWorkNumsByCity(0, "吉林")}]</a><em>
		<#-- 这里使用ajax异步交互来替代直接调用服务层方法来提高显示地图的速度-->
		<#--<#if majorList?exists>
			<#list majorList as major>
				${major.majorName}:${stuInforService.getStuInforList('吉林', major.majorName, '0', '0', 0, '0', 0, '0').size()}<br/>
			</#list>
		</#if>-->
		吉林
		</em></span>

		<span style="top:165px;left:305px"><a href="javascript:show('showSpreadByCityAction.action', '内蒙古', '0')">内蒙古[${stuInforService.getWorkNumsByCity(0, "内蒙古")}]</a><em>
		内蒙古
		</em></span>

		<span style="top:260px;left:120px"><a href="javascript:show('showSpreadByCityAction.action', '西藏', '0')">西藏[${stuInforService.getWorkNumsByCity(0, "西藏")}]</a><em>
		西藏
		</em></span>

		<span style="top:293px;left:255px"><a href="javascript:show('showSpreadByCityAction.action', '四川', '0')">四川[${stuInforService.getWorkNumsByCity(0, "四川")}]</a><em>
		四川
		</em></span>

		<span style="top:290px;left:310px"><a href="javascript:show('showSpreadByCityAction.action', '重庆', '0')">重庆[${stuInforService.getWorkNumsByCity(0, "重庆")}]</a><em>
		重庆
		</em></span>

		<span style="top:365px;left:380px"><a href="javascript:show('showSpreadByCityAction.action', '广东', '0')">广东[${stuInforService.getWorkNumsByCity(0, "广东")}]</a><em>
		广东
		</em></span>

		<span style="top:335px;left:295px"><a href="javascript:show('showSpreadByCityAction.action', '贵州', '0')">贵州[${stuInforService.getWorkNumsByCity(0, "贵州")}]</a><em>
		贵州
		</em></span>

		<span style="top:420px;left:342px"><a href="javascript:show('showSpreadByCityAction.action', '海南', '0')">海南[${stuInforService.getWorkNumsByCity(0, "海南")}]</a><em>
		海南
		</em></span>

		<span style="top:70px;left:460px"><a href="javascript:show('showSpreadByCityAction.action', '黑龙江', '0')">黑龙江[${stuInforService.getWorkNumsByCity(0, "黑龙江")}]</a><em>
		黑龙江
		</em></span>

		<span style="top:296px;left:445px"><a href="javascript:seeDetail(0, this, 1200, 700, 'showZjMap.action');">浙江[${stuInforService.getWorkNumsByCity(0, "浙江")}]</a><em>
		浙江
		</em></span>

		<span style="top:265px;left:410px"><a href="javascript:show('showSpreadByCityAction.action', '安徽', '0')">安徽[${stuInforService.getWorkNumsByCity(0, "安徽")}]</a><em>
		安徽
		</em></span>

		<span style="top:206px;left:400px"><a href="javascript:show('showSpreadByCityAction.action', '山东', '0')">山东[${stuInforService.getWorkNumsByCity(0, "山东")}]</a><em>
		山东
		</em></span>

		<span style="top:359px;left:237px"><a href="javascript:show('showSpreadByCityAction.action', '云南', '0')">云南[${stuInforService.getWorkNumsByCity(0, "云南")}]</a><em>
		云南
		</em></span>

		<span style="top:222px;left:180px"><a href="javascript:show('showSpreadByCityAction.action', '青海', '0')">青海[${stuInforService.getWorkNumsByCity(0, "青海")}]</a><em>
		青海
		</em></span>

		<span style="top:165px;left:200px"><a href="javascript:show('showSpreadByCityAction.action', '甘肃', '0')">甘肃[${stuInforService.getWorkNumsByCity(0, "甘肃")}]</a><em>
		甘肃
		</em></span>

		<span style="top:200px;left:300px"><a href="javascript:show('showSpreadByCityAction.action', '宁夏', '0')">宁夏[${stuInforService.getWorkNumsByCity(0, "宁夏")}]</a><em>
		宁夏
		</em></span>

		<span style="top:317px;left:343px"><a href="javascript:show('showSpreadByCityAction.action', '湖南', '0')">湖南[${stuInforService.getWorkNumsByCity(0, "湖南")}]</a><em>
		湖南
		</em></span>

		<span style="top:317px;left:400px"><a href="javascript:show('showSpreadByCityAction.action', '江西', '0')">江西[${stuInforService.getWorkNumsByCity(0, "江西")}]</a><em>
		江西
		</em></span>

		<span style="top:250px;left:435px"><a href="javascript:show('showSpreadByCityAction.action', '江苏', '0')">江苏[${stuInforService.getWorkNumsByCity(0, "江苏")}]</a><em>
		江苏
		</em></span>

		<span style="top:280px;left:458px"><a href="javascript:show('showSpreadByCityAction.action', '上海', '0')" class="hotcity">上海[${stuInforService.getWorkNumsByCity(0, "上海")}]</a><em>
		上海
		</em></span>

		<span style="top:385px;left:355px"><a href="javascript:show('showSpreadByCityAction.action', '澳门', '0')">澳门[${stuInforService.getWorkNumsByCity(0, "澳门")}]</a><em>
		澳门
		</em></span>

		<span style="top:383px;left:392px"><a href="javascript:show('showSpreadByCityAction.action', '香港', '0')">香港[${stuInforService.getWorkNumsByCity(0, "香港")}]</a><em>
		香港
		</em></span>

		<span style="top:138px;left:433px"><a href="javascript:show('showSpreadByCityAction.action', '辽宁', '0')">辽宁[${stuInforService.getWorkNumsByCity(0, "辽宁")}]</a><em>
		辽宁
		</em></span>

		<span style="top:190px;left:380px"><a href="javascript:show('showSpreadByCityAction.action', '河北', '0')">河北[${stuInforService.getWorkNumsByCity(0, "河北")}]</a><em>
		河北
		</em></span>

		<span style="top:210px;left:350px"><a href="javascript:show('showSpreadByCityAction.action', '山西', '0')">山西[${stuInforService.getWorkNumsByCity(0, "山西")}]</a><em>
		山西
		</em></span>

		<span style="top:176px;left:408px"><a href="javascript:show('showSpreadByCityAction.action', '天津', '0')">天津[${stuInforService.getWorkNumsByCity(0, "天津")}]</a><em>
		天津
		</em></span>

		<span style="top:130px;left:125px"><a href="javascript:show('showSpreadByCityAction.action', '新疆', '0')">新疆[${stuInforService.getWorkNumsByCity(0, "新疆")}]</a><em>
		新疆
		</em></span>

		<span style="top:277px;left:357px"><a href="javascript:show('showSpreadByCityAction.action', '湖北', '0')">湖北[${stuInforService.getWorkNumsByCity(0, "湖北")}]</a><em>
		湖北
		</em></span>

		<span style="top:240px;left:310px"><a href="javascript:show('showSpreadByCityAction.action', '陕西', '0')">陕西[${stuInforService.getWorkNumsByCity(0, "陕西")}]</a><em>
		陕西
		</em></span>

		<span style="top:240px;left:360px"><a href="javascript:show('showSpreadByCityAction.action', '河南', '0')">河南[${stuInforService.getWorkNumsByCity(0, "河南")}]</a><em>
		河南
		</em></span>

		<span style="top:340px;left:420px"><a href="javascript:show('showSpreadByCityAction.action', '福建', '0')">福建[${stuInforService.getWorkNumsByCity(0, "福建")}]</a><em>
		福建
		</em></span>

		<span style="top:360px;left:460px"><a href="javascript:show('showSpreadByCityAction.action', '台湾', '0')">台湾[${stuInforService.getWorkNumsByCity(0, "台湾")}]</a><em>
		台湾
		</em></span>

		<span style="top:375px;left:315px"><a href="javascript:show('showSpreadByCityAction.action', '广西', '0')">广西[${stuInforService.getWorkNumsByCity(0, "广西")}]</a><em>
		广西
		</em></span>
	</div>
	</center>
	<div id="showMap" style="display:none;"><a href = "javascript:showMap();">点击显示地图</a></div>
	<div id="dataTip" class="dataTip"></div>
	<div id="detail"></div>
