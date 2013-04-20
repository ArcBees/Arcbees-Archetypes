#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package}.server.business.MyEntity;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.google.web.bindery.requestfactory.shared.ValueProxy;

import java.util.Date;

@ProxyFor(value = MyEntity.class)
public interface MyEntityProxy extends ValueProxy {
    Long getId();

    void setId(Long id);

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    Date getCreated();

    void setCreated(Date created);
}
