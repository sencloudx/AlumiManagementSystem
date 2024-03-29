// 这是自定义弹出框的js代码

(function($){

	var globalVar;
	
	$.fn.shadeBlock = function(blockWidth, blockHeight, blockSrc, blockTitle){

		// 初始化全局参数
		globalVar = $.fn.shadeBlock.globalVar;

		// 准备遮罩层调用
		$.fn.shadeBlock.createShade();
		
		// 绑定鼠标事件--显示影藏block调用
		
		$(this).shadeBlock.show(blockWidth, blockHeight, blockSrc, blockTitle);
	};

	// 准备遮罩层
	$.fn.shadeBlock.createShade = function(){
		if($("#shield").html() == null){
			var shield = document.createElement("div");
			$(shield).attr("id","shield");
			$(shield).css({
				position:"absolute",
				top:"0",
				left:"0",
				"z-index":"1000",
				width:"100%",
				height:"100%",
				background:globalVar.shadeBackground,
				opacity:globalVar.shadeOpacity,
				display:"none" 
			});
			$("body").append($(shield));
		}
	};
	
	// 显示影藏block
	$.fn.shadeBlock.show = function(blockWidth, blockHeight, blockSrc, blockTitle){
		
		var pageSize = $.fn.getPageSize();
		var shadeBlockContent;
		var targetBlockArr = blockSrc.split("#");
		var shadeBlockId = targetBlockArr[1];
		
		if($.trim(targetBlockArr[0]) == "") shadeBlockContent = $("#"+shadeBlockId).remove().html();
		else shadeBlockContent = "<iframe class='shadeHiddenBlock' id='"+shadeBlockId+"' scrolling='"+globalVar.frameScroll+"' src='"+targetBlockArr[0]+"' width="+(blockWidth-2)+" height="+(blockHeight-50)+" frameborder='0'></iframe>";

		// 创建将要显示的block
		if($("#"+shadeBlockId+"Wrapper").html() == null){
			var wrapper = "<div class='outWrapper' id='"+shadeBlockId+"Wrapper'>"+
							"<div class='innerWrapper' style='height:620px'>"+
								"<div class='shadeBlockTitle'>"+
									"<img id='closeHandlerFor"+shadeBlockId+"' src='"+globalVar.blockHideIcon+"' />"+
									"<h5>"+blockTitle+"</h5></div>"+
								"<div class='shadeBlockContent'>"+shadeBlockContent+"</div>"+
							"</div></div>";
			$("body").append(wrapper);
			$("#"+shadeBlockId+"Wrapper").css({ 
				top:(pageSize[1] > blockHeight ? pageSize[1] : blockHeight)/2+"px",
				left:"50%",
				width:blockWidth, 
				height:blockHeight, 
				"margin-top":"-"+blockHeight/2+"px", 
				"margin-left":"-"+blockWidth/2+"px" 
			});
			$("#"+shadeBlockId+"Wrapper").children(".innerWrapper").css({ width:(blockWidth-2)+"px", height:(blockHeight-2)+"px" });
			$("#closeHandlerFor"+shadeBlockId).mouseover(function(){ $("#closeHandlerFor"+shadeBlockId).attr("src",globalVar.blockHideIconOn); });
			$("#closeHandlerFor"+shadeBlockId).mouseout(function(){ $("#closeHandlerFor"+shadeBlockId).attr("src",globalVar.blockHideIcon); });
			$("#closeHandlerFor"+shadeBlockId).click(function(){ $.fn.shadeBlock.hides(shadeBlockId); });
			//$("#shield").click(function(){ $.fn.shadeBlock.hides(shadeBlockId); });//点击阴影部分时消失
		}
		
		// 显示block
		var shieldNewHeight = pageSize[1] > (blockHeight+6) ? pageSize[1] : (blockHeight+6); //重新计算当前页面尺度， 并更改遮罩层尺度
		$("#shield").css("height",shieldNewHeight+"px");
		
		$("#shield").fadeIn(globalVar.fadeInTime);
		$("#"+shadeBlockId+"Wrapper").fadeIn(globalVar.fadeInTime);
		
	};
	
	// 影藏shade Block
	$.fn.shadeBlock.hides = function(shadeBlockId){
		$("#shield").fadeOut(globalVar.fadeOutTime);
		$("#"+shadeBlockId+"Wrapper").fadeOut(globalVar.fadeOutTime);
	}
	
	// 全局参数
	$.fn.shadeBlock.globalVar = {
		shadeBlockId : "shadeBlockId",									// 显示内容块的Id，如果与Dom中其他元素的Id冲突，需要定义成其他值
		shadeBackground : "#000", 										// 遮罩层基色
		shadeOpacity : "0",											// 遮罩层透明度
		blockTitleFont : "Verdana, Arial, Helvetica, sans-serif",		// 显示内容区标题字体
		blockHideIcon : "/AlumiManagementSystem/images/shadeBlock/shadeClose.gif",						// 显示内容区关闭图标
		blockHideIconOn : "/AlumiManagementSystem/images/shadeBlock/shadeCloseOn.gif",					// 显示内容区关闭图标(mouseon)
		fadeInTime : 400,												// 渐变显示block时间
		fadeOutTime : 400,												// 渐变影藏block时间
		frameScroll : "no"												// 嵌入的iframe窗口是否带滑动条
	};
	
	// 获取页面尺寸函数
	$.fn.getPageSize = function(){
		var xScroll, yScroll;

		if (window.innerHeight && window.scrollMaxY) {
			xScroll = window.innerWidth + window.scrollMaxX;
			yScroll = window.innerHeight + window.scrollMaxY;
		} else if (document.body.scrollHeight > document.body.offsetHeight){ // all but Explorer Mac
			xScroll = document.body.scrollWidth;
			yScroll = document.body.scrollHeight;
		} else { // Explorer Mac...would also work in Explorer 6 Strict, Mozilla and Safari
			xScroll = document.body.offsetWidth;
			yScroll = document.body.offsetHeight;
		}

		var windowWidth, windowHeight;

		if (self.innerHeight) { // all except Explorer
			if(document.documentElement.clientWidth){
				windowWidth = document.documentElement.clientWidth;
			} else {
				windowWidth = self.innerWidth;
			}
			windowHeight = self.innerHeight;
		} else if (document.documentElement && document.documentElement.clientHeight) { // Explorer 6 Strict Mode
			windowWidth = document.documentElement.clientWidth;
			windowHeight = document.documentElement.clientHeight;
		} else if (document.body) { // other Explorers
			windowWidth = document.body.clientWidth;
			windowHeight = document.body.clientHeight;
		}

		// for small pages with total height less then height of the viewport
		if(yScroll < windowHeight){
			pageHeight = windowHeight;
		} else {
			pageHeight = yScroll;
		}


		// for small pages with total width less then width of the viewport
		if(xScroll < windowWidth){
			pageWidth = xScroll;
		} else {
			pageWidth = windowWidth;
		}

		var arrayPageSize = new Array(pageWidth,pageHeight,windowWidth,windowHeight);
		return arrayPageSize;
	};


})(jQuery);