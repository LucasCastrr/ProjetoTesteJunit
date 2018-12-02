package br.upf.ads.testejpa.teste;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteAutomatizados {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
      driver = new ChromeDriver();  
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testEAutomatizados() throws Exception {
    driver.get("http://localhost:8080/TesteWeb/faces/Sistema/Home/Home.xhtml");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cadastros'])[2]/following::span[1]")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | index=0 | ]]
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Incluir Categoria'])[1]/preceding::span[1]")).click();
    driver.findElement(By.id("j_idt5:j_idt9")).click();
    driver.findElement(By.id("j_idt5:j_idt9")).clear();
    driver.findElement(By.id("j_idt5:j_idt9")).sendKeys("2");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Descrição'])[1]/following::td[1]")).click();
    driver.findElement(By.id("j_idt5:j_idt11")).click();
    driver.findElement(By.id("j_idt5:j_idt11")).clear();
    driver.findElement(By.id("j_idt5:j_idt11")).sendKeys("Ciencias Exatas");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Descrição'])[1]/following::span[2]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Filter by Descricoa'])[1]/following::td[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Incluir Categoria'])[1]/following::span[2]")).click();
    driver.findElement(By.id("j_idt5:j_idt11")).click();
    driver.findElement(By.id("j_idt5:j_idt11")).clear();
    driver.findElement(By.id("j_idt5:j_idt11")).sendKeys("Ciencias");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Descrição'])[1]/following::span[2]")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | relative=parent | ]]
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Manter Categorias'])[1]/following::span[1]")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | index=0 | ]]
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Incluir Disciplina'])[1]/preceding::span[1]")).click();
    driver.findElement(By.id("j_idt5:j_idt9")).click();
    driver.findElement(By.id("j_idt5:j_idt9")).clear();
    driver.findElement(By.id("j_idt5:j_idt9")).sendKeys("2");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Descricão'])[1]/following::td[1]")).click();
    driver.findElement(By.id("j_idt5:j_idt11")).click();
    driver.findElement(By.id("j_idt5:j_idt11")).clear();
    driver.findElement(By.id("j_idt5:j_idt11")).sendKeys("Matematica");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Descricão'])[1]/following::span[2]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Filter by Descricoa'])[1]/following::td[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Incluir Disciplina'])[1]/following::span[2]")).click();
    driver.findElement(By.id("j_idt5:j_idt11")).click();
    driver.findElement(By.id("j_idt5:j_idt11")).clear();
    driver.findElement(By.id("j_idt5:j_idt11")).sendKeys("Portugues");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Descricão'])[1]/following::span[2]")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | relative=parent | ]]
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Manter Disciplina'])[1]/following::span[1]")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | index=0 | ]]
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Alterar Conteudo'])[1]/preceding::span[2]")).click();
    driver.findElement(By.id("formEditar:j_idt8")).click();
    driver.findElement(By.id("formEditar:j_idt8")).clear();
    driver.findElement(By.id("formEditar:j_idt8")).sendKeys("1");
    driver.findElement(By.id("formEditar:j_idt10")).click();
    driver.findElement(By.id("formEditar:j_idt10")).clear();
    driver.findElement(By.id("formEditar:j_idt10")).sendKeys("titulo1");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Texto'])[1]/following::div[4]")).click();
    // ERROR: Caught exception [unknown command [editContent]]
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Categoria'])[1]/following::span[2]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cancelar'])[1]/following::li[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Disciplina'])[1]/following::span[2]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Ciencias'])[1]/following::li[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Disciplina'])[1]/following::span[6]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Filter by Disciplina'])[1]/following::td[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Incluir Conteudo'])[1]/following::span[2]")).click();
    driver.findElement(By.id("formEditar:j_idt10")).click();
    driver.findElement(By.id("formEditar:j_idt10")).clear();
    driver.findElement(By.id("formEditar:j_idt10")).sendKeys("titulo2");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Texto'])[1]/following::p[1]")).click();
    // ERROR: Caught exception [unknown command [editContent]]
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Disciplina'])[1]/following::span[6]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Filter by Disciplina'])[1]/following::td[1]")).click();
    acceptNextAlert = true;
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Alterar Conteudo'])[1]/following::span[2]")).click();
    assertTrue(closeAlertAndGetItsText().matches("^Confirma exclusão[\\s\\S]$"));
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | relative=parent | ]]
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Manter Categorias'])[1]/following::span[1]")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | index=0 | ]]
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Filter by Descricoa'])[1]/following::td[1]")).click();
    acceptNextAlert = true;
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Alterar Disciplina'])[1]/following::span[2]")).click();
    assertTrue(closeAlertAndGetItsText().matches("^Confirma exclusão[\\s\\S]$"));
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | relative=parent | ]]
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cadastros'])[2]/following::span[1]")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | index=0 | ]]
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Filter by Descricoa'])[1]/following::td[1]")).click();
    acceptNextAlert = true;
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Alterar Categoria'])[1]/following::span[2]")).click();
    assertTrue(closeAlertAndGetItsText().matches("^Confirma exclusão[\\s\\S]$"));
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
