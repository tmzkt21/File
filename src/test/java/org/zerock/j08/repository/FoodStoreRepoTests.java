package org.zerock.j08.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.j08.entity.FoodMenu;
import org.zerock.j08.entity.FoodStore;

import java.util.Optional;

@SpringBootTest
public class FoodStoreRepoTests {

    @Autowired
    private FoodStoreRepository storeRepository;

    // 등록
    @Test
    public void testRegister() {

        FoodStore store = FoodStore.builder().fname("Store1").build();

        store.addMenu(FoodMenu.builder().mname("떡볶이").build());
        store.addMenu(FoodMenu.builder().mname("라면").build());

        storeRepository.save(store);
    }

    // EntityGraph 방식
    @Test
    public void testRead2() {

        FoodStore store = storeRepository.getById(2L);

        System.out.println(store.getFname());
        System.out.println(store.getFoodMenus());
    }


    // 조회
    @Test
    public void testRead() {

        Optional<FoodStore> result = storeRepository.findById(2L);

        if(result.isPresent()) {

            FoodStore store = result.get();

            System.out.println(result.get().getFname());
            System.out.println(result.get().getFoodMenus());

        }   //end if
    }

    // 라면 메뉴를 삭제해보자
    @Test
    public void testRemoveMenu() {

        FoodStore store = storeRepository.getById(2L);

        store.removeMenu(1L);   // 떡볶이 제거

    storeRepository.save(store);

    }



}
