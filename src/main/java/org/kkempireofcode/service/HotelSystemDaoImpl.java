package org.kkempireofcode.service;

import org.dom4j.tree.BackedList;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.kkempireofcode.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

import java.sql.Date;
import java.util.List;

@Repository
public class HotelSystemDaoImpl implements HotelSystemDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getUSer(String username, String password) {
        User user=null;

        Query qr=sessionFactory.getCurrentSession().createQuery("FROM User");
        List<User> result=(List<User>) qr.list();

        for (User u:result) {
            if (u.getUserName().equals(username) && u.getPassword().equals(password)){
                user=u;
                break;
            }
        }
        return user ;
    }

    @Override
    public List<User> getAllUsers() {
        Query qr=sessionFactory.getCurrentSession().createQuery("FROM User");
        List<User> result=(List<User>) qr.list();
        return result;
    }

    @Override
    public List<Room> getAllRooms() {
        Query qr=sessionFactory.getCurrentSession().createQuery("FROM Room");
        List<Room> result=(List<Room>) qr.list();
        return result;
    }

    @Override
    public List<Reservation> getAllReservations() {
        Query qr=sessionFactory.getCurrentSession().createQuery("FROM Reservation");
        List<Reservation> result=(List<Reservation>) qr.list();
        return result;
    }

    @Override
    public List<Reservation> getAllPendingReservations() {
        Query qr=sessionFactory.getCurrentSession().createQuery("FROM Reservation");
        List<Reservation> result=(List<Reservation>) qr.list();
        List<Reservation> pendingReservation=new ArrayList<Reservation>();
        for (Reservation reservation:result){
            if (reservation.getResStatus().equals("Pending")){
                pendingReservation.add(reservation);
            }
        }
        return pendingReservation;
    }

    @Override
    public List<Room> getAllAvailableRooms() {
        Query qr=sessionFactory.getCurrentSession().createQuery("FROM Room");
        List<Room> result=(List<Room>) qr.list();

        List<Room> availableRooms=new ArrayList<Room>();
        for (Room room:result){
            if (room.getStatus().equals("Available")||room.getStatus().equals("Reserved")){
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    @Override
    public List<Reservation> getAllReservationsFromDate(Date dateFrom) {
        Query qr=sessionFactory.getCurrentSession().createQuery("FROM Reservation order by roomId");
        List<Reservation> result=(List<Reservation>) qr.list();
        List<Reservation> reservationsAfterDate = new ArrayList<Reservation>();

        for (Reservation res:result){
            if (res.getStartDate().after(dateFrom) || res.getStartDate().equals(dateFrom)){
                reservationsAfterDate.add(res);
            }
        }
        return reservationsAfterDate;
    }

    @Override
    public List<Booking> getAllBookingsFromDate(Date dateFrom) {
        Query qr=sessionFactory.getCurrentSession().createQuery("FROM Booking order by roomId");
        List<Booking> result=(List<Booking>) qr.list();
        List<Booking> bookingsAfterDate = new ArrayList<Booking>();

        for (Booking book:result){
            if (book.getStartDate().after(dateFrom) || book.getStartDate().equals(dateFrom)){
                bookingsAfterDate.add(book);
            }
        }
        return bookingsAfterDate;
    }

    @Override
    public List<Booking> getAllBookingsByStartDateAndEndDate(Date startDate, Date endDate) {
        Query qr=sessionFactory.getCurrentSession().createQuery("FROM Booking order by roomId");
        List<Booking> result=(List<Booking>) qr.list();
        List<Booking> bookingsByStartDateAndEndDate=new ArrayList<Booking>();
        for (Booking bok:result){
            if ((bok.getStartDate().after(startDate)||bok.getStartDate().equals(startDate)) && (bok.getStartDate().before(endDate)||bok.getStartDate().equals(endDate))){
                bookingsByStartDateAndEndDate.add(bok);
            }
        }
        return bookingsByStartDateAndEndDate;
    }

    @Override
    public List<Reservation> getAllReservationByStartDateAndEndDate(Date startDate, Date endDate) {
        Query qr=sessionFactory.getCurrentSession().createQuery("FROM Reservation order by roomId");
        List<Reservation> result=(List<Reservation>) qr.list();
        List<Reservation> reservationByStartDateAndEndDate=new ArrayList<Reservation>();
        for (Reservation reservation:result){
            if ((reservation.getStartDate().after(startDate)||reservation.getStartDate().equals(startDate)) && (reservation.getStartDate().before(endDate)||reservation.getStartDate().equals(endDate))){
                reservationByStartDateAndEndDate.add(reservation);
            }
        }
        return reservationByStartDateAndEndDate;
    }

    @Override
    public List<Item> getAllItems() {
        Query qr=sessionFactory.getCurrentSession().createQuery("FROM Item");
        List<Item> result=(List<Item>) qr.list();
        return result;
    }

    @Override
    public User getUSer(int id) {
        User user=null;
        Query qr=sessionFactory.getCurrentSession().createQuery("FROM User WHERE id="+id);
        List<User> result=(List<User>) qr.list();
        return result.get(0) ;
    }

    @Override
    public Room getRoom(int id) {
        Room room=null;
        Query qr=sessionFactory.getCurrentSession().createQuery("FROM Room WHERE roomId="+id);
        List<Room> result=(List<Room>) qr.list();
        return result.get(0) ;
    }

    @Override
    public Booking getBooking(int id) {
        Booking booking=null;
        Query qr=sessionFactory.getCurrentSession().createQuery("FROM Booking WHERE bookingId="+id);
        List<Booking> result=(List<Booking>) qr.list();
        return result.get(0) ;
    }

    @Override
    public void editUser(User user) {

        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void editRoom(Room room) {

        sessionFactory.getCurrentSession().update(room);
    }

    @Override
    public void removeUser(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    public void removeRoom(Room room) {
        sessionFactory.getCurrentSession().delete(room);
    }

    @Override
    public void makeReservation(Reservation reservation) {
        sessionFactory.getCurrentSession().saveOrUpdate(reservation);
        Room room=getRoom(reservation.getRoomId());
        room.setStatus("Reserved");
        addRoom(room);
    }

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    public void addRoom(Room room) {
        sessionFactory.getCurrentSession().saveOrUpdate(room);
    }

    @Override
    public void addBooking(Booking booking) {
        sessionFactory.getCurrentSession().saveOrUpdate(booking);
    }

    @Override
    public void addItem(Item item) {
        sessionFactory.getCurrentSession().saveOrUpdate(item);
    }

    @Override
    public void addSellItem(Sell sell) {
        sessionFactory.getCurrentSession().saveOrUpdate(sell);
    }
}
