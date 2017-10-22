package com.aisino.domain.shiro;

public class FilterChainDefinition {
    private Integer id;

    private String uri;

    private String filter;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri == null ? null : uri.trim();
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter == null ? null : filter.trim();
    }

	public FilterChainDefinition(String uri, String filter) {
		super();
		this.uri = uri;
		this.filter = filter;
	}

	public FilterChainDefinition() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}