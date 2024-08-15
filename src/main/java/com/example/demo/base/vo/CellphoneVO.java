package com.example.demo.base.vo;


import com.alibaba.excel.annotation.ExcelProperty;

public class CellphoneVO {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @ExcelProperty("简介")
    private String summary;
    @ExcelProperty("保障")
    private String legend;
    @ExcelProperty("七天退换")
    private String protection;
    @ExcelProperty("月销")
    private String sale;
    @ExcelProperty("地点")
    private String place;
    @ExcelProperty("价格")
    private String price;
    @ExcelProperty("店铺")
    private String seller;
    @ExcelProperty(value = "月销数字")
    private String msales;
    @ExcelProperty(value = "评论")
    private String comments;


    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getLegend() {
        return legend;
    }

    public void setLegend(String legend) {
        this.legend = legend;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getMsales() {
        return msales;
    }

    public void setMsales(String msales) {
        this.msales = msales;
    }

    public String getProtection() {
        return protection;
    }

    public void setProtection(String protection) {
        this.protection = protection;
    }





    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}