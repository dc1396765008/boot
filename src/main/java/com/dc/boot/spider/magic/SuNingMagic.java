package com.dc.boot.spider.magic;

import com.ruiyun.jvppeteer.core.Puppeteer;
import com.ruiyun.jvppeteer.core.browser.Browser;
import com.ruiyun.jvppeteer.core.browser.BrowserFetcher;
import com.ruiyun.jvppeteer.core.page.ElementHandle;
import com.ruiyun.jvppeteer.core.page.Page;
import com.ruiyun.jvppeteer.options.LaunchOptions;
import com.ruiyun.jvppeteer.options.LaunchOptionsBuilder;
import com.ruiyun.jvppeteer.protocol.network.Cookie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class SuNingMagic {

    Browser browser = null;
    public SuNingMagic() throws Exception {
        BrowserFetcher.downloadIfNotExist(null);
        ArrayList<String> arrayList = new ArrayList();
        LaunchOptions options = new LaunchOptionsBuilder().withArgs(arrayList).withHeadless(true).build();
        arrayList.add("--no-sandbox");
        arrayList.add("--disable-setuid-sandbox");
        browser = Puppeteer.launch(options);
    }

    public String crawlList(String store,String pageid) throws InterruptedException, ExecutionException {
        Page page = browser.newPage();
        page.goTo("https://search.suning.com/"+store+"/");
//        page.keyboard().press("End",3,"End");

        ElementHandle input = page.$("#bottomPage");
        input.click();
        input.press("Delete");
        input.type(pageid);
        ElementHandle span = page.$(".page-more.ensure");
        span.click();
        page.keyboard().press("End",3,"End");
        Thread.sleep(3000);
        String content = page.content();
        browser.close();
        return content;
    }
}
