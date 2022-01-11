package mioga.entites;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Data
@Entity
@Table(name = "contacts")
public class Contacts {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Basic
    @Column(name = "title")
    private Title title;
    @Basic
    @Column(name = "description")
    private String description;


    @Basic
    @Column(name = "company")
    private String company;


    @Basic
    @Column(name = "vorname")
    private String vorname;

    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "telefone")

    private String telefone;

    @Basic
    @Column(name = "mobile")
    private String mobile;

    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "anmerkung")
    private String anmerkung;
    @Basic
    @Column(name = "updated_at")
    private String updatedAt;
    @Basic
    @Column(name = "success_at")
    private String successAt;




    @Autowired
    public Contacts(String description, String company, String vorname, String name,
                    String telefone, String mobile, String email, String anmerkung, String updatedAt,
                    String successAt) {

        this.description = description;
        this.company = company;
        this.vorname = vorname;
        this.name = name;
        this.telefone = telefone;
        this.mobile = mobile;
        this.email = email;
        this.anmerkung = anmerkung;
        this.updatedAt = updatedAt;
        this.successAt = successAt;

    }


}
