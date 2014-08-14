<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>学生信息详情</title>
	<link type="text/css" rel="stylesheet" href="/AlumiManagementSystem/css/common.css" />
	</head>
	<body>
	<left>
	<#if stuInfor?exists>
	<div class="out_ba_examinee_table_outa">
		<div class="out_ba_examinee_table_one" style="margin:0 auto">
		<div class="table_bordre">
		      <img src="/AlumiManagementSystem/images/passlogo2.jpg" width="590px"/>
		</div>
		<table  class="bs_examinee_table">
		   <col class="bs_examinee_fir"/>
		   <col class="bs_examinee_second"/>
		   <col class="bs_examinee_third"/>
		   <col class="bs_examinee_forth"/>
			<tr>
				<td>姓名:</td>
				<td>${stuInfor.stuName}</td>
				<td  rowspan="6" colspan="2" style=" text-align:center">
				<#if (stuInfor.stuPhotoPath)?exists>
					<img src="../${stuInfor.stuPhotoPath}" class="bs_examinee_img"/>
				<#else>
					<img src="/AlumiManagementSystem/images/touxiang.jpg" class="bs_examinee_img"/>
				</#if>
				</td>
			</tr>
			<tr>
			    <td>学号:</td>
				<td>${stuInfor.stuNum}</td>
			</tr>
			<tr>
			    <td>性别:</td>
				<td>${stuInfor.stuSex}</td>
			</tr>
			<tr>
			    <td>籍贯:</td>
				<td>${stuInfor.stuJg}</td>
			</tr>
			<tr>
			    <td>专业:</td>
				<td>${stuInfor.major.majorName}</td>
			</tr>
			<tr>
			    <td>邮编:</td>
				<td>${stuInfor.stuPostcode}</td>
			</tr>
			<tr>
			    <td>入学时间:</td>
				<td>${stuInfor.stuStartTime}</td>
			    <td>毕业时间:</td>
				<td>${stuInfor.stuEndTime}</td>
			</tr>
			<tr>
			    <td>工作省市:</td>
			    <td>${stuInfor.stuWorkAddress}</td>
				<td>工作单位:</td>
				<td>${stuInfor.stuWorkPlace}</td>
			</tr>
			<tr>
			    <td>工作岗位:</td>
				<td>${stuInfor.stuWorkPost}</td>
				<td>工作职称:</td>
				<td>${stuInfor.stuWorkZc}</td>
			</tr>
			<tr>
			    <td>办公电话:</td>
				<td>${stuInfor.stuPhone}</td>
			    <td>移动电话:</td>
				<td>${stuInfor.stuTelephone}</td>
			</tr>
			<tr>
			    <td>QQ号码:</td>
				<td>${stuInfor.stuQq}</td>
			    <td>邮箱:</td>
				<td>${stuInfor.stuEmail}</td>
			</tr>
			<tr>
			    <td>通信地址:</td>
				<td>${stuInfor.stuCommAddress}</td>
			    <td>家庭地址:</td>
				<td>${stuInfor.stuAddress}</td>
			</tr>
			<tr>
			    <td>身份证号:</td>
				<td>${stuInfor.stuSfzh}</td>
			    <td>所在国家:</td>
				<td>${stuInfor.stuNation}</td>
			</tr>
			<tr>
			    <td>生源地:</td>
				<td>${stuInfor.stuBirth}</td>
			    <td>所属班级:</td>
				<td>${stuInfor.classes.classesName}</td>
			</tr>
			<tr>
			    <td>最终学历与学校:</td>
				<td>${stuInfor.lastXl}</td>
			    <td>最终学位与学校:</td>
				<td>${stuInfor.lastXw}</td>
			</tr>
			<tr>
			    <td>获奖情况:</td>
				<td colspan="3">${stuInfor.sruHonour}</td>
			</tr>
			<tr>
			    <td>个人简历:</td>
				<td colspan="3">${stuInfor.stuResume}</td>
			</tr>
			<tr>
			    <td>校友类型:</td>
				<td>${stuInfor.stuType}</td>
			</tr>
		</table>	
		</div>
	</div>
	</#if>
	</left>
	</body>
</html>
