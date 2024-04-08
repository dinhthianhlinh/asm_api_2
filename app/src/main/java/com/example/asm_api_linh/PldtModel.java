package com.example.asm_api_linh;

import java.io.Serializable;

public class PldtModel implements Serializable {
    private String _id;
    private String ten;

    private int namsx;

    private String hang;

    private double gia;
    private String imgAvatar;

    public PldtModel(String name, String namSX, String hang, String gia) {
    }

    public PldtModel(String _id, String ten, int namsx, String hang, double gia, String imgAvatar) {
        this._id = _id;
        this.ten = ten;
        this.namsx = namsx;
        this.hang = hang;
        this.gia = gia;
        this.imgAvatar = imgAvatar;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getNamsx() {
        return namsx;
    }

    public void setNamsx(int namsx) {
        this.namsx = namsx;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getImgAvatar() {
        return imgAvatar;
    }

    public void setImgAvatar(String imgAvatar) {
        this.imgAvatar = imgAvatar;
    }

}
