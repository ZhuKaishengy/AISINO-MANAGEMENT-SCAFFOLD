package com.aisino.domain.shiro;

public class RolePermission {
    private String id;

    private String roleId;

    private String permissionId;

    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId == null ? null : permissionId.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

	public RolePermission(String roleId, String permissionId) {
		super();
		this.roleId = roleId;
		this.permissionId = permissionId;
	}

	public RolePermission() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}