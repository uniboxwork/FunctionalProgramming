
import java.util.HashMap;

public class Student {

    public enum CourseType {CS1, CS2, CS3, CS4, CS5}
    public enum Module {Mod1, Mod2, Mod3, Mod4, Mod5, Mod6, Mod7, Mod8, Mod9, Mod10}

    int id;
    String firstName;
    String lastName;
    String addressLn1;
    String addressLn2;
    String city;
    String postCode;
    String country;
    String phoneNumber;
    String email;
    CourseType courseType;              //holder for enumerated courseType
    //HashMap<String,Double> modules      //Module ID Name: Module Mark %
    HashMap<Student.Module,Double> modules;     //Module    enum Name: Module Mark 0.00%
    Double queryResult;





    //constructor
    public Student( //input
                    int id,
                    String firstName,
                    String lastName,
                    String addressLn1,
                    String addressLn2,
                    String city,
                    String postCode,
                    String country,
                    String phoneNumber,
                    String email,
                    CourseType courseType,
                    HashMap<Student.Module, Double> modules,
                    Double queryResult

    ) {


        //read into member variables...

        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.addressLn1=addressLn1;
        this.addressLn2=addressLn2;
        this.city=city;
        this.postCode=postCode;
        this.country=country;
        this.phoneNumber=phoneNumber;
        this.email=email;
        this.courseType=courseType;
        this.modules=modules;
        this.queryResult=queryResult;



    }



    //getters...

    public int getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getAddressLn1() { return addressLn1; }
    public String getAddressLn2() { return addressLn2; }
    public String getCity() { return city; }
    public String getPostCode() { return postCode; }
    public String getCountry() { return country; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEmail() { return email; }
    public CourseType getCourseType() { return courseType; }              //holder for enumerated courseType

    //HashMap<String,Double> modules      //Module ID Name: Module Mark %
    public HashMap<Student.Module,Double> getModules() { return modules; }
    public Double getQueryResult() { return queryResult; }




    //Setters....

    public void setId(int id) {  this.id = id; }
    public void setFirstName(String firstName) {  this.firstName = firstName; }
    public void setLastName(String lastName) {  this.lastName = lastName; }
    public void setAddressLn1(String addressLn1) {  this.addressLn1 = addressLn1; }
    public void setAddressLn2(String addressLn2) {  this.addressLn2 = addressLn2; }
    public void setCity(String city) {  this.city = city; }
    public void setPostCode(String postCode) {  this.postCode = postCode; }
    public void setCountry(String country) {  this.country = country; }
    public void setPhoneNumber(String phoneNumber) {  this.phoneNumber = phoneNumber; }
    public void setEmail(String email) {  this.email = email; }
    public void setCourseType(CourseType courseType) {  this.courseType = courseType; }              //holder for enumerated courseType

    //HashMap<String,Double> modules      //Module ID Name: Module Mark %
    public void setModules(HashMap<Student.Module,Double> modules) {  this.modules = modules; }
    public void setQueryResult(Double queryResult) { this.queryResult = queryResult; }








    public String toString() {
        String result = "";
        String space = "      ";

        result += ("" + this.id +
                space +
                this.firstName +
                space +
                this.lastName +
                space +
                this.addressLn1 +
                space +
                this.addressLn2 +
                space +
                this.city +
                space +
                this.postCode +
                space +
                this.country +
                space +
                this.phoneNumber +
                space +
                this.email +
                space +
                courseType.toString() +
                space +
                modules.toString() +
                space +
                "QueryResult: " +
                String.format("%.2f", this.queryResult)
                //queryResult
        );


        return result;

    }









}//end record Student
