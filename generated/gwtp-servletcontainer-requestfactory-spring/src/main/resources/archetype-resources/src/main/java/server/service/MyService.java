#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package}.server.business.MyEntity;

public interface MyService {
    void create(MyEntity entity);

    void delete(MyEntity entity);

    List<MyEntity> loadAll(String searchToken);
}
