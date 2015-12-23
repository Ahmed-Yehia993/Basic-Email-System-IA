/**
 * Create On: Dec 20, 2015 8:52:06 PM
 * @author mohamed265
 */
package com.basicemail.entity;

import java.sql.Timestamp;

/**
 * @author mohamed265
 *
 */
public class Message {

	private int id;

	private int senderId;

	private int threadMsgId;

	private String subject;

	private String body;

	private String attachment;

	private Timestamp timestap;

	private boolean isDeleted;

	private boolean isReaded;

	private boolean isTrashed;

	private boolean isArchived;

	public Message() {
	}

	public Message(int id, int senderId, int threadMsgId, String subject, String body, String attachment,
			Timestamp timestap, boolean isDeleted, boolean isReaded, boolean isTrashed, boolean isArchived) {
		this.id = id;
		this.senderId = senderId;
		this.threadMsgId = threadMsgId;
		this.subject = subject;
		this.body = body;
		this.attachment = attachment;
		this.timestap = timestap;
		this.isDeleted = isDeleted;
		this.isReaded = isReaded;
		this.isTrashed = isTrashed;
		this.isArchived = isArchived;
	}

	public Message(int id, int senderId, int threadMsgId, String subject, String body, Timestamp timestap) {
		this.id = id;
		this.senderId = senderId;
		this.threadMsgId = threadMsgId;
		this.subject = subject;
		this.body = body; 
		this.timestap = timestap;
	}

	public int getId() {
		return id;
	}

	public int getSenderId() {
		return senderId;
	}

	public int getThreadMsgId() {
		return threadMsgId;
	}

	public String getSubject() {
		return subject;
	}

	public String getBody() {
		return body;
	}

	public String getAttachment() {
		return attachment;
	}

	public Timestamp getTimestap() {
		return timestap;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public boolean isReaded() {
		return isReaded;
	}

	public boolean isTrashed() {
		return isTrashed;
	}

	public boolean isArchived() {
		return isArchived;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public void setThreadMsgId(int threadMsgId) {
		this.threadMsgId = threadMsgId;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public void setTimestap(Timestamp timestap) {
		this.timestap = timestap;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public void setReaded(boolean isReaded) {
		this.isReaded = isReaded;
	}

	public void setTrashed(boolean isTrashed) {
		this.isTrashed = isTrashed;
	}

	public void setArchived(boolean isArchived) {
		this.isArchived = isArchived;
	}

}
