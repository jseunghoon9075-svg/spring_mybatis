package com.app.mybatis.domain;
//필드
//   - id
//   - productName
//   - productPrice
//   - productStock

import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(of = "id")
public class ProductVO {
    private Long id;
    private String productName;
    private Integer productPrice;
    private Integer productStock;
}
