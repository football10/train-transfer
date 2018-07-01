package org.traintransfer.dao.entity;

public class UserInfoEntity {

	// 用户ID
	public String user_Id;
	// 用户名
	public String user_name;
	// 头像
	public String icon;
	// 权限组ID
	public String group_Id;

	public String getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(String user_Id) {
		this.user_Id = user_Id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getGroup_Id() {
		return group_Id;
	}
	public void setGroup_Id(String group_Id) {
		this.group_Id = group_Id;
	}
}
