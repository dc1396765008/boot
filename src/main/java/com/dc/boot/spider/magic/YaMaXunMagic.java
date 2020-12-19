package com.dc.boot.spider.magic;

import com.ruiyun.jvppeteer.core.Puppeteer;
import com.ruiyun.jvppeteer.core.browser.Browser;
import com.ruiyun.jvppeteer.core.browser.BrowserFetcher;
import com.ruiyun.jvppeteer.core.page.Page;
import com.ruiyun.jvppeteer.options.LaunchOptions;
import com.ruiyun.jvppeteer.options.LaunchOptionsBuilder;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class YaMaXunMagic {
    Browser browser = null;
    public YaMaXunMagic() throws Exception {

        BrowserFetcher.downloadIfNotExist(null);
        ArrayList<String> arrayList = new ArrayList();
        LaunchOptions options = new LaunchOptionsBuilder().withArgs(arrayList).withHeadless(true).build();
        arrayList.add("--no-sandbox");
        arrayList.add("--disable-setuid-sandbox");
        browser = Puppeteer.launch(options);

    }
    public String crawlList(String store,String pageid) throws InterruptedException, ExecutionException {
        int i = Integer.parseInt(pageid);
        Page page = browser.newPage();
        page.goTo("https://www.amazon.cn/s?k="+store+"&page="+pageid);
//        page.keyboard().press("End",3,"End");
        for (int j = 0; j <20; j++) {
            page.keyboard().press("PageDown",300,"34");
        }
        page.keyboard().press("End",3,"End");
        Thread.sleep(3000);
        String content = page.content();
        browser.close();
        return content;
    }
}
