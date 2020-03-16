package com.rcm.cucumber.database.base.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;

@Data
@Entity
@Table(name="clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Email
    @Column(name="email")
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

//    @Column(name="region_id")
//    private String regionId;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;
}
