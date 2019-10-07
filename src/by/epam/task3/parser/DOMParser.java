package by.epam.task3.parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import by.epam.task3.gem.Gem;
import by.epam.task3.gem.VisualGem;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class DOMParser extends Parser {

    public static ArrayList<Gem> parseGem() {

        //validate the Gem XML file
        if(!validate()) throw new RuntimeException("XML File is not Valid");

        ArrayList<Gem> gemList = new ArrayList();

        //get Document of the XML File
        Document beerDocument = getBeerDocument();

        //get all Jewel pieces from the document
        NodeList nodeList = beerDocument.getElementsByTagName("Jewel");

        //Parse each Jewel element into Gem Object separatly
        for(int pos = 0; pos < nodeList.getLength(); pos++) {
            Node current = nodeList.item(pos);
            gemList.add(parseElement((Element)current));
        }
        return gemList;
    }


    private static Document getBeerDocument() {
        try {
            File file = new File("src"+getSeparator()+"by"+getSeparator()+"epam"+getSeparator()+"task3"+getSeparator()+"files"+getSeparator()+"gem.xml");
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = (Document) dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            return doc;
        }

        catch(IOException | ParserConfigurationException | SAXException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private static Gem parseElement(Element element) {

        Gem gem = new Gem();
        gem.setId(element.getAttribute("id"));

        gem.setName(element.getElementsByTagName("Name").item(0).getTextContent());
        gem.setPreciousness(element.getElementsByTagName("Preciousness").item(0).getTextContent());
        gem.setOrigin(element.getElementsByTagName("Origin").item(0).getTextContent());
        gem.setValue(Integer.parseInt(element.getElementsByTagName("Value").item(0).getTextContent()));

        Element visualGem = (Element) element.getElementsByTagName("VisualParameters").item(0);
        VisualGem visual = new VisualGem();

        visual.setTransparency(Integer.parseInt(visualGem.getAttribute("transparency")));
        visual.setColor(visualGem.getElementsByTagName("color").item(0).getTextContent());
        visual.setEdges(Integer.parseInt(visualGem.getElementsByTagName("edges").item(0).getTextContent()));

        //Concatenate characteristics with the gem
        gem.setParam(visual);

        //object is ready to use
        return gem;
    }
}
