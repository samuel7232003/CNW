package Controller;

import ModelBO.UserBO;
import ModelBO.TourBO;
import ModelBean.UserBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/tourController")
public class tourController extends HttpServlet {
    private TourBO tourBO = TourBO.getInstance();
    private UserBO userBO = UserBO.getInstance();
    public void doGet(HttpServletRequest req, HttpServletResponse rep) throws ServletException, IOException {
        UserBean user = userBO.getUser();
        req.setAttribute("listTour", tourBO.getAllTour());
        req.setAttribute("user", user);
        req.getRequestDispatcher("/view/titketInfor.jsp").forward(req, rep);
    }
}
