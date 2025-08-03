# 📱 SwagLabs Mobile Automation Framework (Appium + Java)<br/>


This project is a **mobile test automation framework** built to automate user journeys in the **SwagLabs mobile app** (`com.swaglabsmobileapp`).  
It covers a full **end-to-end test scenario** using **Appium**, **Selenium**, **TestNG**, **Allure Reports**, and follows **Page Object Model** with the **Fluent Interface Pattern**.  
Test data is managed using `.properties` and `.json` files for a clean **data-driven testing (DDT)** approach.<br/>


---

## ✅ Features

- 🔄 End-to-end user flow: Login → Product Selection → Checkout
- 📱 Appium-based mobile automation (Android)
- 🔧 Page Object Model with Fluent-style method chaining
- 🧪 TestNG support for test management
- 🗂️ DDT from `config.properties` and `testdata.json`
- 📜 Structured logging using Log4j2
- 📊 Beautiful reports via Allure TestNG integration
- 🧱 Modular project structure with Maven

---

## 📦 Technologies Used

| Tool         | Purpose                          |
|--------------|----------------------------------|
| Java         | Programming Language             |
| Appium       | Mobile automation                |
| Selenium     | WebDriver integration            |
| TestNG       | Test runner and assertions       |
| Maven        | Dependency management            |
| Allure       | Test reporting                   |
| Log4j2       | Logging                          |
| JSON         | Dynamic test data                |
| Properties   | Config values (device, app, etc) |

---

## 🧪 End-to-End Scenario – SwagLabs App<br/>

The implemented test simulates a real user purchasing a product:<br/>


1. Launch the SwagLabs app on Android device/emulator<br/>

2. Login using valid credentials from `testdata.json`<br/>

3. Add `"Sauce Labs Fleece Jacket"` to cart<br/>

4. Open `"Sauce Labs Onesie"` product page and add to cart<br/>

5. Assert total cart items = 2<br/>

6. Proceed to Cart → Checkout<br/>

7. Enter user details (fetched from JSON or dummy API)<br/>

8. Confirm and complete the purchase<br/>

9. Assert successful order message: ✅ `THANK YOU FOR YOU ORDER`<br/>


> ✅ Screenshots are captured on failure (optional)  <br/>

> 📊 Report is available in Allure after execution<br/>



