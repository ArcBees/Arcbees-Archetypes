package com.arcbees.project.client.gin;

import javax.inject.Inject;

import com.arcbees.project.client.dispatch.AsyncCallbackImpl;
import com.arcbees.project.shared.dispatch.FetchCurrentUserAction;
import com.arcbees.project.shared.dispatch.FetchCurrentUserResult;
import com.arcbees.project.shared.dto.CurrentUserDto;
import com.gwtplatform.dispatch.shared.DispatchAsync;
import com.gwtplatform.mvp.client.Bootstrapper;
import com.gwtplatform.mvp.client.proxy.PlaceManager;

public class BootstrapperImpl implements Bootstrapper {
    private final PlaceManager placeManager;
    private final DispatchAsync dispatcher;
    private final CurrentUserDto currentUserDto;

    @Inject
    public BootstrapperImpl(final PlaceManager placeManager, final DispatchAsync dispatcher,
            final CurrentUserDto currentUserDto) {
        this.placeManager = placeManager;
        this.dispatcher = dispatcher;
        this.currentUserDto = currentUserDto;
    }
    
    @Override
    public void onBootstrap() {
        fetchCurrentUser();
    }

    private void fetchCurrentUser() {
        dispatcher.execute(new FetchCurrentUserAction(), new AsyncCallbackImpl<FetchCurrentUserResult>() {
            @Override
            public void onSuccess(FetchCurrentUserResult result) {
                onFetchCurrentUserSuccess(result.getCurrentUser());
            }

            @Override
            public void onFailure(Throwable caught) {
                super.onFailure(caught);
                placeManager.revealCurrentPlace();
            }
        });
    }

    private void onFetchCurrentUserSuccess(CurrentUserDto currentUser) {
        currentUserDto.copyFrom(currentUser);
        
        placeManager.revealCurrentPlace();
    }
}
