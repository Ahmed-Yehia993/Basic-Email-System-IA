package com.basicemail.entity;

public class MessageDto {

	private int threadID;

	private int threadMessagesNumber;

	private User receiver;

	private User sender;

	private Message message;

	public MessageDto() {

	}

	public MessageDto(int threadID, User receiver, User sender, Message message, int threadMessagesNumber) {
		super();
		this.threadID = threadID;
		this.receiver = receiver;
		this.sender = sender;
		this.message = message;
		this.threadMessagesNumber = threadMessagesNumber;
	}

	public int getThreadID() {
		return threadID;
	}

	public void setThreadID(int threadID) {
		this.threadID = threadID;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public int getThreadMessagesNumber() {
		return threadMessagesNumber;
	}

	public void setThreadMessagesNumber(int threadMessagesNumber) {
		this.threadMessagesNumber = threadMessagesNumber;
	}

}
