package wawer.kamil.model;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Parser {

    private final XmlMapper xmlMapper;

    private final File inputFile = new File("src/main/resources/input.xml").getAbsoluteFile();
    private final File outputFile = new File("src/main/resources/output.xml").getAbsoluteFile();

    public Parser() {
        this.xmlMapper = new XmlMapper();
        this.xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public AccountList readFromXML() throws IOException {
        return xmlMapper.readValue(inputFile, AccountList.class);
    }

    public void writeToXML(List<Account> accounts) throws IOException {
        xmlMapper.configure( ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true );
        xmlMapper.writeValue(outputFile, new AccountList(accounts));
    }

}
