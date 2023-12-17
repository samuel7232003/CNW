package Controller;

import ModelBO.UserBO;
import ModelBean.UserBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/signupController")
public class signupController extends HttpServlet {
    UserBO userBO = UserBean.getInstance();
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/signup.jsp").forward(req,resp);
    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String usName = req.getParameter("usName");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String re_password = req.getParameter("re_password");
        if(userBO.signUp(usName, username, password)!=null){
            UserBean user = userBO.signIn(username, password);
            userBO.setUser(user);
            req.setAttribute("user", user);
            req.getRequestDispatcher("/view/home.jsp").forward(req, resp);
        }
        else{
            req.setAttribute("error", "Tên đăng nhập đã tồn tại!");
            req.getRequestDispatcher("/view/signup.jsp").forward(req,resp);
        }
    }
}
