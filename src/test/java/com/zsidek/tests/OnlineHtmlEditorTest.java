package com.zsidek.tests;

import com.zsidek.driver.Driver;
import com.zsidek.pages.onlinehtmleditor.StartPage;
import com.zsidek.utils.StringUtil;
import com.zsidek.utils.TestDataProvider;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OnlineHtmlEditorTest {

    private StartPage startPage;

    @BeforeEach
    public void setUp() {
        startPage = new StartPage("https://onlinehtmleditor.dev/");
    }

    @AfterAll
    public static void tearDown() {
        Driver.getInstance().quit();
    }

    @Test
    public void verifyErrorMessagesForMandatoryFields() {
        startPage.buttonBold.click();
        startPage.textboxEditor.sendKeys(TestDataProvider.provideTextC3().get(0));
        startPage.buttonBold.click();
        startPage.buttonUnderline.click();
        startPage.textboxEditor.sendKeys(TestDataProvider.provideTextC3().get(1));
        startPage.buttonUnderline.click();
        startPage.textboxEditor.sendKeys(TestDataProvider.provideTextC3().get(2));

        assertEquals("Automation Test Example",
                StringUtil.normalizeString(startPage.textboxEditor.getText()),
                "Textbox should contain expected text"
        );
    }
}
