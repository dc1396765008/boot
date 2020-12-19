package com.dc.boot.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VosuningListitems {
    private int id;
    private String productName;
    private String price;
    private String evaluationNumber;
    private String shopName;
    private String commodityLink;
    private String imageLink;
    private int key;
}
