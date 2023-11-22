import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;
public class TestTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void test() {
    driver.get("http://localhost/mantisbt-2.26.0/login_page.php");
    driver.manage().window().setSize(new Dimension(1184, 784));

    driver.findElement(By.linkText("Signup for a new account")).click();
    driver.findElement(By.id("email-field")).click();
    driver.findElement(By.cssSelector("fieldset")).click();
    driver.findElement(By.id("email-field")).sendKeys("pmgtusbm@localhost");
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).sendKeys("pmgtusbm");
    driver.findElement(By.cssSelector(".width-40")).click();
  }
}
