package com.ucuenca.web.product.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;

@Entity
@Table(name = "tbl_products")
@Data
@AllArgsConstructor @NoArgsConstructor @Builder  /// crea un constructor con todos los parametros, Sin parametrios , crear unevas instansias de la entidad
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "El nombre no debe ser vacio")
    private String name;
    private String description;
    @Positive(message = "El stock debe de ser mayor a 0")
    private Double stock;
    private Double price;
    private String status;

    @Column(name="create_at")  // caso de que la columna tenga un nombre diferente
    @Temporal(TemporalType.TIMESTAMP) ///Para trabajar con fechas, DATE, TIME o TIMESTAMP(REGISTRA HORA Y FECHA)
    private Date createAt;
    @NotNull(message = "La categoria no debe ser nula")
    @ManyToOne(fetch = FetchType.LAZY)  /// crea una relacion Mucho a uno
    @JoinColumn(name = "category_id")  // relaciona con una columna, clave foranea
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Category category;

}
