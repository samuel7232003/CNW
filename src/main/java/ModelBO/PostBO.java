package ModelBO;

import ModelBean.PostBean;
import ModelDAO.PostDAO;

import java.util.ArrayList;

public class PostBO {
    PostDAO postDAO;
    private static PostBO instance;
    public static synchronized PostBO getInstance() {
        if (instance == null) {
            instance = new PostBO();
        }
        return instance;
    }
    public PostBO(){
        postDAO = new PostDAO();
    }
    public PostBean getPostByID(String idPost){
        return postDAO.getPostByID(idPost);
    }
    public boolean insertPost(String postName, String postDetail){
        PostBean newPost = new PostBean(postName, postDetail);
        if(postDAO.insertPost(newPost) == 1) return true;
        else return false;
    }
    public PostBean getPostbyID(String postID){
        return postDAO.getPostByID(postID);
    }

    public ArrayList<PostBean> getAllPost() { return postDAO.getAllPost();
    }
}
