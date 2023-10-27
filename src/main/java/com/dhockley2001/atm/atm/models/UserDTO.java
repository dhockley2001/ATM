package com.dhockley2001.atm.atm.models;

import java.util.Set;

import lombok.*;



@AllArgsConstructor
@ToString
@Getter
@Setter
@EqualsAndHashCode
public class UserDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String accountNumber;

    private Set<Account> accounts;

}
