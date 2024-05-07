package com.aston.frontendpracticeservice.domain.entity;

import com.aston.frontendpracticeservice.security.Role;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {


    /**
     * id.
     */

    @Id
    @UuidGenerator
    @Column(name = "id", nullable = false)
    private UUID id;


    /**
     * Имя клиента, пример: Иван.
     */

    @Column(name = "first_name", nullable = false)
    private String firstName;

    /**
     * Фамилия клиента, пример: Иванов.
     */

    @Column(name = "last_name", nullable = false)
    private String lastName;

    /**
     * Дата рождения, формат: ГГГГ.ММ.ДД
     */

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    /**
     * Номер паспорта.
     */

    @Column(name = "passport_number", nullable = false, unique = true)
    private Integer passportNumber;

    /**
     * Логин пользователя.
     */

    @Column(name = "login", nullable = false, unique = true)
    private String login;

    /**
     * Пароль пользователя.
     */

    @Column(name = "password", nullable = false)
    private String password;

    /**
     * СНИЛС, пример: 123-456-789 12.
     */

    @Column(name = "snils", length = 11, unique = true)
    private String snils;

    /**
     * Коллекция ролей пользователя.
     */
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @JsonBackReference
    @EqualsAndHashCode.Exclude
    private Requisites requisites;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(getId(),
                user.getId()) && Objects.equals(getSnils(),
                user.getSnils());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSnils());
    }
}
