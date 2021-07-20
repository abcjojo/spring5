package com.atguigui.webflux;

import com.atguigui.webflux.entity.User;
import org.springframework.http.MediaType;
import reactor.core.publisher.Flux;

public class Client {

    public static void main(String[] args) {

        // 调用服务器地址
        WebClient client = WebClient.create("http://127.0.0.1:5794");

        // 根据id查询
        User userresult = client.get().uri("/user/{id}", id)
                .accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(User.class)
                .block();

        System.out.println(userresult.getName());


        // 查询所有
        Flux<User> results = client.get().uri("/users")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(User.class);
        results.map(person -> person.getName()).buffer().doOnNext(System.out::println).blockFirst();
    }
}
