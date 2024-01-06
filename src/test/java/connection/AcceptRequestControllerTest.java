//package connection;
//
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.util.JSONPObject;
//import org.json.JSONObject;
//import org.junit.Assert;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.web.client.RestClientException;
//import org.springframework.web.client.RestTemplate;
//import requestdata.RequestData;
//
//import javax.servlet.ServletResponse;
//import java.io.IOException;
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.util.HashMap;
//import java.util.Map;
//
//import static org.junit.Assert.*;
//
//
////"table_key": 3,
////"start_date": "2020-01-01",
////"end_date": "2020-01-02"
//
//
//public class AcceptRequestControllerTest {
//
//    private static RestTemplate restTemplate;
//    private static JSONObject jsonObject;
//    private static HttpHeaders headers;
//    private static String uri;
//
//    public AcceptRequestControllerTest() {
//    }
//
//    public static JSONObject requestBody(){
//        String uri = "10.10.5.21:6150/get_count";
//        String table_key = "2";
//        String start_date = "2020-01-01";
//        String end_date = "2020-01-02";
////        String end_date = "0";
//        Map<String, String> map = new HashMap<>();
//        map.put("table_key", table_key);
//        map.put("start_date", start_date);
//        map.put("end_date", end_date);
//        JSONObject jsonObject = new JSONObject(map);
//        return jsonObject;
//    }
//
////    protected String uri = "10.10.5.21:6150/get_count";
//
//
////    @Autowired
////    private TestRestTemplate restTemplate;
//
//    @BeforeClass
//    public static void runBeforeAllTestMethods() {
////        createPersonUrl = "http://localhost:8082/spring-rest/createPerson";
////        updatePersonUrl = "http://localhost:8082/spring-rest/updatePerson";
//        uri = "http://10.10.5.21:6150/get_count";
//        restTemplate = new RestTemplate();
//        headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        jsonObject = requestBody();
//    }
//
//    private final ObjectMapper objectMapper = new ObjectMapper();
//
//    @Test
//    public void connectDb() throws URISyntaxException, IOException {
//        HttpEntity<String> request = new HttpEntity<>(jsonObject.toString(), headers);
//
//        String responseResult = restTemplate.postForObject(uri, request, String.class);
////        JsonNode root = objectMapper.readTree(responseResult);
//        System.out.println(responseResult);
//        assertNotNull(responseResult);
////        assertNotNull(root);
////        assertNotNull(root.path("name").asText());
//    }
//
//
//
//
//
////    @org.junit.Test
////    public void connectDb() throws URISyntaxException, RestClientException {
////
////        final String baseUrl = "http://10.10.5.21:6150/get_count";
////        URI uri = new URI(baseUrl);
//////        Employee employee = new Employee(null, "Adam", "Gilly", "test@email.com");
////        JSONObject post_req = requestBody();
//////        JSONObject post_req = new JSONObject();
//////        RequestData requestData = new RequestData(1, "2020-01-01","2020-01-02");
////        HttpHeaders headers = new HttpHeaders();
////        headers.setContentType(MediaType.APPLICATION_JSON);
//////        System.out.println(post_req);
////        HttpEntity<JSONObject> request = new HttpEntity<>(post_req, headers);
//////        HttpEntity<String> request = new HttpEntity<>(post_req.toString());
//////        HttpEntity request = new HttpEntity(post_req);
////        System.out.println(uri);
////        System.out.println(request);
////        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
////        //Verify request succeed
////        Assert.assertEquals(200, result.getStatusCodeValue());
////
////    }
//
//    @org.junit.Test
//    public void fetchCount() {
//    }
//}