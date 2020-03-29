//package methods.specs;
//
//import io.restassured.RestAssured;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.http.ContentType;
//import io.restassured.specification.RequestSpecification;
//
//import java.util.ResourceBundle;
//
///**
// * Created by lovel on 15-Sep-19.
// */
//public class RequestSpecifcations extends RestAssuredDefaults  {
//  private static   ResourceBundle bundle = ResourceBundle.getBundle("env");
//   /* private static String baseUrl = "";
//    public static RequestSpecification getRestAPIAdminRequestSpec() {
//        baseUrl = bundle.getString("base.url.rest");
//        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
//        requestSpecBuilder.setAccept(ContentType.JSON);
//        //requestSpecBuilder.setContentType(ContentType.URLENC);
//        requestSpecBuilder.setBaseUri(baseUrl);
//        return requestSpecBuilder.build().log().all();
//    }*/
//   public static String  baseurl="";
//    public static RequestSpecification getSpecs(){
//        baseurl=bundle.getString("base.url");
//        RequestSpecBuilder requestSpecBuilder= new RequestSpecBuilder();
//        requestSpecBuilder.setAccept(ContentType.JSON);
//        requestSpecBuilder.setBaseUri(baseurl);
//        return requestSpecBuilder.build().log().all();
//    }
//}
