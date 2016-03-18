/**
 * 
 */
package me.impressione.learn.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

/**
 * @author Guilherme Willian de Oliveira
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, features="classpath:funcionalidades", snippets=SnippetType.CAMELCASE, plugin = {"pretty", "html:target/cucumber"})
public class RunCukesTest {

}
