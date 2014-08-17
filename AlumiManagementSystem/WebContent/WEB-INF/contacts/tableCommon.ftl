<#macro pageList actionName>
<script type="text/javascript">
	function pageFunction(currentPage){
		var showType = $("#showType").val();				//显示的类型
		var major = $("#major").val();
		var address = $("#address").val();
		var searchType = $("#searchType").val();
		var searchContext = $("#searchinput").val();	//查询的内容			
        $("#middle").load("${actionName}",{
			sendTime : (new Date()).getTime(),
			searchContext: searchContext,
			searchType: searchType,
			showType:showType,
			major: major,
			address: address,
			currentPage : currentPage
		});
	}
</script>
<table  class="Previousnext">
	<input type="hidden" id="currentPage" value="${currentPage}"/>
    	<col class="huanye1"/>
	    <tr>
	    	<td style="color:#295568;text-align:right;width:250px;">|&nbsp;共<font color="#f05c04">${totalRecord}</font>条&nbsp;|&nbsp;页<font color="#f05c04">${currentPage}/${totalPages}</font> 
				&nbsp;|&nbsp;40条记录/页&nbsp;|&nbsp;&nbsp;&nbsp;</td>
		  	<td style="text-align:center">
		  	<span  onclick="pageFunction('1')" class="handStyle"><img src="images/admin/page/main_54.gif"/></span>
		  	<#if (currentPage<=1)>
		  		<img src="images/admin/page/main_56.gif"/>
		  	<#else>
		  		<span onclick="pageFunction('${currentPage-1}')" class="handStyle">
	       			<img src="images/admin/page/main_56.gif"/>
	       		</span>&nbsp;&nbsp;
		  	</#if>
		  	
		  	<#if (currentPage>=totalPages)>
		  	
	       		<img src="images/admin/page/main_58.gif"/> 
	       	<#else>
	       		<span onclick="pageFunction('${currentPage+1}')" class="handStyle">
	       		<img src="images/admin/page/main_58.gif"/>
	       		</span>&nbsp;&nbsp;
	       	</#if>
			<span onclick="pageFunction('${totalPages}')" class="handStyle">
				<img src="images/admin/page/main_60.gif"/>
			</span> 
			</td>
		</tr>
  </table>
</#macro>
