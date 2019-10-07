package by.epam.task3.parser;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class Parser {
    private static String separator = File.separator;


    public static boolean validate() {
        String xsdPath = "src"+separator+"by"+separator+"epam"+separator+"task3"+separator+"files"+separator+"gem.xsd";
        String xmlPath = "src"+separator+"by"+separator+"epam"+separator+"task3"+separator+"files"+separator+"gem.xml";

        try {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
        } catch (IOException | SAXException e) {
            System.out.println("Exception: "+e.getMessage());
            return false;
        }
        return true;
    }

    public static String getSeparator() {
        return separator;
    }
}
