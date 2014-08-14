package sencloud.sl.util;


import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
/**
 * JUnit测试类的类名和包名是有规范的，类名是由被测试类的名称再加一个Test后缀或前缀
 * 包名保持与被测试类相同
 * */
public class FileUtilTest extends TestCase{
	/**
	 * 每个测试方法执行前都会执行setUp方法，每个测试方法执行结束后都会执行tearDown方法
	 * 有多少个测试方法，setUp与tearDown就会被执行多少次
	 * */
	@Before
	public void setUp() throws Exception {
		System.out.println("开始执行方法");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("结束执行方法");
	}
	/**
	 * 测试方法必须以test为前缀，
	 * */
	public void testSpilt(){
		System.out.println(FormatDate.getFormateDateAll());
	}
}
