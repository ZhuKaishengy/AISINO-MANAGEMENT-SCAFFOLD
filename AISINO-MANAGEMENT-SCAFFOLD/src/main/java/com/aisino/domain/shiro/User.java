package com.aisino.domain.shiro;

import java.util.Date;
import java.util.List;

public class User {
    private String userId;

    private String userPrincipal;

    private String userCreditials;

    private Date createTime;

    private Date updateTime;

    private String status;

    private String userPhone;

    private List<Role> roles;
    
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserPrincipal() {
        return userPrincipal;
    }

    public void setUserPrincipal(String userPrincipal) {
        this.userPrincipal = userPrincipal == null ? null : userPrincipal.trim();
    }

    public String getUserCreditials() {
        return userCreditials;
    }

    public void setUserCreditials(String userCreditials) {
        this.userCreditials = userCreditials == null ? null : userCreditials.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public User(String userPrincipal, String userCreditials) {
		super();
		this.userPrincipal = userPrincipal;
		this.userCreditials = userCreditials;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}