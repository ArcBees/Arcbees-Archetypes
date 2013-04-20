#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.server.service;

import java.util.List;

import ${package}.server.business.MyEntity;

public interface MyService {
    void create(MyEntity entity);

    void delete(MyEntity entity);

    List<MyEntity> loadAll(String searchToken);
}
