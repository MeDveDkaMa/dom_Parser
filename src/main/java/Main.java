import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("/home/alexander/IdeaProjects/Dom_Parser/src/main/resources/university.xml"));
        document.getDocumentElement().normalize();
        Element element = document.getDocumentElement();
        System.out.println("Root element: " + document.getDocumentElement().getNodeName());

        NodeList nList = document.getElementsByTagName("administration");

        for (int i = 0; i < nList.getLength(); i++) {
           Node node = nList.item(i);
            System.out.println("");
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) node;
                System.out.println("id:" + element.getElementsByTagName("id").item(0).getTextContent());
                System.out.println("Name:" + element.getElementsByTagName("FirstName").item(0).getTextContent());
                System.out.println("Name:" + element.getElementsByTagName("LastName").item(0).getTextContent());
            }
        }

       Validate.validateXML();

    }


}
