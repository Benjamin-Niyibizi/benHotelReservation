package org.kkempireofcode.controller;

import org.kkempireofcode.model.Reservation;
import org.kkempireofcode.service.HotelSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
public class ReservationController {

    @Autowired
    private HotelSystemService hotelSystemService;

    // go to the adduser.jsp page which has a form to create user
    @RequestMapping(value = "/reservation")
    public ModelAndView showManageUsePage(ModelAndView model,HttpServletRequest request){
        model.addObject("roomId",request.getParameter("id"));
        model.setViewName("reservation");
        return model;
    }

    // Method to create user and save him/her in database
    @RequestMapping(value = "reservation",method = RequestMethod.POST)
    public ModelAndView requestReservation(ModelAndView model, HttpServletRequest request) throws ParseException {

//        if(!isAuthenticated(session)){
//            return new ModelAndView("redirect:/");
//        }
        //Get values from form (on addUser.jsp)
        int roomid= Integer.parseInt(request.getParameter("id"));
        String names=request.getParameter("names");
        int tel=Integer.parseInt(request.getParameter("telephone"));
        String email=request.getParameter("email");
        String startDate=request.getParameter("startDate");
        String endDate=request.getParameter("endDate");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

        // Create new reservation by using values from form
        Reservation reservation=new Reservation();

        reservation.setRoomId(roomid);
        reservation.setNames(names);
        reservation.setTel(tel);
        reservation.setEmail(email);
        reservation.setStartDate(new java.sql.Date(sdf.parse(String.valueOf(startDate)).getTime()));
        reservation.setEndDate(new java.sql.Date(sdf.parse(String.valueOf(endDate)).getTime()));
        reservation.setResStatus("Pending");

        //save user
        hotelSystemService.makeReservation(reservation);

        //set redirect page
        model.addObject("allRooms",hotelSystemService.getAllRooms());
        model.setViewName("home");

        // go to the redirect page
        return model;
    }

}
