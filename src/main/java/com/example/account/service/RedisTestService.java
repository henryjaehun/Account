package com.example.account.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@RequiredArgsConstructor
public class RedisTestService {
    private final RedissonClient redissonClient;

    public String getLock() {
        RLock lock = redissonClient.getLock("sampleLock");
        //sampleLock 이라는 이름의 redissonClient 를 가져오고 (그걸로 spin lock 을 시도)

        try {
            boolean isLock = lock.tryLock(1, 5, TimeUnit.SECONDS);
            if (!isLock) {
                log.error("=========Lock acquisition failed========");
                return "Lock failed";
            }
        } catch (Exception e) {
            log.error("Redis lock failed");
        }


        return "Lock success";
    }
}
