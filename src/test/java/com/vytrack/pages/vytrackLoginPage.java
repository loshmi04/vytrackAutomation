package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class vytrackLoginPage {

    public vytrackLoginPage(){

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy (id="prependedInput")
    public WebElement loginUserName;

    @FindBy (id="prependedInput2")
    public WebElement inputPassword;

    @FindBy (id="_submit")
    public WebElement logInBtn;

    @FindBy(xpath = "//button[@data-dismiss='alert']")
    public WebElement AlertDismissBtn;

//************************************************************

    @FindBy(xpath = "(//div[@id='main-menu']//ul//li//a//span)[1]")
    public WebElement HomePageFleetHover;

    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-level-1 menu menu-level-1']/li[6]")
    public WebElement VehicleContracts;

    @FindBy(xpath = "//div[.='You do not have permission to perform this action.']")
    public WebElement MessageForDriver;

    @FindBy(xpath = "(//div[@id='main-menu']//ul//a//span)[5]")
    public WebElement ManagersFleetModule;

    @FindBy(xpath = "(//ul[@class='dropdown-menu dropdown-menu-level-1 menu menu-level-1'])[2]//li[6]")
    public WebElement ManagersVehicleContractModule;

    @FindBy(xpath = "//h1[normalize-space()='All Vehicle Contract']")
    public WebElement ModuleOfAllVehicleContractForManager;
}
