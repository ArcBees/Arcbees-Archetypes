package ${package}.server.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import ${package}.server.business.MyEntity;


import java.util.List;

public interface MyEntityRepo extends JpaRepository<MyEntity, Long> {
    List<MyEntity> findByFirstNameLikeOrLastNameLike(String firstName, String lastName);
}
