package org.kkempireofcode.controller;

import org.kkempireofcode.model.Room;
import org.kkempireofcode.service.HotelSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;

@Controller
public class ManageRoomController {
    @Autowired
    private HotelSystemService hotelSystemService;

    @RequestMapping(value ="/room")
    public ModelAndView showroomForm(ModelAndView model){
        model.addObject("allRooms",hotelSystemService.getAllRooms());
        model.setViewName("addRoom");
        return model;
    }

    @RequestMapping(value = "/addRoomAction", method = RequestMethod.POST)
    public ModelAndView addRoomAction(ModelAndView model, HttpServletRequest request, HttpSession session) throws ParseException {

//        if(!isAuthenticated(session)){
//            return new ModelAndView("redirect:/");
//        }

        String desc= request.getParameter("desc");
        String status= request.getParameter("status");
        double price=Double.parseDouble(request.getParameter("price"));

        Room room=new Room();
        room.setDescription(desc);
        room.setStatus(status);
        room.setPrice(price);

        hotelSystemService.addRoom(room);
        //model.addObject("allusers",hotelSystemService.getAllUsers());
        model.addObject("allRooms",hotelSystemService.getAllRooms());
        model.setViewName("addRoom");
        return model;
    }

    @RequestMapping(value="/showEditRoom", method = RequestMethod.GET)
    public ModelAndView showEditRoom(ModelAndView model, HttpServletRequest request){
        int  roomId=Integer.parseInt(request.getParameter("id"));
        String roomDesc= request.getParameter("desc");
        String roomStatus= request.getParameter("status");
        String roomPrice=request.getParameter("price");


        model.addObject("roomId",roomId);
        model.addObject("roomDesc",roomDesc);
        model.addObject("roomStatus",roomStatus);
        model.addObject("roomPrice",roomPrice);

        model.setViewName("editRoom");

        return  model;
    }

//    @RequestMapping(value="/editRoom", method = RequestMethod.POST)
//    public ModelAndView EditUser(ModelAndView model, HttpServletRequest request) throws ParseException {
//
//        int  userId=Integer.parseInt(request.getParameter("id"));
//        String names=request.getParameter("name");
//        String gender=request.getParameter("gender");
//        String level=request.getParameter("level");
//        String dob=request.getParameter("dob");
//
//        SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-DD");
//        room room= service.getroom(userId);
//        room.set(names);
//        room.setGender(gender);
//        room.setLevel(level);
//        room.setBirthDate(sdf.parse(dob));
//
//        service.editroom(room);
//        model.addObject("allusers",service.getAllUsers());
//        model.addObject("allrooms",service.getAllrooms());
//
//        model.setViewName("home");
//        return  model;
//    }
//    @RequestMapping(value ="/removeroom",method = RequestMethod.GET)
//    public ModelAndView removeUser(ModelAndView model, HttpServletRequest request){
//        int id=Integer.parseInt(request.getParameter("id"));
//        room room=hotelSystemService.getroom(id);
//        service.removeroom(room);
//
//        model.addObject("allusers",service.getAllUsers());
//        model.addObject("allrooms",service.getAllrooms());
//
//        model.setViewName("home");
//        return model;
//    }

//    public boolean isAuthenticated(HttpSession session){
//        if(session.getAttribute("nme")!=null)
//            return true;
//        return false;
//    }
}
