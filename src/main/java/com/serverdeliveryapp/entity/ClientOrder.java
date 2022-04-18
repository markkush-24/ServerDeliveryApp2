package com.serverdeliveryapp.entity;



import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "client_order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ClientOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name_client")
    private String nameClient;

    @Column(name = "number_phone")
    private String numberPhone;

    @Column(name = "status")
    private String status;
}
