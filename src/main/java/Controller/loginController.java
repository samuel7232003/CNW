package Controller;

import ModelBO.UserBO;
import ModelBean.UserBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/loginController")
public class loginController extends HttpServlet {
    UserBO userBO = UserBean.getInstance();
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/login.jsp").forward(req,resp);
    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(userBO.signIn(username, password)!=null){
            UserBean user = userBO.signIn(username, password);
            req.setAttribute("user", user);
            req.getRequestDispatcher("/view/home.jsp").forward(req, resp);
        }
        else{
            req.setAttribute("error", "Tên đăng nhập hoặc mật khẩu sai!");
            req.getRequestDispatcher("/view/login.jsp").forward(req,resp);
        }
    }
}
