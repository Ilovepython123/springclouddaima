package cn.itcast.product.service;

import cn.itcast.product.entity.Product;
import cn.itcast.product.entity.danwei.User;
import com.baomidou.mybatisplus.extension.service.IService;

public interface ProductService extends IService<User> {

	/**
	 * 根据id查询
	 */
	Product findById(Long id);

	/**
	 * 保存
	 */
	void save(Product product);
	/**
	 * 更新
	 */
	void update(Product product);
	/**
	 * 删除
	 */
	void delete(Long id);

	public void test();
}
