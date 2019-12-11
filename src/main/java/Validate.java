import org.xml.sax.SAXException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class Validate {
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
        System.out.println("============================================");
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
