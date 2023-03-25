package com.monolith.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookUpdateRequestDto {
    private Long id;
    private String publisher;
    private Double price;
    private Integer pageNumber;
    private Integer bookStock;
}
