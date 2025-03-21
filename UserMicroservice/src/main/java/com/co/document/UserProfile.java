package com.co.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class UserProfile {

    @Id
    private String id;

    private Long authId;

    private String username;

    private String name;

    private String surname;

    private String email;
}

