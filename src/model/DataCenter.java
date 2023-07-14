package model;

import java.io.File;
import java.io.Serializable;

public class DataCenter implements Serializable{
    private static final long serialVersionUID = 1L;
    private UserCenter userCenter;
    private PostCenter postCenter;
    
    private static DataCenter instance;
    
    private DataCenter(UserCenter userCenter, PostCenter postCenter) {
        this.userCenter = userCenter;
        this.postCenter = postCenter;
    }
    
    public static DataCenter getInstance() {
        if(instance == null && new File("dataFolder/DataCenter.dat").exists() == false) {
            instance = new DataCenter(new UserCenter(), new PostCenter());
        } else if(instance == null) {
            instance = Utilities.restoreDataCenter();
        }
        return instance;    
    }
    
    public UserCenter getUserCenter() {
        return userCenter;
    }

    public void setUserCenter(UserCenter userCenter) {
        this.userCenter = userCenter;
    }

    public PostCenter getPostCenter() {
        return postCenter;
    }

    public void setAllPosts(PostCenter postCenter) {
        this.postCenter = postCenter;
    }
    

}
