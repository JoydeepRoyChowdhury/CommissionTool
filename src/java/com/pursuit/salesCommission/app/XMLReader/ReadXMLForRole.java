package com.pursuit.salesCommission.app.XMLReader;

	import javax.xml.parsers.DocumentBuilderFactory;
	import javax.xml.parsers.DocumentBuilder;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.ApplicationContext;
	import org.springframework.context.support.ClassPathXmlApplicationContext;
	import org.springframework.stereotype.Component;
	import org.w3c.dom.Document;
	import org.w3c.dom.NodeList;
		
	import org.w3c.dom.Node;
	import org.w3c.dom.Element;
	import java.io.File;
	import java.util.ArrayList;
	import java.util.Iterator;
	import java.util.List;

	import com.pursuit.salesCommission.app.api.EmployeeAPI;
import com.pursuit.salesCommission.app.api.RoleAPI;
import com.pursuit.salesCommission.app.model.Employee;
import com.pursuit.salesCommission.app.model.Role;
import com.pursuit.salesCommission.app.model.RoleXML;
	@Component
		public class ReadXMLForRole {	
		  public static void main(String argv[]) {
			  ApplicationContext context = 
			            new ClassPathXmlApplicationContext("/applicationContext.xml");
			  RoleAPI roleAPI = (RoleAPI) context.getBean("roleApi");
			  
			  ReadXMLForRole rdx = new ReadXMLForRole();
			  List <RoleXML> roleList = rdx.parseXML();
			  for (Iterator iterator = roleList.iterator(); iterator.hasNext();) {
					
				   Role nRole = (Role) iterator.next();
				   roleAPI.createRole(nRole);
			  }
		  }
		  public List<RoleXML> parseXML() {
			  List<RoleXML> rolesXML = new ArrayList<RoleXML>();
			    try {

				File fXmlFile = new File("WebContent/WEB-INF/resources/XMLFile/role.xml");
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(fXmlFile);
				doc.getDocumentElement().normalize();

				
		         NodeList nodeList = doc.getElementsByTagName("Role");
		         for (int i = 0; i < nodeList.getLength(); i++) {
		              Node node = nodeList.item(i);

		              if (node.getNodeType() == Node.ELEMENT_NODE) {
		                   Element elem = (Element) node;
		 
		                
		                   String roleName = node.getAttributes().getNamedItem("Rolename").getNodeValue();
		                   String description = elem.getElementsByTagName("Description")
                                           .item(0).getChildNodes().item(0).getNodeValue();
		                   String reportsTo = elem.getElementsByTagName("ReportsTo")
                                   .item(0).getChildNodes().item(0).getNodeValue();
		                   
		                   RoleXML nrole = new RoleXML();
		                   rolesXML.add(nrole);
		                   
		              }
		         }

		         // Print all employees.
		       //  for (Employee empl : employees) 
		       //       System.out.println(empl.toString());
		   
			    } catch (Exception e) {
				e.printStackTrace();
			    }
			    return rolesXML;
			  }

		
}
