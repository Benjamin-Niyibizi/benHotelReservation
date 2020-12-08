package org.kkempireofcode.model;


import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "booking")
@Transactional
public class Booking {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookingId;
    @Column
    private String names;
    @Column
    private String tel;
    @Column
    private int roomId;
    @Column
    private Date startDate;
    @Column
    private Date endDate;
    @Column
    private Date checkOutDate;
    @Column
    private  int nights;
    @Column
    private double amount;
    @Column
    private boolean paymentDone;

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getNights() {
        return nights;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isPaymentDone() {
        return paymentDone;
    }

    public void setPaymentDone(boolean paymentDone) {
        this.paymentDone = paymentDone;
    }
}
