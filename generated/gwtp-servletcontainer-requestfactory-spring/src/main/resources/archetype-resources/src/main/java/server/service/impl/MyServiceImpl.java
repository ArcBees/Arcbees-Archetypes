#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ${package}.server.business.MyEntity;
import ${package}.server.repos.MyEntityRepo;
import ${package}.server.service.MyService;

import java.util.List;

@Service("myService")
@Transactional
public class MyServiceImpl implements MyService {
    @Autowired
    private MyEntityRepo myEntityRepo;

    @Override
    public void create(MyEntity entity) {
        myEntityRepo.save(entity);
    }

    @Override
    public void delete(MyEntity entity) {
        myEntityRepo.delete(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MyEntity> loadAll(String searchToken) {
        String token = searchToken + "%";
        return myEntityRepo.findByFirstNameLikeOrLastNameLike(token, token);
    }
}
