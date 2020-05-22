package ua.lviv.home.JavaProject.domain;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Column(name = "last_name")
    private String lastName;

    @NotBlank
    @Email(message = "Please enter a valid e-mail address")
    @Column(unique = true)
    private String email;

    @NotBlank
    @Column(unique = true)
    private String password;

    @NotBlank
    @DateTimeFormat(pattern = "mm/DD/yyyy")
    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @NotBlank
    private String gender;

    @NotBlank
    private String address;

    @NotNull
    @Column(name = "phone_number")
    private Long phoneNumber;

    @NotBlank(message = "Cannot be empty!")
    @Column(unique = true)
    private String username;

    @Lob
    private String image;

    @Transient
    private MultipartFile file;
    public MultipartFile getFile() {
        return file;
    }
    public void setFile(MultipartFile file) {
        this.file = file;
    }

    private boolean isEmailVerified;

    private String verifyEmailHash;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection(targetClass = AccessLevel.class, fetch = FetchType.EAGER)
    @Column(name = "role")
    private Set<AccessLevel> roles;

    public User() {
    }

    public User(String firstName, String lastName, String email, String dateOfBirth, String gender,
                String address, Long phoneNumber, String username) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.username = username;
    }

    public User(String firstName, String lastName, String email, String dateOfBirth, String gender,
                String address, Long phoneNumber, String username, String image) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<AccessLevel> getRoles() {
        return roles;
    }

    public void setRoles(Set<AccessLevel> roles) {
        this.roles = roles;
    }

    public boolean isEmailVerified() {
        return isEmailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        isEmailVerified = emailVerified;
    }

    public String getVerifyEmailHash() {
        return verifyEmailHash;
    }

    public void setVerifyEmailHash(String verifyEmailHash) {
        this.verifyEmailHash = verifyEmailHash;
    }
}
