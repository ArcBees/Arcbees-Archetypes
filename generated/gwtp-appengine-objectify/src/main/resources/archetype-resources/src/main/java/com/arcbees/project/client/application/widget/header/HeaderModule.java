#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package com.arcbees.project.client.application.widget.header;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class HeaderModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenterWidget(HeaderPresenter.class, HeaderPresenter.MyView.class, HeaderView.class);
    }
}
