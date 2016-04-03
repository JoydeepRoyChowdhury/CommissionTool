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
import com.pursuit.salesCommission.app.api.RuleAPI;
import com.pursuit.salesCommission.app.model.Employee;
import com.pursuit.salesCommission.app.model.Rule;
import com.pursuit.salesCommission.app.model.RuleSimple;
@Component
	public class ReadXMLForRule {	
	  public static void main(String argv[]) {
		  ApplicationContext context = 
		            new ClassPathXmlApplicationContext("/applicationContext.xml");
		  RuleAPI ruleAPI = (RuleAPI) context.getBean("ruleApi");
		  
		  ReadXMLForRule rdx = new ReadXMLForRule();
		  List <Rule> rList = rdx.parseXML();
		  for (Iterator iterator = rList.iterator(); iterator.hasNext();) {
				
				Rule rule = (Rule) iterator.next();
				Rule nRule = new Rule();
				nRule.setRuleName(rule.getRuleName());
				nRule.setDescription(rule.getDescription());
				nRule.setRuleType(rule.getRuleType());
				RuleSimple sRule = new RuleSimple();
				//sRule.setCalculationMode(rule.getRuleSimple().getCalculationMode());
				//nRule.setRuleSimple(sRule);
				//ruleAPI.createRule(rule);
		  }
	  }
	  public List<Rule> parseXML() {
		  List<Rule> rules = new ArrayList<Rule>();
		    try {

			File fXmlFile = new File("WebContent/WEB-INF/resources/XMLFile/rule.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			
	         NodeList nodeList = doc.getElementsByTagName("Rule");
	         for (int i = 0; i < nodeList.getLength(); i++) {
	              Node node = nodeList.item(i);

	              if (node.getNodeType() == Node.ELEMENT_NODE) {
	                   Element elem = (Element) node;
	 
	                   String ruleName = node.getAttributes().getNamedItem("RuleName").getNodeValue();
	                   
	                   String description = (elem.getElementsByTagName("Description")
	                		 		.item(0).getChildNodes().item(0).getNodeValue());
	                   
	                   String ruleType = (elem.getElementsByTagName("RuleType")
               		 		.item(0).getChildNodes().item(0).getNodeValue());
	                   
	                   String calculationMode = (elem.getElementsByTagName("CalculationMode")
	               		 		.item(0).getChildNodes().item(0).getNodeValue());
	                   
	                 //  Integer salary = Integer.parseInt(elem.getElementsByTagName("Salary")
	                                 //      .item(0).getChildNodes().item(0).getNodeValue());
	                   
	                  
	                     Rule r = new Rule();
	                    r.setRuleName(ruleName);
	                    r.setDescription(description);
	                    r.setRuleType(ruleType);
	                 //   r.getRuleSimple().setCalculationMode(calculationMode);
	                    rules.add(r);
	                   
	              }
	         }

	         // Print all employees.
	         for (Rule rl : rules) 
	              System.out.println(rl.toString());
	   
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		    return rules;
		  }

	}