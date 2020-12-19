package com.dc.boot.spider.clear;

import com.dc.boot.spider.magic.TianMaoMagic;
import com.dc.boot.spider.magic.WeiPingHuiMagic;
import com.dc.boot.vo.VoTianmaoList;
import com.dc.boot.vo.VoWeiPingHuiItems;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class WeiPingHuiClear {
    public ArrayList ListData(String store, String pageid) throws Exception {
        String s = new WeiPingHuiMagic().crawlList(store,pageid);
        Document parse = Jsoup.parse(s);
        Elements select = parse.select(".c-goods-item.J-goods-item.c-goods-item--auto-width");
        int i=1;
        ArrayList list = new ArrayList();
        for (Element element : select) {
            VoWeiPingHuiItems voWeiPingHuiItems = new VoWeiPingHuiItems();
            //id
            voWeiPingHuiItems.setId(i++);
            //名称
            voWeiPingHuiItems.setName(element.select(".J-goods-item__img").attr("alt"));
            //链接
            voWeiPingHuiItems.setUrl(element.select(".c-goods-item.J-goods-item.c-goods-item--auto-width").select("a").attr("href"));
            //现价
            voWeiPingHuiItems.setCurrentPrice((element.select(".c-goods-item__sale-price.J-goods-item__sale-price").text()));
            //原价
            voWeiPingHuiItems.setCostOfProduction(element.select(".c-goods-item__market-price.J-goods-item__market-price").text());
            //折扣
            voWeiPingHuiItems.setDiscount(element.select(".c-goods-item__discount.J-goods-item__discount").text());
            //卷后价格
            voWeiPingHuiItems.setPostRollPrice(element.select(".c-goods-item__sale-price.J-goods-item__sale-price").text());
            //图片链接
            voWeiPingHuiItems.setImgUrl(element.select(".c-goods-item__img").select("img").attr("src"));
            list.add(voWeiPingHuiItems);
        }
        return list;
    }
}
