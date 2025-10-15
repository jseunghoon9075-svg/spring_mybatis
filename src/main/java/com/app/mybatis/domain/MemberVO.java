package com.app.mybatis.domain;

import lombok.*;

//실무에서는 @Date 안붙힘 쓸데없는거까지 만들어버려서
//@Data
@Getter @Setter @ToString @EqualsAndHashCode(of = "id")
@NoArgsConstructor @AllArgsConstructor
public class MemberVO {
    private Long id;
    private String memberEmail;
    private String memberName;
    private String memberPassword;
}
