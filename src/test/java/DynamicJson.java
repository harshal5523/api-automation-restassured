public class DynamicJson {

    public String userCreate(String firstName, String lastName, String email, String empid) {
        String userCreatePayload = "{  \n" +
                "  \"attributes\": [\n" +
                "    {\n" +
                "      \"attributeId\": 1,\n" +
                "      \"attributeName\": \"firstname\",\n" +
                "      \"value\": \""+firstName+"\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"attributeId\": 2,\n" +
                "      \"attributeName\": \"lastname\",\n" +
                "      \"value\": \""+lastName+"\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"attributeId\": 3,\n" +
                "      \"attributeName\": \"email\",\n" +
                "      \"value\": \""+email+"\"    },\n" +
                "    {\n" +
                "      \"attributeId\": 5,\n" +
                "      \"attributeName\": \"phone\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"attributeId\": 6,\n" +
                "      \"attributeName\": \"gender\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"attributeId\": 7,\n" +
                "      \"attributeName\": \"birthdate\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"attributeId\": 8,\n" +
                "      \"attributeName\": \"title\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"attributeId\": 9,\n" +
                "      \"attributeName\": \"bio\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"attributeId\": 10,\n" +
                "      \"attributeName\": \"employeeid\",\n" +
                "      \"value\": \""+empid+"\"\n" +
                "    }\n" +
                "      ],\n" +
                "\"password\": \"mobinett1!\",\n" +
                "\"generatePassword\": false,\n" +
                "  \"specificPassword\": true,\n" +
                "  \"setUpPasswordFirstLogin\": false,\n" +
                "  \"sendAccountInformation\": false,\n" +
                "  \"changePasswordAtNextLogin\": false\n" +
                "}\n" +
                "  \n";
        return userCreatePayload;


    }

    public String createAttribute(String attributeName, String hint) {
        String createAttributePayload = "{\n" +
                "  \"attributeType\": \"text\",\n" +
                "  \"attributeName\": \""+attributeName+"\",\n" +
                "  \"level\": 0,\n" +
                "  \"languages\": [\n" +
                "    {\n" +
                "      \"languageId\": 1,\n" +
                "      \"langCode\": \"en\",\n" +
                "      \"isUpdatedManually\": false,\n" +
                "      \"hint\": \""+hint+"\",\n" +
                "      \"name\": \"Text Attribute\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"defaultField\": false\n" +
                "}";
        return createAttributePayload;

    }

    public String createGroupPayload(String name, String groupDesc){
       String createGroupPayload= "{\"name\":\""+name+"\",\""+groupDesc+"\":\"TEST\"}";
       return createGroupPayload;

    }
}
