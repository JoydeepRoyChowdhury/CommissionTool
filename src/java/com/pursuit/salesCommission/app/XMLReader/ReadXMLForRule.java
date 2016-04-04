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
import com.pursuit.salesCommission.app.api.RuleSimpleAPI;
import com.pursuit.salesCommission.app.model.AggregateFunctions;
import com.pursuit.salesCommission.app.model.ConditionList;
import com.pursuit.salesCommission.app.model.Employee;
import com.pursuit.salesCommission.app.model.FieldList;
import com.pursuit.salesCommission.app.model.QualifyingClause;
import com.pursuit.salesCommission.app.model.QualifyingClauseUI;
import com.pursuit.salesCommission.app.model.Rule;
import com.pursuit.salesCommission.app.model.RuleParameter;
import com.pursuit.salesCommission.app.model.RuleSimple;

@Component
public class ReadXMLForRule {
	public static void main(String argv[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
		RuleAPI ruleAPI = (RuleAPI) context.getBean("ruleApi");
		RuleSimpleAPI ruleSimpleAPI = (RuleSimpleAPI) context.getBean("ruleSimpleApi");
		ReadXMLForRule rdx = new ReadXMLForRule();
		List<Rule> rList = rdx.parseXML();
		for (Iterator iterator = rList.iterator(); iterator.hasNext();) {

			Rule rule = (Rule) iterator.next();
			RuleSimple sRule = rule.getRuleSimple();

			AggregateFunctions aggtfun1 = ruleSimpleAPI
					.searchAggregateFunction(sRule.getAggregateFunctions().getFunctionName());
			sRule.setAggregateFunctions(aggtfun1);

			List<QualifyingClause> qClauselist = sRule.getQualifyingClause();
			List<QualifyingClause> qClslst = new ArrayList<>();
		/*	for (Iterator iterator1 = qClauselist.iterator(); iterator1.hasNext();) {
				QualifyingClause qCls = (QualifyingClause) iterator1.next();
				QualifyingClause nQCluase = new QualifyingClause();
				FieldList fldList = ruleSimpleAPI.searchFieldList(qCls.getFieldList().getDisplayName());
				ConditionList cnd = ruleSimpleAPI.searchCondition(qCls.getConditionList().getConditionValue());
				nQCluase.setConditionList(cnd);
				nQCluase.setFieldList(fldList);
				nQCluase.setValue(qCls.getValue());
				nQCluase.setNotFlag(qCls.isNotFlag());
				nQCluase.setIgnoreCase(qCls.isIgnoreCase());
				qClslst.add(nQCluase);
			} */
			sRule.setQualifyingClause(qClslst); 
			rule.setRuleSimple(sRule);

		//	ruleAPI.createRule(rule);
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

					String description = (elem.getElementsByTagName("Description").item(0).getChildNodes().item(0)
							.getNodeValue());

					String ruleType = (elem.getElementsByTagName("RuleType").item(0).getChildNodes().item(0)
							.getNodeValue());

					String compensationType = (elem.getElementsByTagName("CompensationType").item(0).getChildNodes()
							.item(0).getNodeValue());

					Integer CompensationValue = Integer.parseInt(elem.getElementsByTagName("CompensationValue").item(0)
							.getChildNodes().item(0).getNodeValue());
					
					List<RuleParameter> rulesParameter = new ArrayList<RuleParameter>();
					NodeList nodeList1 = elem.getElementsByTagName("RuleParameter");
					for (int j = 0; j < nodeList1.getLength(); j++) {
						Node node1 = nodeList1.item(j);

						if (node1.getNodeType() == Node.ELEMENT_NODE) {
							Element elem1 = (Element) node1;

							String parameterName = node1.getAttributes().getNamedItem("ParameterName").getNodeValue();

							System.out.println("param name :" + parameterName);

							String parameterValue = elem1.getElementsByTagName("ParameterValue").item(0).getChildNodes()
									.item(0).getNodeValue();

							System.out.println("param value :" + parameterValue);

							RuleParameter rp = new RuleParameter();
							rp.setParameterName(parameterName);
							rp.setParameterValue(parameterValue);
							rulesParameter.add(rp);

						}
					}

					String calculationMode = (elem.getElementsByTagName("CalculationMode").item(0).getChildNodes()
							.item(0).getNodeValue());

					String field = (elem.getElementsByTagName("Field").item(0).getChildNodes().item(0).getNodeValue());

					String functionName = (elem.getElementsByTagName("AggregateFun").item(0).getChildNodes().item(0)
							.getNodeValue());

			/*		List<QualifyingClause> qualifyingClauses = new ArrayList<QualifyingClause>();
					NodeList nodeList2 = doc.getElementsByTagName("QualifyingClause");
					for (int j = 0; j < nodeList2.getLength(); j++) {
						Node node2 = nodeList2.item(j);

						if (node2.getNodeType() == Node.ELEMENT_NODE) {
							Element elem2 = (Element) node2;

							String qValue = node2.getAttributes().getNamedItem("value").getNodeValue();
							System.out.println("value :" + qValue);

							String fieldListDisplayName = elem2.getElementsByTagName("FieldList").item(0)
									.getChildNodes().item(0).getNodeValue();
							System.out.println("value :" + fieldListDisplayName);

							Boolean notFlag = Boolean.parseBoolean(elem2.getElementsByTagName("notFlag").item(0)
									.getChildNodes().item(0).getNodeValue());
							System.out.println("value :" + notFlag);

							String conditionListValue = elem2.getElementsByTagName("ConditionList").item(0)
									.getChildNodes().item(0).getNodeValue();
							System.out.println("value :" + conditionListValue);

							Boolean ignoreCase = Boolean.parseBoolean(elem2.getElementsByTagName("ignoreCase").item(0)
									.getChildNodes().item(0).getNodeValue());
							System.out.println("value :" + ignoreCase);

							QualifyingClause qClause = new QualifyingClause();

							qClause.setValue(qValue);

							FieldList fldlst = new FieldList();
							fldlst.setDisplayName(fieldListDisplayName);
							qClause.setFieldList(fldlst);

							ConditionList cndlst = new ConditionList();
							cndlst.setConditionValue(conditionListValue);
							qClause.setConditionList(cndlst);

							qClause.setNotFlag(notFlag);
							qClause.setIgnoreCase(ignoreCase);

							qualifyingClauses.add(qClause);

						}
					} */

					Rule r = new Rule();

					r.setRuleName(ruleName);
					r.setDescription(description);
					r.setRuleType(ruleType);
					r.setRuleParameter(rulesParameter);
					r.setCompensationType(compensationType);
					r.setFixedCompValue(CompensationValue);

					RuleSimple rs = new RuleSimple();
					AggregateFunctions aggregateFunction = new AggregateFunctions();
					aggregateFunction.setFunctionName(functionName);
					rs.setAggregateFunctions(aggregateFunction);
					rs.setCalculationMode(calculationMode);
					rs.setField(field);
				//	rs.setQualifyingClause(qualifyingClauses);

					r.setRuleSimple(rs);

					rules.add(r);

				}
			}

			for (Rule rl : rules)
				System.out.println(rl.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rules;
	}

}