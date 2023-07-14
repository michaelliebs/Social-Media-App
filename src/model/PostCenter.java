package model;

import java.io.Serializable;
import java.util.LinkedList;

public class PostCenter implements Serializable {
    private static final long serialVersionUID = 1L;
    private LinkedList<Post> postList;

    public PostCenter() {
        postList = new LinkedList<Post>();
    }

    public void addPost(Post post) {
        postList.add(post);
    }

    public boolean removePost(Post post) {
        return postList.remove(post);
    }

    public int getSize() {
        return postList.size();
    }

    public LinkedList<Post> getPostList() {
        return postList;
    }
}
