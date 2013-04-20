#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package}.client.request;

import com.google.web.bindery.requestfactory.shared.RequestFactory;

public interface MyRequestFactory extends RequestFactory {
    MyServiceRequest myService();
}
