#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package}.server.util.SpringServiceLocator;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

import java.util.List;

@Service(value = MyServiceImpl.class, locator = SpringServiceLocator.class)
public interface MyServiceRequest extends RequestContext {
    abstract Request<Void> create(MyEntityProxy entity);

    abstract Request<Void> delete(MyEntityProxy entity);

    abstract Request<List<MyEntityProxy>> loadAll(String searchToken);
}
