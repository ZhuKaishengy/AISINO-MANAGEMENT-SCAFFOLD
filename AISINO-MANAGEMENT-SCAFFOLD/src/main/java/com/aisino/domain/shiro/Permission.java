package com.aisino.domain.shiro;

import java.util.Date;

public class Permission {
    private String permissionId;

    private String permissionName;

    private String permissionUri;

    private Date createTime;

    private Date updateTime;

    private String status;

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId == null ? null : permissionId.trim();
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    public String getPermissionUri() {
        return permissionUri;
    }

    public void setPermissionUri(String permissionUri) {
        this.permissionUri = permissionUri == null ? null : permissionUri.trim();
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

	public Permission(String permissionName, String permissionUri) {
		super();
		this.permissionName = permissionName;
		this.permissionUri = permissionUri;
	}

	public Permission() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}