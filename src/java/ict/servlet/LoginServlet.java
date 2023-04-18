package ict.servlet;

import ict.data_objects.entities.User;
import ict.data_objects.non_entties.UserType;
import ict.data_objects.non_entties.UserTypeIdentifier;
import ict.db.UserDatabase;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    private UserDatabase db;

    public void init() {
        db = new UserDatabase();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        List<User> members = db.query();
        List<User> q = members.stream().filter(member -> member.getInfo().getUsername().equals(username) && member.getInfo().getPassword().equals(password))    .collect(Collectors.toList());

        boolean loginSuccess = !q.isEmpty();
        String destination;
        if (!loginSuccess) destination = "/loginError.jsp";
        
        UserType userType = UserTypeIdentifier.identify(q.get(0));
        if (userType == UserType.MEMBER) destination = "/user/member_frontpage.jsp";
        else if (userType == UserType.STAFF) destination = "/user/staff_frontpage.jsp";
        else if (userType == UserType.MANAGER) destination = "/user/manager_frontpage.jsp";
        else throw new RuntimeException("Invalid user type");
        request.getRequestDispatcher(destination).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
