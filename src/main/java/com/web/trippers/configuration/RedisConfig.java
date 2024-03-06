//package com.web.trippers.configuration;
//
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class RedisConfig {
//
//}


//package com.project.sns.configuration;
//
//        import com.project.sns.model.User;
//        import io.lettuce.core.RedisURI;
//        import lombok.RequiredArgsConstructor;
//        import lombok.extern.slf4j.Slf4j;
//        import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
//        import org.springframework.context.annotation.Bean;
//        import org.springframework.context.annotation.Configuration;
//        import org.springframework.data.redis.connection.RedisConnectionFactory;
//        import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
//        import org.springframework.data.redis.core.RedisTemplate;
//        import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
//        import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//        import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//@Configuration
//@EnableRedisRepositories
//@RequiredArgsConstructor
//public class RedisConfiguration {
//
//    private final RedisProperties redisProperties; // 자동으로 만들어준다
//
//    @Bean
//    public RedisConnectionFactory redisConnectionFactory() {
//
////        RedisURI redisURI = RedisURI.create(redisProperties.getUrl());
////        org.springframework.data.redis.connection.RedisConfiguration configuration =
////                LettuceConnectionFactory.createRedisConfiguration(redisURI);
////
////        LettuceConnectionFactory factory = new LettuceConnectionFactory(redisProperties.getHost(), redisProperties.getPort());
////        factory.afterPropertiesSet();
//
////        return factory;
//
//        LettuceConnectionFactory factory = new LettuceConnectionFactory(redisProperties.getHost(), redisProperties.getPort());
//        factory.afterPropertiesSet();
//
//        return factory;
//    }
//
//    @Bean
//    public RedisTemplate<String, User> userRedisTemplate() {
//        RedisTemplate<String, User> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(redisConnectionFactory());
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<User>(User.class));
//        return redisTemplate;
//    }
//
//}
