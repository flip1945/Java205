package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자의 요청 분석 : type 파라미터의 값을 분석
		String type = request.getParameter("type");
		
		Object resultObj = null;
		String viewPage = "/WEB-INF/views/default.jsp";
		
		// 2. 요청 처리 : 모델 선택, 실행 -> 요청을 처리할 수 있는 Service를 선택 
		if (type == null || type.equals("greeting")) {
			// 처리해야할 Service의 메소드를 실행
			resultObj = "안녕하세요!";
			viewPage = "/WEB-INF/views/greeting.jsp"; 
		} else if(type.equals("date")) {
			resultObj = new Date();
			viewPage = "/WEB-INF/views/date.jsp";
		} else {
			resultObj = "Invalid Type Request";
		}
		
		// 3. 결과 데이터를 공유(전달)
		request.setAttribute("result", resultObj);
		
		// 4. viewPage로 포워딩
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
