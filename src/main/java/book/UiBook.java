package book;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

import java.io.File;
import java.util.Properties;

import static java.lang.Thread.sleep;

public class UiBook implements IBook {
    public static final String DRIVER_CHROMEDRIVER_EXE = "driver/chromedriver.exe";
    public static final String HOME_URL = "home.url";
    WebDriver driver;
    HomePage homePage;


    public UiBook(Properties prop) {
        String path = new File(DRIVER_CHROMEDRIVER_EXE)
                .getAbsolutePath();
        // System Property for Chrome Driver
        System.setProperty("webdriver.chrome.driver", path);
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        driver.get(prop.getProperty(HOME_URL));
        //Maximize current window
        driver.manage().window().maximize();

    }

    @Override
    public String getBookById(String id) {
        System.out.println("###########Run getBookById test###########");
        homePage.press_get_book_by_id_button();
        homePage.press_get_try_it_out_button();
        homePage.set_text_to_get_id_text_area(id);
        homePage.press_get_execute_button();
        return homePage.get_response_code_from_ui();

    }

    @Override
    public String addBook(JSONObject testData) {
        System.out.println("###########Run addBook test###########");
        homePage.press_post_book_button();
        homePage.press_post_try_it_out_button();
        homePage.insert_post_request_body_json_text_area(testData);
        homePage.press_post_execute_button();
        return homePage.post_get_response_code_from_ui();

    }


    @Override
    public void dispose() {
        System.out.println("TEST UI ENDED");
        driver.close();
        driver.quit();
    }
}
