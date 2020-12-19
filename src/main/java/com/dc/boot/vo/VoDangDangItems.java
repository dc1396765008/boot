package com.dc.boot.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VoDangDangItems {

    private int id;
    private String shopName;
    private String imageLink;
    private String commodityLink;
    private String productName;
    private String price;
    private String evaluationTheNumber;
    private int key;


}
