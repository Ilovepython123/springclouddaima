package cn.itcast.product.service.impl;

import cn.itcast.product.dao.ProductDao;
import cn.itcast.product.dao.UserMapper;
import cn.itcast.product.entity.Product;
import cn.itcast.product.entity.User;
import cn.itcast.product.service.ProductService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	@Autowired
	private UserMapper userMapper;

	public void test(){
		List<User> userList = userMapper.selectList(null);
		for(User user:userList) {
			System.out.println(user);
		}
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.lambda()
				.eq(User::getName, "Tom");
		List<User> userList2 = userMapper.selectList(queryWrapper);
		System.out.println(userList2);
	}

	@Override
	public Product findById(Long id) {
		return productDao.findById(id).get();
	}

	@Override
	public void save(Product product) {
		productDao.save(product);
	}

	@Override
	public void update(Product product) {
		productDao.save(product);
	}

	@Override
	public void delete(Long id) {
		productDao.deleteById(id);
	}
}
