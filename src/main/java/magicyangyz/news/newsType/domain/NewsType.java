package magicyangyz.news.newsType.domain;

public class NewsType {
	private int tid;
	private String tname;
	public NewsType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NewsType(int tid, String tname) {
		super();
		this.tid = tid;
		this.tname = tname;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	@Override
	public String toString() {
		return "newsType [tid=" + tid + ", tname=" + tname + "]";
	}
}
