package com.basicemail.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.basicemail.entity.Message;
import com.basicemail.entity.MessageDto;
import com.basicemail.entity.ThreadMessageDto;
import com.basicemail.entity.User;
import com.basicemail.util.DBUtil;

public class UserMessagesDao {

	public List<MessageDto> getUserInbox(int userID) throws SQLException {

		String selectSQL = "SELECT COUNT(recipient_message.thread_msg_id) as 'threadMessagesNumber' , "
				+ "MAX(message.id) as 'msgID' , recipient_message.thread_msg_id as 'threadID', "
				+ "user.firstname as 'fname' , user.lastname as 'lname' , user.email as 'email' "
				+ "FROM recipient_message INNER JOIN message ON recipient_message.msg_id = message.id "
				+ "INNER JOIN user ON message.sender_id = user.id "
				+ "WHERE (recipient_message.reciver_id = ? or message.sender_id  = ? ) AND recipient_message.thread_msg_id IN ( "
				+ "SELECT recipient_message.thread_msg_id FROM recipient_message WHERE recipient_message.reciver_id = ? ) "
				+ "AND recipient_message.is_archived = 0 AND "
				+ "recipient_message.is_trashed = 0 AND recipient_message.is_deleted = 0 "
				+ "GROUP BY recipient_message.thread_msg_id DESC;";

		List<MessageDto> list = new ArrayList<MessageDto>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User receiver = new User();
		receiver.setId(userID);

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(selectSQL);
			ps.setInt(1, userID);
			ps.setInt(2, userID);
			ps.setInt(3, userID);
			rs = ps.executeQuery();

			while (rs.next()) {
				int threadID = rs.getInt("threadID");
				int threadMessagesNumber = rs.getInt("threadMessagesNumber");

				int msgID = rs.getInt("msgID");

				String fname = rs.getString("fname");
				String lname = rs.getString("lname");
				String email = rs.getString("email");

				Message message = getMessageBYID(msgID);
				User sender = new User(message.getSenderId(), fname, lname, email);
				MessageDto messageDto = new MessageDto(threadID, receiver, sender, message, threadMessagesNumber);
				list.add(messageDto);
			}
			return list;
		} finally {
			DBUtil.cleanUp(con, ps, rs);
		}
	}

	public List<MessageDto> getUserSent(int userID) throws SQLException {

		String selectSQL = "SELECT COUNT(recipient_message.thread_msg_id) as 'threadMessagesNumber' , "
				+ "MAX(message.id) as 'msgID' , recipient_message.thread_msg_id as 'threadID', recipient_message.reciver_id as 'receiverID',"
				+ "user.firstname as 'fname' , user.lastname as 'lname' , user.email as 'email' "
				+ "FROM recipient_message INNER JOIN message ON recipient_message.msg_id = message.id "
				+ "INNER JOIN user ON recipient_message.reciver_id = user.id "
				+ "WHERE (recipient_message.reciver_id = ? or message.sender_id  = ? ) AND recipient_message.thread_msg_id IN ( "
				+ "SELECT message.thread_msg_id FROM message WHERE message.sender_id = ? ) "
				+ "AND recipient_message.is_archived = 0 AND "
				+ "recipient_message.is_trashed = 0 AND recipient_message.is_deleted = 0 "
				+ "GROUP BY recipient_message.thread_msg_id DESC;";

		List<MessageDto> list = new ArrayList<MessageDto>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		User sender = new User();
		sender.setId(userID);

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(selectSQL);
			ps.setInt(1, userID);
			ps.setInt(2, userID);
			ps.setInt(3, userID);
			rs = ps.executeQuery();

			while (rs.next()) {
				int threadID = rs.getInt("threadID");
				int threadMessagesNumber = rs.getInt("threadMessagesNumber");

				int msgID = rs.getInt("msgID");

				int receiverID = rs.getInt("receiverID");
				String fname = rs.getString("fname");
				String lname = rs.getString("lname");
				String email = rs.getString("email");

				Message message = getMessageBYID(msgID);
				User receiver = new User(receiverID, fname, lname, email);
				MessageDto messageDto = new MessageDto(threadID, receiver, sender, message, threadMessagesNumber);
				list.add(messageDto);
			}
			return list;
		} finally {
			DBUtil.cleanUp(con, ps, rs);
		}
	}

	public static Message getMessageBYID(int messageID) throws SQLException {

		String selectSQL = "SELECT * from message WHERE id = ? ;";

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Message message = null;

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(selectSQL);
			ps.setInt(1, messageID);
			rs = ps.executeQuery();

			while (rs.next()) {
				int sender_id = rs.getInt("sender_id");
				int thread_msg_id = rs.getInt("thread_msg_id");

				String subject = rs.getString("subject");
				String body = rs.getString("body");
				String attachment = rs.getString("attachment");
				Timestamp timestamp = rs.getTimestamp("timestap");

				boolean is_deleted = rs.getBoolean("is_deleted");
				boolean is_readed = rs.getBoolean("is_readed");
				boolean is_trashed = rs.getBoolean("is_trashed");
				boolean is_archived = rs.getBoolean("is_archived");

				message = new Message(messageID, sender_id, thread_msg_id, subject, body, attachment, timestamp,
						is_deleted, is_readed, is_trashed, is_archived);

			}
			return message;
		} finally {
			DBUtil.cleanUp(con, ps, rs);
		}
	}

	public List<MessageDto> getUserArchived(int userID) throws SQLException {

		String selectSQL = "SELECT COUNT(recipient_message.thread_msg_id) as 'threadMessagesNumber' , "
				+ "MAX(message.id) as 'msgID' , recipient_message.thread_msg_id as 'threadID', "
				+ "user.firstname as 'fname' , user.lastname as 'lname' , user.email as 'email' "
				+ "FROM recipient_message INNER JOIN message ON recipient_message.msg_id = message.id "
				+ "INNER JOIN user ON message.sender_id = user.id "
				+ "WHERE (recipient_message.reciver_id = ? or message.sender_id  = ? ) "
				+ "AND (recipient_message.is_archived = 1 or message.is_archived = 1)  AND "
				+ "recipient_message.is_trashed = 0 AND recipient_message.is_deleted = 0 "
				+ "GROUP BY recipient_message.thread_msg_id DESC;";

		List<MessageDto> list = new ArrayList<MessageDto>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User receiver = new User();
		receiver.setId(userID);

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(selectSQL);
			ps.setInt(1, userID);
			ps.setInt(2, userID);
			rs = ps.executeQuery();

			while (rs.next()) {
				int threadID = rs.getInt("threadID");
				int threadMessagesNumber = rs.getInt("threadMessagesNumber");

				int msgID = rs.getInt("msgID");

				String fname = rs.getString("fname");
				String lname = rs.getString("lname");
				String email = rs.getString("email");

				Message message = getMessageBYID(msgID);
				User sender = new User(message.getSenderId(), fname, lname, email);
				MessageDto messageDto = new MessageDto(threadID, receiver, sender, message, threadMessagesNumber);
				list.add(messageDto);
			}
			return list;
		} finally {
			DBUtil.cleanUp(con, ps, rs);
		}
	}

	public List<MessageDto> getUserTrashed(int userID) throws SQLException {

		String selectSQL = "SELECT COUNT(recipient_message.thread_msg_id) as 'threadMessagesNumber' , "
				+ "MAX(message.id) as 'msgID' , recipient_message.thread_msg_id as 'threadID', "
				+ "user.firstname as 'fname' , user.lastname as 'lname' , user.email as 'email' "
				+ "FROM recipient_message INNER JOIN message ON recipient_message.msg_id = message.id "
				+ "INNER JOIN user ON message.sender_id = user.id "
				+ "WHERE (recipient_message.reciver_id = ? or message.sender_id  = ? ) "
				+ "AND (recipient_message.is_archived = 0 AND ( recipient_message.is_trashed = 1 or message.is_trashed = 1 ) "
				+ "AND recipient_message.is_deleted = 0 " + "GROUP BY recipient_message.thread_msg_id DESC;";

		List<MessageDto> list = new ArrayList<MessageDto>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User receiver = new User();
		receiver.setId(userID);

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(selectSQL);
			ps.setInt(1, userID);
			ps.setInt(2, userID);
			rs = ps.executeQuery();

			while (rs.next()) {
				int threadID = rs.getInt("threadID");
				int threadMessagesNumber = rs.getInt("threadMessagesNumber");

				int msgID = rs.getInt("msgID");

				String fname = rs.getString("fname");
				String lname = rs.getString("lname");
				String email = rs.getString("email");

				Message message = getMessageBYID(msgID);
				User sender = new User(message.getSenderId(), fname, lname, email);
				MessageDto messageDto = new MessageDto(threadID, receiver, sender, message, threadMessagesNumber);
				list.add(messageDto);
			}
			return list;
		} finally {
			DBUtil.cleanUp(con, ps, rs);
		}
	}

	public void ArchiveThreadMessages(int threadID) throws SQLException {
		String recipient_message = "UPDATE recipient_message SET recipient_message.is_archived = 1 WHERE recipient_message.thread_msg_id = ?;";
		String message = "UPDATE message SET message.is_archived = 1 WHERE message.thread_msg_id = ?;";

		Connection con = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		try {
			con = DBUtil.getConnection();
			ps1 = con.prepareStatement(recipient_message);
			ps1.setInt(1, threadID);
			ps1.executeUpdate();

			ps2 = con.prepareStatement(message);
			ps2.setInt(1, threadID);
			ps2.executeUpdate();
		} finally {
			DBUtil.cleanUp(con, ps1, null);
			DBUtil.cleanUp(con, ps2, null);
		}
	}

	public void DeleteThreadMessages(int threadID) throws SQLException {
		String recipient_message = "UPDATE recipient_message SET recipient_message.is_deleted = 1 WHERE recipient_message.thread_msg_id = ?;";
		String message = "UPDATE message SET message.is_deleted = 1 WHERE message.thread_msg_id = ?;";

		Connection con = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		try {
			con = DBUtil.getConnection();
			ps1 = con.prepareStatement(recipient_message);
			ps1.setInt(1, threadID);
			ps1.executeUpdate();

			ps2 = con.prepareStatement(message);
			ps2.setInt(1, threadID);
			ps2.executeUpdate();
		} finally {
			DBUtil.cleanUp(con, ps1, null);
			DBUtil.cleanUp(con, ps2, null);
		}
	}

	public void MarkThreadASReaded(int threadID) throws SQLException {
		String recipient_message = "UPDATE recipient_message SET recipient_message.is_readed = 1 WHERE recipient_message.thread_msg_id = ?;";
		String message = "UPDATE message SET message.is_readed = 1 WHERE message.thread_msg_id = ?;";

		Connection con = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		try {
			con = DBUtil.getConnection();
			ps1 = con.prepareStatement(recipient_message);
			ps1.setInt(1, threadID);
			ps1.executeUpdate();

			ps2 = con.prepareStatement(message);
			ps2.setInt(1, threadID);
			ps2.executeUpdate();
		} finally {
			DBUtil.cleanUp(con, ps1, null);
			DBUtil.cleanUp(con, ps2, null);
		}
	}

	public static String getAllMessageReceivers(int msgID, int threadID) throws SQLException {
		String selectSQL = "SELECT DISTINCT(user.email) FROM recipient_message "
				+ "INNER JOIN user ON user.id = recipient_message.reciver_id "
				+ "WHERE recipient_message.thread_msg_id = ? AND recipient_message.msg_id = ?;";

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(selectSQL);
			ps.setInt(1, threadID);
			ps.setInt(2, msgID);

			rs = ps.executeQuery();

			String receiver = "";

			while (rs.next())
				if (rs.isLast())
					receiver = rs.getString("email");
				else
					receiver = rs.getString("email") + " , ";

			return receiver;
		} finally {
			DBUtil.cleanUp(con, ps, rs);
		}
	}

	public List<ThreadMessageDto> getAllMessagesOfThreadByThreadID(int threadID) throws SQLException {
		String selectSQL = "SELECT user.email as 'email' , message.id FROM message INNER JOIN user ON user.id = message.sender_id "
				+ "WHERE message.thread_msg_id = ? ORDER BY message.timestap DESC;";

		List<ThreadMessageDto> list = new ArrayList<ThreadMessageDto>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(selectSQL);
			ps.setInt(1, threadID);

			rs = ps.executeQuery();

			while (rs.next()) {
				int msgID = rs.getInt("id");
				String sender = rs.getString("email");

				String receiver = getAllMessageReceivers(msgID, threadID);
				Message message = getMessageBYID(msgID);

				ThreadMessageDto messageDto = new ThreadMessageDto(threadID, receiver, sender, message);
				list.add(messageDto);
			}
			return list;
		} finally {
			DBUtil.cleanUp(con, ps, rs);
		}
	}
}
