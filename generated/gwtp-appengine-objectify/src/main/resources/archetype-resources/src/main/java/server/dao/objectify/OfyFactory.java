#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.server.dao.objectify;

import static ${package}.server.dao.objectify.OfyService.ofy;

import com.googlecode.objectify.ObjectifyFactory;

public class OfyFactory extends ObjectifyFactory {
    public OfyFactory() {
    }

    @Override
    public Ofy begin() {
        return new Ofy(ofy());
    }
}
