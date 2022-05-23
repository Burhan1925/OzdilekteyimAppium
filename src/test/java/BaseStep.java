import com.thoughtworks.gauge.Logger;
import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BaseStep extends BaseTest {

    @Step("<wait> saniye kadar bekle")
    public void waitForSeconds(int wait) throws InterruptedException {
        Thread.sleep(wait * 1000);

    }

    @Step("id<id> li elemente tıkla")
    public void clickById(String id) {
        appiumDriver.findElement(By.id(id)).click();
        Logger.info("Uygulama acildi");

    }

    @Step("id<id> li elementi kontrol et")
    public void checkText(String id) {
        String chectText = appiumDriver.findElement(By.id(id)).getText();
        Assertions.assertEquals("ALIŞVERİŞE BAŞLA", chectText);

    }

    @Step("id<id> li elementi ara")
    public void checkText1(String id) {
        String chectText1 = appiumDriver.findElement(By.id(id)).getText();
        Logger.info("Alisveris sayfasi acildi");
    }

    @Step("id<kategori> kategoriye tıkla")
    public void clickBykategori(String kategori) {
        appiumDriver.findElement(By.id(kategori)).click();
        Logger.info("Kategoriye tiklandi");
    }

    @Step("xpath<kadin> kadın kategorisine tıkla")
    public void clickByXpathkadin(String kadin) {
        appiumDriver.findElement(By.xpath(kadin)).click();
        Logger.info("Kadin kategorisine tiklandi");

    }

    @Step("xpath<pantolon> Pantolon kategorisine tıklandı")
    public void clickByXpathPantolon(String pantolon) {
        appiumDriver.findElement(By.xpath(pantolon)).click();
        Logger.info("Pantolon kategorisine tiklandi");
    }

    @Step("Sayfayı aşağı kaydır")
    public void swipeUp() {
        final int ANIMATION_TIME = 2000;
        final int PRESS_TIME = 2000;
        int edgeBorder = 2;
        PointOption pointOptionStart, pointOptionEnd;
        Dimension dims = appiumDriver.manage().window().getSize();
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);
        pointOptionEnd = PointOption.point(dims.width / 2,edgeBorder);
        new TouchAction(appiumDriver)
                .press(pointOptionStart)
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                .moveTo(pointOptionEnd)
                .release().perform();
        logger.info("Sayfayi aşagi kaydir");

    }

    @Step("Rastgele bir urun sec")
    public void selectRandom() {
        Random random = new Random();
        List<MobileElement> rastgeleUrun = appiumDriver.findElements(By.xpath("//*[@resource-id='com.ozdilek.ozdilekteyim:id/imageView']"));
        System.out.println("rastgeleUrun" + rastgeleUrun);
        MobileElement element = rastgeleUrun.get(random.nextInt(rastgeleUrun.size()));
        element.click();
        Logger.info("Rastgele bir urun secildi");

    }

    @Step("id<id> Urun detay kontrolu")
    public void checkUrunDetay(String id) {
        String checkUrunDetay = appiumDriver.findElement(By.id(id)).getText();
        Assertions.assertEquals("Beden:", checkUrunDetay);
        Logger.info("Urun detay kontrolu yapildi");

    }

    @Step("xpath<xpath> Favoriye ekle")
    public void FavoriEkle(String favXpath) {
        appiumDriver.findElement(By.xpath(favXpath)).click();
        Logger.info("Urun favorilere eklendi");

    }

    @Step("id<id> Giris  kontrolu")
    public void checkText3(String id) {
        String chectLoginKontrol = appiumDriver.findElement(By.id(id)).getText();
        Assertions.assertEquals("Beni Hatırla", chectLoginKontrol);
        Logger.info("Yeniden giris yapildi");

    }

    @Step("<id> id'li elemente <email> Email adresi girme")
    public void loginMail(String emailId,String emailText) {
        appiumDriver.findElement(By.id(emailId)).sendKeys(emailText);
        Logger.info("E-Mail adresi girildi");

    }

    @Step("<id> 'li elemente <password> Sifre girme")
    public void loginPassword(String passwordId, String passwordText) {
        appiumDriver.findElement(By.id(passwordId)).sendKeys(passwordText);
        Logger.info("Sifre girildi");

    }

    @Step("id<id> Geri tusuna tikla")
    public void clickGeri(String id) {
        appiumDriver.findElement(By.id(id)).click();
        Logger.info("Geri tusuna basildi");

    }

    @Step("<id> Sepete ekleme yap")
    public  void SepeteEkle(String sepetId) {
        appiumDriver.findElement(By.id(sepetId)).click();
        Logger.info("Sepete ekle tusuna basildi");

    }

}
