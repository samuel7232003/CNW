package Controller;

import ModelBO.PostBO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/posterController")
public class posterController extends HttpServlet {
    private PostBO postBO = PostBO.getInstance();
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listPost", postBO.getAllPost());
        req.getRequestDispatcher("/view/poster.jsp").forward(req,resp);
    }
}
