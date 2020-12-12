/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointmentsystem_2019300;

/**
 *
 * @author Francisco Leite
 */

//class to create a barber lcoation object
class BarberLocation {
    private int barberId;
    private int locationId;
    private String location;
    private boolean worksMon;
    private boolean worksTue;
    private boolean worksWed;
    private boolean worksThu;
    private boolean worksFri;
    private boolean worksSat;
    private boolean worksSun;
    
    //constructor with the to properties of the location carries the day the barber is available
    public BarberLocation(int barberId, int locationId, String location, boolean worksMon, boolean worksTue, boolean worksWed, boolean worksThu, boolean worksFri, boolean worksSat, boolean worksSun) {
        this.barberId = barberId;
        this.locationId = locationId;
        this.location = location;
        this.worksMon = worksMon;
        this.worksTue = worksTue;
        this.worksWed = worksWed;
        this.worksThu = worksThu;
        this.worksFri = worksFri;
        this.worksSat = worksSat;
        this.worksSun = worksSun;
    }

    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public int getBarberId() {
        return barberId;
    }

    public void setBarberId(int barberId) {
        this.barberId = barberId;
    }

    public int getLocationId() {
        return locationId;
    }
    
    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }
    
    public boolean isWorksMon() {
        return worksMon;
    }
    
    public void setWorksMon(boolean worksMon) {
        this.worksMon = worksMon;
    }
    
    public boolean isWorksTue() {
        return worksTue;
    }

    public void setWorksTue(boolean worksTue) {
        this.worksTue = worksTue;
    }

    public boolean isWorksWed() {
        return worksWed;
    }

    public void setWorksWed(boolean worksWed) {
        this.worksWed = worksWed;
    }

    public boolean isWorksThu() {
        return worksThu;
    }

    public void setWorksThu(boolean worksThu) {
        this.worksThu = worksThu;
    }

    public boolean isWorksFri() {
        return worksFri;
    }

    public void setWorksFri(boolean worksFri) {
        this.worksFri = worksFri;
    }

    public boolean isWorksSat() {
        return worksSat;
    }

    public void setWorksSat(boolean worksSat) {
        this.worksSat = worksSat;
    }

    public boolean isWorksSun() {
        return worksSun;
    }

    public void setWorksSun(boolean worksSun) {
        this.worksSun = worksSun;
    }
}
