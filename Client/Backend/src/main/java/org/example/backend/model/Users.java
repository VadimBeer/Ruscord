package org.example.backend.model;

import jakarta.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long UserID;
    @Column(name = "Login", nullable = false)
    private String Login;
    @Column(name = "Email", nullable = false)
    private String Email;

    private String Password;
    private String Avatar;
    private ZonedDateTime DateCreated;

    public Users() {};
    public Users(long UserID, String Login, String Password, String Avatar, ZonedDateTime DateCreated) {
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

    public String getEmail() { return Email; }
    public void setEmail(String Email) { this.Email = Email; }

    public String getPassword() { return Password; }
    public void setPassword(String Password) { this.Password = Password; }

    public String getAvatar() { return Avatar; }
    public void setAvatar(String Avatar) { this.Avatar = Avatar; }

    public ZonedDateTime getDateCreated() { return DateCreated; }
    public void setDateCreated(ZonedDateTime DateCreated) { this.DateCreated = DateCreated; }

    @Override
    public String toString() {
        return "User{" +
                "Login:' " + Login + "\'" +
                ", Email:' " + Email + "\'" +
                ", Password:' " + Password + "\'" +
               // ", Date Created:' " + DateCreated + "\'" +
                '}';
    }
}
