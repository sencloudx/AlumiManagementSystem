<#assign FCK=JspTaglibs["/WEB-INF/FCKeditor.tld"] />
<p style="text-align:left; padding-top:15px">
	发送的内容：<br/>
	<@FCK.editor id="fckNoteContent" basePath="/AlumiManagementSystem/FCKeditor/"  
			      toolbarSet="Plan"
			      height="300"
			      width="600"
				                  
				>  
				
			</@FCK.editor> 
</p>

