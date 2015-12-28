package com.basicemail.service;

import java.sql.SQLException;
import java.util.List;

import com.basicemail.dao.ComposeMessageDao;
import com.basicemail.entity.Message;
import com.basicemail.entity.MessageDto;

public class SendingMessageService {

	private ComposeMessageDao cmd;

	public SendingMessageService() {
		cmd = new ComposeMessageDao();
	}

	public String composeMessage(Message message, String recivers) {
		try {
			return cmd.composeMessage(message, recivers);
		} catch (SQLException e) {
			return null;
		}
	}

	public String replayMessage(Message message, String recivers, int threadid) {
		try {
			return cmd.replayMessage(message, recivers, threadid);
		} catch (SQLException e) {
			return null;
		}
	}

	public String forwardMessage(Message message, String recivers) {
		try {
			return cmd.composeMessage(message, recivers);
		} catch (SQLException e) {
			return null;
		}
	}

	public List<MessageDto> searchAboutThreadsByFrom(int userID, int wantedUserID) throws SQLException {
		return cmd.searchAboutThreadsByFrom(userID, wantedUserID);
	}

	public List<MessageDto> searchAboutThreadsByTo(int userID, int wantedUserID) throws SQLException {
		return cmd.searchAboutThreadsByTo(userID, wantedUserID);
	}

	public List<MessageDto> searchAboutThreadsBySpecificRange(int userID, String from, String to) throws SQLException {
		return cmd.searchAboutThreadsBySpecificRange(userID, from, to);
	}
}
