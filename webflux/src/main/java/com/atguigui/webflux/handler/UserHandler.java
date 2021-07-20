package com.atguigui.webflux.handler;

import com.atguigui.webflux.entity.User;
import com.atguigui.webflux.service.UserSerVice;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.servlet.function.EntityResponse.fromObject;

public class UserHandler {

    private final UserSerVice userService;

    public UserHandler(UserSerVice userService) {
        this.userService = userService;
    }

    // 根据id查询
    public Mono<ServerResponse> getUserById(ServerRequest request) {

        // 获取id
        int id = Integer.valueOf(request.pathVariable("id"));
        // 空值处理
        Mono<ServerResponse> notFound = (Mono<ServerResponse>)ServerResponse.notFound().build();

        // 调用方法
        Mono<User> userMono = this.userService.getUserById(id);

        // 把userMono进行转换并返回
        // 使用Reactor操作flatMap
        return userMono.flatMap(person -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)       // 包不一样导致报错  正确包：org.springframework.web.reactive.function.server
                .body(fromObject(person)))
                .switchIfEmpty(notFound);
    }

    // 查询所有
    public Mono<ServerResponse> getAllUser() {
        Flux<User> allUser = userService.getAllUser();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(allUser, User.class);
    }

    // 添加
    public Mono<ServerResponse> saveUser(ServerRequest request) {
        Mono<User> userMono = request.bodyToMono(User.class);
        return ServerResponse.ok().build()this.userService.saveUserInfo(userMono);
    }

}
