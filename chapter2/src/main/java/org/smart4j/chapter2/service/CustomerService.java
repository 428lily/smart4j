package org.smart4j.chapter2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.chapter2.helper.DatabaseHelper;
import org.smart4j.chapter2.model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 提供客户数据服务
 */
public class CustomerService {

  private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

  /**
   * 获取客户列表
   *
   * @return
   */
  public List<Customer> getCustomerList() {
    String sql = "select * from customer";
    return DatabaseHelper.queryEntityList(Customer.class, sql);
  }

  /**
   * 获取客户
   *
   * @return
   */
  public Customer getCustomer(long id) {
    Connection conn = null;
    try {
      String sql = "select * from customer where id = " + id;
      PreparedStatement stmt = conn.prepareStatement(sql);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 创建客户
   *
   * @param fieldMap
   * @return
   */
  public boolean createCustomer(Map<String, Object> fieldMap) {
    DatabaseHelper.insertEntity(Customer.class,fieldMap);
    return false;
  }

  /**
   * 更新客户
   *
   * @param id
   * @param fieldMap
   * @return
   */
  public boolean updateCustomer(long id, Map<String, Object> fieldMap) {
    DatabaseHelper.updateEntity(Customer.class,id,fieldMap);
    return false;
  }

  /**
   * 删除客户
   *
   * @param id
   * @return
   */
  public boolean deleteCustomer(long id) {
    DatabaseHelper.deleteEntity(Customer.class,id);
    return false;
  }
}
