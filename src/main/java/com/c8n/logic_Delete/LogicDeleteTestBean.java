package com.c8n.logic_delete;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by dragon on 2019/7/4.
 */
@Data
@NoArgsConstructor
@TableName("logic_delete_test")
public class LogicDeleteTestBean {

    @TableId(type = IdType.AUTO)
    private int id;

    private String data;

    @TableLogic
    private Integer delFlag = 0;
}
