package wawer.kamil.model;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.List;

public class Parser {

    private XmlMapper xmlMapper;

    public Parser() {
        this.xmlMapper = new XmlMapper();
        this.xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public AccountList readFromXML(File xmlFile) throws IOException {
        return xmlMapper.readValue(xmlFile, AccountList.class);
    }

    public void writeToXML(List<Account> accounts, File output) throws IOException {
        xmlMapper.writeValue(output, new AccountList(accounts));
    }

}
