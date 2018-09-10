package magicyangyz.news.news.domain;

public class News {
	private int newsId;
	private String newsType;
	private String author;
	private String caption;
	private String content;
	private String newsTime;
	private String publishTime;
	private int exam;
	@Override
	public String toString() {
		return "News [newsId=" + newsId + ", newsType=" + newsType + ", author=" + author + ", caption=" + caption
				+ ", content=" + content + ", newsTime=" + newsTime + ", publishTime=" + publishTime + ", exam=" + exam
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	public News() {
		super();
		// TODO Auto-generated constructor stub
	}
	public News(int newsId, String newsType, String author, String caption, String content, String newsTime,
			String publishTime, int exam) {
		super();
		this.newsId = newsId;
		this.newsType = newsType;
		this.author = author;
		this.caption = caption;
		this.content = content;
		this.newsTime = newsTime;
		this.publishTime = publishTime;
		this.exam = exam;
	}
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public String getNewsType() {
		return newsType;
	}
	public void setNewsType(String newsType) {
		this.newsType = newsType;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getNewsTime() {
		return newsTime;
	}
	public void setNewsTime(String newsTime) {
		this.newsTime = newsTime;
	}
	public String getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}
	public int getExam() {
		return exam;
	}
	public void setExam(int exam) {
		this.exam = exam;
	}

}
	
