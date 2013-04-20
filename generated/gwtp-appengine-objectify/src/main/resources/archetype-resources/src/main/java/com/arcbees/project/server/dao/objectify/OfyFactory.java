#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package com.arcbees.project.server.dao.objectify;

import static com.arcbees.project.server.dao.objectify.OfyService.ofy;

import com.googlecode.objectify.ObjectifyFactory;

public class OfyFactory extends ObjectifyFactory {
    public OfyFactory() {
    }

    @Override
    public Ofy begin() {
        return new Ofy(ofy());
    }
}
