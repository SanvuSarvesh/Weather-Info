package com.example.weather_info_application.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "pincode_info")
public class PinCodeInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String Name;
    private String Description;
    private String BranchType;
    private String Delivery;
    private String Taluk;
    private String Circle;
    private String District;
    private String Division;
    private String Region;
    private String State;
    private String Country;
}
