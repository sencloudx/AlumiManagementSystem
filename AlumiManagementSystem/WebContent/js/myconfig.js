//FCKConfig.AutoDetectLanguage=false;
//FCKConfg.DefaultLanguage="fr";
FCKConfig.ToolbarSets["simple"] = [//设置显示的功能
	['Source','DocProps'],
	['Bold','Italic','Underline','StrikeThrough','-','Subscript','Superscript'],
	['OrderedList','UnorderedList','-','Outdent','Indent','Blockquote','CreateDiv'],
	['JustifyLeft','JustifyCenter','JustifyRight','JustifyFull'],
	['Link','Unlink','Anchor'],
	['Image','Flash','Table','Rule','Smiley','SpecialChar','PageBreak'],
	'/',
	['Style','FontFormat','FontName','FontSize'],
	['TextColor','BGColor'],
	['FitWindow','ShowBlocks','-','About']		// No comma for the last row.
] ;
FCKConfig.ToolbarSets["very_simple"] = [//设置显示的功能
              ['FontName','FontSize'],
              ['TextColor']
              ] ;
FCKConfig.ToolbarSets["very_simple2"] = [//设置显示的功能
                                     	['Bold','Italic','Underline'],
                                     	['JustifyLeft','JustifyCenter','JustifyRight','JustifyFull'],
                                     	['Smiley'],
                                     	['Style','FontFormat','FontName','FontSize'],
                                        ] ;

FCKConfig.FontNames		= '宋体;楷体-GB2312;黑体;隶书;行书;Times New Roman;Verdana' ;//设置字体的类型

FCKConfig.EnterMode = 'br' ;			// 设置回车和换行
FCKConfig.ShiftEnterMode = 'p' ;
//设置表情图片
FCKConfig.SmileyPath	= FCKConfig.BasePath + 'images/smiley/msn/biaoqing/' ;//放置表情图片的文件夹,FCKConfig.BasePath路径为fckeditor下的editor
//设置被使用的表情图片
FCKConfig.SmileyImages	= ['1.jpg','2.jpg','3.jpg','4.jpg','5.jpg','6.jpg','7.jpg','8.jpg','9.jpg','10.jpg','11.jpg','12.jpg','13.jpg','14.jpg','15.jpg','16.jpg','17.jpg','18.jpg','19.jpg','20.jpg','21.jpg','22.jpg','23.jpg','24.jpg','25.jpg','26.jpg','27.jpg','28.jpg','29.jpg','30.jpg','31.jpg','32.jpg','33.jpg',] ;
FCKConfig.SmileyColumns = 4 ;//每行显示多少文件
FCKConfig.SmileyWindowWidth		= 450 ;//表情图片框的宽带
FCKConfig.SmileyWindowHeight	= 380 ;//表情图片框的高度

FCKConfig.ImageUploadAllowedExtensions	= ".(jpg|gif|jpeg|png|bmp|abc)$" ;		// 在客户端增加abc的图片扩展名



