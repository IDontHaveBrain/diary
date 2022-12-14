package com.example.diary.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Integer id;

    @Email(message = "이메일 형식이 아닙니다.")
    @NotBlank(message = "이메일을 입력해주세요.")
    @Column(name = "email", length = 40)
    private String email;

    @Size(min = 6, max = 12, message = "비밀번호는 6자 이상 12자 이하로 입력해주세요.")
    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Column(name = "pw", length = 20)
    private String pw;

    @Size(min = 2, max = 6, message = "닉네임은 2자 이상 6자 이하로 입력해주세요.")
    @NotBlank(message = "닉네임을 입력해주세요.")
    @Column(name = "nick", length = 20)
    private String nick;

    @Column(name = "gender")
    private Integer gender;

    @Column(name = "age")
    private Integer age;

    @Column(name = "regdate")
    private Instant regdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Instant getRegdate() {
        return regdate;
    }

    public void setRegdate(Instant regdate) {
        this.regdate = regdate;
    }

}