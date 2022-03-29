import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.border.MatteBorder;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.getInteger;
import static java.lang.Integer.parseInt;

public class project2 {


  

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "/Users/aygunaliyeva/Desktop/browsers/chromedriver");
        WebDriver driver = new ChromeDriver();

        //Navigate
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        Thread.sleep(1000);

        // Login using username Tester and password test
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        Thread.sleep(1000);

        //Click on Login and Order link
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@href='Process.aspx']")).click();
        Thread.sleep(2000);

        //  Enter a random product quantity between 1 and 100
        int random = (int) ((int) 1 + (Math.random() * 100));
        int unit = 100;
        double total = 0.0;

        //delete 0
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys(Keys.DELETE);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys(Keys.chord("" + random));
        if (random > 10)
            total = random * unit * 0.92;
        else
            total = random * unit;


        // Click on Calculate and verify that the Total value is correct.
        WebElement total1 = driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtTotal"));
        total1.sendKeys("" + total);
        Thread.sleep(2000);


        //returns the value
        System.out.println(driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtTotal")).getAttribute("value"));


        // Enter Customer Name:
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String firstName = "";
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            char c = alphabet.charAt(rand.nextInt(26));
            firstName += c;
        }
        firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);

        // Enter Customer LastName:
        String alphabet2 = "abcdefghijklmnopqrstuvwxyz";
        String lastName = "";
        Random rand2 = new Random();
        for (int i = 0; i < 5; i++) {
            char c = alphabet.charAt(rand.nextInt(26));
            lastName += c;
        }
        lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys(Keys.chord(firstName + " " + lastName));
        Thread.sleep(2000);


        // Enter street:
        String numbers = "0123456789";
        String street = "";
        for (int i = 0; i < 5; i++) {
            char num = numbers.charAt(rand.nextInt(4));
            street += num;
        }

        // Enter address:
        String alphabet3 = "abcdefghijklmnopqrstuvwxyz";
        String streetAd = "";
        Random rand3 = new Random();
        for (int i = 0; i < 8; i++) {
            char c = alphabet.charAt(rand.nextInt(26));
            streetAd += c;
        }
        streetAd = streetAd.substring(0, 1).toUpperCase() + streetAd.substring(1);

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys(Keys.chord(street + " " + streetAd));
        Thread.sleep(2000);


        // Enter City:
        List<String> city = new ArrayList();
        city.add("Dallas");
        city.add("New York");
        city.add("San Francisco");
        city.add("Key West");
        ArrayList newCity = new ArrayList();

        int a = (int) (1 + Math.random() * city.size());
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys(Keys.chord(city.get(a)));
        Thread.sleep(2000);


        // Enter State:
        List<String> state = new ArrayList();
        state.add("Texas");
        state.add("New York");
        state.add("California");
        state.add("Florida");
        ArrayList newState = new ArrayList();

        int b = (int) (1 + Math.random() * state.size());
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys(Keys.chord(state.get(b)));
        Thread.sleep(2000);


        // Enter Zip code:
        String numbers1 = "0123456789";
        String zipCode = "";
        for (int i = 0; i < 5; i++) {
            char zip = numbers1.charAt(rand.nextInt(10));
            zipCode += zip;
        }
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(Keys.chord(zipCode));
        Thread.sleep(2000);


        // Enter any card number:
        WebElement visa = driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0"));
        WebElement masterCard = driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_1"));
        WebElement americanExpress = driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_2"));
        String num = "abc";
        char c = num.charAt(rand.nextInt(3));
        if (c == 'a')
            visa.click();
        else if (c == 'b')
            masterCard.click();
        else if (c == 'c')
            americanExpress.click();
        Thread.sleep(2000);


        // If you selected Visa 16 numbers:
        if (visa.isSelected()) {
            long visaNumber = 4000000000000000L + (long) (Math.random() * 1000000000000000L);
            driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(Keys.chord("" + visaNumber));
        }
        //  If you selected Master 16 numbers:
        else if (masterCard.isSelected()) {
            long mastercardNumber = 5000000000000000L + (long) (Math.random() * 1000000000000000L);
            driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(Keys.chord("" + mastercardNumber));
        }
        // If you selected American Express 15 numbers:
        else if (americanExpress.isSelected()) {
            long americanExpressNumber = 300000000000000L + (long) (Math.random() * 100000000000000L);
            driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(Keys.chord("" + americanExpressNumber));
        }
        Thread.sleep(2000);


        // Enter a valid expiration date:
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys(Keys.chord("12/26"));
        Thread.sleep(2000);

        // Click on Process:
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
        Thread.sleep(2000);

        // Verify that “New order has been successfully added” message appeared on the page.
        String expected = driver.findElement(By.xpath("//strong")).getText();
        String actual1 = "New order has been successfully added.";
        assertEquals(expected, actual1);
        Thread.sleep(2000);

        // Log out of the application:
        driver.findElement(By.id("ctl00_logout")).click();
        Thread.sleep(2000);
           driver.quit();
    }

   
        public static void assertEquals(String expected, String actual) throws InterruptedException {

            if (actual.equals(expected)) {
                System.out.println("Passed");
            } else {
                System.out.println("Failed \n" +
                        "Expected: " + expected + "\n" +
                        "Actual: " + actual);
            }

        }
}