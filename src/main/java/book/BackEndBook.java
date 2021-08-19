package book;

import Infra.HelpFunc;
import org.json.simple.JSONObject;
import java.io.IOException;
import java.util.Properties;

public class BackEndBook implements IBook {

    public static final String BASE_URL_POSTFIX = "api/v1/Books/";
    public static final String HOME_URL = "home.url";
    public static String BASE_URL = null;
    HelpFunc logic = new HelpFunc();

    public BackEndBook(Properties prop){
        BASE_URL = prop.getProperty(HOME_URL) + BASE_URL_POSTFIX;
    }

    @Override
    public String getBookById(String id) {
        System.out.println("Run BE test");

        try {
            return logic.sendGetRestRequest(String.format(BASE_URL + "%s", id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String addBook(JSONObject testData) {
        try {
            return logic.sendPostRequest(testData, BASE_URL);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void dispose() {

    }
}
