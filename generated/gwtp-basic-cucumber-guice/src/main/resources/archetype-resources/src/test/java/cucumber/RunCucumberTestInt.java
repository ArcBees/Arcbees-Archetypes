#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

/**
 * The cucumber features can be moved and located in src/test/resources same package. 
 */
@RunWith(Cucumber.class)
@Cucumber.Options(features = {"."})
public class RunCucumberTestInt {
}
