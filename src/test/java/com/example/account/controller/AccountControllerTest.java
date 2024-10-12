package com.example.account.controller;

import com.example.account.service.AccountService;
import com.example.account.service.RedisTestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

@WebMvcTest(AccountController.class)
class AccountControllerTest {
     @MockBean
    private AccountService accountService;

     @MockBean
    private RedisTestService redisTestService;

     @Autowired
     private MockMvc mockMvc;

     @Test
     void successGetAccount() {
         //given
         given(accountService.getAccount(anyLong()))
                 .willReturn(Account);
         //when
         //then
     }
}