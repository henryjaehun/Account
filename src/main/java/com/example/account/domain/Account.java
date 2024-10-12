package com.example.account.domain;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder //빌더를 쓰려면 노아규랑 얼아규가 있어야함
@Entity //일종의 설정 클래스
public class Account { //Account 라는 테이블
    @Id
    @GeneratedValue
    private Long id;
    //id를 Account PK(primary key)로 쓸것이다

    private String accountNumber;

    @Enumerated(EnumType.STRING) //Enum값에 실제 문자의 이름을 그대로 저장함
    private AccountStatus accountStatus;
}
