package com.dc.boot.spider.magic;

import com.dc.boot.Util.Constants;
import com.ruiyun.jvppeteer.core.Puppeteer;
import com.ruiyun.jvppeteer.core.browser.Browser;
import com.ruiyun.jvppeteer.core.browser.BrowserFetcher;
import com.ruiyun.jvppeteer.core.page.*;
import com.ruiyun.jvppeteer.options.LaunchOptions;
import com.ruiyun.jvppeteer.options.LaunchOptionsBuilder;
import com.ruiyun.jvppeteer.protocol.network.Cookie;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;



import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class TaoBaoMagic {
    Browser browser = null;

    public TaoBaoMagic() throws Exception {
        BrowserFetcher.downloadIfNotExist(null);
        ArrayList<String> arrayList = new ArrayList();
        LaunchOptions options = new LaunchOptionsBuilder().withArgs(arrayList).withHeadless(true).build();
        arrayList.add("--no-sandbox");
        arrayList.add("--disable-setuid-sandbox");
        browser = Puppeteer.launch(options);
    }

    public String loginTaoBao(String username, String password) throws Exception {


        Page page = browser.newPage();
        page.goTo("https://login.taobao.com/");
        ElementHandle usernamelogin = page.$("#fm-login-id");
        usernamelogin.click();
        usernamelogin.type(username);
        ElementHandle passwordlogin = page.$("#fm-login-password");
        passwordlogin.type(password);
        ElementHandle handle = page.$("button");
        handle.click();
        page.waitFor("3000");
        List<Cookie> cookies = page.cookies();
        String s = "";
        for (int i = 0; i < cookies.size(); i++) {
            s += cookies.get(i).getName() + "=" + cookies.get(i).getValue() + "; ";
        }
        HashMap<String, String> objectObjectHashMap = new HashMap();
        page.close();
        return s;
    }


    public String crawlList(String storeName, String username, String password, String page1) throws Exception {

        HashMap<String, String> objectObjectHashMap = new HashMap();
        String cookies = this.loginTaoBao(username, password);
        objectObjectHashMap.put("cookie", cookies);
        Page page = browser.newPage();
        page.setExtraHTTPHeaders(objectObjectHashMap);
        page.goTo("https://s.taobao.com/search?q=" + storeName);
        ElementHandle f = page.$(".form");
        ElementHandle input = f.$(".input.J_Input");
        input.focus();
        input.press("Delete");
        input.type(page1);
        input.press("Enter");
        ElementHandle f1 = page.$(".form");
        Thread.sleep(2000);
        String content = page.content();
        browser.close();
        System.out.println(content);
        return content;

    }

    public String crawlDay(String value) throws InterruptedException {
        Page page = browser.newPage();
        page.goTo("https://uland.taobao.com/sem/tbsearch?keyword="+value);
        String content = page.content();
        page.close();
        browser.close();
        return content;
    }
    public String crawlUnion(String value) throws InterruptedException {
        Page page = browser.newPage();
        page.goTo("http://www.xuandan.com/allindex.html?key="+value);
        String content = page.content();

        browser.close();
        return content;
    }
    public String crawlComment() throws Exception {
        Page page = browser.newPage();
        page.goTo("https://detail.tmall.hk/hk/item.htm?id=621786431470#J_Reviews");
        ElementHandle close = page.$("#sufei-dialog-close");
        if (close!=null){
            close.click();
        }
        ElementHandle elementHandle = page.waitForSelector(".rate-list-append.rate-radio-group");
        String content = page.content();
        browser.close();
        return content;

    }
    public String crawlDetails(String id) throws InterruptedException, IOException {
        Page page = browser.newPage();
        page.goTo("https://detail.tmall.com/item.htm?id=" + id);
        Thread.sleep(3000);
        String content = page.content();
        browser.close();
        return content;
    }



}
