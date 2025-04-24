package net.application.Banking.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Account")
public class Account {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="Customer_Name")
    private String accountHolderName;
    private Double balance;
}
