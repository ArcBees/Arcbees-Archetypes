#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.shared.dispatch;

import com.gwtplatform.dispatch.shared.UnsecuredActionImpl;

public class FetchCurrentUserAction extends UnsecuredActionImpl<FetchCurrentUserResult> {
    public FetchCurrentUserAction() {
    }
}
