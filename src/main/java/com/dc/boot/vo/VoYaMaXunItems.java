package com.dc.boot.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VoYaMaXunItems {
    //id
    private int id;
    //商品名称
    private String name;
    //价格
    private String price;
    //商品链接
    private String url;
    //图片链接
    private String imgUrl;
    private int key;
}
