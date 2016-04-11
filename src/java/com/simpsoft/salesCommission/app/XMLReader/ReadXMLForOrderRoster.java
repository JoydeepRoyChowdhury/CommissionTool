
package com.simpsoft.salesCommission.app.XMLReader;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
	
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.simpsoft.salesCommission.app.api.EmployeeAPI;
import com.simpsoft.salesCommission.app.api.OrderAPI;
import com.simpsoft.salesCommission.app.dataloader.OrderRosterXML;
import com.simpsoft.salesCommission.app.model.CustomerType;
import com.simpsoft.salesCommission.app.model.Employee;
import com.simpsoft.salesCommission.app.model.OrderRoster;

@Component
	public class ReadXMLForOrderRoster {	
	  public static void main(String argv[]) {
		  ApplicationContext context = 
		            new ClassPathXmlApplicationContext("/applicationContext.xml");
		  OrderAPI ordrAPI = (OrderAPI) context.getBean("orderApi"); 
		  EmployeeAPI empAPI = (EmployeeAPI) context.getBean("employeeApi");
		  
		  ReadXMLForOrderRoster rdx = new ReadXMLForOrderRoster();
		  List <OrderRosterXML> orderList = rdx.parseXML();
		  for (Iterator iterator = orderList.iterator(); iterator.hasNext();) {
				
			  OrderRosterXML order = (OrderRosterXML) iterator.next();
			  OrderRoster newOrder = new OrderRoster();
			  
			  newOrder.setImportDate(order.getImportDate());			  
			  newOrder.setCountOfOrders(order.getCountOfOrders());
			  newOrder.setStatus(order.getStatus());
			  //Employee employee = new Employee();
			  //employee.setEmployeeName(order.getImportedBy());
			  Employee employee = empAPI.searchEmployee(order.getImportedBy());
			  newOrder.setImportedBy(employee);
			  ordrAPI. createOrderRoster(newOrder);
		  } 
	  }
	  public List<OrderRosterXML> parseXML() {
		  List<OrderRosterXML> orderList = new ArrayList<OrderRosterXML>();
		    try {

			File fXmlFile = new File("WebContent/WEB-INF/resources/XMLFile/orderRoster.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
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
	                   
	                   String importedBy = (elem.getElementsByTagName("importedBy")
	               		 		.item(0).getChildNodes().item(0).getNodeValue());
	                   System.out.println("importedBy :" + importedBy);
	                   
	                   Integer orderCounts = Integer.parseInt(elem.getElementsByTagName("orderCounts")
                               .item(0).getChildNodes().item(0).getNodeValue());
	                   System.out.println("orderCounts :" + orderCounts);
	                   
	                   String status = (elem.getElementsByTagName("status")
               		 		.item(0).getChildNodes().item(0).getNodeValue());
	                   
	                   
	                   OrderRosterXML order = new OrderRosterXML();
	                   
	                   order.setImportDate(date);
	                   order.setImportedBy(importedBy);
	                   order.setCountOfOrders(orderCounts);
	                   order.setStatus(status);
	                   
	                   orderList.add(order);
	                   
	              }
	         }

	        
	   
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		    return orderList;
		  }

	}