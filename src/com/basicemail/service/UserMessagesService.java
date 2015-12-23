package com.basicemail.service;

import java.sql.SQLException;
import java.util.List;

import com.basicemail.dao.UserMessagesDao;
import com.basicemail.entity.MessageDto;

public class UserMessagesService {
	private static UserMessagesDao userMessagesDao;

	public UserMessagesService() {
		userMessagesDao = new UserMessagesDao();
	}

	public static List<MessageDto> getUserInbox(int userID) throws SQLException {
		return userMessagesDao.getUserInbox(userID);
	}
	
	public static List<MessageDto> getUserSent(int userID) throws SQLException {
		return userMessagesDao.getUserSent(userID);
	}
	
	public static List<MessageDto> getUserArchived(int userID) throws SQLException {
		return userMessagesDao.getUserArchived(userID);
	}
	
	public static List<MessageDto> getUserTrashed(int userID) throws SQLException {
		return userMessagesDao.getUserTrashed(userID);
	}
}
