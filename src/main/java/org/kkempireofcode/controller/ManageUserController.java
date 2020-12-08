package org.kkempireofcode.controller;

import org.kkempireofcode.businessLogic.EncriptPassword;
import org.kkempireofcode.service.HotelSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.kkempireofcode.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ManageUserController {
    @Autowired
    private HotelSystemService hotelSystemService;

    // go to the adduser.jsp page which has a form to create user
    @RequestMapping(value = "/user")
    public ModelAndView showManageUsePage(ModelAndView model){
        model.setViewName("addUser");
        return model;
    }

    // Method to create user and save him/her in database
    @RequestMapping(value = "addUser",method = RequestMethod.POST)
    public ModelAndView addUser(ModelAndView model, HttpServletRequest request, HttpSession session) throws Exception {

//        if(!isAuthenticated(session)){
//            return new ModelAndView("redirect:/");
//        }
        //Get values from form (on addUser.jsp)
        String fname=request.getParameter("fName");
        String lname=request.getParameter("lName");
        String role=request.getParameter("role");
        String username=request.getParameter("userName");
        //String password=request.getParameter("pass");
        String password = EncriptPassword.byteArrayToHexString(EncriptPassword.computeHash(request.getParameter("pass")));


        // Create new user by using values from form
        User user=new User();
        user.setFirstName(fname);
        user.setLastName(lname);
        user.setRole(role);
        user.setUserName(username);
        user.setPassword(password);

        //save user
        hotelSystemService.addUser(user);

        //set redirect page
        model.addObject("allUsers",hotelSystemService.getAllUsers());
        //model.addObject("allStudents",service.getAllStudents());
        model.setViewName("homeUser");

        // go to the redirect page
        return model;
    }

    @RequestMapping(value="/showEditUser", method = RequestMethod.GET)
    public ModelAndView showEditUser(ModelAndView model, HttpServletRequest request){

        String userId=request.getParameter("id");
        String firstname=request.getParameter("fName");
        String lastname=request.getParameter("lName");
        String role=request.getParameter("role");
        String userName=request.getParameter("userName");
        String password=request.getParameter("password");

        model.addObject("userId",userId);
        model.addObject("firstname",firstname);
        model.addObject("lastname",lastname);
        model.addObject("role",role);
        model.addObject("userName",userName);
        model.addObject("password",password);

       model.setViewName("editUser");
        return  model;
    }

    @RequestMapping(value="/editUser", method = RequestMethod.POST)
    public ModelAndView EditUser(ModelAndView model, HttpServletRequest request) throws Exception {

        int  userId=Integer.parseInt(request.getParameter("id"));
        String firstname=request.getParameter("fName");
        String lastname=request.getParameter("lName");
        String role=request.getParameter("role");
        String userName=request.getParameter("userName");
        //String password=request.getParameter("pass");
        String password = EncriptPassword.byteArrayToHexString(EncriptPassword.computeHash(request.getParameter("pass")));


        User user=hotelSystemService.getUSer(userId);
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setRole(role);
        user.setUserName(userName);
        user.setPassword(password);

        hotelSystemService.editUser(user);
        model.addObject("allUsers",hotelSystemService.getAllUsers());
        model.addObject("allRooms", hotelSystemService.getAllRooms());

        model.setViewName("homeUser");
        return  model;
    }
    @RequestMapping(value ="/removeUser",method = RequestMethod.GET)
    public ModelAndView removeUser(ModelAndView model, HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("id"));
        User user=hotelSystemService.getUSer(id);
        hotelSystemService.removeUser(user);

        model.addObject("allUsers",hotelSystemService.getAllUsers());
        model.addObject("allRooms", hotelSystemService.getAllRooms());

        model.setViewName("homeUser");
        return model;
    }

//    public boolean isAuthenticated(HttpSession session){
//        if(session.getAttribute("fname && lname")!=null)
//            return true;
//        return false;
//    }

}
