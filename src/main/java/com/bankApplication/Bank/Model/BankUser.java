package com.bankApplication.Bank.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "BankUser")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long AccountNumber;

    @Column(nullable = false)
    @NotBlank(message = "User Name is required ")
    private String UserName;
    @Column(nullable = false)
    @NotBlank(message = "Invalid Location ")
    private String Location;
    @Column(nullable = false,unique = true)
    @Email(message = "Email should be valid ")
    @NotBlank(message = "Email is required")
    private String Email;
}
