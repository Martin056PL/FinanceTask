package wawer.kamil.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.List;

public class Parser {

     private ObjectMapper objectMapper;

    public Parser() {
        this.objectMapper = new XmlMapper();
    }

    public AccountList readFromXML() throws IOException {
        return objectMapper.readValue(
                readTextFromFile(), AccountList.class);
    }

    public void writeToXML(List<Account> account) throws IOException {
        objectMapper.writeValue(new
                File("src/main/resources/SortedData.xml"), account);
    }

    private String readTextFromFile() throws IOException {

        InputStream in = new FileInputStream("src/main/resources/SourceData.xml");
        BufferedReader buff = new BufferedReader(new InputStreamReader(in));

        String line = buff.readLine();
        StringBuilder builder = new StringBuilder();

        while(line != null){
            builder.append(line).append("\n");
            line = buff.readLine(); }

        return builder.toString();
    }
}
