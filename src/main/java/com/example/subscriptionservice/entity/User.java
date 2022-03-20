package com.example.subscriptionservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "User")
@Table(name = "`user`")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "userIdSeq", sequenceName = "user_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userIdSeq")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "telegram_usernmae")
    private String telegramUsername;

    @Column(name = "email")
    private String email;

    @Column(name = "telegram_id")
    private String telegramId;

    @Column(name = "phone")
    private String phone;

    @ManyToMany
    @JoinTable(
            name = "subscribed_user_shop",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name = "shop_id", referencedColumnName="id"))
    List<Shop> subscribedShops;
}

