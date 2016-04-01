package com.pursuit.salesCommission.app.XMLReader;

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

import com.pursuit.salesCommission.app.api.EmployeeAPI;
import com.pursuit.salesCommission.app.model.Employee;
@Component
	public class ReadXMLFile {	
	  public static void main(String argv[]) {
		  ApplicationContext context = 
		            new ClassPathXmlApplicationContext("/applicationContext.xml");
		  EmployeeAPI empAPI = (EmployeeAPI) context.getBean("employeeApi");
		  
		  ReadXMLFile rdx = new ReadXMLFile();
		  List <Employee> empList = rdx.parseXML();
		  for (Iterator iterator = empList.iterator(); iterator.hasNext();) {
				
				Employee employee = (Employee) iterator.next();
				empAPI.createEmployee(employee);
		  }
	  }
	  public List<Employee> parseXML() {
		  List<Employee> employees = new ArrayList<Employee>();
		    try {

			File fXmlFile = new File("WebContent/WEB-INF/resources/XMLFile/employee.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			
	         NodeList nodeList = doc.getElementsByTagName("Employee");
	         for (int i = 0; i < nodeList.getLength(); i++) {
	              Node node = nodeList.item(i);

	              if (node.getNodeType() == Node.ELEMENT_NODE) {
	                   Element elem = (Element) node;
	 
	                   String empName = node.getAttributes().getNamedItem("Employeename").getNodeValue();
	                   
	                   String startDate = (elem.getElementsByTagName("StartDate")
	                		 		.item(0).getChildNodes().item(0).getNodeValue());
	                   Integer salary = Integer.parseInt(elem.getElementsByTagName("Salary")
	                                       .item(0).getChildNodes().item(0).getNodeValue());
	                   
	                   DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	                   Date date = df.parse(startDate); 
	                     Employee emp = new Employee();
	                     emp.setEmployeeName(empName);
	                     emp.setStartDate(date);
	                     emp.setSalary(salary);
	                     employees.add(emp);
	                   
	              }
	         }

	         // Print all employees.
	         for (Employee empl : employees) 
	              System.out.println(empl.toString());
	   
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		    return employees;
		  }

	}