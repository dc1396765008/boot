package com.dc.boot.spider.clear;

import com.dc.boot.spider.magic.YaMaXunMagic;
import com.dc.boot.vo.VoYaMaXunItems;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class YaMaXunClear {
    public ArrayList ListData(String store, String pageid) throws Exception {
        String s = new YaMaXunMagic().crawlList(store,pageid);
        Document parse = Jsoup.parse(s,"utf8");
        Elements select = parse.select(".s-main-slot.s-result-list.s-search-results.sg-row").select("div[data-asin]");
        int i=1;
        ArrayList list = new ArrayList();
        for (Element element : select) {
            VoYaMaXunItems voYaMaXunItems = new VoYaMaXunItems();
            voYaMaXunItems.setId(i++);
            voYaMaXunItems.setName(element.select(".a-size-base-plus.a-color-base.a-text-normal").text());
            voYaMaXunItems.setPrice(element.select(".a-offscreen").text());
            voYaMaXunItems.setUrl(element.select(".a-link-normal.s-no-outline").attr("href"));
            voYaMaXunItems.setImgUrl(element.select(".a-section.aok-relative.s-image-square-aspect").select("img").attr("src"));
            list.add(voYaMaXunItems);
        }
        return list;
    }
}
