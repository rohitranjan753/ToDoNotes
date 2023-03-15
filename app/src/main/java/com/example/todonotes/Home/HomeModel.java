package com.example.todonotes.Home;


public class HomeModel {
    String hTitle, hTime;

    public HomeModel(String hTitle,String hTime){
        this.hTitle = hTitle;
        this.hTime = hTime;
    }

    public String gethTitle() {
        return hTitle;
    }

    public void sethTitle(String hTitle) {
        this.hTitle = hTitle;
    }

    public String gethTime() {
        return hTime;
    }

    public void sethTime(String hTime) {
        this.hTime = hTime;
    }


}
