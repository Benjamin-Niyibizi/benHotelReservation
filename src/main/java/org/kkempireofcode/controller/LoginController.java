package org.kkempireofcode.controller;

import org.kkempireofcode.businessLogic.EncriptPassword;
import org.kkempireofcode.model.User;
import org.kkempireofcode.service.HotelSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private HotelSystemService hotelSystemService;

    @RequestMapping(value= "/")
    public ModelAndView viewHomePage (ModelAndView model){
        model.addObject("allRooms",hotelSystemService.getAllRooms());
        model.setViewName("home");
        return model;
    }
    @RequestMapping(value= "/login",method = RequestMethod.POST)
    public ModelAndView loginPage (ModelAndView model, HttpServletRequest request, HttpSession session) throws Exception {
        String username = request.getParameter("username");
        //String password = request.getParameter("pass");
        String password = EncriptPassword.byteArrayToHexString(EncriptPassword.computeHash(request.getParameter("pass")));
        User user = hotelSystemService.getUSer(username, password);

        if (user != null) {

            model.addObject("allUsers",hotelSystemService.getAllUsers());
            model.addObject("allRooms", hotelSystemService.getAllRooms());

            //model.addObject("allStudents",service.getAllStudents());
            model.setViewName("homeUser");
           session.setAttribute("fname", user.getFirstName());
           session.setAttribute("lname", user.getLastName());
            session.setAttribute("role",user.getRole());
                    } else {
            model.setViewName("home");
        }
        return model;
    }

    @RequestMapping(value= "/logout")
    public ModelAndView logout (ModelAndView model, HttpSession session){
        model.addObject("allRooms", hotelSystemService.getAllRooms());
        session.removeAttribute("fname");
        session.removeAttribute("lname");
        model.setViewName("home");
        return model;
    }

    @RequestMapping(value= "/home")
    public ModelAndView showHome (ModelAndView model, HttpSession session){
        model.addObject("allRooms", hotelSystemService.getAllRooms());
        return model;
    }


}