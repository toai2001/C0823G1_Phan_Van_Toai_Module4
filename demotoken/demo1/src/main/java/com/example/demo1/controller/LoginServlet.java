package com.example.demo1.controller;

import com.example.demo1.Model.Account;
import com.example.demo1.Model.Customer;
import com.example.demo1.service.account.IServiceAccount;
import com.example.demo1.service.account.ServiceAccount;
import com.example.demo1.service.customer.CustomerService;
import com.example.demo1.service.customer.ICustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = {
        "/login",
        "/signup",
        "/logout",
        "/error-access",
})
public class LoginServlet extends HttpServlet {
    private final IServiceAccount serviceAccount = new ServiceAccount();
    private final ICustomerService customerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String url = req.getRequestURI();
        if (url.endsWith("/signup")) {
            showSignUp(req, resp);
        } else if (url.endsWith("/login")) {
            showLogInForm(req, resp);
        } else if (url.endsWith("/logout")) {
            logOut(req, resp);
        } else if (url.endsWith("/error-access")) {
            errorAccess(req, resp);
        }
    }

    private void logOut(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        session.invalidate();
        try {
            resp.sendRedirect("/user");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showLogInForm(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login_1-1/login.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showSignUp(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login_1-1/login.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void errorAccess(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/error-access.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if (url.endsWith("/signup")) {
            saveInfoSignUp(req, resp);
        } else if (url.endsWith("/login")) {
            checkLogIn(req, resp);
        }
    }

    private void checkLogIn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String useName = req.getParameter("tai_khoan");
        String password = req.getParameter("mat_khau");
        if (serviceAccount.findByName(useName) == null) {
            req.setAttribute("errorUsername", "Không tồn tại tài khoản này trong hệ thống");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login_1-1/login.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            Account account = serviceAccount.findAccount(useName, password);
            if (account == null) {
                req.setAttribute("errorPassword", "Mật khẩu không chính xác !");
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login_1-1/login.jsp");
                requestDispatcher.forward(req, resp);
            } else {
                HttpSession session = req.getSession();
                session.setAttribute("username", useName);
                session.setAttribute("loai_tai_khoan", account.getAccountType());
                resp.sendRedirect("/");
            }
        }
    }


    private void saveInfoSignUp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("tai_khoan_dk");
        String password = req.getParameter("mat_khau_dk");
        String name = req.getParameter("ho_ten");
        String phone = req.getParameter("so_dien_thoai");
        String address = req.getParameter("dia_chi");
        String email = req.getParameter("gmail");
        if (serviceAccount.findByName(username) != null) {
            req.setAttribute("errorUsername", "Tài khoản này đã tồn tại trong hệ thống");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login_1-1/login.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            Account account = new Account(username, password, "user");
            serviceAccount.createAccount(account);
            Account accountUpdate = serviceAccount.findByName(username);
            Customer customer = new Customer(name, phone, address, email, accountUpdate);
            customerService.add(customer);
            req.setAttribute("username", username);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login_1-1/signup-sussces.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
