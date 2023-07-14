package model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class Post implements Serializable{
	private static final long serialVersionUID = 1L;
	private String content;
	private LinkedList<Post> responses;
	private Date postDate;
	private User creator;

	public Post(String content, User creator) {
		super();
		this.content = content;
		this.postDate = new Date();
		this.creator = creator;
		this.responses = new LinkedList<Post>();
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

	public LinkedList<Post> getResponses() {
		return responses;
	}

	public void setResponses(LinkedList<Post> responses) {
		this.responses = responses;
	}
	
	public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    @Override
	public String toString() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy h:mm:ss aa");
		return "Post [content=" + content + ", responses=" + responses + ", postDate=" + dateFormat.format(postDate)
				+ ", creator=" + creator + "]";
	}

}
