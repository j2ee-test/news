package magicyangyz.bean;

import java.util.List;

import magicyangyz.news.news.domain.News;

public class PageBean<T> {
	private int pc;
//	private int tp;
	private int tr;
	private int ps;
	private List<T> beanList;
	
	private String url;

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getPc() {
		return pc;
	}
	public void setPc(int pc) {
		this.pc = pc;
	}
	public int getTp() {
		int tp = tr/ps;
		return tr%ps==0 ? tp:tp+1;
	}
//	public void setTp(int tp) {
//		this.tp = tp;
//	}
	public int getTr() {
		return tr;
	}
	public void setTr(int tr) {
		this.tr = tr;
	}
	public int getPs() {
		return ps;
	}
	public void setPs(int ps) {
		this.ps = ps;
	}
	public List<T> getBeanList() {
		return beanList;
	}
	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}
	
}
