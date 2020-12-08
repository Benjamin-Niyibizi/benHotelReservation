package org.kkempireofcode.controller;

import org.kkempireofcode.model.Booking;
import org.kkempireofcode.service.HotelSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
public class BookingController {
    @Autowired
    private HotelSystemService hotelSystemService;
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

    @RequestMapping(value = "checkInAction",method = RequestMethod.POST)
    public ModelAndView addRoom(ModelAndView model, HttpServletRequest request, HttpSession session) throws ParseException {
//        if (!isAuthenticated(session)){
//            return new ModelAndView("redirect:/");
//        }
        model.addObject("roomId", request.getParameter("id"));

        int roomId=Integer.parseInt(request.getParameter("roomId"));
        String names=request.getParameter("names");
        String otherNames=request.getParameter("otherNames").trim();
        if(!otherNames.equals("") && otherNames!=null){
            names=otherNames;
        }
        String tel=request.getParameter("tel");
        String startDate=request.getParameter("startDate");
        String endDate=request.getParameter("endDate");

        Booking booking=new Booking();
        booking.setRoomId(roomId);
        booking.setNames(names);
        booking.setTel(tel);
        booking.setStartDate( new java.sql.Date(sdf.parse(String.valueOf(startDate)).getTime()));
        booking.setEndDate( new java.sql.Date(sdf.parse(String.valueOf(endDate)).getTime()));

        hotelSystemService.addBooking(booking);
        model.setViewName("reception");

        model.addObject("pendingReservations",hotelSystemService.getAllPendingReservations());
        model.addObject("availableRooms",hotelSystemService.getAllAvailableRooms());
        return model;
    }
    @RequestMapping (value = "checkinAction",method = RequestMethod.POST)
    public ModelAndView checkInAction(ModelAndView model, HttpServletRequest request, HttpSession session) throws ParseException {
//        if (!isAuthenticated(session)){
//            return new ModelAndView("redirect:/");
//        }
        int roomId=Integer.parseInt(request.getParameter("roomId"));
        String names=request.getParameter("names");
        String tel=request.getParameter("tel");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String startDate=request.getParameter("startDate");
        String endDate=request.getParameter("endDate");

        Booking booking=new Booking();
        booking.setRoomId(roomId);
        booking.setNames(names);
        booking.setTel(tel);
        booking.setStartDate( new java.sql.Date(sdf.parse(String.valueOf(startDate)).getTime()));
        booking.setEndDate(new java.sql.Date(sdf.parse(String.valueOf(endDate)).getTime()));

        hotelSystemService.addBooking(booking);

        model.setViewName("reception");
        model.addObject("pendingReservations",hotelSystemService.getAllPendingReservations());
        model.addObject("availableRooms",hotelSystemService.getAllAvailableRooms());
//        model.addObject("allreservation",hotelSystemService.getAllReservations());
        return model;
    }
//
////    public boolean isAuthenticated(HttpSession session){
//////        if(session.getAttribute("userId")!=null)
//////            return true;
//////        return false;
//////    }
}
