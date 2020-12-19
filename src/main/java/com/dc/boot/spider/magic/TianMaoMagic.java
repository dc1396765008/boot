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

public class TianMaoMagic  {
    Browser browser = null;
    public TianMaoMagic() throws Exception {
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
        page.goTo("https://list.tmall.com/search_product.htm?q="+storeName);
        ElementHandle input = page.$(".ui-page-skipTo");


        input.focus();
        input.press("Delete");
        input.type(page1);
//        input.press("Enter");



        Thread.sleep(2000);
        String content = page.content();

        browser.close();
        System.out.println(content);
        return content;

    }

}
