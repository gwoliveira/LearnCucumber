/**
 * 
 */
package me.impressione.learn.cucumber;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

/**
 * @author Guilherme Willian de Oliveira
 *
 */
public class InserirModeloPassos {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Dado("^que estou na tela de incluir modelos$")
    public void queEstouNaTelaDeIncluirModelos() throws Throwable {
        driver.navigate().to("http://localhost:9000/");
    }

    @Dado("^preencho o campo Modelo com \"([^\"]*)\"$")
    public void preenchoOCampoModeloCom(String nomeModelo) throws Throwable {
        WebElement modeloInput = driver.findElement(By.cssSelector(".col-sm-11 > input:nth-child(1)"));
        modeloInput.sendKeys(nomeModelo);
    }

    @Dado("^preencho o campo Field com \"([^\"]*)\" do tipo \"([^\"]*)\" e requerido \"([^\"]*)\"$")
    public void preenchoOCampoFieldComDoTipoERequeridoTrue(String nome, String tipo, Boolean requerido)
        throws Throwable {
        WebElement ultimoDivField = driver.findElement(By.cssSelector("div.form-group:last-child"));
        WebElement nomeField = ultimoDivField.findElement(By.cssSelector("div:nth-child(1)>input"));
        WebElement tipoField = ultimoDivField.findElement(By.cssSelector("select.form-control"));
        WebElement requeridoField = ultimoDivField.findElement(By.cssSelector("input.ng-valid"));
        nomeField.sendKeys(nome);
        Select dropDown = new Select(tipoField);
        dropDown.selectByValue(tipo);
        if (requerido) {
            requeridoField.click();
        }
    }

    @Dado("^clico em novo campo$")
    public void clicoEmNovoCampo() throws Throwable {
        WebElement ultimoDivField = driver.findElement(By.cssSelector("div.form-group:last-child"));
        WebElement novoCampo = ultimoDivField.findElement(By.cssSelector(".btn-success"));
        novoCampo.click();
    }

    @Quando("^clico salvar$")
    public void clicoSalvar() throws Throwable {
        WebElement botaoSalvar = driver.findElement(By.cssSelector(".btn-primary"));
        botaoSalvar.click();
        Thread.sleep(1000);
    }

    @Então("^o modelo \"([^\"]*)\" é salvo$")
    public void oModeloÉSalvo(String nomeModelo) throws Throwable {
        WebElement modelos = driver.findElement(By.cssSelector(".list-group"));
        List<WebElement> links = modelos.findElements(By.tagName("a"));
        WebElement modelo = null;
        for (WebElement link : links) {
            if (nomeModelo.equals(link.getText())) {
                modelo = link;
            }
        }
        assertThat(modelo, notNullValue());
    }
    
    @Dado("^clico no modelo \"([^\"]*)\"$")
    public void clicoNoModelo(String nomeModelo) throws Throwable {
        WebElement modelos = driver.findElement(By.cssSelector(".list-group"));
        List<WebElement> links = modelos.findElements(By.tagName("a"));
        WebElement modelo = null;
        for (WebElement link : links) {
            if (nomeModelo.equals(link.getText())) {
                modelo = link;
            }
        }
        modelo.click();
    }
}
