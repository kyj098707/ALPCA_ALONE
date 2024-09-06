package com.example.back.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TierListDto {
    private List<ProductDto> s;
    private List<ProductDto> a;
    private List<ProductDto> b;
    private List<ProductDto> c;
    private List<ProductDto> d;

}
