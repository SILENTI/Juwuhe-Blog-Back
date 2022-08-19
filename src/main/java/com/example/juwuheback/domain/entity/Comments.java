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
@ApiModel(value = "Comments对象", description = "")
public class Comments implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("评论ID")
    @TableId(value = "comment_id", type = IdType.AUTO)
    private Long commentId;

    @ApiModelProperty("发表用户邮箱")
    private Long email;

    @ApiModelProperty("评论博文ID")
    private Long articleId;

    @ApiModelProperty("点赞数")
    private Long commentLikeCount;

    @ApiModelProperty("评论日期")
    private LocalDateTime commentDate;

    @ApiModelProperty("评论内容")
    private String commentContent;

    @ApiModelProperty("父评论ID")
    private Long parentCommentId;


}
