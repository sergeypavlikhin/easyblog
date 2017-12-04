package com.pavser.easyblog.backend.vo;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PostVO {

    private Long id;

    private Long created;

    private String title;

    private String description;

    private String body;

}
