package org.kkempireofcode.service;

import org.kkempireofcode.model.Booking;
import org.kkempireofcode.model.Reservation;
import org.kkempireofcode.model.Room;
import org.kkempireofcode.model.User;


import java.sql.Date;
import java.util.List;

public interface HotelSystemDao {

    public User getUSer(String username, String password);

    public void addUser(User user);
    public void addRoom(Room room);
    public void addBooking(Booking booking);

    public List<User> getAllUsers();
    public List<Room> getAllRooms();
    public List<Reservation> getAllReservations();
    public List<Reservation> getAllPendingReservations();
    public List<Room> getAllAvailableRooms();
    public List<Reservation> getAllReservationsFromDate(Date dateFrom);
    public List<Booking> getAllBookingsFromDate(Date dateFrom);
    public List<Booking> getAllBookingsByStartDateAndEndDate(Date startDate,Date endDate);
    public List<Reservation> getAllReservationByStartDateAndEndDate(Date startDate, Date endDate);



    public User getUSer(int id);
    public Room getRoom(int id);
    public Booking getBooking(int id);


    public void editUser(User user);
    public void editRoom(Room room);

    public void makeReservation(Reservation reservation);

    public  void removeUser(User user);
    public  void removeRoom(Room room);


}
