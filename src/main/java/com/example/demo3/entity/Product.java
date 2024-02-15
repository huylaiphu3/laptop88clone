package com.example.demo3.entity;

import jakarta.persistence.*;

import java.awt.*;
import java.sql.Blob;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "ram")
    private int ram;
    @Column(name = "chip")
    private String chip;
    @Column(name = "ssd")
    private int ssd;
    @Column(name = "vga")
    private String vga;
    @Column(name = "monitor")
    private String monitor;
    @Column(name = "weight")
    private double weight;
    @Column(name = "color")
    private String color;
    @Column(name = "image")
    private String image;
    @Column(name = "price")
    private int price;

    public Product() {
    }

    public Product(String name, int ram, String chip, int ssd, String vga, String monitor, double weight, String color,String image, int price) {
        this.name = name;
        this.ram = ram;
        this.chip = chip;
        this.ssd = ssd;
        this.vga = vga;
        this.monitor = monitor;
        this.weight = weight;
        this.color = color;
        this.image = image;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public int getSsd() {
        return ssd;
    }

    public void setSsd(int ssd) {
        this.ssd = ssd;
    }

    public String getVga() {
        return vga;
    }

    public void setVga(String vga) {
        this.vga = vga;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
