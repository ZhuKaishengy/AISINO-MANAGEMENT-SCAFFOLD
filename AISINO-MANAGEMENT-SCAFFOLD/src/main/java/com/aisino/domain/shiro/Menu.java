package com.aisino.domain.shiro;

public class Menu {
    private String menuId;

    private String menuUpid;

    private String iconClass;

    private String title;

    private String haschild;

    private String href;

    private String roleNeeded;

    private String status;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

    public String getMenuUpid() {
        return menuUpid;
    }

    public void setMenuUpid(String menuUpid) {
        this.menuUpid = menuUpid == null ? null : menuUpid.trim();
    }

    public String getIconClass() {
        return iconClass;
    }

    public void setIconClass(String iconClass) {
        this.iconClass = iconClass == null ? null : iconClass.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getHaschild() {
        return haschild;
    }

    public void setHaschild(String haschild) {
        this.haschild = haschild == null ? null : haschild.trim();
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href == null ? null : href.trim();
    }

    public String getRoleNeeded() {
        return roleNeeded;
    }

    public void setRoleNeeded(String roleNeeded) {
        this.roleNeeded = roleNeeded == null ? null : roleNeeded.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

	public Menu(String menuUpid, String iconClass, String title, String haschild, String href, String roleNeeded) {
		super();
		this.menuUpid = menuUpid;
		this.iconClass = iconClass;
		this.title = title;
		this.haschild = haschild;
		this.href = href;
		this.roleNeeded = roleNeeded;
	}

	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}