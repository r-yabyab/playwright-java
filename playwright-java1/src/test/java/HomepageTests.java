import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

//@UsePlaywright
public class HomepageTests {

    private static Page page;

    @BeforeAll
    static void setup() {
        PlaywrightUtils.setUp();
        page = PlaywrightUtils.createPage();
    }

//    @BeforeEach
//    void setUp() {
//        page = PlaywrightUtils.createPage();
//    }
//
//    @AfterEach
//    void tearDownEach() {
//        if (page != null) {
//            page.close();
//        }
//    }

    @AfterAll
    static void tearDownClass() {
        PlaywrightUtils.tearDown();
    }


    @Test
    @DisplayName("Add to Cart and Remove from Cart")
    void test() {
        // Navigate and login
        page.navigate("https://www.saucedemo.com/");
        page.locator("[data-test=\"username\"]").fill("standard_user");
        page.locator("[data-test=\"password\"]").fill("secret_sauce");
        page.locator("[data-test=\"login-button\"]").click();

        // Add Sauce Labs Fleece Jacket to cart
        page.locator("[data-test=\"add-to-cart-sauce-labs-fleece-jacket\"]").click();

        // Go to cart
        page.locator("[data-test=\"shopping-cart-link\"]").click();

        // Verify item is in cart
        Locator itemQuantity = page.locator("[data-test=\"item-quantity\"]");
        assertThat(itemQuantity).isVisible();
        assertThat(itemQuantity).containsText("1");
//        // Go back to cart and remove item
//        page.locator("[data-test=\"shopping-cart-link\"]").click();
//        page.locator("[data-test=\"remove-sauce-labs-fleece-jacket\"]").click();

//        // Verify cart is empty
//        assertThat(page.locator("[data-test=\"cart-list\"]")).isEmpty();
    }
    @Test
    void itemTest() {
        page.locator("[data-test=\"item-5-title-link\"]").click();
        assertThat(page.locator("[data-test=\"inventory-item-name\"]")).containsText("Sauce Labs Fleece Jacket");
    }


}
