# vizsgaremek-fa-260117-2


**Készítette:** Freud Andrea

**Tesztelt webalkalmazás:**  [LambdaTest E-Commerce Playground](https://ecommerce-playground.lambdatest.io/)

**Teszt környezet:** Chrome böngésző; 1920×1080; internet hozzáférés

Futtatás:
linux-on és macOS-en: `./mvnw clean test`

windows-on: `mvnw clean test`

# Tech Stack

- Java 21;
- Maven;
- JUnit 5;
- Selenium WebDriver a UI tesztek készítéséhez;
- Page Object Model tervezési minta;
- Log4j a naplózáshoz (mentési helye: target/logs/test-execution.log);
- Git/GitHub a verziókezeléshez
- GitHub Actions a tesztek CI-környezetben történő futtatásához

# Jelentés letöltése

Az jelentés megtalálható a GitHub-on az Actions fülön, ha az adott workflow-ra kattintunk lejebb görgetünk az Artifacts részen letölthető a `surfire-reports` egy zip-ben. 

Valamint offline a tesztek futtatása után a target mappában is megtalálható a `surefire-reports`.
