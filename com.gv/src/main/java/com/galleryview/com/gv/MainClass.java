package com.galleryview.com.gv;

import org.openqa.selenium.chrome.ChromeDriver;

public class MainClass {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		
			new Ownerlogin(driver);
			new ManageArtworkProducts(driver);
//			new CreateEvents(driver);
//			new GalleryLocations(driver);
//			new ManageConsultant(driver);
//			new UpdateSubscription(driver);
//			new ClientOperations(driver);
//			new CreateLeads(driver);
//			new ClientLeads(driver);
//			new ClientOrders(driver);
//			new SidebarLeads(driver);
//			new CreateTask(driver);
//			new ImportArtwork(driver);
//			new ClientImport(driver);
		}
}