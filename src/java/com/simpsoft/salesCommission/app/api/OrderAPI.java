package com.simpsoft.salesCommission.app.api;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.simpsoft.salesCommission.app.model.Address;
import com.simpsoft.salesCommission.app.model.Customer;
import com.simpsoft.salesCommission.app.model.CustomerType;
import com.simpsoft.salesCommission.app.model.OrderRoster;
import com.simpsoft.salesCommission.app.model.Product;
import com.simpsoft.salesCommission.app.model.ProductSubType;
import com.simpsoft.salesCommission.app.model.ProductType;
import com.simpsoft.salesCommission.app.model.State;

@Component
public class OrderAPI {

	@Autowired
	private static SessionFactory sessionFactory;
	
	@Autowired
	private EmployeeAPI employeeAPI;

	private static final Logger logger = Logger.getLogger(RuleAPI.class);

	public void setSessionFactory(SessionFactory factory) {
		sessionFactory = factory;
	}
	
	/**
	 * 
	 * @param state
	 * @return
	 */
	public Long createState(State state) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		State newState = new State();
		try {
			tx = session.beginTransaction();
			newState.setStateName(state.getStateName());
			newState.setStateCode(state.getStateCode());
			session.save(newState);
			tx.commit();
			logger.debug("CREATED AN AGGREGATE FUNCTION INTO DATABASE" + newState);
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return newState.getId();
	}
	
	/**
	 * 
	 * @param address
	 * @return
	 */
	public Address createAddress(Address address) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Address newAddress = new Address();
		try {
			tx = session.beginTransaction();
			newAddress.setAddrslinen1(address.getAddrslinen1());
			newAddress.setAddrslinen2(address.getAddrslinen2());
			 State state = searchState(address.getState().getStateName());
			 newAddress.setState(state); 
			//newAddress.setState(address.getState());
			session.save(newAddress);
			tx.commit();
			logger.debug("CREATED AN AGGREGATE FUNCTION INTO DATABASE" + newAddress);
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return newAddress;
	} 
	
	/**
	 * 
	 * @param stateName
	 * @return
	 */
	public State searchState(String stateName) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<State> stateList = new ArrayList<>();
		try {
		tx = session.beginTransaction();
		Criteria crit = session.createCriteria(State.class);
		crit.add(Restrictions.eq("stateName",stateName));
		stateList = crit.list();
				tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return stateList.get(0);
	}
	
	/**
	 * 
	 * @param customerType
	 * @return
	 */
	public Long createCustomerType(CustomerType customerType) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		CustomerType newCustomerType = new CustomerType();
		try {
			tx = session.beginTransaction();
			newCustomerType.setCustType(customerType.getCustType());
			session.save(newCustomerType);
			tx.commit();
			logger.debug("CREATED AN CUSTOMER TYPE INTO DATABASE" + newCustomerType);
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return newCustomerType.getId();
	}
	
	/**
	 * 
	 * @param customerType
	 * @return
	 */
	public CustomerType searchCustomerType(String customerType) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<CustomerType> customerTypeList = new ArrayList<>();
		try {
		tx = session.beginTransaction();
		Criteria crit = session.createCriteria(CustomerType.class);
		crit.add(Restrictions.eq("custType",customerType));
		customerTypeList = crit.list();
				tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return customerTypeList.get(0);
	}
	
	/**
	 * 
	 * @param customer
	 * @return
	 */
	public Long createCustomer(Customer customer) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Customer newCustomer = new Customer();
		try {
			tx = session.beginTransaction();
			newCustomer.setCustomerName(customer.getCustomerName());
			CustomerType customerType = searchCustomerType(customer.getCustomerType().getCustType());
			newCustomer.setCustomerType(customerType);
			Address newAddress = createAddress(customer.getAddress());
			newCustomer.setAddress(newAddress);
			session.save(newCustomer);
			tx.commit();
			logger.debug("CREATED AN CUSTOMER TYPE INTO DATABASE" + newCustomer);
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return newCustomer.getId();
	}
	
