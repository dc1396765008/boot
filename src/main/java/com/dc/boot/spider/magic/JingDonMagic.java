package com.dc.boot.spider.magic;

import com.ruiyun.jvppeteer.core.Puppeteer;
import com.ruiyun.jvppeteer.core.browser.Browser;
import com.ruiyun.jvppeteer.core.browser.BrowserFetcher;
import com.ruiyun.jvppeteer.core.page.ElementHandle;
import com.ruiyun.jvppeteer.core.page.Page;
import com.ruiyun.jvppeteer.options.LaunchOptions;
import com.ruiyun.jvppeteer.options.LaunchOptionsBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class JingDonMagic {

    Browser browser = null;
    public JingDonMagic() throws Exception {
        BrowserFetcher.downloadIfNotExist(null);
        ArrayList<String> arrayList = new ArrayList();
        LaunchOptions options = new LaunchOptionsBuilder().withArgs(arrayList).withHeadless(true).build();
        arrayList.add("--no-sandbox");
        arrayList.add("--disable-setuid-sandbox");
        browser = Puppeteer.launch(options);
    }

    public String crawlList(String store,String pageid) throws InterruptedException, ExecutionException {
        Page page = browser.newPage();
        page.goTo("https://search.jd.com/Search?keyword="+store );
        page.keyboard().press("End",3,"End");
        ElementHandle span = page.$(".page.clearfix");
        ElementHandle input = span.$(".input-txt");
        input.click();
        input.press("Delete");
        input.type(pageid);
        input.press("Enter");
        page.keyboard().press("End",3,"End");
        Thread.sleep(3000);
        String content = page.content();
        browser.close();
        return content;
    }
    public String crawlRaise() throws InterruptedException {
        Page page = browser.newPage();
        page.goTo("https://z.jd.com/bigger/search.html");
        String content = page.content();
        browser.close();
        return content;
    }
    public String crawlcomments(String url) throws InterruptedException, ExecutionException {
        Page page = browser.newPage();
        page.goTo(url);
        ElementHandle pl = page.$("#comment-count");
        ElementHandle a = pl.$("a");
        a.click();
        page.keyboard().press("PageDown",3,"34");
        Thread.sleep(1000);
        page.keyboard().press("PageDown",3,"34");
        Thread.sleep(2000);
        for (int i= 0; i<20;i++) {
            page.keyboard().press("ArrowLeft", 3, "37");
            Thread.sleep(100);
        }
        String content = page.content();
        browser.close();
        return content;


    }

}
