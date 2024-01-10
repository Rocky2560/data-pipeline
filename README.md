## Spring Boot Template 

This is a Spring boot template for all spring application. It will provide standard api configuration and 
project structure for spring boot application.

#### Steps to run :
1) <code> java -jar <app>.jar --spring.config.location=<properties file location> </code>

The endpoint in this project are:

Endpoint: validate
Info: Returns lpcardno of the existing user, only returns first user incase multiple users are registered with the same mobile number
URL: 182.93.86.58:2076/validate
Format: 
<code>
{
	"mobile_no": "String"
	}
</code>
Endpoint: enc_date_table
Info: Returns records from a table based on certain date range
URL: 182.93.86.58:2076/enc_date_table
Format: 
<code>
{
	"table_name": "String",
	"start_date": "String",
	"end_date": "String",
	"date_column": "String"
	}
</code>
Endpoint: sales_history
Info: Counts total records for mutiple lpcardno's and starts to fetch sales history of users and returns last fetch offset. After all records are fetched for those lpcardno, status done is sent.
URL: 182.93.86.58:2076/sales_history
Format: 
<code>
{	
	"start_date": "String",
	"end_date": "String",
	"lpcardno": "String",
	"limit": int,
	"offset_value": int
	}
 </code>
Endpoint: enc_table
Info: Returns records from a table that do not have date column. Records are fetched on the basis of last offset
URL: 182.93.86.58:2076/enc_table
Format: 
<code>
{
	"table_name": "String",
	"offset_value": int
	}
</code>
