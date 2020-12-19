package com.dc.boot.spider.clear;

import com.dc.boot.spider.magic.TianMaoMagic;
import com.dc.boot.vo.VoTianmaoList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class TianMaoClear {

    public ArrayList ListData(String storeName, String username, String password, String page1) throws Exception {
        String s = new TianMaoMagic().crawlList(storeName,username,password,page1);
        Document parse = Jsoup.parse(s);
        Elements select = parse.select("#J_ItemList").select(".product-iWrap");
        int i=1;
        ArrayList list = new ArrayList();
        for (Element element : select) {
            VoTianmaoList voTianmaoList = new VoTianmaoList();
            voTianmaoList.setId(i++);
            //商品名称
            voTianmaoList.setShopName(element.select(".productTitle").text());
            //店铺名称
            voTianmaoList.setProductName(element.select(".productShop-name").text());
            //价格
            voTianmaoList.setProductPrice(element.select(".productPrice").text());
            //月成交量
            String span = element.select(".productStatus").select("span").text();
            int i1 = span.lastIndexOf("笔")+1;
            voTianmaoList.setProductSales(span.substring(0, i1));
            //商品链接
            voTianmaoList.setCommodityLink(element.select(".productImg-wrap").select("a").attr("href"));
            //评论数
            int i2 = span.lastIndexOf("评");
            int i3 = span.indexOf("旺");
            if(i2==-1){
                continue;
            }
            voTianmaoList.setProductEvaluation(span.substring(i2,i3));
            list.add(voTianmaoList);
        }
        return list;

    }
}
