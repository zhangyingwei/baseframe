package com.fc.framework.web.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Module implements Serializable{
	private Integer moduleid;
	private String modulename;
	private String fatherid;
	private String modulepath;
	private String createuser;
	private String createdate;
	public Integer getModuleid() {
		return moduleid;
	}
	public void setModuleid(Integer moduleid) {
		this.moduleid = moduleid;
	}
	public String getModulename() {
		return modulename;
	}
	public void setModulename(String modulename) {
		this.modulename = modulename;
	}
	public String getFatherid() {
		return fatherid;
	}
	public void setFatherid(String fatherid) {
		this.fatherid = fatherid;
	}
	public String getModulepath() {
		return modulepath;
	}
	public void setModulepath(String modulepath) {
		this.modulepath = modulepath;
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
	@Override
	public String toString() {
		return "Module [createdate=" + createdate + ", createuser="
				+ createuser + ", fatherid=" + fatherid + ", moduleid="
				+ moduleid + ", modulename=" + modulename + ", modulepath="
				+ modulepath + "]";
	}
}
