package org.zerock.j08.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class FoodStoreImageDTO {

    private String uuid;

    private String fileName;

    private boolean main;
}
