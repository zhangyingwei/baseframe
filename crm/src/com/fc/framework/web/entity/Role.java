package com.fc.framework.web.entity;

public class Role {
	private Integer roleid;
	private String rolename;
	private String roledescribe;
	private String createuser;
	private String createdate;
	public Integer getRoleid() {
		return roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getRoledescribe() {
		return roledescribe;
	}
	public void setRoledescribe(String roledescribe) {
		this.roledescribe = roledescribe;
	}
	public String getCreateuser() {
		return createuser;
	}
	public void setCreateuser(String createuser) {
		this.createuser = createuser;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
}
