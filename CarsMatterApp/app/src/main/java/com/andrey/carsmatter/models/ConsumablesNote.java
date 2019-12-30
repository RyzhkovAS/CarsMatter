package com.andrey.carsmatter.models;

import java.util.Date;

public class ConsumablesNote {
    public int Id;
    public Date Date;
    public String KindOfService;
    public float Price;
    public int Odo;
    public String Location;
    public String Notes;

    public ConsumablesNote(Date date, String kindOfService, float price, int odo, String location, String notes) {
        this.Date = date;
        this.KindOfService = kindOfService;
        this.Price = price;
        this.Odo = odo;
        this.Location = location;
        this.Notes = notes;
    }

    public ConsumablesNote(){
    }
}
