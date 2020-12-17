package com.sj.damai.po;

public class Categorysecond implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer csid;
	private Integer cid;
	private String csname;
	public Integer getCsid() {
		return csid;
	}
	public void setCsid(Integer csid) {
		this.csid = csid;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCsname() {
		return csname;
	}
	public void setCsname(String csname) {
		this.csname = csname;
	}
	@Override
	public String toString() {
		return "Categorysecond [csid=" + csid + ", cid=" + cid + ", csname=" + csname + "]";
	}
	
	
}
