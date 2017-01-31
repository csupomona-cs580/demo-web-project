package edu.cpp.cs580.data.provider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import edu.cpp.cs580.data.GpsProduct;

public class EBayGpsProductManager implements GpsProductManager {

	@Override
	public List<GpsProduct> listGps() {
		List<GpsProduct> gpsProducts = new ArrayList<>();
		Document doc;
		try {
			doc = Jsoup.connect("http://www.ebay.com/sch/i.html?_from=R40&_trksid=p2050601.m570.l1313.TR0.TRC0.H0.Xgps.TRS0&_nkw=gps&_sacat=0").get();


			// title
			Elements elements = doc.select("h3.lvtitle");
			for(Element e : elements) {
				System.out.println(e.text());
			}

			// price
			Elements elements2 = doc.select("li.lvprice");
			for(Element e : elements2) {
				System.out.println(e.text());
			}

			// imgUrl
			Elements elements3 = doc.select("div.lvpicinner img");
			for(Element e : elements3) {
				System.out.println(e.attr("src"));
			}

			for(int i = 0; i < 10; i++) {
				GpsProduct g = new GpsProduct(
						elements.get(0).text(),
						elements2.get(0).text(),
						elements3.get(0).attr("src"));
				gpsProducts.add(g);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return gpsProducts;
	}

}
