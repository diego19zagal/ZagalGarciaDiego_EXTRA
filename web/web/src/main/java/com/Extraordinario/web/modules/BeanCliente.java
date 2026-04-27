package com.Extraordinario.web.modules;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "cliente")
public class BeanCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String NOMBRE;
    private boolean activo;



    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private BeanCliente beanCliente;
}
