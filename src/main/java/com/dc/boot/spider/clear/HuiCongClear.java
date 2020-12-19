package com.dc.boot.spider.clear;

import com.dc.boot.spider.magic.HuiCongMagic;
import com.dc.boot.vo.VoHuiCongItems;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class HuiCongClear {
    public ArrayList ListData(String store,String page) throws Exception {
        String s = new HuiCongMagic().crawlList(store,page);
        Document utf8 = Jsoup.parse(s, "utf8");
        Elements select = utf8.select(".wrap-grid").select(".NewItem");
        ArrayList list = new ArrayList();
        int i=1;
        for (Element element : select) {
            VoHuiCongItems voHuiCongItems = new VoHuiCongItems();
            voHuiCongItems.setId(i++);
            voHuiCongItems.setName(element.select(".title.highRed").text());
            voHuiCongItems.setShopName(element.select(".forbid-companyname").text());
            voHuiCongItems.setPrice(element.select(".seaNewPrice").text());
            voHuiCongItems.setUrl(element.select(".picmid.pRel").select("a").attr("href"));
            voHuiCongItems.setImgUrl(element.select(".picmid.pRel").select("img").attr("src"));
            voHuiCongItems.setAddress(element.select(".areaBox").attr("title"));
            list.add(voHuiCongItems);

        }
        return list;
    }
}
