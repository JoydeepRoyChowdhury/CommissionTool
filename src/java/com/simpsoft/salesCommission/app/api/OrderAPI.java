package com.simpsoft.salesCommission.app.api;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.simpsoft.salesCommission.app.dataloader.OrderLineItemsXML;
import com.simpsoft.salesCommission.app.dataloader.OrderRosterXML;
import com.simpsoft.salesCommission.app.dataloader.OrderXML;
import com.simpsoft.salesCommission.app.model.Address;
import com.simpsoft.salesCommission.app.model.Customer;
import com.simpsoft.salesCommission.app.model.CustomerType;
import com.simpsoft.salesCommission.app.model.Employee;
import com.simpsoft.salesCommission.app.model.OrderDetail;
import com.simpsoft.salesCommission.app.model.OrderLineItems;
import com.simpsoft.salesCommission.app.model.OrderRoster;
import com.simpsoft.salesCommission.app.model.Product;
import com.simpsoft.salesCommission.app.model.ProductSubType;
import com.simpsoft.salesCommission.app.model.ProductType;
import com.simpsoft.salesCommission.app.model.Rule;
import com.simpsoft.salesCommission.app.model.State;

@Component
public class OrderAPI {

	@Autowired
	private static SessionFactory sessionFactory;

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
			// newAddress.setState(address.getState());
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
			crit.add(Restrictions.eq("stateName", stateName));
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
			crit.add(Restrictions.eq("custType", customerType));
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

