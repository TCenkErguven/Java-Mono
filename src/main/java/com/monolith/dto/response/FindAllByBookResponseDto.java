package com.monolith.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FindAllByBookResponseDto {
    private String name;
    private String author;
    private String category;
    private String publisher;
    private String releaseDate;
    private Double price;
    private Integer pageNumber;
}
