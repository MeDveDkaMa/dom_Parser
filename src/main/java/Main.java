import org.apache.log4j.Logger;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import java.io.File;
import java.io.IOException;

public class Main {

    private static final Logger log = Logger.getLogger(String.valueOf(ModifyXML.class));

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("./src/main/resources/university.xml"));
        document.getDocumentElement().normalize();
        System.out.println("Root element: " + document.getDocumentElement().getNodeName());

        NodeList nList = document.getElementsByTagNameNS("http://sasha.rsatu.ru","administration");
        NodeList nList2 = document.getElementsByTagNameNS("http://sasha.rsatu.ru","student");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName() + nNode.getTextContent());
            log.info("Current Element: " + nNode.getTextContent());
        }

        for (int temp = 0; temp < nList2.getLength(); temp++) {
            Node nNode2 = nList2.item(temp);
            System.out.println("\nCurrent Element :" + nNode2.getNodeName() + nNode2.getTextContent());
            log.info("Current Element: " + nNode2.getTextContent());
        }
        log.info("End parsing ");

        Validate.getValidateXML();
    }

}
