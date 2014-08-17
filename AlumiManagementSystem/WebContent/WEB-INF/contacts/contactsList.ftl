<#import "tableCommon.ftl" as common>
<div class="overbg"></div>
<div class="controltitle">当前操作：信息管理——>通讯录</div>
<div id = "div_print">
    <div class="contact_options">
        <span class="addspan" onclick="addContacts()">新增</span>
        <span class="deletespan" onclick="batchDeleteContacts()">批量删除</span>
    </div>
	<table class="tablefirst" id="radioSub">
    		<tr>
    		<th></th><th>序号</th><th>校友姓名</th><th>手机号码</th><th>联系地址</th><th>操作</th>
    		</tr>
			<#if contactsList?exists>
		   	<#list contactsList as contacts>
		   	<tr onmouseover="bgColor='#9ad6fb'" onmouseout="bgColor='#ffffff'">
		   		<td><input type="checkbox" name="id" value="${contacts.contactsId}"/></td>
		   		<td>${contacts_index+1}</td>
	            <td id="userName_${contacts.contactsId}">${(contacts.userName)?default("")}</td>
	            <td id="contactPhoneNum_${contacts.contactsId}">${(contacts.contactPhoneNum)?default("")}</td>
	            <td id="contactAddress_${contacts.contactsId}">${(contacts.contactAddress)?default("")}</td>
	            <td>
	                <span class="editspan" onclick="modifyContacts('${contacts.contactsId}')">修改</span>&nbsp;&nbsp;
	                <span class="deletespan" onclick="deleteContacts('${contacts.contactsId}')">删除</span>
	            </td>
		   	</tr>
		   	</#list>
		   	</#if>
</table>
<div class="contactsWindow">
    <div class="close" onclick="closeWindow()"><img width="18" src="/AlumiManagementSystem/images/admin/close.png"></img></div>
	<div class="windowHeader">
	    <div class="widowTitle">
            <span>新增通讯录</span>
        </div>
	</div>
    <!-- <form action="addContacts.action" method="POST" name="contactsWindow" enctype="multipart/form-data" id="contactsForm">-->
	    <table>
	        <tbody>
	            <tr>
	                <th>校友姓名</th>
	                <td>
	                    <input type="text" id="userName" name="contacts.userName"/>
	                    <em id="errorUserName" class="errorTips"></em>
	                </td>
	            </tr>
	            <tr>
	                <th>手机号码</th>
	                <td>
	                    <input type="text" id="contactPhoneNum" name="contacts.contactPhoneNum"/>
	                    <em id="errorPhoneNum" class="errorTips"></em>
	                </td>
	            </tr>
	            <tr>
	                <th>联系地址</th><td><input type="text" id="contactAddress" name="contacts.contactAddress"/></td>
	            </tr>
	            <input type="hidden" id="contactsId"/>
	        </tbody>
	    </table>
    <!--</form>-->
    <div class="contactsBtn">
        <div class="addBtn" onclick="addContactsSubmit()"><span>新增</span></div>
        <div class="editBtn" onclick="eidtContactsSubmit()"><span>修改</span></div>
        <div class="resetBtn" onclick="reset()"><span>重置</span></div>
    </div>
</div>

</div>
<@common.pageList actionName="myContactsList.action"></@common.pageList>
<span class="content_button_a_left" onclick="allSelect('id')">全选</span>
<span class="content_button_a_left" onclick="invertSelect('id')">反选</span>
<div class="shadeHiddenBlock" id="subDetail" style="dispaly:none;"></div>