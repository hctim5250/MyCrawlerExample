package crawler.example;

import com.github.abola.crawler.CrawlerPack;
import org.apache.commons.logging.impl.SimpleLog;
import org.jsoup.select.Elements;

/**
 * 爬蟲包程式的全貌，就只有這固定的模式
 * 
 * @author Abola Lee
 *
 */
public class PttExample {
	// commit test test
	public static void main(String[] args) {

		// set to debug level
		//CrawlerPack.setLoggerLevel(SimpleLog.LOG_LEVEL_DEBUG);

		// turn off logging
		CrawlerPack.setLoggerLevel(SimpleLog.LOG_LEVEL_OFF);

		// 遠端資料路徑
		//String uri = "https://www.ptt.cc/bbs/Gossiping/M.1512863117.A.FC8.html"; //推&噓文
		String uri = "https://www.ptt.cc/bbs/Gossiping/M.1512863534.A.251.html";   //抓內文

		/*
		System.out.println(
				CrawlerPack.start()
				
				// 參數設定
			    .addCookie("over18","1")	// 設定cookie
				//.setRemoteEncoding("big5")// 設定遠端資料文件編碼
				
				// 選擇資料格式 (三選一)
				//.getFromJson(uri)
			    .getFromHtml(uri)
			    //.getFromXml(uri)
			    
			    // 這兒開始是 Jsoup Document 物件操作
				//.select("span.hl.push-tag:contains(推)")
			    //.select("span.hl.push-tag:contains(推)+span.hl.push-userid")
				.select("span.hl.push-tag:contains(推)+span.hl.push-userid")
		);
		*/

		Elements jsoup = CrawlerPack.start()

				// 參數設定
				.addCookie("over18","1")	// 設定cookie
				//.setRemoteEncoding("big5")// 設定遠端資料文件編碼

				.getFromHtml(uri)

				// 這兒開始是 Jsoup Document 物件操作
				.select("#main-content");

		System.out.println(jsoup.select("span, div").remove().text());

	}
}
