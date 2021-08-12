package cn.itcast.product.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import javax.persistence.Table;

@Data
@TableName("user_id")
public class User {
    @TableId
    private String userId;
    @TableField(condition = SqlCondition.LIKE)
    private String name;
    private Integer age;
    private String email;
    @TableField(exist = false)
    private String remark;
}
