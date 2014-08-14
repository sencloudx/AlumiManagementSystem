<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0035)http://www.sojump.com/jq/79210.aspx -->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD id="ctl00_Head1">
<TITLE>问卷调查</TITLE>
<META content="no-cache" http-equiv="Pragma">
<META content="no-cache" http-equiv="Cache-Control">
<META content="0" http-equiv="Expires">
<META content="text/html; charset=UTF-8" http-equiv="content-type">
<LINK rel="stylesheet" type="text/css" href="/AlumiManagementSystem/css/surveyCss.css">
<META name="GENERATOR" content="MSHTML 9.00.8112.16457">
</HEAD>
<BODY style='background: url("/AlumiManagementSystem/images/survey/surveyBg.jpg") fixed no-repeat top rgb(185, 230, 235);'>
<DIV style="height: 100px; text-align: center; display: none;" id="divNotRun"></DIV>
<DIV style="background: rgb(255, 255, 255); margin: 20px auto 0px; width: 920px; text-align: left;" id="jqContent">
  <DIV style="height: 15px; overflow-x: hidden; overflow-y: hidden;" id="headerCss">
    <DIV id="ctl00_header"></DIV>
  </DIV>
  <DIV id="mainCss">
    <DIV id="mainInner">
      <DIV id="box">
        <STYLE>  
                 .interface
                 {
                       text-align: left; border: solid 1px #ff9900; background: #FDEADA; color: #333333;vertical-align:middle;
                       margin:20px auto; width: 760px; height:32px; line-height:32px; padding:0 4px;
                 }
                 html{ overflow-x:hidden;}
            </STYLE>
        <DIV style="margin: 0px auto;" class="survey">
          <DIV style="border: 0px currentColor;" class="surveyhead">
            <H1><SPAN>${questionnaire.questionnaireTitle}</SPAN></H1>
            <DIV style="margin: 5px 0px; float: right;">
                <SPAN>发布者：
                    <STRONG>
                        <A class="link-U00a6e6" href="#" >${questionnaire.admin.adminNum}</A>
                    </STRONG>
                    <A href="#" ><IMG style="padding-left: 2px;"align="absmiddle" src="/AlumiManagementSystem/images/survey/email.png"></A>&nbsp;
                    <SPAN class="hei"><SPAN>${questionnaire.queDate?default("")}</SPAN></SPAN>&nbsp;&nbsp;
                </SPAN>
                <#--<SPAN >有效答卷：<A style="font-weight: bold;" href="#" >1002</A>份&nbsp;</SPAN>-->
            </DIV>
            <DIV style="text-align: left; margin-left: 10px;"></DIV>
            <DIV style="clear: both;"></DIV>
            <DIV class="surveydescription">
                <SPAN style="vertical-align: middle;">${questionnaire.questionnaireDes}</SPAN>
            </DIV>
            <DIV style="clear: both;"></DIV>
          </DIV>
          <!--surveyhead end-->
          <DIV class="surveycontent">
            <DIV>
              <STYLE type="text/css">
