package ModelBean;

import java.util.ArrayList;

public class PostBean {
    private String postID;
    private String postName;
    private String postDetail;

    public PostBean(String postID, String postName, String postDetail) {
        this.postID = postID;
        this.postName = postName;
        this.postDetail = postDetail;
    }

    public PostBean(String postName, String postDetail) {
        this.postName = postName;
        this.postDetail = postDetail;
    }

    public PostBean() {
    }

    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getPostDetail() {
        return postDetail;
    }

    public void setPostDetail(String postDetail) {
        this.postDetail = postDetail;
    }

    public String getHiredContent(){
        String rs = "";
        String[] e = postDetail.split(" ");
        for(int i = 0; i < 20&&i<e.length; i++){
            rs+= e[i] + " ";
        }
        rs+="...";
        return rs;
    }
}
