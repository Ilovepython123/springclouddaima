package cn.itcast.product.dao;

import cn.itcast.product.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface UserMapper extends BaseMapper<User> {
}

