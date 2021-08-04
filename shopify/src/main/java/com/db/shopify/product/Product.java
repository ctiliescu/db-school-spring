package com.db.shopify.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
@Data
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product implements Cloneable{
    @Id
    @Column(name = "code")
    public String code;
    @Column(name = "name")
    public String name;
    @Column(name = "description")
    public String description;
    @Column(name = "stock")
    public int stock;
    @Column(name = "price")
    public double price;

    @Override
    public Object clone()
            throws CloneNotSupportedException
    {
        return super.clone();
    }
}
