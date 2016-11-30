/*
 * COPYRIGHT. HSBC HOLDINGS PLC 2016. ALL RIGHTS RESERVED.
 *
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer
 * language in any way or for any other purposes whatsoever without the prior
 * written consent of HSBC Holdings plc.
 */
package com.devops;
import org.junit.Test;
import junit.framework.Assert;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SeleniumRemoteTest {

     String URL = "http://creditcardapp.centralindia.cloudapp.azure.com:8000/CreditCardApp/";
     String title = "Credit Card Application";

    @Test
    public  void checkTitle() throws InterruptedException, MalformedURLException {
        System.out.println("**************    ******   Selenium Test Starting *******   *****************");
        DesiredCapabilities dCaps = DesiredCapabilities.chrome();	  
        //dCaps.setJavascriptEnabled(true);
		//dCaps.setCapability("takesScreenshot", false);
		//dCaps.setCapability("phantomjs.binary.path", "/opt/phantomjs/bin/phantomjs");
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://creditcardapp.centralindia.cloudapp.azure.com:4444/"), dCaps);
        driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
        Thread.sleep(10000L);
        driver.get(URL);
        Thread.sleep(10000L);
        Assert.assertEquals(title, driver.getTitle());
        System.out.println(" Verified that the title is as expected.. Ending Test");
        Thread.sleep(10000L);
        System.out.println("**************   *******  Closing Browser and quitting Selenium  *******  ***********");
        driver.quit();
    }

}
