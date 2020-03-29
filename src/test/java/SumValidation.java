import Files.Payload;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by lovel on 15-Mar-20.
 */
public class SumValidation {
    @Test
    public void sumOfCourses(){
        int sum=0;
        JsonPath js = new JsonPath(Payload.coursePrice());
        int coursesSize=js.getInt("courses.size()");
        for(int i=0; i<coursesSize;i++){
            int price=js.get("courses["+i+"].price");
            int copies=js.get("courses["+i+"].copies");
            int amount=price*copies;
            sum=sum+amount;
        }
        System.out.println(sum);
        int purchasedAmout=js.getInt("dashboard.purchaseAmount");
        Assert.assertEquals(sum,purchasedAmout);
    }
}
