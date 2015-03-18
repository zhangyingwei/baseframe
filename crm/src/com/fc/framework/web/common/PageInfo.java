package com.fc.framework.web.common;

import java.io.Serializable;

public class PageInfo implements Serializable{
	private Integer currentPage;
	private Integer pageLimit;
	private Integer start;
	private Integer total = 0;
	private Integer totalPage;
	
	public PageInfo() {
		this.currentPage = 1;
		this.pageLimit = 8;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageLimit() {
		return pageLimit;
	}
	public void setPageLimit(Integer pageLimit) {
		this.pageLimit = pageLimit;
	}
	public Integer getStart() {
		Integer start2 = ((this.currentPage-1)*this.pageLimit);
		return start2;
	}
	public Integer getTotalPage() {
		Integer totalpage2 = total%pageLimit == 0?total/pageLimit:total/pageLimit+1;
		return totalpage2;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "PageInfo [currentPage=" + currentPage + ", pageLimit="
				+ pageLimit + ", start=" + start + ", total=" + total
				+ ", totalPage=" + totalPage + "]";
	}
}
