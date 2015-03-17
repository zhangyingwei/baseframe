package com.fc.framework.web.entity;

public class RoleModule {
	private Integer id;
	private String roleid;
	private String moduleid;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoleid() {
		return roleid;
	}
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	public String getModuleid() {
		return moduleid;
	}
	public void setModuleid(String moduleid) {
		this.moduleid = moduleid;
	}
	@Override
	public String toString() {
		return "RoleModule [id=" + id + ", moduleid=" + moduleid + ", roleid="
				+ roleid + "]";
	}
}
