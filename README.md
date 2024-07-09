# Training project to automate test scenarios for the company's website [fundraiseup.com](https://fundraiseup.com/)

---

<a href="https://fundraiseup.com/"><img src="https://img.hhcdn.ru/employer-logo/3261637.png"/></a>

---

## Content:

- <a href="#tools">Tools and technologies</a>
- <a href="#scenarios">Test scenarios</a>
- <a href="#jenkins">CI/CD with Jenkins</a>
- <a href="#cli">Launch from the CLI</a>
- <a href="#allure">Allure reporting</a>
- <a href="#allure-testops">Integration with Allure TestOps</a>
- <a href="#jira">Integration with JIRA</a>
- <a href="#telegram">Bot notifications in Telegram</a>
- <a href="#video">Examples of test execution</a>


<a id="tools"></a>
## Tools and technologies:
<p align="center">
<a href="https://www.jetbrains.com/idea/"><img src="./media/logo/Idea.svg" width="50" height="50"  alt="IDEA"/></a>  
<a href="https://www.java.com/"><img src="./media/logo/java.svg" width="50" height="50"  alt="Java"/></a>  
<a href="https://github.com/"><img src="./media/logo/github.svg" width="50" height="50"  alt="Github"/></a>  
<a href="https://junit.org/junit5/"><img src="./media/logo/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a>  
<a href="https://gradle.org/"><img src="./media/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>  
<a href="https://selenide.org/"><img src="./media/logo/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>  
<a href="https://aerokube.com/selenoid/"><img src="./media/logo/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>  
<a href="https://rest-assured.io/"><img alt="RestAssured" height="50" src="./media/logo/RestAssured.svg" width="50"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="./media/logo/Allure.svg" width="50" height="50"  alt="Allure"/></a>
<a href="https://qameta.io/"><img src="./media/logo/AllureTestOps.svg" width="50" height="50"  alt="Allure TestOps"/></a>   
<a href="https://www.jenkins.io/"><img src="./media/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>  
<a href="https://www.atlassian.com/ru/software/jira/"><img src="./media/logo/JIRA.svg" width="50" height="50"  alt="Jira"/></a>
</p>

<a id="scenarios"></a>
## Test Scenarios
## UI
* [x] Open contact sales page and check title and talk to sales button
* [x] Open features page and check title and explore campaign link
* [x] Check error message with unsuccessful login attempt
* [x] Check FAQ text display on campaign pages page
* [x] Check that number of languages in header corresponds to number of icons
* [x] Check that successful PayPal recurring request message equals to expected
* [x] Check opening checkout widget window
## API
* [x] Making unsuccessful login request without CSRF token
* [x] Making request to subscribe product updates
* [x] Making request to PayPal recurring
## Manual
* [x] Checking the subscription for product updates
* [x] Checking the opening of donor portal demo page
* [x] Opening the job response page

<a id="jenkins"></a>
## <img alt="Jenkins" height="25" src="./media/logo/Jenkins.svg" width="25"/></a><a name="CI/CD with Jenkins"></a>CI/CD with [Jenkins](https://jenkins.autotests.cloud/job/26-merkuzio88-automacon/)</a>
<img alt="Jenkins" src="./media/reports/jenkins.jpg"> 

### Jenkins parameters:

- `TASK` (`ui_tests` or `api_tests`)
- `BROWSER` (browser, `chrome` by default)
- `BROWSER_VERSION` (version of browser, `122` by default)
- `BROWSER_SIZE` (browser windows size, `1920x1080` by default)
- `WD_HOST` (data of remote Selenoid server)

<a id="cli"></a>
## <img alt="cli" height="25" src="./media/logo/run.png" width="25"> Launch from the CLI

**Local launch:**
```bash  
./gradlew clean ui_tests
```

**Remote Jenkins launch:**
```bash  
clean ${TASK} -Dbrowser=${BROWSER} -DbrowserVersion=${BROWSER_VERSION} -DbrowserSize=${BROWSER_SIZE} -DwdHost=${WD_HOST}
```

<a id="allure"></a>
## <img alt="Allure" height="25" src="./media/logo/Allure.svg" width="25"/></a> <a name="Allure"></a>Allure [reporting](https://jenkins.autotests.cloud/job/26-merkuzio88-automacon/allure/)</a>
<img alt="Allure" src="./media/reports/AllureReportExample.jpg"> 

`Allure` report includes:
- Test steps
- Screenshot of the page at the last step
- Page Source
- Browser console logs
- Video of execution for automated tests

<img alt="Allure2" src="./media/reports/AllureReportExample2.jpg">

<a id="allure-testops"></a>
## <img alt="Allure" height="25" src="./media/logo/AllureTestOps.svg" width="25"/></a> Integration with <a target="_blank" href="https://allure.autotests.cloud/project/4210/dashboards">Allure TestOps</a>

All test cases and execution results are available in `Allure TestOps`. Dashboard contains test runs statistics:
<img alt="Dashboard" src="./media/reports/Dashboard.jpg">

Test cases:
<img alt="Cases" src="./media/reports/Cases.jpg">

Launches:
<img alt="Launch" src="./media/reports/Launches.jpg">



<a id="jira"></a>
## <img alt="Jira" height="25" src="./media/logo/JIRA.svg" width="25"/></a> Integration with <a target="_blank" href="https://jira.autotests.cloud/browse/HOMEWORK-1208">Jira</a>

`Jira` task has information about all created test cases, their statuses and test launches results from `Allure TestOps`:

<img alt="JIRA" src="./media/reports/Jira.jpg">

<a id="telegram"></a>
## <img alt="Telegram" height="25" src="./media/logo/Telegram.svg" width="25"/></a> Bot notifications in Telegram
After every build Telegram bot sends notification with `Allure` report:

<img alt="Bot" src="./media/reports/Bot.jpg"> 

<a id="video"></a>
## <img alt="Selenoid" height="25" src="./media/logo/Selenoid.svg" width="25"/></a> Example of test execution
<img alt="Video" src="./media/video/example.gif"> 
