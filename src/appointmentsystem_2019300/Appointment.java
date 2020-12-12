/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointmentsystem_2019300;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.text.DateFormatter;

/**
 *
 * @author Francisco Leite
 */

class Appointment {

   
    // 0 = PendingConfirmation
    // 1 = Confirmed
    // 2 = Cancelled
    // 3 = Completed
    
    private int appoitmentId;
    private Date date;
    private String location;
    private String barber;
    private int status;
    private String time;
    private String customer;

    
    //constructor for an appointment object
    public Appointment(int appoitmentId, Date date, String location, String barber, int status, String customer) {
        this.appoitmentId = appoitmentId;
        this.date = date;
        this.location = location;
        this.barber = barber;
        this.status = status;
        this.customer = customer;
    }
    
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    public int getAppoitmentId() {
        return appoitmentId;
    }

    public void setAppoitmentId(int appoitmentId) {
        this.appoitmentId = appoitmentId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBarber() {
        return barber;
    }

    public void setBarber(String barber) {
        this.barber = barber;
    }
   
    public String getTime() {
        return time;
    }

    public String getFormattedDate() {
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        return format.format(this.date);
    }

    public String getCustomer() {
        return customer;
    }
    
    public void setCustomer(String customer){
        this.customer = customer;
    }
    
    
}
