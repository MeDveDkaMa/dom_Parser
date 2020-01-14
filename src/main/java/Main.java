import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("/home/alexander/IdeaProjects/Dom_Parser/src/main/resources/university.xml"));
        document.getDocumentElement().normalize();
        Element element = document.getDocumentElement();
        System.out.println("Root element: " + document.getDocumentElement().getNodeName());

        NodeList nList = document.getElementsByTagName("administration");
        NodeList nList2 = document.getElementsByTagName("student");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName() + nNode.getTextContent());
        }

        for (int temp = 0; temp < nList2.getLength(); temp++) {
            Node nNode2 = nList2.item(temp);
            System.out.println("\nCurrent Element :" + nNode2.getNodeName() + nNode2.getTextContent());
        }

        Validate.getValidateXML();
    }

}
