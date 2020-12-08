package org.kkempireofcode.model;

import javax.persistence.*;

@Entity
@Table(name="room")
public class Room{
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int roomId;

    @Column
    private String description;

    @Column
    private String status;

    @Column
    private double price;

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
