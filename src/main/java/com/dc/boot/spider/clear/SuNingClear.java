package com.dc.boot.spider.clear;

import com.dc.boot.spider.magic.SuNingMagic;

import com.dc.boot.vo.VosuningListitems;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class SuNingClear {

    public ArrayList ListData(String storeName,  String page1) throws Exception {
        String s = new SuNingMagic().crawlList(storeName,page1);
        Document parse = Jsoup.parse(s);
        Elements select = parse.select(".general.clearfix").select(".item-bg");
        int i=1;
        ArrayList list = new ArrayList();
        for (Element element : select) {
            VosuningListitems vosuningListitems = new VosuningListitems();
            //id
            vosuningListitems.setId(i++);
            //商品名称
            vosuningListitems.setProductName(element.select(".title-selling-point").text());
            //价格
            vosuningListitems.setPrice(element.select(".price-box").text());
            //评价数
            vosuningListitems.setEvaluationNumber(element.select(".info-evaluate").select("a").text());
            //店铺名称
            vosuningListitems.setShopName(element.select(".store-stock").select("a").text());
            //商品链接
            vosuningListitems.setCommodityLink(element.select(".img-block").select("a").attr("href"));
            //图片链接
            vosuningListitems.setImageLink(element.select(".img-block").select("a").select("img").attr("src"));
            list.add(vosuningListitems);
        }

        return list;

    }



}
