package com.example.fullapplication;

public class allcar_model {
    int img ,img1;
    String Company,Model,gear,fuel,lugage,seat,expensive,medium,best;

    public  allcar_model(int img, String Company, String Model , String gear, String fuel , String lugage, String seat, String expensive , String medium , String best ,int logo){
        this.Model=Model;
        this.img1=logo;
        this.Company=Company;
        this.img=img;
        this.gear=gear;
        this.fuel=fuel;
        this.lugage=lugage;
        this.seat=seat;
        this.expensive=expensive;
        this.medium=medium;
        this.best=best;

    }
    public  allcar_model(int img, String Company, String Model , String gear, String fuel, String expensive , String medium , String best, int logo ){
        this.Model=Model;
        this.img1=logo;
        this.Company=Company;
        this.img=img;
        this.gear=gear;
        this.fuel=fuel;
        this.expensive=expensive;
        this.medium=medium;
        this.best=best;

    }




}
