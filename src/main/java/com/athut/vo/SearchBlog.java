package com.athut.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yangwan
 * @create 2021-04-14 14:52
 */
@Data
@NoArgsConstructor
public class SearchBlog {
    private String title;
    private Long typeId;
}
