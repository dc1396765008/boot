package com.dc.boot.spider.clear;

import com.dc.boot.spider.magic.DangDangMagic;
import com.dc.boot.vo.VoDangDangItems;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class DangDangClear {
    public ArrayList ListData(String storeName, String page1) throws Exception {
        ArrayList<Object> list = new ArrayList<Object>();
        String s = new DangDangMagic().crawlList(storeName, page1);
        Document parse = Jsoup.parse(s, "utf-8");
        Elements select = parse.select(".bigimg.cloth_shoplist").select("li[ddt-pit]");
        System.out.println(select.size());
        int i = 0;
        for (Element s1 : select) {
            VoDangDangItems voDangDangItems = new VoDangDangItems();
            i++;
            voDangDangItems.setId(i);

//商品图片
            Elements select1 = s1.select(".pic");
            String attr = select1.select("img").attr("src");
            voDangDangItems.setImageLink(attr);

//商品链接
            String attr1 = s1.select(".name").select("a").attr("href");
            voDangDangItems.setCommodityLink(attr1);
//标题title
            String attr2 = s1.select(".name").select("a").attr("title");
            voDangDangItems.setProductName(attr2);
//评论条数
            String text = s1.select(".star").select("a").text();
            voDangDangItems.setEvaluationTheNumber(text);
//店铺名
            String a = s1.select(".link").select("a").text();
            voDangDangItems.setShopName(a);
//价钱
            String a1 = s1.select(".price_n").text();
            voDangDangItems.setPrice(a1);
            list.add(voDangDangItems);
        }
        return list;
    }



}
