package org.kkempireofcode.service;

import org.kkempireofcode.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.sql.Date;
import java.util.List;

@Service
@Transactional
public class HotelSystemServiceImpl  implements HotelSystemService{

    @Autowired
    private HotelSystemDao hotelSystemDao;

    @Override
    public User getUSer(String username, String password) {
        return hotelSystemDao.getUSer(username,password);
    }

    @Override
    public List<User> getAllUsers() {

        return hotelSystemDao.getAllUsers();
    }

    @Override
    public List<Room> getAllRooms() {
        return  hotelSystemDao.getAllRooms();
    }

    @Override
    public List<Reservation> getAllReservations() {
        return hotelSystemDao.getAllReservations();
    }

    @Override
    public List<Reservation> getAllPendingReservations() {
        return hotelSystemDao.getAllPendingReservations();
    }

    @Override
    public List<Room> getAllAvailableRooms() {
        return hotelSystemDao.getAllAvailableRooms();
    }

    @Override
    public List<Reservation> getAllReservationsFromDate(Date dateFrom) {
        return hotelSystemDao.getAllReservationsFromDate(dateFrom);
    }

    @Override
    public List<Booking> getAllBookingsFromDate(Date dateFrom) {
        return hotelSystemDao.getAllBookingsFromDate(dateFrom);
    }

    @Override
    public List<Booking> getAllBookingsByStartDateAndEndDate(Date startDate, Date endDate) {
        return hotelSystemDao.getAllBookingsByStartDateAndEndDate( startDate, endDate);
    }

    @Override
    public List<Reservation> getAllReservationByStartDateAndEndDate(Date startDate, Date endDate) {
        return hotelSystemDao.getAllReservationByStartDateAndEndDate(startDate,endDate);
    }

    @Override
    public List<Item> getAllItems() {
        return hotelSystemDao.getAllItems();
    }

    @Override
    public User getUSer(int id) {
        return hotelSystemDao.getUSer(id);
    }

    @Override
    public Room getRoom(int id) {
        return hotelSystemDao.getRoom(id);
    }

    @Override
    public Booking getBooking(int id) {
        return hotelSystemDao.getBooking(id);
    }

    @Override
    public void editUser(User user) {

        hotelSystemDao.editUser(user);
    }

    @Override
    public void editRoom(Room room) {

        hotelSystemDao.editRoom(room);
    }

    @Override
    public void removeUser(User user) {

        hotelSystemDao.removeUser(user);
    }

    @Override
    public void removeRoom(Room room) {
        hotelSystemDao.removeRoom(room);
    }

    @Override
    public void makeReservation(Reservation reservation) {
        hotelSystemDao.makeReservation(reservation);
    }

    @Override
    public void addUser(User user) {
        hotelSystemDao.addUser(user);
    }

    @Override
    public void addRoom(Room room) {
        hotelSystemDao.addRoom(room);
    }

    @Override
    public void addBooking(Booking booking) {
        hotelSystemDao.addBooking(booking);
    }

    @Override
    public void addItem(Item item) {
        hotelSystemDao.addItem(item);
    }
}
