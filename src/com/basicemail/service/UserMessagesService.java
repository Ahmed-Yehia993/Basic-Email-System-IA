package com.basicemail.service;

import java.sql.SQLException;
import java.util.List;

import com.basicemail.dao.UserMessagesDao;
import com.basicemail.entity.MessageDto;
import com.basicemail.entity.ThreadMessageDto;

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

	public void ArchiveThreadMessages(int threadID) throws SQLException {
		userMessagesDao.ArchiveThreadMessages(threadID);
	}

	public void DeleteThreadMessages(int threadID) throws SQLException {
		userMessagesDao.DeleteThreadMessages(threadID);
	}

	public void MarkThreadASReaded(int threadID) throws SQLException {
		userMessagesDao.MarkThreadASReaded(threadID);
	}

	public List<ThreadMessageDto> getAllMessagesOfThreadByThreadID(int threadID) throws SQLException {
		return userMessagesDao.getAllMessagesOfThreadByThreadID(threadID);
	}
}
