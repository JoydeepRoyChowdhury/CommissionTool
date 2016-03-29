package com.pursuit.salesCommission.app.api;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
	
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.pursuit.salesCommission.app.model.Employee;

	public class ReadXMLFile {
		@Autowired
		private EmployeeAPI employeeApi;
	  public static void main(String argv[]) {
		  ApplicationContext context = 
		             new ClassPathXmlApplicationContext("classpath*:/META-INF/spring/applicationContext*.xml");
	    try {

		File fXmlFile = new File("src/java/employee1.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		doc.getDocumentElement().normalize();

		 List<Employee> employees = new ArrayList<Employee>();
         NodeList nodeList = doc.getElementsByTagName("Employee");
         for (int i = 0; i < nodeList.getLength(); i++) {
              Node node = nodeList.item(i);

              if (node.getNodeType() == Node.ELEMENT_NODE) {
                   Element elem = (Element) node;
 
                   long ID = Integer.parseInt(node.getAttributes().getNamedItem("ID").getNodeValue());
                  
                   String firstname = elem.getElementsByTagName("Employeename")
                                       .item(0).getChildNodes().item(0).getNodeValue();

                   Integer salary = Integer.parseInt(elem.getElementsByTagName("Salary")
                                       .item(0).getChildNodes().item(0).getNodeValue());
                     Employee emp = new Employee(ID, firstname, salary);
                     EmployeeAPIXML rx = new EmployeeAPIXML();
                     Employee e = rx.createEmployee(ID, firstname);
                   employees.add(emp);
              }
         }

         // Print all employees.
         for (Employee empl : employees)
              System.out.println(empl.toString());
   
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	  }
	  public void createEmp(Employee emp){
		  employeeApi.createEmployee(emp);
	  }
	}