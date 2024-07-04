package com.galleryview.com.gv.SuperAdminuser;

import org.openqa.selenium.chrome.ChromeDriver;

public class SuperAdminClass {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		
		new Adminlogin(driver);
//		new AdminComponents(driver);
//		new AdminProductCreation(driver);
//		new AdminKB(driver);
//		new FeatureRequestCreation(driver);
//		new FeatureRequestDeletion(driver);
		new Notification(driver);
	}

}
