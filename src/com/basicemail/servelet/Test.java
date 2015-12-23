package com.basicemail.servelet;

import java.sql.SQLException;

import com.basicemail.dao.UserMessagesDao;
import com.basicemail.entity.MessageDto;
import com.basicemail.service.UserMessagesService;

public class Test {

	public static void main(String[] args) throws SQLException {
		
		
		
		UserMessagesService s = new UserMessagesService();
		//System.out.println(s.getUserInbox(1).size());
		 
		System.out.println(UserMessagesDao.getAllMessageReceivers(1, 1));
		//System.out.println(s.getUserInbox(1).get(0).getSender().getFirstname());
	}

}
