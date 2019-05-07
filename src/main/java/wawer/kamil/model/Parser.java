package wawer.kamil.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class Parser {

     private ObjectMapper objectMapper;

    public Parser() {
        this.objectMapper = new XmlMapper();
    }

    public AccountList readFromXML() throws IOException {
        return objectMapper.readValue(
                StringUtils.toEncodedString(Files.readAllBytes
                                (Paths.get("src/main/resources/SourceData.xml"))
                        , StandardCharsets.UTF_8), AccountList.class);
    }

    public void writeToXML(List<Account> account) throws IOException {
        objectMapper.writeValue(new
                File("src/main/resources/SortedData.xml"), account);
    }
}
