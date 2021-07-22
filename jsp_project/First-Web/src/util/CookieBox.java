package util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


public class CookieBox {

	// request 객체를 이용해서 모든 Cookie 객체르르 Map에 저장
	private Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
	
	// CookieBox 생성자
	public CookieBox(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		
		if (cookies != null && cookies.length > 0) {
			for (int i = 0; i < cookies.length; i++) {
				cookieMap.put(cookies[i].getName(), cookies[i]);
			}
		}
	}
	
	public static Cookie makeCookie(String name, String value) throws UnsupportedEncodingException {
		Cookie c = new Cookie(name, URLEncoder.encode(value, "utf-8"));
		return c;
	}
	
	public static Cookie makeCookie(String name, String value, String path, int maxAge) throws UnsupportedEncodingException {
		Cookie c = new Cookie(name, URLEncoder.encode(value, "utf-8"));
		c.setPath(path);
		c.setMaxAge(maxAge);
		return c;
	}
	
	public static Cookie makeCookie(String name, String value, String path, int maxAge, String domain) throws UnsupportedEncodingException {
		Cookie c = new Cookie(name, URLEncoder.encode(value, "utf-8"));
		c.setPath(path);
		c.setMaxAge(maxAge);
		c.setDomain(domain);
		return c;
	}
	
	// 객체 생성 -> 쿠키 검색(존재유무), 쿠키이름으로 쿠키 객체 반환, 쿠키이름으로 쿠키 값을 반환
	
	// 이름으로 쿠키 객체를 반환하는 메소드
	public Cookie getCookie(String name) {
		return cookieMap.get(name);
	}
	
	// 이름으로 쿠키의 값을 반환하는 메소드
	public String getValue(String name) throws UnsupportedEncodingException {
		Cookie c = cookieMap.get(name);
		if (c == null) {
			return null;
		}
		return URLDecoder.decode(c.getValue(), "utf-8");
	}
	
	// 이름으로 쿠키가 존재하는지 확인하는 메소드
	public boolean exists(String name) {
		return cookieMap.get(name) != null;
	}
}
