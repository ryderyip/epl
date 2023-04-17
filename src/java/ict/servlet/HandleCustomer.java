package ict.servlet;

import ict.bean.CustomerBean;
import ict.db.Database;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/handleCustomer"})
public class HandleCustomer extends HttpServlet {
    private Database db;

    public void init() {
        String url = "jdbc:mysql://localhost:3306/ITP4511_DB";
        String username = "root";
        String password = "";
        db = new Database(url, username, password);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        PrintWriter out = response.getWriter();

        if ("list".equalsIgnoreCase(action)) {
            ArrayList<CustomerBean> customers = db.queryCust();
            request.setAttribute("customers", customers);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/listCustomers.jsp");
            rd.forward(request, response);
        } else if ("delete".equalsIgnoreCase(action)) {
            String id = request.getParameter("id");
            if (id == null) return;
            db.delRecord(id);
            response.sendRedirect("handleCustomer?action=list");
        } else if ("getEditCustomer".equalsIgnoreCase(action)) {
            String id = request.getParameter("id");
            if (id == null) return;
            CustomerBean c = db.queryCustByID(id);
            request.setAttribute("c", c);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/editCustomer.jsp");
            rd.forward(request, response);
        } else if ("search".equalsIgnoreCase(action)) {
            String name = request.getParameter("name");
            if (name != null) {
                ArrayList<CustomerBean> customers = db.queryCustByName(name);
                request.setAttribute("customers", customers);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/listCustomers.jsp");
                rd.forward(request, response);
            }
        } else {
            out.println("No such action!!!");
        }
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
