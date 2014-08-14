package sencloud.sl.util.mail;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 替换图片的相对地址为绝对地址工具类
 */
public class ImageUtil {
	
	/**
	 * 替换html 中的图片地址为绝对地址
	 * @param content
	 * @param IP 服务器的域名或是ip地址，如http://www.baidu.com或http://ip:port
	 * @return
	 */
	public static String replaceRelativeToAbsolute(String content,String IP){
		try {
			Document document = Jsoup.parse(content);
			//获取到文章中的图片标签
			Elements elements = document.getElementsByTag("img");
			for (int i = 0; i < elements.size(); i++) {
				Element element = elements.get(i);
				try {
					String src = element.attr("src");
					// 图片标签的地址要以"/"开头
					if (src.startsWith("/")) {
						src  = IP+src;
						element.attr("src", src);
					}
					//替换不掉则移除标签
					else {
						element.remove();
					}
				} catch (Exception e) {
					e.printStackTrace();
					element.remove();
				}
			}
			return document.body().html();
		} catch (Exception e) {
			e.printStackTrace();
			//替换失败，还是返回原文
			return content;
		}
	}
	
	public static void main(String[] args) {
		 String IP = "http://www.oschina.net";
		  String content =  "<img id='NewsPic' src='/img/logo/android.png' /><p>测试</p>";
		  content =  replaceRelativeToAbsolute(content, IP);
		  System.out.println(content);
	}
	

}
