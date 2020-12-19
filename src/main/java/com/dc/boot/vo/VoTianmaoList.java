package com.dc.boot.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VoTianmaoList {
    private int id;
    private String shopName;
    private String productName;
    private String productPrice;
    private String productSales;
    private String commodityLink;
    private String productEvaluation;
    private int key;
}