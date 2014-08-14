package sencloud.sl.util;
/**用来进行数据类型验证的工具类
 */
public class ValidateData {
	/**
	 * 用JAVA自带的函数判断字符串是否为数字
	 * @param str
	 * @return是数字返回true不是则返回false
	 * 
	 */
	public static boolean isNumeric(String str) {
		for (int i = str.length(); --i >= 0;) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	//取值范围验证
	public static boolean validateScope(Object[] arrayScope,Object value){
		for(int i=0;i<arrayScope.length;i++){
			if(value.equals(arrayScope[i])){
				return true;
				
			}
			
		}
		return false;
	}
	
	//验证选项格式是否正确，必须是首字母含有
	public static boolean validateChoise(String beCheckStr,String checkStr){
		if(beCheckStr.indexOf(checkStr)!=0){
			return false;
		}
		return true;	
	}
	
	//验证一段字符串中是否含有另一段字符串
	public static boolean validateIsExsit(String beCheckStr,String checkStr){
		if(beCheckStr.indexOf(checkStr)==-1){
			return false;
		}
		return true;
		
	}
}
