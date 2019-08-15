package com.example.rediscrud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("persons")
public class Person {

    @Id
    private String id;

    private String firstName;
    private String lastName;

    private Gender gender;

    @Indexed
    private UUID jobId;

}
