package com.kodcu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by usta on 18.07.2014.
 */
@WebServlet(name = "HelloServlet", urlPatterns = "/**")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try (PrintWriter writer = resp.getWriter();) {
            writer.write("Merhaba Dünya");
        }

    }
}
