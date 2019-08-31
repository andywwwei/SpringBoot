package com.springboot.firstappdemo.repository;

import com.springboot.firstappdemo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Administrator
 * {@link User} {@link Repository}
 */
@Repository
public class UserRepository {

    private final ConcurrentMap<Integer,User> repository =
            new ConcurrentHashMap<>();
    private final static AtomicInteger idGenerator =
            new AtomicInteger();

    /**
     * @param user {@link User}
     * @return
     */
    public boolean save(User user){
        boolean success = false;
        //主键自增
        Integer id = idGenerator.incrementAndGet();
        user.setId(id);
        return repository.put(id,user) == null;
    }


    public Collection<User> findAll(){
        return repository.values();
    }

}
