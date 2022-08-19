package com.example.juwuheback.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author 居無何
 * @since 2022-08-19
 */
@Getter
@Setter
@ApiModel(value = "Articles对象", description = "")
public class Articles implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("博文ID")
    @TableId(value = "article_id", type = IdType.AUTO)
    private Long articleId;

    @ApiModelProperty("发表用户ID")
    private Long userId;

    @ApiModelProperty("博文标题")
    private String articleTitle;

    @ApiModelProperty("博文内容")
    private String articleContent;

    @ApiModelProperty("浏览量")
    private Long articleViews;

    @ApiModelProperty("评论总数")
    private Long articleCommentCount;

    @ApiModelProperty("发表时间")
    private LocalDateTime articleDate;

    private Long articleLikeCount;


}
