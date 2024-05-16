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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;


@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
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
    private String passportNumber;

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
    @JsonBackReference
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Requisites requisites;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(id, user.id) && Objects.equals(getSnils(), user.getSnils());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getSnils());
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSnils() {
        return snils;
    }

    public void setSnils(String snils) {
        this.snils = snils;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Requisites getRequisites() {
        return requisites;
    }

    public void setRequisites(Requisites requisites) {
        this.requisites = requisites;
    }
}
