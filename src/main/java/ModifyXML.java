import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ModifyXML {

    private static final Logger log = Logger.getLogger(String.valueOf(ModifyXML.class));

    public static void main(String[] args) throws TransformerException, IOException, SAXException, ParserConfigurationException {
        String filepath = "./src/main/resources/universityModify.xml";
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        docFactory.setNamespaceAware(true);
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(filepath);

        Node student = doc.getElementsByTagNameNS("http://sasha.rsatu.ru","student").item(0);
        // update staff attribute
        NamedNodeMap attr = student.getAttributes();

//        Node nodeAttr = attr.getNamedItemNS("http://sasha.rsatu.ru","id");
//        nodeAttr.setTextContent("2234432");

        // append a new node to staff
        Element age = doc.createElementNS("http://sasha.rsatu.ru","Lastname");
        age.appendChild(doc.createTextNode("ALENA"));
        //age.appendChild(doc.c("http://sasha.rsatu.ru","Alena"));
        student.appendChild(age);

        // loop the staff child node
        NodeList list = student.getChildNodes();

        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);

            // get the salary element, and update the value
            if ("sas:Education".equals(node.getNodeName())) {
                node.setTextContent("работает234");
            }

        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(filepath));
        transformer.transform(source, result);

        System.out.println("Done");
        log.info("Done");

    }
}
