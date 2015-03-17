package com.fc.framework.web.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Table;

import org.hibernate.annotations.Entity;

@Entity
@SuppressWarnings("serial")
public class User implements Serializable{

	private Integer userid;
	private String username;
	private String password;
	private String realname;
	private String sex;
	private String age;
	private String mail;
	private String phonenum;
	private String state;
	private String createdate;
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	@Override
	public String toString() {
		return "User [age=" + age + ", createdate=" + createdate + ", mail="
				+ mail + ", password=" + password + ", phonenum=" + phonenum
				+ ", realname=" + realname + ", sex=" + sex + ", state="
				+ state + ", userid=" + userid + ", username=" + username + "]";
	}
}