package com.basicemail.servelet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basicemail.entity.Message;
import com.basicemail.service.SendingMessageService;

@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MessageServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int userid = (int) session.getAttribute("logedInUserId");
		
		if (userid == 0) {
			getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		Integer type = (Integer) request.getAttribute("type");
		String subject = (String) request.getAttribute("subject");
		String body = (String) request.getAttribute("body");
		String recivers = (String) request.getAttribute("recivers");

		SendingMessageService sms = new SendingMessageService();
		if (type.intValue() == 1) { // compose
			response.getWriter().append(sms.composeMessage(new Message(0, userid, 0, subject, body, null), recivers));
		} else if (type.intValue() == 2) { // replay
			int threadid = (int) session.getAttribute("threadid");
			response.getWriter()
					.append(sms.replayMessage(new Message(0, userid, 0, subject, body, null), recivers, threadid));
		} else if (type.intValue() == 3) { // forward
			response.getWriter().append(sms.forwardMessage(new Message(0, userid, 0, subject, body, null), recivers));
		} else {
			// TODO to be handled
			getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
