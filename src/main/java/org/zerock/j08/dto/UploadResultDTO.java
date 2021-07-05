package org.zerock.j08.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UploadResultDTO {
    //각각의 아이디
    private String uuid;
    //파일 이름
    private String fileName;


}
