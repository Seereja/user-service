package com.aston.frontendpracticeservice.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.UuidGenerator;

import java.util.Objects;
import java.util.UUID;

/**
 * Класс Requisites представляет сущность сведений о реквизитах,
 * необходимых для финансовых операций и взаимодействия с банковскими системами.
 * Этот класс расширяет базовый класс BaseEntity и предоставляет поля
 * для хранения различных реквизитов, таких как рассчетный счет, БИК,
 * корреспондентский счет, ИНН, КПП и КБК.
 */


@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "requisites")
public class Requisites{


    /**
     * id.
     */
    @Id
    @UuidGenerator
    @Column(name = "id", nullable = false)
    private UUID id;

    /**
     * Рассчетный счет
     * Пример значения: "40702810901234567890".
     */

    @Column(name = "settlement_account", length = 20, nullable = false)
    private String settlementAccount;


    /**
     * БИК
     * Пример значения: "044525225".
     */

    @Column(name = "bik", length = 9, nullable = false)
    private String bik;

    /**
     * Корреспондентский счет
     * Пример значения: "30101810400000000225".
     */

    @Column(name = "correspondent_account", length = 20, nullable = false)
    private String correspondentAccount;

    /**
     * ИНН пример:7123567891.
     */

    @Column(name = "inn", length = 10, unique = true)
    private String inn;

    /**
     * КПП (KPP).
     * Пример значения: "771501001".
     */

    @Column(name = "kpp", length = 9)
    private String kpp;

    /**
     * КБК (KBK).
     * Пример значения: "03531000000000000130".
     */

    @Column(name = "kbk", length = 20)
    private String kbk;


    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @Cascade({CascadeType.PERSIST, CascadeType.MERGE})
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Requisites that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(getInn(), that.getInn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getInn());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSettlementAccount() {
        return settlementAccount;
    }

    public void setSettlementAccount(String settlementAccount) {
        this.settlementAccount = settlementAccount;
    }

    public String getBik() {
        return bik;
    }

    public void setBik(String bik) {
        this.bik = bik;
    }

    public String getCorrespondentAccount() {
        return correspondentAccount;
    }

    public void setCorrespondentAccount(String correspondentAccount) {
        this.correspondentAccount = correspondentAccount;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getKbk() {
        return kbk;
    }

    public void setKbk(String kbk) {
        this.kbk = kbk;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
