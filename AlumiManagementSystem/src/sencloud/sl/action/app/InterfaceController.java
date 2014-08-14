///**
// * 
// */
//package sencloud.sl.action.app;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import sencloud.sl.base.BaseAction;
//import sencloud.sl.entity.StuInfor;
//
//import com.opensymphony.xwork2.ModelDriven;
//
///**
// * @author farryxia
// * 
// */
//public class InterfaceController extends BaseAction implements ModelDriven<Object>{
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//
//	private Map<String,Object> dataMap;
//
//	public String login(){
//		// dataMap中的数据将会被Struts2转换成JSON字符串，所以这里要先清空其中的数据  
//        dataMap = new HashMap<String, Object>();  
//        StuInfor user = new StuInfor();
//        user.setStuNum("张三");  
//        user.setPassword("123");  
//        dataMap.put("user", user);  
//        // 放入一个是否操作成功的标识  
//        dataMap.put("success", true);  
//        // 返回结果  
//        return SUCCESS;
//	}
//	
//	public Map<String, Object> getDataMap() {  
//        return dataMap;  
//    }
//
//	@Override
//	public Object getModel() {
//		
//		return null;
//	}  
//  
//}
