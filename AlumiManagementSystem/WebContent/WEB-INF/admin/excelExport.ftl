<p style="text-align:left; padding-top:15px">
	<b>导出声明：</b><font color = "red">勾选选定导出则按照勾选的学生进行导出，否则将按当前视图进行导出</font>
</p>
<p style="text-align:left; padding-top:15px">
<input type="checkbox" name = "require" id = "require" value="1" onclick = "require()">&nbsp;&nbsp;选定导出<font color = "red">[勾选后将会根据你选定的学生进行导出]</font></p>
<p style="text-align:center; padding-top:15px">
<input type="button" value="全选" onclick="allSelect('stu');"/>
<input type="button" value="反选" onclick="invertSelect('stu');"/>
</p>
<p></p>
<p style="text-align:center; padding-top:15px">
	选择需要导出的选项：</br>
	<input type="checkbox" name="stu" id="a" value="学生学号">学生学号&nbsp;&nbsp;
	<input type="checkbox" name="stu" id="a" value="学生姓名">学生姓名&nbsp;&nbsp;
	<input type="checkbox" name="stu" id="a" value="学生性别">学生性别&nbsp;&nbsp;
	<input type="checkbox" name="stu" id="a" value="学生专业">学生专业&nbsp;&nbsp;
	<input type="checkbox" name="stu" id="a" value="所属班级">所属班级</br>
	
	<input type="checkbox" name="stu" id="a" value="入学年份">入学年份&nbsp;&nbsp;
	<input type="checkbox" name="stu" id="a" value="毕业年份">毕业年份&nbsp;&nbsp;
	<input type="checkbox" name="stu" id="a" value="电子邮箱">电子邮箱&nbsp;&nbsp;
	<input type="checkbox" name="stu" id="a" value="通信地址">通信地址&nbsp;&nbsp;
	<input type="checkbox" name="stu" id="a" value="家庭地址">家庭地址</br>
	
	<input type="checkbox" name="stu" id="a" value="工作省市">就业省市&nbsp;&nbsp;
	<input type="checkbox" name="stu" id="a" value="工作单位">工作单位&nbsp;&nbsp;
	<input type="checkbox" name="stu" id="a" value="工作岗位">工作岗位&nbsp;&nbsp;
	<input type="checkbox" name="stu" id="a" value="职务职称">职务职称&nbsp;&nbsp;
	<input type="checkbox" name="stu" id="a" value="办公电话">办公电话</br>
	
	<input type="checkbox" name="stu" id="a" value="身份证号">身份证号&nbsp;&nbsp;
	<input type="checkbox" name="stu" id="a" value="所在国家">所在国家&nbsp;&nbsp;
	<input type="checkbox" name="stu" id="a" value="生源省市">生源省市&nbsp;&nbsp;
	<input type="checkbox" name="stu" id="a" value="校友类型">校友类型&nbsp;&nbsp;
	<input type="checkbox" name="stu" id="a" value="通信邮编">通信邮编</br>
	
	<input type="checkbox" name="stu" id="a" value="最后学历及学校">最后学历及学校&nbsp;&nbsp;
	<input type="checkbox" name="stu" id="a" value="最后学位及学校">最后学位及学校&nbsp;&nbsp;
	<input type="checkbox" name="stu" id="a" value="荣誉奖励">荣誉奖励&nbsp;&nbsp;
	<input type="checkbox" name="stu" id="a" value="个人简历">个人简历<br>
	
	<input type="checkbox" name="stu" id="a" value="医师职称">医师职称&nbsp;&nbsp;
	<input type="checkbox" name="stu" id="a" value="教师职称">教师职称&nbsp;&nbsp;
	<input type="checkbox" name="stu" id="a" value="QQ号码">QQ号码&nbsp;&nbsp;
	<input type="checkbox" name="stu" id="a" value="手机号码">手机号码</br>
</p>
<p style="text-align:center; padding-top:15px">
	<input type="button" value="全选" onclick="allSelect('stu');"/>
	<input type="button" value="反选" onclick="invertSelect('stu');"/>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="button" value="导出" onclick="exportExcel('exportExcelAction.action');"/>
</p>
