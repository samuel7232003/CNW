package Controller;

import ModelBO.PostBO;
import ModelBO.UserBO;
import ModelBean.UserBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/posterController")
public class posterController extends HttpServlet {
    private PostBO postBO = PostBO.getInstance();
    private UserBO userBO = UserBO.getInstance();
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userID = userBO.getUser().getUserID();
        UserBean user = userBO.getUserByID(userID);
        req.setAttribute("listPost", postBO.getAllPost());
        req.setAttribute("user", user);
        req.getRequestDispatcher("/view/poster.jsp").forward(req,resp);
    }
}
