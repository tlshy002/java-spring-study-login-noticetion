package model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class Board {
	@NotNull(message="글번호를 입력하세요")
	private Integer seq;
	@NotEmpty(message="작성자를 입력하세요")
	private String id;
	@NotEmpty(message="제목을 입력하세요")
	private String title;
	@NotEmpty(message="내용을 입력하세요")
	private String content;
	private String write_date;
	
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getWrite_date() {
		return write_date;
	}
	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}
}