	public static Customer searchCustomer(String custName) {
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
			crit.add(Restrictions.eq("prodType", productType));
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
			crit.add(Restrictions.eq("subType", productSubType));
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
	 * 
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
	 * 
	 * @param productType
	 * @return
	 */
	public static Product searchProduct(String product) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<Product> productList = new ArrayList<>();
		try {
			tx = session.beginTransaction();
			Criteria crit = session.createCriteria(Product.class);
			crit.add(Restrictions.eq("productName", product));
			productList = crit.list();
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return productList.get(0);
	}

	/**
	 * Method for creating order roster
	 * 
	 * @param orderRoster
	 * @return
	 */
	public static Long createOrderRoster(OrderRoster orderRoster) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		OrderRoster newOrderRoster = new OrderRoster();
		try {
			tx = session.beginTransaction();
			newOrderRoster.setImportDate(orderRoster.getImportDate());
			newOrderRoster.setCountOfOrders(orderRoster.getCountOfOrders());
			newOrderRoster.setStatus(orderRoster.getStatus());
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

	public void importOrders(InputStream is) {

		List<OrderRosterXML> importOrderList = parseXML(is);

		for (Iterator iterator = importOrderList.iterator(); iterator.hasNext();) {

			OrderRosterXML orderRoster = (OrderRosterXML) iterator.next();
			OrderRoster newOrderRoster = new OrderRoster();

			newOrderRoster.setImportDate(orderRoster.getImportDate());
			newOrderRoster.setCountOfOrders(orderRoster.getCountOfOrders());
			newOrderRoster.setStatus(orderRoster.getStatus());
			List<OrderXML> orderList = orderRoster.getOrderXML();
			List<OrderDetail> newOrderList = new ArrayList<OrderDetail>();
			for (Iterator iterator1 = orderList.iterator(); iterator1.hasNext();) {

				OrderXML order = (OrderXML) iterator1.next();

				OrderDetail newOrder = new OrderDetail();
				newOrder.setOrderDate(order.getOrderDate());

				Employee salesRepresentative = searchEmployee(order.getSalesRepresentative());
				newOrder.setSalesRepresentative(salesRepresentative);

				Employee administrator = searchEmployee(order.getAdministrator());
				newOrder.setAdministrator(administrator);

				Employee supportEngineer = searchEmployee(order.getSupportEngineer());
				newOrder.setSupportEngineer(supportEngineer);

				Customer customer = searchCustomer(order.getCustomer());
				newOrder.setCustomer(customer);

				newOrder.setOrderTotal(order.getOrderTotal());

				List<OrderLineItemsXML> orderLineItemList = order.getOrderLineItemsXML();
				List<OrderLineItems> newOrderLineItemList = new ArrayList<OrderLineItems>();
				for (Iterator iterator2 = orderLineItemList.iterator(); iterator2.hasNext();) {

					OrderLineItemsXML orderLineItem = (OrderLineItemsXML) iterator2.next();

					OrderLineItems newOrderLineItem = new OrderLineItems();

					Product product = searchProduct(orderLineItem.getProduct());
					newOrderLineItem.setProduct(product);

					newOrderLineItem.setQuantity(orderLineItem.getQuantity());
					newOrderLineItem.setRate(orderLineItem.getRate());
					newOrderLineItem.setDiscountPercentage(orderLineItem.getDiscountPercentage());
					newOrderLineItem.setDutyPercentage(orderLineItem.getDutyPercentage());
					newOrderLineItem.setSubtotal(orderLineItem.getSubtotal());

					newOrderLineItemList.add(newOrderLineItem);
				}

				newOrder.setOrderLineItems(newOrderLineItemList);
				newOrderList.add(newOrder);
			}

			Employee employee = searchEmployee(orderRoster.getImportedBy());
			newOrderRoster.setImportedBy(employee);
			newOrderRoster.setOrderDetail(newOrderList);
			Long id = createOrderRoster(newOrderRoster);
		}

	}

	public static List<OrderRosterXML> parseXML(InputStream is) {
		List<OrderRosterXML> importOrderList = new ArrayList<OrderRosterXML>();
		try {

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(is);
			doc.getDocumentElement().normalize();

			NodeList nodeList = doc.getElementsByTagName("Import");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element elem = (Element) node;

					String importDate = node.getAttributes().getNamedItem("importDate").getNodeValue();
					System.out.println("importDate :" + importDate);

					DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					Date date = df.parse(importDate);

					String importedBy = (elem.getElementsByTagName("importedBy").item(0).getChildNodes().item(0)
							.getNodeValue());
					System.out.println("importedBy :" + importedBy);

					Integer orderCounts = Integer.parseInt(
							elem.getElementsByTagName("orderCounts").item(0).getChildNodes().item(0).getNodeValue());
					System.out.println("orderCounts :" + orderCounts);

					String status = (elem.getElementsByTagName("status").item(0).getChildNodes().item(0)
							.getNodeValue());

					List<OrderXML> orderList = new ArrayList<OrderXML>();
					NodeList nodeList1 = elem.getElementsByTagName("order");
					for (int j = 0; j < nodeList1.getLength(); j++) {
						Node node1 = nodeList1.item(j);

						if (node1.getNodeType() == Node.ELEMENT_NODE) {
							Element elem1 = (Element) node1;

							String date1 = node1.getAttributes().getNamedItem("orderDate").getNodeValue();
							System.out.println("orderDate :" + date1);

							Date orderDate = df.parse(importDate);

							String salesRep = elem1.getElementsByTagName("salesRep").item(0).getChildNodes().item(0)
									.getNodeValue();
							System.out.println("salesRep :" + salesRep);

							String admin = elem1.getElementsByTagName("admin").item(0).getChildNodes().item(0)
									.getNodeValue();
							System.out.println("admin :" + admin);

							String supportEngineer = elem1.getElementsByTagName("supportEngineer").item(0)
									.getChildNodes().item(0).getNodeValue();
							System.out.println("supportEngineer :" + supportEngineer);

							String customer = elem1.getElementsByTagName("customer").item(0).getChildNodes().item(0)
									.getNodeValue();
							System.out.println("customer :" + customer);

							long orderTotal = Integer.parseInt(elem1.getElementsByTagName("orderTotal").item(0)
									.getChildNodes().item(0).getNodeValue());
							System.out.println("orderTotal :" + orderTotal);

							List<OrderLineItemsXML> orderLineItemList = new ArrayList<OrderLineItemsXML>();
							NodeList nodeList2 = elem1.getElementsByTagName("orderLineItem");
							for (int k = 0; k < nodeList2.getLength(); k++) {
								Node node2 = nodeList2.item(k);

								if (node2.getNodeType() == Node.ELEMENT_NODE) {
									Element elem2 = (Element) node2;

									String product = node2.getAttributes().getNamedItem("product").getNodeValue();
									System.out.println("product :" + product);

									int quantity = Integer.parseInt(elem2.getElementsByTagName("quantity").item(0)
											.getChildNodes().item(0).getNodeValue());
									System.out.println("quantity :" + quantity);

									int rate = Integer.parseInt(elem2.getElementsByTagName("rate").item(0)
											.getChildNodes().item(0).getNodeValue());
									System.out.println("rate :" + rate);

									int discountPercentage = Integer
											.parseInt(elem2.getElementsByTagName("discountPercentage").item(0)
													.getChildNodes().item(0).getNodeValue());
									System.out.println("discountPercentage :" + discountPercentage);

									int dutyPercentage = Integer.parseInt(elem2.getElementsByTagName("dutyPercentage")
											.item(0).getChildNodes().item(0).getNodeValue());
									System.out.println("dutyPercentage :" + dutyPercentage);

									long subtotal = Integer.parseInt(elem2.getElementsByTagName("subtotal").item(0)
											.getChildNodes().item(0).getNodeValue());
									System.out.println("subtotal :" + subtotal);

									OrderLineItemsXML orderLineItem = new OrderLineItemsXML();
									orderLineItem.setProduct(product);
									orderLineItem.setQuantity(quantity);
									orderLineItem.setRate(rate);
									orderLineItem.setDiscountPercentage(discountPercentage);
									orderLineItem.setDutyPercentage(dutyPercentage);
									orderLineItem.setSubtotal(subtotal);
									orderLineItemList.add(orderLineItem);

								}
							}
							OrderXML order = new OrderXML();
							order.setOrderDate(orderDate);
							order.setSalesRepresentative(salesRep);
							order.setAdministrator(admin);
							order.setSupportEngineer(supportEngineer);
							order.setCustomer(customer);
							order.setOrderTotal(orderTotal);
							order.setOrderLineItemsXML(orderLineItemList);
							orderList.add(order);

						}
					}

					OrderRosterXML order = new OrderRosterXML();

					order.setImportDate(date);
					order.setImportedBy(importedBy);
					order.setCountOfOrders(orderCounts);
					order.setStatus(status);
					order.setOrderXML(orderList);
					importOrderList.add(order);

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return importOrderList;
	}

	public static Employee searchEmployee(String empName) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<Employee> empList = new ArrayList<>();
		try {
			tx = session.beginTransaction();
			Criteria crit = session.createCriteria(Employee.class);
			crit.add(Restrictions.eq("employeeName", empName));
			empList = crit.list();
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return empList.get(0);
	}
/**
 * Method for getting orderRoster details by import ID	
 * @param importID
 * @return
 */
public OrderRoster getOrderRoster(long importID) {
		
	OrderRoster newOrderRoster = new OrderRoster();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			newOrderRoster = (OrderRoster) session.get(OrderRoster.class, importID);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return newOrderRoster;
	}

}
