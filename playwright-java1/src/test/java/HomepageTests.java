import com.microsoft.playwright.Locator;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.*;

import org.junit.jupiter.api.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

@UsePlaywright
public class HomepageTests {
    @Test
    @DisplayName("Add to Cart and Remove from Cart")
    void test(Page page) {
        page.locator("[data-test=\"username\"]").click();
        page.locator("[data-test=\"username\"]").fill("standard_user");
        page.locator("[data-test=\"username\"]").press("Tab");
        page.locator("[data-test=\"password\"]").fill("secret_sauce");
        page.locator("[data-test=\"password\"]").press("Enter");
        page.locator("[data-test=\"login-button\"]").click();
        page.locator("[data-test=\"inventory-list\"] div").filter(new Locator.FilterOptions().setHasText("Sauce Labs Fleece JacketIt's")).nth(1).click();
        page.locator("[data-test=\"add-to-cart-sauce-labs-fleece-jacket\"]").click();
        page.locator("[data-test=\"shopping-cart-link\"]").click();
        assertThat(page.locator("[data-test=\"item-quantity\"]")).isVisible();
        assertThat(page.locator("[data-test=\"item-quantity\"]")).containsText("1");
        page.locator("[data-test=\"item-5-title-link\"]").click();
        assertThat(page.locator("[data-test=\"inventory-item-name\"]")).containsText("Sauce Labs Fleece Jacket");
        assertThat(page.locator("[data-test=\"cart-list\"]")).isVisible();
        page.locator("[data-test=\"remove-sauce-labs-fleece-jacket\"]").click();
        assertThat(page.locator("[data-test=\"cart-list\"]")).isVisible();
    }
}