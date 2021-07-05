package org.zerock.j08.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.zerock.j08.entity.FoodStore;

public interface FoodStoreRepository extends JpaRepository<FoodStore, Long> {

    @EntityGraph(attributePaths = "foodMenus",
            type = EntityGraph.EntityGraphType.FETCH)
    @Query("select s from  FoodStore  s where s.fno = :sno ")
    FoodStore getById(Long sno);


}
