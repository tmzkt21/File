package org.zerock.j08.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class FoodStoreImage {

    @Id
    private String uuid;

    private String fileName;

    private boolean main;
}
