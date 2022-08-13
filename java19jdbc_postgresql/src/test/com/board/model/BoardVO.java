package test.com.board.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

public class BoardVO {
	
	private int num;
	private String title;
	private String content;
	private String writer;
	private Timestamp wdate;
	
	public BoardVO() {
		System.out.println("BoardVO...");
	}

	@Override
	public int hashCode() {
		return Objects.hash(content, num, title, wdate, writer);
	}

	public BoardVO(int num, String title, String content, String writer, Timestamp wdate) {
		super();
		this.num = num;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.wdate = wdate;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoardVO other = (BoardVO) obj;
		return Objects.equals(content, other.content) && num == other.num && Objects.equals(title, other.title)
				&& Objects.equals(wdate, other.wdate) && Objects.equals(writer, other.writer);
	}

	@Override
	public String toString() {
		return "BoardVO [num=" + num + ", title=" + title + ", content=" + content + ", writer=" + writer + ", wdate="
				+ wdate + "]";
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getWdate() {
		return wdate;
	}

	public void setWdate(Timestamp wdate) {
		this.wdate = wdate;
	}

}
