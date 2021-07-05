package org.zerock.j08.entity;

import lombok.*;
import org.hibernate.engine.spi.ManagedEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class FoodStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fno;

    private String fname;

    // 중복데이터 안잡기 위해 setter 쓴다
    // 조인할 때 곱하면서 중복데이터 발생할 수 있는데, 이를 방지하기 위해서

    // 엔티티를 한꺼번에 관리하기 위해 OneToMany 쓰는 것
    // foodStore객체를 가지고 바로 foodMenus에 접근할 수도 있다

    @Builder.Default
    // Builder.Default 안주면 셋에문제가 생긴다
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<FoodStoreImage> storeImages = new HashSet<>();

    public void addImage(FoodStoreImage image) {
        storeImages.add(image);
    }



}
