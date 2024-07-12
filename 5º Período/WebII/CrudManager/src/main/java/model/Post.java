package model;

import java.util.Calendar;
import java.util.Date;

public class Post {
	private int id;
	private String content;
	private Date postDate;
	private User user;
	
	public Post() {
		this(0);
	}
	
	public Post(int id) {
		this.id = id;
		setContent("");
		setPostDate(Calendar.getInstance().getTime());
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	public int getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
