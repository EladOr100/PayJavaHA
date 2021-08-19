package book;

import java.util.Properties;

public class BookFactory {
    private static final String UI = "UI";
    private static final String BE = "BE";
    public static IBook getBook(String bookType ,Properties prop) throws Exception {
        if (bookType == null) {
            throw new Exception();
        }
        if (bookType.equalsIgnoreCase(UI)) {
            return new UiBook(prop);

        } else if (bookType.equalsIgnoreCase(BE)) {
            return new BackEndBook(prop);
        }

        throw new Exception();
    }
//    public IDisposable fo (){
//
//    }
}
