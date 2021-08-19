package pages;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class HomePage {
    WebDriver driver;
    private final static String GET_BOOK_BY_ID_BUTTON = "#operations-Books-get_api_v1_Books__id_ >div>span";
    private final static String GET_TRY_IT_OUT_BUTTON = "#operations-Books-get_api_v1_Books__id_ button.btn.try-out__btn";
    private final static String GET_ID_TEXT_AREA =      "#operations-Books-get_api_v1_Books__id_ .parameters tr[data-param-name=\"id\"] .parameters-col_description input";
    private final static String GET_EXECUTE_BUTTON =    "#operations-Books-get_api_v1_Books__id_ .execute-wrapper button";
    private final static String GET_RESPONSE_CODE_UI =  "#operations-Books-get_api_v1_Books__id_ .responses-wrapper .responses-inner .responses-table tbody tr.response > .response-col_status";

    private final static String POST_BOOK_BUTTON =                  "#operations-Books-post_api_v1_Books span.opblock-summary-method";
    private final static String POST_TRY_IT_OUT_BUTTON =            "#operations-Books-post_api_v1_Books button.btn.try-out__btn";
    private final static String POST_REQUEST_BODY_JSON_TEXT_AREA =  "#operations-Books-post_api_v1_Books .opblock-section-request-body .opblock-description-wrapper textarea.body-param__text";
    private final static String POST_EXECUTE_BUTTON =               "#operations-Books-post_api_v1_Books .execute-wrapper button.btn.execute.opblock-control__btn";
    private final static String POST_GET_RESPONSE_CODE =            "#operations-Books-post_api_v1_Books .response .response-col_status";
    private final int WAITTIME =700;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    public void press_post_book_button(){
        driver.findElement(By.cssSelector(POST_BOOK_BUTTON)).click();
        try {
            Thread.sleep(WAITTIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void press_post_try_it_out_button(){
        driver.findElement(By.cssSelector(POST_TRY_IT_OUT_BUTTON)).click();
        try {
            Thread.sleep(WAITTIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void insert_post_request_body_json_text_area(JSONObject testData){
        driver.findElement(By.cssSelector(POST_REQUEST_BODY_JSON_TEXT_AREA)).clear();
        driver.findElement(By.cssSelector(POST_REQUEST_BODY_JSON_TEXT_AREA)).sendKeys(testData.toJSONString());
        try {
            Thread.sleep(WAITTIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void press_post_execute_button(){
        driver.findElement(By.cssSelector(POST_EXECUTE_BUTTON)).click();
        try {
            Thread.sleep(WAITTIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String post_get_response_code_from_ui() {
        try {
            Thread.sleep(WAITTIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.findElement(By.cssSelector(POST_GET_RESPONSE_CODE)).getText();

    }
//################################################################################

    public void press_get_book_by_id_button() {
        driver.findElement(By.cssSelector(GET_BOOK_BY_ID_BUTTON)).click();
        try {
            Thread.sleep(WAITTIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void press_get_try_it_out_button() {
        driver.findElement(By.cssSelector(GET_TRY_IT_OUT_BUTTON)).click();
        try {
            Thread.sleep(WAITTIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void set_text_to_get_id_text_area(Object id) {

        driver.findElement(By.cssSelector(GET_ID_TEXT_AREA)).clear();
        driver.findElement(By.cssSelector(GET_ID_TEXT_AREA)).sendKeys((String) id);
        try {
            Thread.sleep(WAITTIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void press_get_execute_button() {
        driver.findElement(By.cssSelector(GET_EXECUTE_BUTTON)).click();
        try {
            Thread.sleep(WAITTIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String get_response_code_from_ui() {
        try {
            Thread.sleep(WAITTIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.findElement(By.cssSelector(GET_RESPONSE_CODE_UI)).getText();

    }
}
