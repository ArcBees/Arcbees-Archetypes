#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.application.home;

import ${package}.client.request.proxy.MyEntityProxy;
import com.gwtplatform.mvp.client.UiHandlers;

public interface HomeUiHandlers extends UiHandlers {
    void saveEntity(MyEntityProxy myEntity);
}
