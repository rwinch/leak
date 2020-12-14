package pl.pancordev.leak;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Channel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private Integer number;

    @NotNull
    private String name;

    @NotNull
    private Long rx;

    @NotNull
    private Long tx;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRx() {
        return rx;
    }

    public void setRx(Long rx) {
        this.rx = rx;
    }

    public Long getTx() {
        return tx;
    }

    public void setTx(Long tx) {
        this.tx = tx;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "id=" + id +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", rx=" + rx +
                ", tx=" + tx +
                '}';
    }
}
