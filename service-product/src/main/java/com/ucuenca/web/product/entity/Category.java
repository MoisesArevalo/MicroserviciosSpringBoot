package com.ucuenca.web.product.entity;


import lombok.*;

import javax.persistence.*;

@Entity //Esta anotacion indica que es una Entidad
@Table(name="TBL_CATEGORIES") //Indica si el nombre de la tabla es diferente al nombre de la entidad
//@Getter // genera getters
//@Setter //genera setters
@Data @AllArgsConstructor @NoArgsConstructor @Builder //Genera getter, setter y otras funciones, para el resto de anotaciones revisar Product

public class Category {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
