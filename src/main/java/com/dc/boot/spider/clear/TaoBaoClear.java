package com.dc.boot.spider.clear;

import com.dc.boot.spider.magic.TaoBaoMagic;
import com.dc.boot.vo.VoListItems;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TaoBaoClear {
    TaoBaoMagic taoBaoMagic = new TaoBaoMagic();

    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    String date=df.format(new Date());// new Date()为获取当前系统时间

    public TaoBaoClear() throws Exception {

    }

    public ArrayList ListData(String title,String username,String password,String page1) throws Exception {
        String store = taoBaoMagic.crawlList(title, username, password, page1);
        Document doc = Jsoup.parse(store, "utf8");
        Elements elements2 = doc.select(".item.J_MouserOnverReq");
        ArrayList<Object> list = new ArrayList();
        int i=0;
        for (Element element : elements2) {
            i++;
            VoListItems voListItems = new VoListItems();
            voListItems.setId(i);

            //获取商品链接
            voListItems.setUrl(element.select(".J_ClickStat").attr("href"));
            //获取商品名称
            voListItems.setGoodsName(element.select(".row.row-2.title").text());
            //商品价格
            voListItems.setPrice(element.select(".price.g_price.g_price-highlight").tagName("strong").text());
            //地理位置
            voListItems.setLocaTion(element.select(".location").text());
            //付款人数
            voListItems.setNumber(element.select(".deal-cnt").text());
            //时间
            voListItems.setDate(date);
            //店铺名称
            voListItems.setStoreName(element.select(".shop").text());

            list.add(voListItems);
        }

        return list;
    }



}

