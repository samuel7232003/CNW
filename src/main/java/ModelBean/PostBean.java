package ModelBean;

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
}
