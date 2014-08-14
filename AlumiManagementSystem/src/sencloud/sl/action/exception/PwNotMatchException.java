package sencloud.sl.action.exception;

public class PwNotMatchException extends Exception{

	/**
	 * 密码未找到的异常
	 */
	private static final long serialVersionUID = -8931692992407800003L;
	
	public PwNotMatchException(){};
	public PwNotMatchException(String msg){
		super(msg);
	}

}
