package org.example.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import org.springframework.data.annotation.Id;

import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name = "users")
public class Users {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long UserID;
    private String Login;
    private String Email;
    private String Password;
    private String Avatar;
    private Timestamp DateCreated;

    public Users() {};
    public Users(long UserID, String Login, String Password, String Avatar, Timestamp DateCreated) {
        this.UserID = UserID;
        this.Login = Login;
        this.Password = Password;
        this.Avatar = Avatar;
        this.DateCreated = DateCreated;
    }

    public void setUserID(long userID) { this.UserID = userID; }
    public Long getUserID() { return UserID; }

    public String getLogin() { return Login; }
    public void setLogin(String Login) { this.Login = Login; }

    public String getPassword() { return Password; }
    public void setPassword(String Password) { this.Password = Password; }

    public String getAvatar() { return Avatar; }
    public void setAvatar(String Avatar) { this.Avatar = Avatar; }

    public Timestamp getDateCreated() { return DateCreated; }
    public void setDateCreated(Timestamp DateCreated) { this.DateCreated = DateCreated; }

    @Override
    public String toString() {
        return "User{" +
                "Login:' " + Login + "\'" +
                ", Email:' " + Email + "\'" +
                ", Password:' " + Password + "\'" +
                ", Date Created:' " + DateCreated + "\'" +
                '}';
    }
}
