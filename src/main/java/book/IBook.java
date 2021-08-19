package book;

import org.json.simple.JSONObject;
import java.util.Properties;

public interface IBook extends IDisposable {
    String getBookById(String id);
    String addBook(JSONObject testData);
}
