package com.atguigui.webflux.entity.impl;

import com.atguigui.webflux.entity.User;
import com.atguigui.webflux.service.UserSerVice;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserServiceImpl implements UserSerVice {

    // 创建map集合存储数据
    private final Map<Integer, User> users = new HashMap<>();
    public UserServiceImpl() {
        this.users.put(1, new User("lucy", "women", 30));
        this.users.put(2, new User("marry", "women", 20));
        this.users.put(3, new User("jack", "men", 22));
    }


    @Override
    public Mono<User> getUserById(int id) {
        return Mono.justOrEmpty(this.users.get(id));
    }

    @Override
    public Flux<User> getAllUser() {
        return Flux.fromIterable(this.users.values());
    }

    @Override
    public Mono<Void> saveUserInfo(Mono<User> userMono) {
        return userMono.doOnNext(person -> {
            // 向map集合中添加值
            int id = users.size() + 1;
            users.put(id, person);
        }).thenEmpty(Mono.empty());
    }
}
