package cn.itcast.product.entity.danwei;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

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
    @TableLogic
    @TableField(select = false ,fill = FieldFill.INSERT )
    private Integer deleted;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;
    @Version
    private Integer version;

}
