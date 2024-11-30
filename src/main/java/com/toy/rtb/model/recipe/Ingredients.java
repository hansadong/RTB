package com.toy.rtb.model.recipe;

import com.toy.rtb.model.common.CommonEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ingredients")
@Getter
@Setter
public class Ingredients extends CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ingredientSn;

    @Column(nullable = false)
    private String ingredientName;

    @Column(nullable = false)
    private String notes;
}
