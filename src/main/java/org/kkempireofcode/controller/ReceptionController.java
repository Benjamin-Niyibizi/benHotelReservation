package org.kkempireofcode.controller;

import org.kkempireofcode.businessLogic.FileExport;
import org.kkempireofcode.model.Booking;
import org.kkempireofcode.model.Reservation;
import org.kkempireofcode.model.Room;
import org.kkempireofcode.service.HotelSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
public class ReceptionController {

    @Autowired
    private HotelSystemService hotelSystemService;
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

    @RequestMapping (value = "/reception")
    public ModelAndView showReception(ModelAndView model, HttpServletRequest request){
        model.addObject("pendingReservations",hotelSystemService.getAllPendingReservations());
        model.addObject("availableRooms",hotelSystemService.getAllAvailableRooms());
        return model;
    }

    @RequestMapping (value = "/checkIn")
    public ModelAndView showCheckInPage(ModelAndView model,HttpServletRequest request) throws ParseException {        int roomId=Integer.parseInt(request.getParameter("roomId"));
        String names=request.getParameter("names");
        String tel=request.getParameter("tel");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String startDate=request.getParameter("startDate");
        String endDate=request.getParameter("endDate");

        model.addObject("roomId",roomId);
        model.addObject("names",names);
        model.addObject("tel",tel);
        model.addObject("startDate",startDate);
        model.addObject("endDate",endDate);

        model.setViewName("checkIn");
        return model;
    }

    @RequestMapping (value = "/checkOut")
    public ModelAndView showCheckOutPage(ModelAndView model,HttpServletRequest request){
        int bookingId = Integer.parseInt(request.getParameter("bookingId"));

        Booking booking=hotelSystemService.getBooking(bookingId);
        Room room=hotelSystemService.getRoom(booking.getRoomId());
        java.sql.Date checkOutDate= new  java.sql.Date(new java.util.Date().getTime());
        int nights = (int) TimeUnit.MILLISECONDS.toDays(checkOutDate.getTime() - booking.getStartDate().getTime());
        Double amount = (nights)*room.getPrice();

        booking.setCheckOutDate(checkOutDate);
        booking.setNights(nights);
        booking.setAmount(amount);
        booking.setPaymentDone(true);
        hotelSystemService.addBooking(booking);

        model.addObject("booking",booking);
        return model;
    }


    @RequestMapping (value = "/checkStatus", method = RequestMethod.POST)
    public ModelAndView roomStatus(ModelAndView model,HttpServletRequest request) throws ParseException {
//        String status= request.getParameter("status");
        java.sql.Date dateFrom = new java.sql.Date(sdf.parse(request.getParameter("dateFrom")).getTime()) ;
        HashMap<Integer, List<Reservation>> roomReservations = new HashMap<Integer, List<Reservation>>();

        List<Reservation>reservationMadeByDateFrom=hotelSystemService.getAllReservationsFromDate(dateFrom);
        for (Reservation res1:reservationMadeByDateFrom) {

            List<Reservation> reservationsByRoom= new ArrayList<Reservation>();

            for (Reservation res2:reservationMadeByDateFrom) {
                if (res1.getRoomId()==res2.getRoomId()){
                    reservationsByRoom.add(res2);
                }
            }
            roomReservations.put(res1.getRoomId(), reservationsByRoom);
        }
        HashMap<Room, List<Reservation>> roomReservationsTemp = new HashMap<Room, List<Reservation>>();
        for (Integer key:roomReservations.keySet()){
            roomReservationsTemp.put(hotelSystemService.getRoom(key),roomReservations.get(key));
        }

        HashMap<Integer,List<Booking>> roomBooking = new HashMap<Integer, List<Booking>>();
        List<Booking>bookingsMadeByDateFrom=hotelSystemService.getAllBookingsFromDate(dateFrom);

        for (Booking res1:bookingsMadeByDateFrom) {
            List<Booking>bookingsByRoom=new ArrayList<Booking>();
            for (Booking res2:bookingsMadeByDateFrom) {
                if (res1.getRoomId()==res2.getRoomId()){
                    bookingsByRoom.add(res2);
                }
            }
            roomBooking.put(res1.getRoomId(), bookingsByRoom);

        }
        HashMap<Room,List<Booking>> roomBookingsTemp = new HashMap<Room, List<Booking>>();
        for (Integer key: roomBooking.keySet()){
            roomBookingsTemp.put(hotelSystemService.getRoom(key),roomBooking.get(key));
        }
        model.addObject("pendingReservations",hotelSystemService.getAllPendingReservations());
        model.addObject("availableRooms",hotelSystemService.getAllAvailableRooms());
        model.addObject("roomReservations", roomReservationsTemp);
        model.addObject("roomBookings",roomBookingsTemp);
        model.setViewName("reception");
         return model;
    }

    @RequestMapping(value = "/printBookingBill", method = RequestMethod.POST)
    public ModelAndView printBookingBill(ModelAndView model,HttpServletRequest request, HttpServletResponse response){
            int bookingId=Integer.parseInt(request.getParameter("bookingId"));

            Booking booking=hotelSystemService.getBooking(bookingId);
            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String filename="bookingBill"+dateFormatter.format(new java.util.Date())+".pdf";
            FileExport.printBill(request,response,booking,filename.replaceAll("\\s+",""));

            return  model;
        }
    @RequestMapping(value = "/report")
    public ModelAndView showPageReport(ModelAndView model) {
            return model;
    }

    @RequestMapping(value = "/reportAction",method =RequestMethod.POST)
    public ModelAndView runReportForm(ModelAndView model, HttpServletRequest request, HttpSession session) throws ParseException {

            Date startDate=new Date(sdf.parse(request.getParameter("startDate")).getTime());
            Date endDate= new Date(sdf.parse(request.getParameter("endDate")).getTime());

            String dataType=request.getParameter("dataType");

//            System.out.println("ffffff"+startDate.toString());
//            System.out.println("ffffff"+endDate.toString());
//            System.out.println("ffffff"+dataType.toString());

            List<Booking> bookings=new ArrayList<Booking>();
            List<Reservation> reservations=new ArrayList<Reservation>();

            if (dataType.equals("booking")){
                bookings=hotelSystemService.getAllBookingsByStartDateAndEndDate(startDate,endDate);
            }
            if (dataType.equals("reservation")){
                reservations=hotelSystemService.getAllReservationByStartDateAndEndDate(startDate,endDate);

            }
            model.addObject("bookings",bookings);
            model.addObject("reservations",reservations);
            session.setAttribute("bookings",bookings);
            session.setAttribute("reservations",reservations);

            model.setViewName("report");
            return model;
    }
    @RequestMapping(value = "/printBookingReport",method = RequestMethod.POST)
    public ModelAndView printReportAction(ModelAndView model,HttpSession session,HttpServletResponse response){

            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String filename="bookingReport"+dateFormatter.format(new java.util.Date())+".pdf";
            FileExport.printBookingReport(response,(List<Booking>)session.getAttribute("bookings"),filename.replaceAll("\\s+",""));
            return model;
    }
    @RequestMapping(value = "/printReservationReport",method = RequestMethod.POST)
    public ModelAndView printReservationAction(ModelAndView model,HttpSession session,HttpServletResponse response){

            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String filename="reservationReport"+dateFormatter.format(new java.util.Date())+".pdf";
            FileExport.printReservationReport(response,(List<Reservation>)session.getAttribute("reservations"),filename.replaceAll("\\s+",""));
            return model;
    }
}

