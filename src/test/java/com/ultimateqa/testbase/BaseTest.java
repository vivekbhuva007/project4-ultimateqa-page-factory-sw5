package com.ultimateqa.testbase;

import com.ultimateqa.browserfactory.ManageBrowser;
import com.ultimateqa.propertyreader.PropertyReader;
import com.ultimateqa.utility.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest extends Utility {


    String browser =PropertyReader.getInstance().getProperty("browser");

    @BeforeMethod

    public void setUp() {
        selectBrowser(browser);
    }

    @AfterMethod
    public void tearDown(){
        closeBrowser();
    }
}

