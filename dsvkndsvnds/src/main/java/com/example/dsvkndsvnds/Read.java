package com.example.dsvkndsvnds;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "read", value = "/read")
public class Read extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>"+message+"</h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ArtemP\\IdeaProjects\\dsvkndsvnds\\src\\main\\webapp\\json\\bebra.json"));
        StringBuilder str = new StringBuilder();
        String line;
        while((line = br.readLine())!=null){
            str.append(line);
        }
        br.close();
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        out.print(str.toString());
        out.flush();
    }






    public void destroy() {
    }
}