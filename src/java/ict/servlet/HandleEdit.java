package ict.servlet;

import ict.bean.CustomerBean;
import ict.db.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/handleEdit"})
public class HandleEdit extends HttpServlet {
    private Database db;

    public void init() {
        String url = "jdbc:mysql://localhost:3306/ITP4511_DB";
        String username = "root";
        String password = "";
        db = new Database(url, username, password);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        PrintWriter out = response.getWriter();

        if ("add".equalsIgnoreCase(action)) {
            boolean isSuccess = db.addRecord(
                    request.getParameter("id"),
                    request.getParameter("name"),
                    request.getParameter("tel"),
                    Integer.parseInt(request.getParameter("age"))
            );
            if (isSuccess)
                response.sendRedirect("handleCustomer?action=list");
            else {
                out.println("Error 😀");
            }
        } else if ("edit".equalsIgnoreCase(action)) {
            String id = request.getParameter("id");
            if (id == null) {
                out.println("id is null");
                return;
            }
            
            String name = request.getParameter("name");
            String tel = request.getParameter("tel");
            int age = Integer.parseInt(request.getParameter("age"));
            
            CustomerBean c = db.queryCustByID(id);
            c.setName(name);
            c.setTel(tel);
            c.setAge(age);
            db.editRecord(c);
            
            response.sendRedirect("handleCustomer?action=list");
        } else {
            out.println("No such action as " + action + "!!!");
        }
    }

    @Override
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
