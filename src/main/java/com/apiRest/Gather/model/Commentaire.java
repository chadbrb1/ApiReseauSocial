package com.apiRest.Gather.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "commentaire")
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Commentaire {

    @Id
    @Column(name="id", nullable = false)
    @SequenceGenerator(name="commentaire_sequence", sequenceName = "commentaire_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "commentaire_seq")
    private long id;
    private String commentaire;
}
