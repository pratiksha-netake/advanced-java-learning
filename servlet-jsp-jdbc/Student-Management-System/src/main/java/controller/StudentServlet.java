package controller;

import java.io.IOException;
import java.util.*;
import dao.StudentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Model.Student;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
    private StudentDAO dao;

    public void init() {
        dao = new StudentDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if(action == null) action = "list";

        switch(action) {
            case "new":
                request.getRequestDispatcher("student-form.jsp").forward(request, response);
                break;

            case "insert":
                insertStudent(request, response);
                break;

            case "delete":
                int id = Integer.parseInt(request.getParameter("id"));
                dao.deleteStudent(id);
                response.sendRedirect("StudentServlet");
                break;

            case "edit":
                int sid = Integer.parseInt(request.getParameter("id"));
                Student s = dao.getStudentById(sid);
                request.setAttribute("student", s);
                request.getRequestDispatcher("student-form.jsp").forward(request, response);
                break;

            case "update":
                updateStudent(request, response);
                break;

            default:
                List<Student> list = dao.getAllStudents();
                request.setAttribute("list", list);
                request.getRequestDispatcher("student-list.jsp").forward(request, response);
        }
    }

    private void insertStudent(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Student s = new Student();
        s.setName(request.getParameter("name"));
        s.setEmail(request.getParameter("email"));
        s.setCourse(request.getParameter("course"));
        dao.insertStudent(s);
        response.sendRedirect("StudentServlet");
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response)
           throws IOException {
        Student s = new Student();
        s.setId(Integer.parseInt(request.getParameter("id")));
        s.setName(request.getParameter("name"));
        s.setEmail(request.getParameter("email"));
        s.setCourse(request.getParameter("course"));
        dao.updateStudent(s);
        response.sendRedirect("StudentServlet");
    }
}