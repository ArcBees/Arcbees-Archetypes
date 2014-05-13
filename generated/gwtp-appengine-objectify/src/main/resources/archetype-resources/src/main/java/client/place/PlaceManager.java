#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.place;

import javax.inject.Inject;

import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.annotations.DefaultPlace;
import com.gwtplatform.mvp.client.proxy.PlaceManagerImpl;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import com.gwtplatform.mvp.shared.proxy.TokenFormatter;

public class PlaceManager extends PlaceManagerImpl {
    private final PlaceRequest defaultPlaceRequest;

    @Inject
    PlaceManager(EventBus eventBus,
                 TokenFormatter tokenFormatter,
                 @DefaultPlace String defaultPlaceNameToken) {
        super(eventBus, tokenFormatter);

        this.defaultPlaceRequest = new PlaceRequest.Builder()
                .nameToken(defaultPlaceNameToken)
                .build();
    }

    @Override
    public void revealDefaultPlace() {
        revealPlace(defaultPlaceRequest, false);
    }
}