legend
                        {
                            display: none;
                        }
                        fieldset
                        {
                            border: 0px; margin:0; padding:0;
                        }
                        
                    </STYLE>
            </DIV>
            <DIV>
              <FIELDSET id="fieldset1" class="fieldset">
			          
              <DIV id="div2" class="div_question">
                <DIV class="div_title_question_all">
                  <DIV class="div_topic_question"><B>2.</B></DIV>
                  <DIV class="div_title_question">
                      您目前从事的职业：
                      <SPAN style="color: red;">&nbsp;*</SPAN>
                  </DIV>
                  <DIV style="clear: both;"></DIV>
                </DIV>
                <DIV class="div_table_radio_question">
                  <DIV class="div_table_clear_top"></DIV>
                  <SELECT id="q2" name="q2">
                    <OPTION value="-2">请选择</OPTION>
                    <OPTION value="1">全日制学生</OPTION>
                    <OPTION value="2">客户服务类</OPTION>
                    <OPTION value="3">市场·公关·媒介类</OPTION>
                    <OPTION value="4">行政·后勤类</OPTION>
                  </SELECT>
                  <DIV style="clear: both;"></DIV>
                  <DIV class="div_table_clear_bottom"></DIV>
                </DIV>
              </DIV>
              
              
              <#if questionBankList?exists>	  
				<#list questionBankList as que>  
				  <#if que.queType.typeName == "单选题">
	              <DIV id="div3" class="div_question">
	                <DIV class="div_title_question_all">
	                  <DIV class="div_topic_question"><B>${que_index+1}.</B></DIV>
	                  <DIV class="div_title_question">
	                      ${que.queTitle?default("")}
	                      <SPAN style="color: red;">&nbsp;*</SPAN>
	                  </DIV>
	                  <DIV style="clear: both;"></DIV>
	                </DIV>
	                <DIV class="div_table_radio_question">
	                  <DIV class="div_table_clear_top"></DIV>
	                  <UL>
	                    <LI style="width: 24%;">
	                      <INPUT type="radio">
	                      <LABEL>有</LABEL>
	                    </LI>
	                    <LI style="width: 24%;">
	                      <INPUT type="radio">
	                      <LABEL>没有</LABEL>
	                    </LI>
	                    <LI style="width: 24%;">
	                      <INPUT type="radio">
	                      <LABEL>偶尔喝一点</LABEL>
	                    </LI>
	                    <DIV style="clear: both;"></DIV>
	                  </UL>
	                  <DIV style="clear: both;"></DIV>
	                  <DIV class="div_table_clear_bottom"></DIV>
	                </DIV>
	              </DIV>
              	</#if>
              	</#list>
              	</#if>
              <DIV id="div4" class="div_question">
                <DIV class="div_title_question_all">
                  <DIV class="div_topic_question"><B>4.</B></DIV>
                  <DIV class="div_title_question">
                      您一般喝什么牌子的牛奶？
                      <SPAN style="color: red;">&nbsp;*</SPAN>
                  </DIV>
                  <DIV style="clear: both;"></DIV>
                </DIV>
                <DIV class="div_table_radio_question">
                  <DIV class="div_table_clear_top"></DIV>
                  <UL>
                    <LI style="width: 24%;">
                      <INPUT type="radio">
                      <LABEL>蒙牛</LABEL>
                    </LI>
                    <LI style="width: 24%;">
                      <INPUT type="radio">
                      <LABEL>伊利</LABEL>
                    </LI>
                    <LI style="width: 24%;">
                      <INPUT type="radio">
                      <LABEL>光明</LABEL>
                    </LI>
                    <LI style="width: 24%;">
                      <INPUT type="radio">
                      <LABEL>其他</LABEL>
                    </LI>
                    <DIV style="clear: both;"></DIV>
                  </UL>
                  <DIV style="clear: both;"></DIV>
                  <DIV class="div_table_clear_bottom"></DIV>
                </DIV>
              </DIV>
              
              <DIV id="div5" class="div_question">
                <DIV class="div_title_question_all">
                  <DIV class="div_topic_question"><B>5.</B></DIV>
                  <DIV class="div_title_question">
                      您购买牛奶时最受哪种媒体的影响？
                      <SPAN style="color: red;">&nbsp;*</SPAN>
                  </DIV>
                  <DIV style="clear: both;"></DIV>
                </DIV>
                <DIV class="div_table_radio_question">
                  <DIV class="div_table_clear_top"></DIV>
                  <UL>
                    <LI style="width: 24%;">
                      <INPUT type="radio">
                      <LABEL>报刊杂志</LABEL>
                    </LI>
                    <LI style="width:24%;">
                      <INPUT type="radio">
                      <LABEL>电视广告</LABEL>
                    </LI>
                    <LI style="width:24%;">
                      <INPUT type="radio">
                      <LABEL>海报宣传</LABEL>
                    </LI>
                    <DIV style="clear: both;"></DIV>
                  </UL>
                  <UL>
                    <LI>
                      <INPUT type="radio">
                      <LABEL>其它</LABEL>
                      <INPUT oninput="lengthChange(this);" onpropertychange="lengthChange(this);" class="underline" type="text">
                    </LI>
                    <DIV style="clear: both;"></DIV>
                  </UL>
                  <DIV style="clear: both;"></DIV>
                  <DIV class="div_table_clear_bottom"></DIV>
                </DIV>
              </DIV>
              <DIV id="div6" class="div_question">
                <DIV class="div_title_question_all">
                  <DIV class="div_topic_question"><B>6.</B></DIV>
                  <DIV id="divTitle6" class="div_title_question">
                      假如你一直购买一个品牌，什么原因能使你去买其他的品牌？
                      <SPAN style="color: red;">&nbsp;*</SPAN>
                  </DIV>
                  <DIV style="clear: both;"></DIV>
                </DIV>
                <DIV id="divquestion6" class="div_table_radio_question">
                  <DIV class="div_table_clear_top"></DIV>
                  <UL>
                    <LI style="width: 49%;">
                      <INPUT type="radio">
                      <LABEL>价格便宜</LABEL>
                    </LI>
                    <LI style="width: 49%;">
                      <INPUT type="radio">
                      <LABEL>包装新颖</LABEL>
                    </LI>
                    <DIV style="clear: both;"></DIV>
                  </UL>
                  <UL>
                    <LI style="width: 49%;">
                      <INPUT type="radio">
                      <LABEL>除非原来的出现质量问题，否则不更换</LABEL>
                    </LI>
                    <LI style="width: 49%;">
                      <INPUT type="radio">
                      <LABEL>其他原因</LABEL>
                    </LI>
                    <DIV style="clear: both;"></DIV>
                  </UL>
                  <UL>
                    <DIV style="clear: both;"></DIV>
                  </UL>
                  <DIV style="clear: both;"></DIV>
                  <DIV class="div_table_clear_bottom"></DIV>
                </DIV>
              </DIV>
              <DIV id="div7" class="div_question">
                <DIV class="div_title_question_all">
                  <DIV class="div_topic_question"><B>7.</B></DIV>
                  <DIV id="divTitle7" class="div_title_question">
                      您选择某品牌的理由是什么？
                      <SPAN style="color: red;">&nbsp;*</SPAN>
                  </DIV>
                  <DIV style="clear: both;"></DIV>
                </DIV>
                <DIV id="divquestion7" class="div_table_radio_question">
                  <DIV class="div_table_clear_top"></DIV>
                  <UL>
                    <LI style="width: 15.66%;">
                      <INPUT type="radio">
                      <LABEL>品牌</LABEL>
                    </LI>
                    <LI style="width: 15.66%;">
                      <INPUT type="radio">
                      <LABEL>质量</LABEL>
                    </LI>
                    <LI style="width: 15.66%;">
                      <INPUT type="radio">
                      <LABEL>口感</LABEL>
                    </LI>
                    <LI style="width: 15.66%;">
                      <INPUT type="radio">
                      <LABEL>价格</LABEL>
                    </LI>
                    <LI style="width: 15.66%;">
                      <INPUT type="radio">
                      <LABEL>广告</LABEL>
                    </LI>
                    <LI>
                      <INPUT type="radio">
                      <LABEL>其它</LABEL>
                      <INPUT oninput="lengthChange(this);" onpropertychange="lengthChange(this);" 
              class="underline" type="text">
                    </LI>
                    <DIV style="clear: both;"></DIV>
                  </UL>
                  <UL>
                    <DIV style="clear: both;"></DIV>
                  </UL>
                  <DIV style="clear: both;"></DIV>
                  <DIV class="div_table_clear_bottom"></DIV>
                </DIV>
              </DIV>
                           
              <DIV id="div11" class="div_question">
                <DIV class="div_title_question_all">
                  <DIV class="div_topic_question"><B>11.</B></DIV>
                  <DIV class="div_title_question">
                      对于蒙牛牛奶您有些什么建议？&nbsp;
                      <SPAN class="font-a0">（1000字以内）</SPAN></DIV>
                  <DIV style="clear: both;"></DIV>
                </DIV>
                <DIV class="div_table_radio_question">
                  <DIV class="div_table_clear_top"></DIV>
                  <TEXTAREA style="width: 62%; height: 36px; overflow: auto;" class="inputtext" value=""></TEXTAREA>
                  <DIV class="div_table_clear_bottom"></DIV>
                </DIV>
              </DIV>
              <DIV class="register_div">
              </DIV>
              </DIV>
              </FIELDSET>
            </DIV>
            <DIV style="clear: both; margin-top:20px; height:40px; text-align:center" id="submit_div">
              <INPUT id="submit_button" class="submitbutton" value="提交答卷" type="button">
                   
              <DIV style="clear: both;"></DIV>
            </DIV>
            
          </DIV>
          <DIV style="clear: both;"></DIV>
          <DIV style="clear: both;"></DIV>
        </DIV>
        <DIV style="margin: 30px auto 0px; width: 920px; overflow-x: hidden;">
          <DIV style="margin: 0px auto; width: 98%; height: 1px; line-height: 1px; font-size: 0px; border-top-color: rgb(187, 187, 187); border-top-width: 1px; border-top-style: solid;">
          </DIV>
          <div style="height: 30px; line-height:30px;color: rgb(102, 102, 102); font-family: Tahoma, 宋体; font-size: 12px; text-align:center">
          曦点提供技术支持
          </div>
         
        </DIV>
      </DIV>
    </DIV>
    <DIV style="clear: both;"></DIV>
  </DIV>
  <!--mainCss end-->
  <DIV id="footercss">
    <DIV id="footerLeft"></DIV>
    <DIV id="footerCenter"></DIV>
    <DIV id="footerRight"></DIV>
  </DIV>
  <DIV style="height: 10px; clear: both;"></DIV>
  <DIV style="height: 20px;">&nbsp;</DIV>
</DIV>
<DIV style="clear: both;"></DIV>
<DIV style="height: 70px; display: none;" id="rbbox"></DIV>
<DIV style="display: none;">
  
</DIV>
</BODY>
</HTML>
