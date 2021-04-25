package com.athut.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author yangwan
 * @create 2021-04-09 14:52
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Blog {
    private Long id;
    private String title;
    private String content;
    private String firstPicture;
    private String flag;
    private Integer views;

    private Integer commentCount;

    private boolean appreciation;
    private boolean shareStatement;
    private boolean commentabled;
    private boolean published;
    private boolean recommend;
    private Date createTime;
    private Date updateTime;

    private Long typeId;
    private Long userId;
    private String description;
    private Type type;
    private User user;
    private List<Comment> comments = new ArrayList<>();
}
