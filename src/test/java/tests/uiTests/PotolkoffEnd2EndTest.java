package tests.uiTests;

import BaseClasses.uii.pageModel.*;
import BaseClasses.uii.uiTestBase.UiTestBase;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class PotolkoffEnd2EndTest extends UiTestBase {

    @Test
    public void fullTest() {
        open("/");
        MainPage.checkAllMenus();
        MainPage.openGalleryPage();
        GalleryPage.checkHeaderAndItems();
        GalleryPage.openRoomsTypeList();
        GalleryPage.checkRoomTypes();
        GalleryPage.openChandelierPicturesList();
        GalleryPage.checkAndGetPictures();
        GalleryPage.openColorCataloguePicturesList();
        GalleryPage.checkAndGetColorsPictures();
        MainPage.openPriceListPage();
        PriceListPage.checkHeader();
        PriceListPage.checkTableValues();
        PriceListPage.openCalcForm();
        CalcForm.calculateAndCheck();
        MainPage.openContactsPage();
        ContactsPage.checkHeader();
        ContactsPage.proceedContactUsForm();
    }
}
