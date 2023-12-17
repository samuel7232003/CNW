package Controller;

import ModelBO.PostBO;
import ModelBean.PostBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/posterDetailController")
public class posterDetailController extends HttpServlet {
    private PostBO postBO = PostBO.getInstance();
    public void doGet(HttpServletRequest req, HttpServletResponse rep) throws ServletException, IOException {
        String id = req.getParameter("id");
        req.setAttribute("num", id);
        id = "PO0"+id;
        req.setAttribute("post", postBO.getPostByID(id));
        req.getRequestDispatcher("/view/postDetail.jsp").forward(req,rep);
    }
}
