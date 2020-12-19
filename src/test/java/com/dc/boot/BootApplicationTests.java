package com.dc.boot;

import com.dc.boot.dao.DangDangWangDao;
import com.dc.boot.dao.HuiCongWangDao;
import com.dc.boot.dao.UserDao;
import com.dc.boot.spider.magic.*;
import com.dc.boot.vo.VoDangDangItems;
import com.dc.boot.vo.VoHuiCongItems;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;

//@MapperScan("com.dc.boot.dao")
@SpringBootTest
class BootApplicationTests {
	@Autowired
	private UserDao userDao;
	@Test
	void contextLoads() {
		ArrayList<Object> zh = new ArrayList();
		ArrayList<Object> en = new ArrayList();
		String[] zh1= new String[]{"ID", "商品ID","商品链接","标题","副标题","图片链接","全部轮播图","价格","月销","评论数量","收藏数量","店铺名称","宝贝描述","卖家服务","物流服务"};
		String[] en1= new String[]{"id", "goodsId","url","goodsTitle","subtitle","imgurl","slideshow","price","monthSold","commentNun","CollectNumber","storeName","babyBescription","service","logisticsService"};
		String[] es1= new String[]{"id", "Товарный","1","2","Подзаголовок.","3","Диаграмма колеса","4","5","6","коллекция","7","Милая, опиши.","Услуги продавца","Логистическое обслуживание"};
		String[] ja1= new String[]{"id", "商品ID","1","2","サブタイトル","3","カルーセル図","4","5","6","収蔵数","7","お宝説明","売り手サービス","物流サービス"};
		System.out.println("zh1"+zh1.length);
		System.out.println("en1"+en1.length);
		System.out.println("es1"+es1.length);
		System.out.println("ja1"+ja1.length);
		for (int i = 0; i <zh1.length ; i++) {
			zh.add("\'"+zh1[i]+"\'");
		}
		for (int i = 0; i <zh1.length ; i++) {
			en.add("\'"+en1[i]+"\'");
		}
//		zh.addAll(Arrays.asList(zh1));
//		en.addAll(Arrays.asList(en1));
		System.out.println(zh);
		System.out.println(en);
		System.out.println("#############################ZH.START###################");
		for (int i = 0; i <zh1.length ; i++) {
//1
			if (i==0||i==1||i==2||i==3||i==5||i==7||i==8||i==11){
				continue;
			}
			System.out.println(en1[i]+":"+"\'"+zh1[i]+"\',");

		}
		System.out.println("#############################ZH.END###################");
		System.out.println("#############################EN.START###################");
		for (int i = 0; i <en1.length ; i++) {
//	2
			if (i==0||i==1||i==2||i==3||i==5||i==7||i==8||i==11){
				continue;
			}
			System.out.println(en1[i]+":"+"\'"+en1[i].substring(0,1).toUpperCase().concat(en1[i].substring(1,en1[i].length()))+"\',");

		}
		System.out.println("#############################EN.END###################");
		System.out.println("#############################ES.START###################");
		for (int i = 0; i <es1.length ; i++) {
//3
			if (i==0||i==1||i==2||i==3||i==5||i==7||i==8||i==11){
				continue;
			}
			System.out.println(en1[i]+":"+"\'"+es1[i]+"\',");

		}
		System.out.println("#############################ES.END###################");
		System.out.println("#############################JA.START###################");
		for (int i = 0; i <ja1.length ; i++) {
//4
			if (i==0||i==1||i==2||i==3||i==5||i==7||i==8||i==11){
				continue;
			}
			System.out.println(en1[i]+":"+"\'"+ja1[i]+"\',");

		}
		System.out.println("#############################JA.END###################");
		System.out.println("#############################BEAN.START###################");
		for (int i = 0; i <zh1.length ; i++) {
			if (i==0){
				System.out.println("private int "+en1[i]+";");
				continue;
			}
			System.out.println("private String "+en1[i]+";");
		}
		System.out.println("#############################BEAN.END###################");
		System.out.println("#############################HTML.START###################");
		String s="";
		for (int i = 0; i <en1.length ; i++) {
			if (i==0){
				continue;
			}
		s+="   <el-table-column :label=\"$t('table."+en1[i]+"')\"  width=\"100px\" align=\"center\">\n" +
					"        <template slot-scope=\"{row}\">\n" +
					"          <span>{{ row."+en1[i]+" }}</span>\n" +
					"        </template>\n" +
					"      </el-table-column>\n";
		}
		System.out.println(s);
		System.out.println("#############################HTML.END###################");

	}
    @Autowired
    DangDangWangDao dangDangWangDao;
	@Autowired
	HuiCongWangDao huiCongWangDao;
	@Test
	void gitTest() throws Exception {

//        int add = dangDangWangDao.delete();
//        System.out.println(add);
//		List page = dangDangWangDao.findPage(1, 20);
//		System.out.println(page);
		VoHuiCongItems voHuiCongItems = new VoHuiCongItems();
		voHuiCongItems.setId(12);
		huiCongWangDao.add(voHuiCongItems);
    }

	@Test
	void test() throws Exception {
		TaoBaoMagic taoBaoMagic = new TaoBaoMagic();
		String url= taoBaoMagic.crawlDay("1");
		Document doc = Jsoup.parse(url, "utf8");
		Elements elements = doc.select(".lego-pc-search-list.pc-search-list");
		Elements elements2 = elements.select(".pc-items-item.item-undefined");
//		System.out.println(elements2);
		int i=1;
		for (Element element : elements2) {
//			int size = elements2.size()
//			System.out.println(size);
//			//商品名称
//			String name = element.select(".pc-items-item-title.pc-items-item-title-row2").select(".title-text").text();
////			商品价格
//			String price = element.select(".coupon-price-afterCoupon").text();
////			特价
//			String tejia = element.select(".coupon-price-old").text();
////			店铺名称
//			String text = element.select(".seller-name").text();
////			月销
//			String text = element.select(".sell-info").text();
			//链接
			String url1 = element.select(".pc-items-item-a").attr("href");
			System.out.println(url1);
			Document doc1 = Jsoup.parse(new URL(url1) , 3000);
			String text = doc1.select("#attributes").text();
			System.out.println(text);
//			String a = doc1.select(".#attributes").text();
//
//			System.out.println(a);
			System.out.println(i++);
		}
		//商品名称
//		String name = elements2.select(".title-text").text();
//		name
	}
}
