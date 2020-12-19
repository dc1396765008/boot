package com.dc.boot.spider.clear;

import com.dc.boot.bean.User;
import com.dc.boot.dao.UserDao;
import com.dc.boot.spider.magic.JingDonMagic;

import com.dc.boot.vo.VojdListItems;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class JingDonClear {
public ArrayList listJdData(String store ,String pageid) throws Exception {
    String s = new JingDonMagic().crawlList(store, pageid);
    Document parse = Jsoup.parse(s);
    Elements select = parse.select(".gl-warp.clearfix").select(".gl-item");
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    String date = df.format(new Date());// new Date()为获取当前系统时间
    ArrayList list = new ArrayList();
    int i = 0;
    for (Element element : select) {

        VojdListItems vojdSearch = new VojdListItems();
        //商品id
        vojdSearch.setId(++i);
        //关键字
        vojdSearch.setSearchKeywords(store);
        //商品名称
        vojdSearch.setTradeName(element.select(".p-name.p-name-type-2").select("em").text());
        //商品sku
        //商品链接
        vojdSearch.setProductLink(element.select(".p-img").select("a").attr("href"));
        //封面图链接
        vojdSearch.setCoverPictureLink(element.select(".p-img").select("a").select("img").attr("data-lazy-img"));
        //价格
        vojdSearch.setPrice(element.select(".p-price").text());
        //评价人数
        vojdSearch.setEvaluationOfTheNumber(element.select(".p-commit").text());
        //评论链接
        vojdSearch.setTheCommentsLink(element.select(".p-commit").select("a").attr("href"));
        //商家店名
        vojdSearch.setBusinessName(element.select(".J_im_icon").select("a").text());
        //店铺链接
        vojdSearch.setTheStoreLink(element.select(".J_im_icon").select("a").attr("href"));
        //标签'
        vojdSearch.setLabel(element.select(".p-icons").text());
        // , '页码',
        vojdSearch.setThePageNumber(store);
        // '当前时间
        vojdSearch.setTheCurrentTime(date);
        list.add(vojdSearch);
    }

    return list;
}



}
