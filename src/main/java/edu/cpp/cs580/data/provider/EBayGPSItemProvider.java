package edu.cpp.cs580.data.provider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import edu.cpp.cs580.data.GPSItem;

public class EBayGPSItemProvider implements GPSDataProvider {

	@Override
	public List<GPSItem> listAllGPSItems() {
		List<GPSItem> gpsItems = new ArrayList<GPSItem>();

		Document doc;
		try {

			// need http protocol
			doc = Jsoup.connect("http://www.ebay.com/sch/Vehicle-Electronics-GPS-/3270/i.html?_from=R40&_nkw=gps").get();

			// get page title
			String title = doc.title();
			System.out.println("title : " + title);

			// get all title information
			Elements links = doc.select("a.vip");
			for (Element link : links) {

				// get the value from href attribute
				//				System.out.println("\nlink : " + link.attr("href"));
				//				System.out.println("text : " + link.text());

				GPSItem gpsItem = new GPSItem();
				gpsItem.setTitle(link.text());
				gpsItems.add(gpsItem);
			}

			// get all price information
			Elements pricetext = doc.select("span.bold");
			int index = 0;
			for (Element price : pricetext) {
				//System.out.println("text : " + price.text());
				index++;
				if (index >= gpsItems.size()) {
					break;
				} else {
					gpsItems.get(index).setPrice(price.text());
				}
			}

			// get all price information
			index = 0;
			Elements imageUrls = doc.select("img.img");
			for (Element imageUrl : imageUrls) {
				System.out.println("\nimg : " + imageUrl.attr("src"));
				index++;
				if (index >= gpsItems.size()) {
					break;
				} else {
					gpsItems.get(index).setImageUrl(imageUrl.attr("src"));
				}
			}

			//System.out.println(links.size() + " --- " + pricetext.size());

		} catch (IOException e) {
			e.printStackTrace();
		}

		return gpsItems;
	}

}
