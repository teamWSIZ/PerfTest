package model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Rekord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String value;
}
