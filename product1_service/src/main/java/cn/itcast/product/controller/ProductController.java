package cn.itcast.product.controller;

import cn.itcast.product.entity.Product;
import cn.itcast.product.entity.danwei.User;
import cn.itcast.product.service.ProductService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Value("${server.port}")
	private String port;

//	@Value("${spring.cloud.client.ip-address}") //spring cloud 自动的获取当前应用的ip地址
//	private String ip;

	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public Product findById(@PathVariable Long id) {
		Product product = productService.findById(id);
//		product.setProductName("访问的服务地址:"+ip + ":" + port);
		return product;
	}

	@RequestMapping(value = "",method = RequestMethod.POST)
	public String save(@RequestBody Product product) {
		productService.save(product);
		return "保存成功";
	}


	@RequestMapping(value = "123",method = RequestMethod.POST)
	public String test() {
		productService.test();
//		QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
//		queryWrapper.like("name","an").between("age",20,40).isNotNull("email");
//		User one = productService.getOne(queryWrapper,false);
//		System.out.println(one);
//		List<User> list = new ArrayList<User>();
//		User user1 = new User();
//		user1.setUserId("1425764693302562817");
//		user1.setAge(1000);
//		User user2 = new User();
//		user2.setAge(200);
//		list.add(user1);
//		list.add(user2);
//		productService.saveOrUpdateBatch(list);
		return "保存成功";
	}
}
