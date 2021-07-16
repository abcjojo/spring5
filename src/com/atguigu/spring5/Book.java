package com.atguigu.spring5;

public class Book {

    private String bname;
    private String bauthor;



    private String address;
    public void setAddress(String address) {
        this.address = address;
    }
    public void setBname(String bname) {
        this.bname = bname;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }

    public void getBookInfo() {
        System.out.println(bname + ":::" + bauthor + ":::::::" + address);
    }
}
