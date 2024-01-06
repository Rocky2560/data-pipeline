package connection;

import com.datastax.driver.core.*;
import com.datastax.driver.core.Statement;
import misc.Queries;
import misc.Status;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import requestdata.RequestData;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


@RestController

//@PropertySource("file:/etc/bigmart_fetch_count/dbconfig.properties")
//@PropertySource("file:/etc/bigmart_fetch_count/application.properties")

public class AcceptRequestController {
    @Autowired
    private Environment env;
    public AcceptRequestController() {}

    String start_date = "";
    String end_date = "";
    private Logger log = Logger.getLogger(AcceptRequestController.class);
    private Connection conn;
    private Queries queries = new Queries();
    private int table_key;
    private String table_name;
    private String url;
    private String user;
    private String pass;



    @RequestMapping(value = "/get_count", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
    public Map<String, Object> connectDb(@RequestBody RequestData requestData){
        this.table_key = requestData.getTable_key();
        this.start_date = requestData.getStart_date();
        this.end_date = requestData.getEnd_date();
        Map<String,Object> final_map = new HashMap<>();
        final_map = FetchCount();
        return final_map;
    }

    public Map<String, Object> FetchCount(){
        Map<String, Object> al = new TreeMap<>();
        String fetch_query = "";

        SocketOptions options = new SocketOptions();
        options.setConnectTimeoutMillis(300000);
        options.setReadTimeoutMillis(3000000);
        options.setTcpNoDelay(true);

        Cluster cluster = Cluster.builder()
//                .withoutJMXReporting()
//                .withSocketOptions(options)
                .addContactPoints("127.0.0.1")
                .withPort(Integer.parseInt("9042"))
                .withCredentials("cassandra", "super")
//                .withSSL()
                .build();

        Session session = cluster.connect(env.getProperty("test"));

//        if (table_key == 1){
//            table_name = env.getProperty("1");
//            fetch_query = queries.QACountQuery(table_name,start_date,end_date);
//        } else if (table_key == 2){
//            table_name = env.getProperty("2");
//            fetch_query = queries.QACountQuery(table_name,start_date,end_date);
//        } else if (table_key == 3){
//            table_name = env.getProperty("3");
//            fetch_query = queries.QACountQuerySite(table_name);
//        } else {
//            al.put("Status", Status.DB_MAP_NOT_FOUND);
//        }

        try {
            Statement statement = new SimpleStatement(fetch_query);
            for (Row row: session.execute(statement)) {
                System.out.println(row.toString());
                al.put("Count", row.getObject(0));
            }
        }
        catch (Exception e){
            e.printStackTrace();
            al.put("Status", Status.DB_MAP_NOT_FOUND);
        }

        return al;
    }
}

