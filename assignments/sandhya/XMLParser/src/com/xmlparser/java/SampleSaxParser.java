package com.xmlparser.java;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public final class SampleSaxParser {
    private SampleSaxParser() {
        throw new IllegalStateException("Utility class");
    }

    /**
     *
     * @param args
     */
    public static void main(final String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            UserHandler userhandler = new UserHandler();
            saxParser.parse("sample.xml", userhandler);
        } catch (Exception e) {
            e.printStackTrace();
        } // TODO Auto-generated method stub
    }
}
