import com.microsoft.playwright.*;

public class PlaywrightUtils {
    private static Playwright playwright;
    private static Browser browser;

    public static void setUp() {
        playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions()
                .setHeadless(false);
        browser = playwright.chromium().launch(launchOptions);
    }

    public static Page createPage() {
        if (browser == null) {
            setUp();
        }
        return browser.newPage();
    }

    public static void tearDown() {
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }
}