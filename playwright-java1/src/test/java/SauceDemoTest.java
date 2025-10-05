package org.example;

import com.microsoft.playwright.*;

public class SauceDemoTest {
    public static void main(String[] args) {

        System.out.println("this is from the test folder");

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            Page page = browser.newPage();
            page.navigate("https://playwright.dev");
            System.out.println(page.title());
        }
    }
}