	public Customer searchCustomer(String custName) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<Customer> custList = new ArrayList<>();
		try {
		tx = session.beginTransaction();
		Criteria crit = session.createCriteria(Customer.class);
		crit.add(Restrictions.eq("customerName", custName));
		custList = crit.list();
				tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return custList.get(0);
	}
	/**
	 * 
	 * @param productType
	 * @return
	 */
	
	public Long createProductType(ProductType productType) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		ProductType newProductType = new ProductType();
		try {
			tx = session.beginTransaction();
			newProductType.setProdType(productType.getProdType());
			session.save(newProductType);
			tx.commit();
			logger.debug("CREATED AN PRODUCT TYPE INTO DATABASE" + newProductType);
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return newProductType.getId();
	}
	
	/**
	 * 
	 * @param productSubType
	 * @return
	 */
	public ProductSubType createProductSubType(ProductSubType productSubType) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		ProductSubType newproductSubType = new ProductSubType();
		try {
			tx = session.beginTransaction();
			newproductSubType.setSubType(productSubType.getSubType());
			ProductType productType = searchProductType(productSubType.getProductType().getProdType());
			newproductSubType.setProductType(productType);
			session.save(newproductSubType);
			tx.commit();
			logger.debug("CREATED AN AGGREGATE FUNCTION INTO DATABASE" + newproductSubType);
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return productSubType;
	} 
	
	/**
	 * 
	 * @param productType
	 * @return
	 */
	public ProductType searchProductType(String productType) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<ProductType> productTypeList = new ArrayList<>();
		try {
		tx = session.beginTransaction();
		Criteria crit = session.createCriteria(ProductType.class);
		crit.add(Restrictions.eq("prodType",productType));
		productTypeList = crit.list();
				tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return productTypeList.get(0);
	}
	
	/**
	 * 
	 * @param productSubType
	 * @return
	 */
	public ProductSubType searchProductSubType(String productSubType) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<ProductSubType> productSubTypeList = new ArrayList<>();
		try {
		tx = session.beginTransaction();
		Criteria crit = session.createCriteria(ProductSubType.class);
		crit.add(Restrictions.eq("subType",productSubType));
		productSubTypeList = crit.list();
				tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return productSubTypeList.get(0);
	}
	
	/**
	 * Method for creating product
	 * @param product
	 * @return
	 */
	public Product createProduct(Product product) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Product newProduct = new Product();
		try {
			tx = session.beginTransaction();
			newProduct.setProductName(product.getProductName());
			newProduct.setDescription(product.getDescription());
			ProductSubType productSubType = searchProductSubType(product.getProductSubType().getSubType());
			newProduct.setProductSubType(productSubType);
			session.save(newProduct);
			tx.commit();
			logger.debug("CREATED AN PRODUCT INTO DATABASE" + newProduct);
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return newProduct;
	} 
	
	/**
	 * Method for creating order roster
	 * @param orderRoster
	 * @return
	 */
	public Long createOrderRoster(OrderRoster orderRoster) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		OrderRoster newOrderRoster = new OrderRoster();
		try {
			tx = session.beginTransaction();
			newOrderRoster.setImportDate(orderRoster.getImportDate());
			newOrderRoster.setCountOfOrders(orderRoster.getCountOfOrders());
			newOrderRoster.setStatus(orderRoster.getStatus());
			//Employee employee = employeeAPI.searchEmployee(orderRoster.getImportedBy().getEmployeeName());
			//newOrderRoster.setImportedBy(employee);
			newOrderRoster.setImportedBy(orderRoster.getImportedBy());
			newOrderRoster.setOrderDetail(orderRoster.getOrderDetail());
			session.save(newOrderRoster);
			tx.commit();
			logger.debug("CREATED AN CUSTOMER TYPE INTO DATABASE" + newOrderRoster);
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return newOrderRoster.getId();
	}
	
	/**
	 * Method for getting list of orderRoster
	 * 
	 * @return
	 */
	public List<OrderRoster> listOfOrderRosters() {

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<OrderRoster> orderRosters = new ArrayList<OrderRoster>();
		try {
		tx = session.beginTransaction();
		orderRosters = session.createQuery("FROM OrderRoster").list();
		tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return orderRosters;
	}

}
