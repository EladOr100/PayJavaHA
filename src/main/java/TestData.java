import org.json.simple.JSONObject;

public class TestData {
    String bookId;
    String url;
    String addBookID;
    JSONObject jsonBodyData;

    public TestData() {
        bookId = "7";
        jsonBodyData = new JSONObject();
        jsonBodyData.put("id", 5);
        jsonBodyData.put("title", "string");
        jsonBodyData.put("description", "string");
        jsonBodyData.put("pageCount", 0);
        jsonBodyData.put("publishDate", "2021-08-09T18:41:33.850Z");
    }

    public TestData(String pageUrl, String bookId, String title, String description, int pageCount, String publishDate) {
        url = pageUrl;
        addBookID = bookId;
        jsonBodyData = new JSONObject();
        jsonBodyData.put("id", addBookID);
        jsonBodyData.put("title", title);
        jsonBodyData.put("description", description);
        jsonBodyData.put("pageCount", pageCount);
        jsonBodyData.put("publishDate", publishDate);
    }

}
