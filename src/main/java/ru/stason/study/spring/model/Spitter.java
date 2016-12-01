package ru.stason.study.spring.model;

//todo
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

public class Spitter {

    public Spitter() {
    }

    public Spitter(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Spitter(Long id, String username, String password, String firstName, String lastName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    private Long id;
//    @NotNull
//    @Size(min = 5, max = 16)
    private String username;

//    @NotNull
//    @Size(min = 5, max = 25)
    private String password;

//    @NotNull
//    @Size(min = 2, max = 30)
    private String firstName;

//    @NotNull
//    @Size(min = 2, max = 30)
    private String lastName;

    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Spitter spitter = (Spitter) o;

        if (id != null ? !id.equals(spitter.id) : spitter.id != null) {
            return false;
        }
        if (username != null ? !username.equals(spitter.username) : spitter.username != null) {
            return false;
        }
        if (password != null ? !password.equals(spitter.password) : spitter.password != null) {
            return false;
        }
        if (firstName != null ? !firstName.equals(spitter.firstName) : spitter.firstName != null) {
            return false;
        }
        if (lastName != null ? !lastName.equals(spitter.lastName) : spitter.lastName != null) {
            return false;
        }
        return email != null ? email.equals(spitter.email) : spitter.email == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
