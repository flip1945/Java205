package ex;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpURLConnectionTest {

	public static void main(String[] args) {
		
		String urlStr = "https://sports.news.naver.com/news.nhn?oid=421&aid=0005392894";
		
		try {
			URL url = new URL(urlStr);
			
			// httpURLConnection : url.openConnecntion()
			HttpURLConnection hcon = (HttpURLConnection)url.openConnection();
			
			for (int i = 1; i < 9; i++) {
				System.out.print(hcon.getHeaderFieldKey(i));
				System.out.println(" : " + hcon.getHeaderField(i));
			}
			
			hcon.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
