package com.dc.boot.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VoListItems implements Serializable {
    private int id;
    private String storeName;
    private String locaTion;
    private String goodsName;
    private String price;
    private String number;
    private String url;
    private String date;
    private int key;

}
