package com.example.dsvkndsvnds;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>"+message+"</h1>");
        out.println("</body></html>");
    }
    public static class Team {
        String name = "";
        int champ = 0;
        int lch = 0;
        int year = 0;
        String country = "";


        // Это позволит Jackson правильно выполнять десериализацию.
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        public int getchamp() {
            return champ;
        }

        public void setChamp(int Champ) {
            this.champ = champ;
        }

        public int getLch() {
            return champ;
        }

        public void setLch(int lch) {
            this.lch = lch;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }
        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        StringBuilder jsonString = new StringBuilder();
        String line;
        while((line=reader.readLine())!=null){
            jsonString.append(line);
        }
        reader.close();
        System.out.println(jsonString.toString());
        ObjectMapper objectMapper = new ObjectMapper();
        line=jsonString.toString();
        Team team = objectMapper.readValue(line,Team.class);
        System.out.println(team.name);
        File file = new File("C:\\Users\\ArtemP\\IdeaProjects\\dsvkndsvnds\\src\\main\\webapp\\json\\bebra.json");
        try(RandomAccessFile raf = new RandomAccessFile(file,"rw")){
            long length = raf.length();
            if(length==0){
                raf.writeBytes("[");
            }else{
                raf.seek(length-1);
                raf.writeBytes(",");
                raf.writeBytes("\n");
            }
            raf.writeBytes(jsonString.toString());
            raf.writeBytes("]");
        }catch (IOException e){
            e.printStackTrace();
        }
        resp.setStatus(HttpServletResponse.SC_OK);
    }






    public void destroy() {
    }
}