package org.zerock.j08.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;
import org.zerock.j08.entity.FoodStore;

import java.lang.reflect.Array;
import java.util.Arrays;


@SpringBootTest
@ActiveProfiles("dev")
@Log4j2
public class FoodStoreRepositoryTests {

    @Autowired
    private FoodStoreRepository storeRepository;

    @Test
    public void testList() {
        Pageable pageable = PageRequest.of(0,10, Sort.by("fno").descending());
        Page<Object[]> result = storeRepository.getList(pageable);

        result.getContent().forEach(todo -> {
            log.info(todo);
        });
        result.getContent().forEach(arr -> Arrays.toString(arr));
    }



}
