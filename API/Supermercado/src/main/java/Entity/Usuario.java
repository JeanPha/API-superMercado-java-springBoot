package Entity;

import jakarta.persistence.*;

@Entity
public class Usuario {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Cambiado a IDENTITY
    private Long Id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String token;
    @Column
    private String ROLL;


    // Constructor
    public Usuario(String username, String password,int permiso) {
        this.username = username;
        this.password = password;
    }

    public Usuario(String username, String password,String ROLL) {
        this.username = username;
        this.password = password;
        this.ROLL = ROLL;
    }

    public Usuario() {

    }

    // Getters y Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getROLL() {
        return ROLL;
    }

    public void setROLL(String ROLL) {
        this.ROLL = ROLL;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
