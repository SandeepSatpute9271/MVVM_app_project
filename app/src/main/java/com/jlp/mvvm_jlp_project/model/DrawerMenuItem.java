package com.jlp.mvvm_jlp_project.model;/*
 * Created by Sandeep(Techno Learning) on 29,June,2022
 */

public class DrawerMenuItem {

    private String title = "";
    private int resource = 0;

    public DrawerMenuItem(String title) {
        this.title = title;
    }


    public DrawerMenuItem(String title, int resource) {
        this.title = title;
        this.resource = resource;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }
}
