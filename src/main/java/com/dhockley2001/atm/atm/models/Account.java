package com.dhockley2001.atm.atm.models;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account {

    public enum AccountType {
        SAVINGS, CURRENT;

        @Override
        public String toString() {
            switch (this) {
                case SAVINGS:
                    return "Savings";
                case CURRENT:
                    return "Current";
                default:
                    return "";
            }
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "accountType")
    private AccountType accountType;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "interestRate")
    private Double interestRate;

    @Column(name = "lastInterestApplied")
    private LocalDateTime lastInterestApplied;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Account(Integer id, AccountType accountType, Double balance, Double interestRate, User user) {
        this.id = id;
        this.accountType = accountType;
        this.balance = balance;
        this.interestRate = interestRate;
        this.lastInterestApplied = LocalDateTime.now();
        this.user = user;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AccountType getAccountType() {
        return this.accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Double getBalance() {
        return this.balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public LocalDateTime getLastInterestApplied() {
        return this.lastInterestApplied;
    }

    public void setLastInterestApplied(LocalDateTime lastInterestApplied) {
        this.lastInterestApplied = lastInterestApplied;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Account id(Integer id) {
        setId(id);
        return this;
    }

    public Account accountType(AccountType accountType) {
        setAccountType(accountType);
        return this;
    }

    public Account balance(Double balance) {
        setBalance(balance);
        return this;
    }

    public Account interestRate(Double interestRate) {
        setInterestRate(interestRate);
        return this;
    }

    public Account lastInterestApplied(LocalDateTime lastInterestApplied) {
        setLastInterestApplied(lastInterestApplied);
        return this;
    }

    public Account user(User user) {
        setUser(user);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Account)) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(id, account.id) && Objects.equals(accountType, account.accountType)
                && Objects.equals(balance, account.balance) && Objects.equals(interestRate, account.interestRate)
                && Objects.equals(lastInterestApplied, account.lastInterestApplied)
                && Objects.equals(user, account.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountType, balance, interestRate, lastInterestApplied, user);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", accountType='" + getAccountType() + "'" +
                ", balance='" + getBalance() + "'" +
                ", interestRate='" + getInterestRate() + "'" +
                ", user='" + getUser().getFirstName() + " " + getUser().getLastName() + "'" +
                "}";
    }

}
