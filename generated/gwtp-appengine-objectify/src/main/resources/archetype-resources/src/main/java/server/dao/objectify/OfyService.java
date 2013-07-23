#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.server.dao.objectify;

import ${package}.shared.domain.Task;
import ${package}.shared.domain.User;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

/**
 * For use of: import static com.sceneverse.shozon.server.dao.objectify.OfyService.ofy;
 */
public class OfyService {
    static {
        factory().register(Task.class);
        factory().register(User.class);
    }

    public static Objectify ofy() {
        return ObjectifyService.ofy();
    }

    public static ObjectifyFactory factory() {
        return ObjectifyService.factory();
    }
}
