import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("/home/alexander/IdeaProjects/Dom_Parser/src/main/resources/university.xml"));
        document.getDocumentElement().normalize();

        Element element = document.getDocumentElement();
        System.out.println(element.getTagName());

        NodeList nodeList = element.getChildNodes();
        validateXML();

    }

    public static void validateXML() throws SAXException, IOException {
        // 1. Поиск и создание экземпляра фабрики для языка XML Schema
        SchemaFactory factory2 = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");

        // 2. Компиляция схемы
        // Схема загружается в объект типа java.io.File, но вы также можете использовать
        // классы java.net.URL и javax.xml.transform.Source
        File schemaLocation = new File("/home/alexander/IdeaProjects/Dom_Parser/src/main/resources/university.xsd");
        Schema schema = factory2.newSchema(schemaLocation);

        // 3. Создание валидатора для схемы
        Validator validator = schema.newValidator();

        // 4. Разбор проверяемого документа
        Source source = new StreamSource("/home/alexander/IdeaProjects/Dom_Parser/src/main/resources/university.xml");

        // 5. Валидация документа
        try {
            validator.validate(source);
            System.out.println("XML is valid.");
        }
        catch (SAXException ex) {
            System.out.println("XML is not valid because ");
            System.out.println(ex.getMessage());
        }

    }
}
