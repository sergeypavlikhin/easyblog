package com.pavser.easyblog.backend.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "posts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = {"id"})
public class Post implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "posts_id_seq")
    @SequenceGenerator(name="posts_id_seq", sequenceName="posts_id_seq", allocationSize=1)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "date_created")
    private Date date_created;
    @Column(name = "description")
    private String description;
    @Column(name = "body")
    private String body;

}
