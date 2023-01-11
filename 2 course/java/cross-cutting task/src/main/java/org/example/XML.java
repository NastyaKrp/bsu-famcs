package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XML {
    public static Node getLanguage(Document doc, String s, String ans) {
        Element line = doc.createElement("Line");
        line.appendChild(getLanguageElements(doc, line, "Task", s));
        line.appendChild(getLanguageElements(doc, line, "Answer", ans));
        return line;
    }

    static Node getLanguageElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }

    public static List<String> ReadXML(String file) throws ParserConfigurationException, IOException, SAXException {
        List<String> listXML = new ArrayList<>();
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.parse(file);

        Node root = document.getDocumentElement().getFirstChild();
        Node line = root.getNextSibling();
        while (line != null) {
            String str = line.getTextContent();
            String c = str.trim();
            if (c != ""){
                listXML.add(str);
            }
            line = line.getNextSibling();
        }
        return listXML;
    }

    public static void WriteXML(List<Sol> info, String file) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        builder = factory.newDocumentBuilder();
        Document document2 = builder.newDocument();
        Element element = document2.createElementNS("math", "answer");
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transform = transformerFactory.newTransformer();
        transform.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(document2);
        StreamResult result = new StreamResult(new File(file));
        String answerXML = String.valueOf(info.get(0).ans);
        String task = info.get(0).task;
        document2.appendChild(element);
        element.appendChild(XML.getLanguage(document2, task, answerXML));
        for (int i = 1; i <= info.size() - 1; i++) {
                answerXML = String.valueOf(info.get(i).ans);
                task = info.get(i).task;
                element.appendChild(XML.getLanguage(document2, task, answerXML));

        }
        transform.transform(source, result);
    }
}
