package com.monolith.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FindByVideoGameNameResponseDto {
    private String name;
    private String gameCategory;
    private Double price;
    private Integer videoGameStock;
    private Integer ageRestriction;

}
