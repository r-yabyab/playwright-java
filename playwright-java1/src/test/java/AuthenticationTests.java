import com.microsoft.playwright.*;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.*;

//npx playwright codegen demo.playwright.dev/todomvc
//npx playwright codegen saucedemo.com

//@UsePlaywright
public class AuthenticationTests {
    private Page page;

    @BeforeAll
    static void setup() {
        PlaywrightUtils.setUp();
    }

    @BeforeEach
    void setUp() {
        page = PlaywrightUtils.createPage();
    }

    @AfterEach
    void tearDownEach() {
        if (page != null) {
            page.close();
        }
    }

    @AfterAll
    static void tearDownClass() {
        PlaywrightUtils.tearDown();
    }

    @Test
    @DisplayName("Invalid Login")
    void test() {
        page.navigate("https://www.saucedemo.com/");
        page.locator("[data-test=\"username\"]").click();
        page.locator("[data-test=\"username\"]").fill("standard_user1");
        page.locator("[data-test=\"username\"]").press("Tab");
        page.locator("[data-test=\"password\"]").fill("secret_sauce");
        page.locator("[data-test=\"login-button\"]").click();
        page.locator("[data-test=\"error\"]").click();
        String invalidLoginMessage = "Epic sadface: Username and password do not match any user in this service";
    }
}