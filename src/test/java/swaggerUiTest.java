
import book.BookFactory;
import book.IBook;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class swaggerUiTest {

    private static final String TEST_TYPE = "test.type";
    private static final String CONFIG_PATH = "src/main/resources/config.properties";
    private static IBook bookService;
    private static TestData testData;

    @BeforeAll
    static void setUpAll() {
        try {
            System.out.println("loading configuration");
            testData = new TestData();
            String path = new File(CONFIG_PATH).getAbsolutePath();
            InputStream input = new FileInputStream(path);
            // load a properties file
            Properties prop = new Properties();
            prop.load(input);

            System.out.println("Crate test type ");
            bookService = BookFactory.getBook(prop.getProperty(TEST_TYPE), prop);

        } catch (NullPointerException | FileNotFoundException ex) {
            System.out.println("FileNotFoundException");
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    @DisplayName("test Get book function by Id")
    void testGetBookFunc() {

        System.out.printf("search in the server book with %s id%n", testData.bookId);
        String res = bookService.getBookById(testData.bookId);
        if (res == null) {
            fail("empty response ");
        }
        assertEquals("200", res, "The response code is not valid");
    }

    @Test
    @DisplayName("test the add book function")
    void testAddBook() {
        System.out.println("Add new book to the server ");
        String res = bookService.addBook(testData.jsonBodyData);
        if (res == null) {
            fail("empty response ");
        }
        assertEquals("200", res, "The response code is not valid ");


    }

    @AfterAll
    static void tearDownClass() {
        bookService.dispose();
    }

}
