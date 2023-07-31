package com.example.traincartlocation;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
public class XmlParser {
    private static String xmlFileName = "";
    private Document xmlDom;
    public XmlParser (String fileName) {
        xmlFileName = fileName;
        createDom();
    }

    public String[] sectionList(int trainNumber, int wagonNumber){
        String[] results = {""};
        XPath xPath = XPathFactory.newInstance().newXPath();
        try {
            NodeList trains = (NodeList) xPath.compile("/station/tracks/track/trains/train").evaluate(xmlDom, XPathConstants.NODESET);
            for (int i = 0; i < trains.getLength(); i++) {
                Node trainNode = trains.item(i);
                boolean correctTrain = false;
                if (trainNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element train = (Element) trainNode;
                    NodeList trainNumbers = (NodeList) xPath.compile("trainNumbers/trainNumber").evaluate(train, XPathConstants.NODESET);
                    for (int j = 0; j < trainNumbers.getLength(); j++) {
                        int number = Integer.parseInt(trainNumbers.item(j).getTextContent());
                        if (number == trainNumber) {
                            correctTrain = true;
                            break;
                        }
                    }
                    if (correctTrain) {
                        NodeList wagons = (NodeList) xPath.compile("waggons/waggon").evaluate(train, XPathConstants.NODESET);
                        for (int k = 0; k < wagons.getLength(); k++) {
                            Node wagon = wagons.item(k);
                            String numberString = (String) xPath.compile("number").evaluate(wagon, XPathConstants.STRING);
                            if (!numberString.isEmpty() && Integer.parseInt(numberString) == wagonNumber) {
                                NodeList sections = (NodeList) xPath.compile("sections/identifier").evaluate(wagon, XPathConstants.NODESET);
                                results = new String[sections.getLength()];
                                for (int l = 0; l < sections.getLength(); l++) {
                                    results[l] = sections.item(l).getTextContent();
                                }
                                return results;
                            }
                        }
                    }
                }
            }
        } catch (XPathExpressionException e) {
            throw new RuntimeException(e);
        }
        return results;
    }

    private void createDom() {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            File xmlFile = new File(xmlFileName);
            xmlDom = builder.parse(xmlFile);
            xmlDom.getDocumentElement().normalize();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
