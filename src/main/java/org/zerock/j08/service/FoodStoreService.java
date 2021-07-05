package org.zerock.j08.service;

import org.zerock.j08.dto.FoodStoreDTO;
import org.zerock.j08.dto.ListFoodStoreDTO;
import org.zerock.j08.entity.FoodStore;
import org.zerock.j08.entity.FoodStoreImage;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public interface FoodStoreService {

    Long register(FoodStoreDTO storeDTO);

    default FoodStore dtoToEntity(FoodStoreDTO storeDTO) {

      Set<FoodStoreImage> imageSet =  storeDTO.getImageList().stream().map(imageDTO ->
              FoodStoreImage.builder()
                      .uuid(imageDTO.getUuid())
                      .fileName(imageDTO.getFileName())
                      .main(imageDTO.isMain())
                      .build()).collect(Collectors.toSet());
        FoodStore.builder().build();

        return FoodStore.builder()
                .fno(storeDTO.getFno())
                .storeImages(imageSet)
                .fname(storeDTO.getFname())
                .build();
    }

    List<ListFoodStoreDTO> getList();

    default ListFoodStoreDTO arrToDTO(Object[] arr) {
        return ListFoodStoreDTO.builder()
                .fno((long)arr[0])
                .fname((String)arr[1])
                .uuid((String)arr[2])
                .fileName((String)arr[3])
                .build();
    }
}
