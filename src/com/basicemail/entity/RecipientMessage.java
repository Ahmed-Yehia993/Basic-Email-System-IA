/**
 * Create On: Dec 20, 2015 9:02:01 PM
 * @author mohamed265
 */
package com.basicemail.entity;

/**
 * @author mohamed265
 *
 */
public class RecipientMessage {
	private int id;

	private int reciverId;

	private int threadMsgId;

	private int mesId;

	private boolean isDeleted;

	private boolean isReaded;

	private boolean isTrashed;

	private boolean isArchived;

	public RecipientMessage() {
	}

	public RecipientMessage(int id, int reciverId, int threadMsgId, int mesId, boolean isDeleted, boolean isReaded,
			boolean isTrashed, boolean isArchived) {
		this.id = id;
		this.reciverId = reciverId;
		this.threadMsgId = threadMsgId;
		this.mesId = mesId;
		this.isDeleted = isDeleted;
		this.isReaded = isReaded;
		this.isTrashed = isTrashed;
		this.isArchived = isArchived;
	}

	public int getId() {
		return id;
	}

	public int getReciverId() {
		return reciverId;
	}

	public int getThreadMsgId() {
		return threadMsgId;
	}

	public int getMesId() {
		return mesId;
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

	public void setReciverId(int reciverId) {
		this.reciverId = reciverId;
	}

	public void setThreadMsgId(int threadMsgId) {
		this.threadMsgId = threadMsgId;
	}

	public void setMesId(int mesId) {
		this.mesId = mesId;
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
