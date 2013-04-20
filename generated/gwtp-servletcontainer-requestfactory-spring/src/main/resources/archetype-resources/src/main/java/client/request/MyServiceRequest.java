#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.request;

import ${package}.client.request.proxy.MyEntityProxy;
import ${package}.server.service.impl.MyServiceImpl;
import ${package}.server.util.SpringServiceLocator;
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
