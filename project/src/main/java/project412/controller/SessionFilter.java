/*
CSE 412 Final Project
Due: 12/4/22
Michael Payne
Yue Fang
Jesus Perez
 */
package project412.controller;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class SessionFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        if (request.getRequestURI().equals("/login") || request.getRequestURI().equals("/login.html")) {
            chain.doFilter(request, response);
            return;
        }
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            response.sendRedirect("login.html");
            return;
        }
        chain.doFilter(request, response);
    }
}
