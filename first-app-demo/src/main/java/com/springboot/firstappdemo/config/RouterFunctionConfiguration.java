package com.springboot.firstappdemo.config;

import com.springboot.firstappdemo.domain.User;
import com.springboot.firstappdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import java.util.Collection;

/**
 * configuration java版的xml
 * web flux
 *
 */
@Configuration
public class RouterFunctionConfiguration {

    /**
     * servlet 请求接口：ServletRequest 或者 HttpServletRequest
     *  响应接口：ServletResponse 或者 HttpServletResponse
     *  Spring 5.0 重新定义了服务请求和响应接口；
     *  请求接口：ServletRequest
     *  响应接口：ServletResponse
     *  即可支持Servlet规范，也可以支持自定义，比如Netty（web server）
     *  Flux 是 0-N个对象集合
     *  Mono 是 0-1个对象集合
     *  Reactive 中的Flux或者Mono它是异步处理（非阻塞）
     *  集合对象基本上是同步处理（阻塞）
     *  Flux 或者Mono都是publisher
     *
     */

    @Bean
    @Autowired
    public RouterFunction<ServerResponse> personFindAll(UserRepository userRepository){
        return RouterFunctions.route(RequestPredicates.GET("/person/find/all"),
                request ->{
                    Collection<User> users = userRepository.findAll();
                    Flux<User> userFlux = Flux.fromIterable(users);
                    return ServerResponse.ok().body(userFlux,User.class);
                });
    }

}
