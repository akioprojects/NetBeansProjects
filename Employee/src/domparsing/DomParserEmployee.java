package domparsing;

import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Ivan
 */

public class DomParserEmployee {

    ArrayList<Employee> employees = new ArrayList<Employee>();
    Document dom;


    public void runExample() {
        loadXMLFileIntoDOM(); //parse the xml file and get the dom object

        parseTheDOM();//get each drink element, create a Drink object and insert it into the AL

        outputData(); //Iterate through the AL and print the data
    }


    private void loadXMLFileIntoDOM(){
        //get the factory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            //Using factory get an instance of document builder
            DocumentBuilder db = dbf.newDocumentBuilder();

            //parse using builder to get DOM representation of the XML
            //file
            dom = db.parse("Personnel.xml");
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    private void parseTheDOM(){
        //get the root elememt (i.e. SoftDrinks)
        Element docEle = dom.getDocumentElement();

        //get a nodelist of <Drink> elements
        NodeList nl = docEle.getElementsByTagName("Employee");
        if(nl != null && nl.getLength() > 0) {
            for(int i = 0 ; i < nl.getLength();i++) {
                //get the drink element
                //  item(n) returns a Node object (i.e. you must
                //cast it)
                //  Node is a parent interface of Element
                //             Node
                //				/ \
                //				 |
                //				 |
                //			  Element
                Element el = (Element)nl.item(i);

                //get the Drink object
                Employee e = getEmployee(el);

                //add it to list
                employees.add(e);
            }
        }
    }


    /**
     * I take a Drink element and read the values in, create
     * a Drink object and return it
     * @param empEl
     * @return
     */
    private Employee getEmployee(Element empEl) {
        //for each <Drink> element get text or int values of
        //name ,id, age and name
        
        
        
        String type = empEl.getAttribute("type");
        int id      = Integer.parseInt(getTextValue(empEl,"Id"));
        int age     = Integer.parseInt(getTextValue(empEl,"Age"));
        String name = getTextValue(empEl,"Name");
        //Create a new Drink with the value read from the xml nodes
        Employee e = new Employee(name,age,id,type);

        return e;
    }


    /**
     * I take an xml element and the tag name, look for the tag and get
     * the text content
     * i.e for <Drink><company>CocaCola</company></Drink> xml snippet if
     * the Element points to a Drink node and tagName is company I will return
     * CocaCola
     * @param ele
     * @param tagName
     * @return
     */
    private String getTextValue(Element ele, String tagName) {
            String textVal = null;
            NodeList nl = ele.getElementsByTagName(tagName);
            if(nl != null && nl.getLength() > 0) {
                    Element el = (Element)nl.item(0);
                    textVal = el.getFirstChild().getNodeValue();
                    Node n = el.getFirstChild();
                    System.out.println("n.nodeName "+n.getNodeName());
                    System.out.println("n.nodeValue "+n.getNodeValue());
            }

            return textVal;
    }

    /**
     * Iterate through the list and print the
     * content to console
     */
    private void outputData(){

            System.out.println("No of Employees '" + employees.size() + "'.");

            for(Employee employee:employees){
                System.out.println(employee);
            }
    }


    public static void main(String[] args){
            //create an instance
            DomParserEmployee dpe = new DomParserEmployee();

            //call run example
            dpe.runExample();
    }

}
