package org.example;

import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.File;
import java.util.Set;

public class EmailValidator {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode schemaNode = mapper.readTree(new File("C:\\Users\\Lenovo\\OneDrive\\Desktop\\Java\\Week 5\\Day 2\\json\\email_schema.json"));
        JsonNode dataNode = mapper.readTree(new File("C:\\Users\\Lenovo\\OneDrive\\Desktop\\Java\\Week 5\\Day 2\\json\\email_input.json"));

        JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);
        JsonSchema schema = factory.getSchema(schemaNode);

        Set<ValidationMessage> errors = schema.validate(dataNode);
        if (errors.isEmpty()) {
            System.out.println("Email is valid.");
        } else {
            System.out.println("Validation errors:");
            errors.forEach(e -> System.out.println(e.getMessage()));
        }
    }
}
