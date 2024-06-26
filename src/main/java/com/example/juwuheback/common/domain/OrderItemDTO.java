package com.example.juwuheback.common.domain;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: shuhong
 * @create: 2020-03-20 09:07 PM from win10
 */

@Slf4j
@Data
public class OrderItemDTO {
    private String column;
    private boolean asc = true;
}
