import Files.Payload;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

/**
 * Created by lovel on 15-Mar-20.
 */
public class ComplexParseJson {
    @Test
    public void parseJson(){
        //Print No of courses returned by API
        JsonPath js= new JsonPath(Payload.coursePrice());
        int count = js.getInt("courses.size()");
        System.out.println(count);
        //Print Purchase Anount
        int purhchaseAMt=js.getInt("dashboard.purchaseAmount");
        System.out.println(purhchaseAMt);
        //Get Title of first course
        String firstCourse = js.get("courses[0].title");
        System.out.println(firstCourse);
        //Print all courses titles and respective prices
        for(int i =0; i<count; i++){
            String courseTitles = js.get("courses[" + i + "].title");
            System.out.println(js.get("courses["+i+"].price").toString());
            System.out.println(courseTitles);
            if(courseTitles.equalsIgnoreCase("RPA")){
                int copies=js.get("courses["+i+"].copies");
                System.out.println("Copies:"+copies);
                break;
            }
        }

    }



}
