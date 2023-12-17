package ModelBO;

import ModelBean.PostBean;
import ModelDAO.PostDAO;

public class PostBO {
    PostDAO postDAO;
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
}
