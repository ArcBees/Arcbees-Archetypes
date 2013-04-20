#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package com.arcbees.project.client.application;

import com.arcbees.project.client.application.widget.header.HeaderPresenter;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;

public class ApplicationPresenter extends Presenter<ApplicationPresenter.MyView, ApplicationPresenter.MyProxy> {
    public interface MyView extends View {
    }

    @ContentSlot
    public static final Type<RevealContentHandler<?>> TYPE_SetMainContent = new Type<RevealContentHandler<?>>();

    public static final Object TYPE_HeaderPresenter = new Object();

    private HeaderPresenter headerPresenter;

    @ProxyStandard
    public interface MyProxy extends Proxy<ApplicationPresenter> {
    }

    @Inject
    public ApplicationPresenter(final EventBus eventBus, final MyView view, final MyProxy proxy,
            final HeaderPresenter headerPresenter) {
        super(eventBus, view, proxy, RevealType.Root);

        this.headerPresenter = headerPresenter;
    }

    @Override
    protected void onBind() {
        super.onBind();

        setInSlot(TYPE_HeaderPresenter, headerPresenter);
    }
}
