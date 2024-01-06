package misc;

public class Queries {


    public String QACountQuery(String table_name, String start_date, String end_date){
        return "select count(*) from test";
    }

    public String QACountQuerySite(String table_name){
        return "select count(*) from " + table_name + "";
    }

}
