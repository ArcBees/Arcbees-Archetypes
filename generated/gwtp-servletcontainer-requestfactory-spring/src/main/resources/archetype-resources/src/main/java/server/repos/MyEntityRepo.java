#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package}.server.business.MyEntity;

import java.util.List;

public interface MyEntityRepo extends JpaRepository<MyEntity, Long> {
    List<MyEntity> findByFirstNameLikeOrLastNameLike(String firstName, String lastName);
}
