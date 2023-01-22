package com.micro.service.userservice.web.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.micro.service.userservice.web.model.UserTransaction;

import java.util.List;

@Repository
public class UserTransactionRepo {
    public static final String HASH_KEY_NAME = "MENU-ITEM";
    @Autowired
    private RedisTemplate redisTemplate;


    public UserTransaction save(UserTransaction userTransaction){
        redisTemplate.opsForHash().put(HASH_KEY_NAME,userTransaction.getId(),userTransaction);
        return userTransaction;
    }

    public List<UserTransaction> findAll(){
        return redisTemplate.opsForHash().values(HASH_KEY_NAME);
    }

    public UserTransaction findItemById(int id){
        return (UserTransaction) redisTemplate.opsForHash().get(HASH_KEY_NAME,id);
    }


    public String deleteUserTransaction(int id){
        redisTemplate.opsForHash().delete(HASH_KEY_NAME,id);
        return "UserTransaction deleted successfully !!";
    }
}
