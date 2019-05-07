package wawer.kamil.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Parser {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new XmlMapper();

        // Reads from XML and converts to POJO

        AccountList account = objectMapper.readValue(
                StringUtils.toEncodedString(Files.readAllBytes
                        (Paths.get("src/main/resources/SourceData.xml"))
                        ,StandardCharsets.UTF_8), AccountList.class);

        System.out.println(account);

         //Reads from POJO and converts to XML

        objectMapper.writeValue(new File("src/main/resources/SortedData.xml"),account);
    }
}
