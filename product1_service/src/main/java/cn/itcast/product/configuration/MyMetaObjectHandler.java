package cn.itcast.product.configuration;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        boolean createTime = metaObject.hasSetter("createTime");
        if (createTime){
            System.out.println("start insert fill ....");
            // 起始版本 3.3.0(推荐使用)
            this.strictInsertFill(metaObject, "createTime", Date.class, new Date());
            this.strictInsertFill(metaObject, "deleted", Integer.class, 0);
        }

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        System.out.println("start update fill ....");
        // 起始版本 3.3.0(推荐)
        this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date());

    }
}
