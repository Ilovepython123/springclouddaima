package cn.itcast.product;

import cn.itcast.product.dao.ProductDao;
import cn.itcast.product.dao.UserMapper;
import cn.itcast.product.entity.danwei.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestMybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ProductDao productDao;


    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        System.out.println(productDao);
        System.out.println(userMapper);

        List<User> userList = userMapper.selectList(null);
        for(User user:userList) {
            System.out.println(user);
        }
    }
}