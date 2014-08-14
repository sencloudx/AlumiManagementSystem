package sencloud.sl.action.exception;

public class NameNotFoundException extends Exception{

	/**
	 * 定义名字未找到异常
	 */
	private static final long serialVersionUID = 8493997141601553361L;
	
	public NameNotFoundException(){};
	public NameNotFoundException(String msg)
	{
		super(msg);
	}
}
