package com.uek.domain;

public class CrowdMember {
	private int id;
	private int userId;
	private int crowdId;
	private String joinTime;
	private int status;
	
	
	
	public CrowdMember() {
		super();
	}
	public CrowdMember(int userId, int crowdId, String joinTime, int status) {
		super();
		this.userId = userId;
		this.crowdId = crowdId;
		this.joinTime = joinTime;
		this.status = status;
	}
	public CrowdMember(int id, int userId, int crowdId, String joinTime, int status) {
		super();
		this.id = id;
		this.userId = userId;
		this.crowdId = crowdId;
		this.joinTime = joinTime;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCrowdId() {
		return crowdId;
	}
	public void setCrowdId(int crowdId) {
		this.crowdId = crowdId;
	}
	public String getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(String joinTime) {
		this.joinTime = joinTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "CrowdMember [id=" + id + ", userId=" + userId + ", crowdId=" + crowdId + ", joinTime=" + joinTime
				+ ", status=" + status + "]";
	}
	
	
	
}
