package edu.cpp.cs580.data.provider;

import java.util.List;

import org.junit.Test;

import edu.cpp.cs580.data.GPSItem;
import org.junit.Assert;

public class EBayGPSItemProviderTest {

	@Test
	public void testListAllGPSItems() {
		// 1. call the actual method
		EBayGPSItemProvider provider = new EBayGPSItemProvider();
		
		// 2. record the result
		List<GPSItem> items = provider.listAllGPSItems();
		
		// 3. assert
		Assert.assertNotNull(items);		
		Assert.assertTrue(items.size() > 20);
		
		//GPSItem firstItem = items.get(0);
		//Assert.assertTrue(firstItem.getTitle().contains("Bluetooth"));
		
	}
}
