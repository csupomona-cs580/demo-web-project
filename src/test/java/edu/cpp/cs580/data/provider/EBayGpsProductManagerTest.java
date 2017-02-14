package edu.cpp.cs580.data.provider;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import edu.cpp.cs580.data.GpsProduct;

public class EBayGpsProductManagerTest {

	@Test
	public void testListGps() {
		EBayGpsProductManager manager = new EBayGpsProductManager();
		List<GpsProduct> products = manager.listGps();

		Assert.assertNotNull(products);
		Assert.assertEquals(10, products.size());
		for(GpsProduct gps : products) {
			Assert.assertNotNull(gps.getName());
			Assert.assertNotNull(gps.getPrice());
			Assert.assertNotNull(gps.getImgUrl());
		}

		//Assert.assertTrue(products.get(0).getPrice().contains("119.99"));

	}
}
