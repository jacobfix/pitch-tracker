package com.jsoftworks.pitchtracker;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class GamedayXMLParser {

    public static List<Inning> parseAllInningsFile(String filename)
            throws ParserConfigurationException, IOException, SAXException {
        Document doc = loadXMLDocument(filename);

        List<Inning> innings = new ArrayList<>();
        NodeList inningNodes = doc.getDocumentElement().getElementsByTagName("inning");
        for (int i = 0; i < inningNodes.getLength(); i++)
            innings.add(parseInning(inningNodes.item(i)));

        return innings;
    }

    public static Inning parseInning(Node inningNode) {
        NamedNodeMap attrs = inningNode.getAttributes();

        List<AtBat> atBatsTop = new ArrayList<>();
        assert (inningNode.getFirstChild().getNodeName().equals("top"));
        NodeList atBatNodes = inningNode.getFirstChild().getChildNodes();
        for (int i = 0; i < atBatNodes.getLength(); i++) {
            atBatsTop.add(parseAtBat(atBatNodes.item(i)));
        }

        List<AtBat> atBatsBottom = new ArrayList<>();
        assert (inningNode.getLastChild().getNodeName().equals("bottom"));
        atBatNodes = inningNode.getLastChild().getChildNodes();
        for (int i = 0; i < atBatNodes.getLength(); i++) {
            assert (atBatNodes.item(i).getNodeName().equals("atbat"));
            atBatsBottom.add(parseAtBat(atBatNodes.item(i)));
        }

        return new Inning(getInt("num", attrs), get("away_team", attrs), get("home_team", attrs), atBatsTop,
                atBatsBottom);
    }

    private static AtBat parseAtBat(Node atBatNode) {
        NamedNodeMap attrs = atBatNode.getAttributes();

        List<Pitch> pitches = new ArrayList<>();
        NodeList pitchNodes = atBatNode.getChildNodes();
        for (int i = 0; i < pitchNodes.getLength(); i++) {
            assert (pitchNodes.item(i).getNodeName().equals("pitch"));
            pitches.add(parsePitch(pitchNodes.item(i)));
        }

        return new AtBat(get("pitcher", attrs), get("batter", attrs),
                new int[] { getInt("b", attrs), getInt("s", attrs), getInt("o", attrs) }, get("des", attrs),
                get("event", attrs), pitches);
    }

    private static Pitch parsePitch(Node pitchNode) {
        NamedNodeMap attrs = pitchNode.getAttributes();
        return new Pitch(get("des", attrs), get("type", attrs), getDouble("start_speed", attrs),
                getDouble("end_speed", attrs), getDouble("pfx_x", attrs), getDouble("pfx_z", attrs),
                getDouble("px", attrs), getDouble("pz", attrs), getDouble("sz_top", attrs), getDouble("sz_bot", attrs),
                get("pitch_type", attrs));
    }

    private static String get(String itemName, NamedNodeMap attributes) {
        return attributes.getNamedItem(itemName).getNodeValue();
    }

    private static int getInt(String itemName, NamedNodeMap attributes) {
        return Integer.parseInt(get(itemName, attributes));
    }

    private static double getDouble(String itemName, NamedNodeMap attributes) {
        return Double.parseDouble(get(itemName, attributes));
    }

    private static Document loadXMLDocument(String filename)
            throws ParserConfigurationException, IOException, SAXException {
        File file = new File(filename);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(file);
        doc.getDocumentElement().normalize();
        return doc;
    }

}
