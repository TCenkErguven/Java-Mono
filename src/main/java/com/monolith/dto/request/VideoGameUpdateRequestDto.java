package com.monolith.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideoGameUpdateRequestDto {
    private Long id;
    private Double price;
    private Integer videoGameStock;
    private Integer ageRestriction;
}
