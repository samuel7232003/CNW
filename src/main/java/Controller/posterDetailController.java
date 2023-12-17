package Controller;

import ModelBO.PostBO;
import ModelBO.UserBO;
import ModelBean.PostBean;
import ModelBean.UserBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/posterDetailController")
public class posterDetailController extends HttpServlet {
    private PostBO postBO = PostBO.getInstance();
    private UserBO userBO = UserBO.getInstance();
    public void doGet(HttpServletRequest req, HttpServletResponse rep) throws ServletException, IOException {
        String id = req.getParameter("id");
        UserBean user = userBO.getUser();
        req.setAttribute("num", id);
        id = "PO0"+id;
        req.setAttribute("user", user);
        req.setAttribute("post", postBO.getPostByID(id));
        req.getRequestDispatcher("/view/postDetail.jsp").forward(req,rep);
    }
}
