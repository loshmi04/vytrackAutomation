package com.vytrack.test;

import com.vytrack.pages.vytrackLoginPage;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class Test {

    vytrackLoginPage vytrackLoginPage;

    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get(ConfigurationReader.getProperty("urlVYTrack"));
        vytrackLoginPage = new vytrackLoginPage();
    }

    @org.testng.annotations.Test
    public void driverLoginTestVerifyNoAccessToContract() throws InterruptedException {
        // user login using driver credentials
        vytrackLoginPage.loginUserName.sendKeys(ConfigurationReader.getProperty("vytrackLoginPage"));

        //user input password
        vytrackLoginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("password1"));

        // user click on login
        vytrackLoginPage.logInBtn.click();

        Thread.sleep(4000);

        // user dismisses alert by closing it
        vytrackLoginPage.AlertDismissBtn.click();

        // user hover or click fleet module
        vytrackLoginPage.HomePageFleetHover.click();

        //user selects vehicle contract
        vytrackLoginPage.VehicleContracts.click();

        Thread.sleep(4000);

        // driver sees message "You do not have permission to perform this action."
        String actualDriverMessage = vytrackLoginPage.MessageForDriver.getText();
        String expectedDriverMessage = "You do not have permission to perform this action.";

        Assert.assertEquals(actualDriverMessage, expectedDriverMessage);

        Driver.getDriver().close();

    }

    @org.testng.annotations.Test
    public void managerLoginAccessVehicleContract() throws InterruptedException {

        // user login as store manager
        vytrackLoginPage.loginUserName.sendKeys(ConfigurationReader.getProperty("userNameStoreManager"));

        // user input password
        vytrackLoginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("password1"));

        // user clicks login btn
        vytrackLoginPage.logInBtn.click();

        Thread.sleep(4000);

        // user hover or click fleet module
        vytrackLoginPage.ManagersFleetModule.click();

        //user selects vehicle contract
        vytrackLoginPage.ManagersVehicleContractModule.click();

        Thread.sleep(4000);

        // get title of current page
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "All - Vehicle Contract - Entities - System - Car - Entities - System";

        Assert.assertEquals(actualTitle, expectedTitle);

        Driver.getDriver().close();
    }
}
