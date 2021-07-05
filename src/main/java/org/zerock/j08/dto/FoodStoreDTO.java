package org.zerock.j08.dto;


import lombok.*;
import org.zerock.j08.entity.FoodStoreImage;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class FoodStoreDTO {
    private Long fno;
    private String fname;
    private List<FoodStoreImage> imageList;

}
