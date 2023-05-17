package com.epam.atm.pageobjects.actions;

import com.epam.atm.pageobjects.BasePage;
import com.epam.atm.pageobjects.folders.DraftFolderPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoToDraftFolderPage extends BasePage {

    private By draftBy = By.xpath("//a[contains(@href,'drafts')]//parent::span");
    private By draftFolderBy = By.xpath("//*[text()='Drafts']");


    public GoToDraftFolderPage(WebDriver driver) {
        super(driver);
    }

    public DraftFolderPage goToDraftFolder() {

        driver.findElement(draftBy).click();
        waitElementToBeClicable(draftFolderBy);
        driver.findElement(draftFolderBy).click();

        return new DraftFolderPage(driver);
    }
}

