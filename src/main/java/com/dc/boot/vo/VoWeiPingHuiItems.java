package com.dc.boot.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VoWeiPingHuiItems {
    //id
    private int id;
    //名称
    private String name;
    //链接
    private String url;
    //现价
    private String currentPrice;
    //原价
    private String costOfProduction;
    //折扣
    private String discount;
    //卷后价格
    private String postRollPrice;
    //图片链接
    private String imgUrl;
    private int key;
}
