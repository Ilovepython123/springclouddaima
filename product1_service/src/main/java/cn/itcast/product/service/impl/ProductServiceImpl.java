package cn.itcast.product.service.impl;

import cn.itcast.product.configuration.MybatisPlusConfig;
import cn.itcast.product.dao.ProductDao;
import cn.itcast.product.dao.UserMapper;
import cn.itcast.product.entity.Product;
import cn.itcast.product.entity.danwei.User;
import cn.itcast.product.service.ProductService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl  extends ServiceImpl<UserMapper,User> implements ProductService  {

	@Autowired
	private ProductDao productDao;
	@Autowired
	private UserMapper userMapper;

	public void test(){



//		1、名字中包含雨并且年龄小于40
//		name like '%雨%' and age<40


//		//模拟前端传的值
//		User user = new User();
//		user.setName("hu");
//		user.setEmail("");
//		QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
//		queryWrapper.like(StringUtils.isNotEmpty(user.getName()), "name", user.getName()).
//				like(StringUtils.isNotEmpty(user.getEmail()), "email", user.getEmail());
//		List<User> users = userMapper.selectList(queryWrapper);
//		System.out.println(users);

//		2、名字中包含雨年并且龄大于等于20且小于等于40并且email不为空
//		name like '%雨%' and age between 20 and 40 and email is not null
//		QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
//		queryWrapper.like("name","an").between("age",20,40).isNotNull("email");
//		List<User> list = userMapper.selectAll(queryWrapper);
//		System.out.println(list);

//		int i = userMapper.deleteById("1422374343481466884");
//		System.out.println(i);

		System.out.println("asd");
		MybatisPlusConfig.myTableName.set("user_2019");
		QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
		queryWrapper.like("name","li");
//				.lt("age",40);
		List<User> list = userMapper.selectList(queryWrapper);
		System.out.println(list);
//		Integer version = 2;
//
//		User user = new User();
//		user.setUserId("1427105063533772802");
//		user.setAge(101);
////		user.setVersion(version);
//		int i = userMapper.updateById(user);
//		System.out.println(i);
//
//
//
//		3、名字为王姓或者年龄大于等于25，按照年龄降序排列，年龄相同按照id升序排列
//		name like '王%' or age>=25 order by age desc,id asc
//		QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
//		queryWrapper.likeRight("name","l").or()between("age",20,40).isNotNull("email");
//		List<User> users = userMapper.selectList(queryWrapper);
//		System.out.println(users);


//		User user = new User();
//		user.setAge(21);
//		user.setEmail("test4@baomidou.com");
//		user.setName("Sandy");
//
//		QueryWrapper<User> queryWrapper = new QueryWrapper<User>(user);
//
//		queryWrapper.like("name","hu").lt("age",40);
//
//		List<User> users = userMapper.selectList(queryWrapper);
//		System.out.println(users);


//		QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
//		Map<String,Object> params =  new HashMap<String, Object>();
//		params.put("name","王天风");
//		params.put("age", null);
//		queryWrapper.allEq(params,false);
////		queryWrapper. allEq((k, v)->!k.equals("name");
//		List<User> userList = userMapper.selectList(queryWrapper);
//		System.out.println(userList);


//		Preparing: SELECT user_id,name,age,email FROM user_id WHERE (name LIKE ? AND ( (age < ? OR email IS NOT NULL) ))
//==> Parameters: 王%(String), 40(Integer)
//		QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
//		queryWrapper.likeRight("name","王").and(wq->wq.lt("age",40).or().isNotNull("email"));
////		Consumer<User> consumer = new Consumer<User>();
//
////		queryWrapper.likeRight("name","王").and(queryWrapper3);
//
//		List<User> list = userMapper.selectList(queryWrapper);
//		System.out.println(list);














//		HashMap<String,Object> map = new HashMap<String,Object>();
//		map.put("user_id",1422375953435697154l);
//		List<User> users = userMapper.selectByMap(map);
//		System.out.println(users);


//		User user = userMapper.selectById(1422376424342769665l);
//		List<Long> list = Arrays.asList(1422376424342769665l, 1422375953435697154l, 1422374343481466882l);
//		List<User> users = userMapper.selectBatchIds(list);
//		System.out.println(user);
//		System.out.println(users);

//		List<User> userList = userMapper.selectList(null);
//		for(User user:userList) {
//			System.out.println(user);
//		}
//		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//		queryWrapper.lambda()
//				.eq(User::getRealName, "Tom");
//		List<User> userList2 = userMapper.selectList(queryWrapper);
//		System.out.println(userList2);
//		User user = new User();
////		user.setId(6l);
//		user.setAge(31);
//		user.setName("tianfei");
//		int insert = userMapper.insert(user);
//		System.out.println(insert);


//		分页
//		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//		queryWrapper.lt("age",47);
//		Page<User> page = new Page<User>(1,6);
//		IPage<User> iPage = userMapper.selectshuangbiao(page,queryWrapper);
//		System.out.println("总页数:"+iPage.getPages());
//		System.out.println("总记录数:"+iPage.getTotal());
//		System.out.println("记录"+iPage.getRecords());


//		//更新
//		User user = new User();
////		user.setUserId(1422374343481466885L);
//		user.setName("hfrtjhfdjffdjfj");
//		int i = userMapper.insert(user);
//		System.out.println(i);



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
