package ModelDAO;

import ModelBean.PostBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PostDAO {
    public int insertPost(PostBean newPost){
        try{
            Connection conn = DBUtil.connection();
            String sql = "SELECT * FROM post ORDER BY postID DESC LIMIT 1";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            String postLastID = null;
            while(resultSet.next()){
                postLastID = resultSet.getString("postID");
                break;
            }

            if(postLastID == null) newPost.setPostID("Po01");
            else{
                int numPost = Integer.parseInt(postLastID.substring(2));
                String ID_newPost = "Po";
                numPost++;
                if(numPost < 10) ID_newPost += "0" + numPost;
                else ID_newPost += numPost;
                newPost.setPostID(ID_newPost);
            }

            sql = "INSERT INTO post(postID, postName, postDetail) VALUES ('" + newPost.getPostID() +"'," +
                    "'" + newPost.getPostName() + "'" +
                    ",'" + newPost.getPostDetail() + "')";
            statement = conn.createStatement();
            return statement.executeUpdate(sql);
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return 0;
    }

    public PostBean getPostByID(String postID){
        PostBean post = null;
        try {
            Connection conn = DBUtil.connection();
            String sql = "SELECT * FROM post WHERE postID = '" + postID + "';";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                String postName = resultSet.getString("postName");
                String postDetail = resultSet.getString("postDetail");
                post = new PostBean(postID, postName, postDetail);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return post;
    }

    public ArrayList<PostBean> getAllPost() {
        ArrayList<PostBean> postBeans = new ArrayList<>();
        try {
            Connection conn = DBUtil.connection();
            String sql = "SELECT * FROM post;";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                PostBean post = null;
                String postID = resultSet.getString("postID");
                String postName = resultSet.getString("postName");
                String postDetail = resultSet.getString("postDetail");
                post = new PostBean(postID, postName, postDetail);
                postBeans.add(post);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return postBeans;
    }
}
