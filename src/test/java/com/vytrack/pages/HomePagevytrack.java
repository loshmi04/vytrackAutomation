package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagevytrack {

    public HomePagevytrack(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

//    @FindBy(xpath = "//span[normalize-space()='Fleet'][1]")
//    public WebElement HomePageFleetHover;
//
//    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-level-1 menu menu-level-1']/li[6]")
//    public WebElement VehicleContracts;
//
//    @FindBy(xpath = "//div[.='You do not have permission to perform this action.']")
//    public WebElement MessageForDriver;
//
//    @FindBy(xpath = "//h1[@class='oro-subtitle']")
//    public WebElement ModuleOfAllVehicleContractForManager;

}
