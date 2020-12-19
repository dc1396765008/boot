package com.dc.boot.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VoUnionItems {
    private int id;
    private String goodsTitle;
    private String keywords;
    private String monthSold;
    private String price;
    private String commission;
    private String ratio;
    private String goodsId;
    private String url;
    private String imgUrl;
    private String salePlan;
    private String store;
    private String storeID;
    private String storedetails;
    private int key;

}
