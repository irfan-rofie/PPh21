/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.pph21.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import spring.pph21.model.User;
import spring.pph21.service.UserService;

/**
 *
 * @author labprog1_7
 */
public class UserController implements Controller {

    private UserService userService;
    public static int ID;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map map = new HashMap();
        String aksi = request.getParameter("aksi");
        if (aksi == null) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            List<User> user = userService.getUser(username, password);
            if (user.isEmpty()) {
                return new ModelAndView("login", map);
            } else {
//                map.put("status", "login berhasil");
//            map.put("hasil", userService.getUser(username, password));
                User u = user.get(0);
                ID = u.getId();
                request.getSession().setAttribute("username", u);
                map.put("hasil", u);
                map.put("url", "home.jsp");
//                response.sendRedirect("home.htm");
            }
            return new ModelAndView("index", map);
        } else if (aksi.contains("keluar")) {
            User user = (User) request.getSession().getAttribute("username");
            request.getSession().removeAttribute("username");
            request.getSession().removeAttribute("password");
            return new ModelAndView("login", map);
        } else {
            map.put("url", "home.jsp");
            return new ModelAndView("index", map);
        }
    }
}
