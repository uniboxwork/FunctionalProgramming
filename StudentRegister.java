import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class StudentRegister {

    //public enum CourseType {CS, CSG, SE}

    private int idCounter =0;  //counter for issuing id numbers to new students. Incremented each time a new student is created.

    ArrayList<Student> studentsList;


    //constructor
    public StudentRegister() {

        studentsList = new ArrayList<Student>(); //initialise students

        //==================
        //TEST DATA SET
        //==================

        //used: https://www.ofcom.org.uk/phones-telecoms-and-internet/advice-for-consumers/advice/telephone-area-codes-tool
        //  to get phone number area codes

        this.add("Adam", "Ingshurst", "67 Ottascar Road", "Edgehorton","London","SW17 4PQ","United Kingdom", "0207 587 923", "a.ingshurst@somewhere.zzz", Student.CourseType.CS1, Student.Module.Mod1, 57.1, Student.Module.Mod2, 63.8, Student.Module.Mod3, 70.2, Student.Module.Mod4, 67.9, Student.Module.Mod5, 77.3, Student.Module.Mod6, 71.3, 0.0);
        this.add("Brian", "Linkhurst", "41 Jogshurst Street","Gilston","Manchester","MN15 4PQ","United Kingdom","0161 678 321","b.linkhurst@somewhere.zzz", Student.CourseType.CS3, Student.Module.Mod1, 33.5, Student.Module.Mod2, 60.7, Student.Module.Mod3, 73.8, Student.Module.Mod4, 58.5, Student.Module.Mod5, 63.3, Student.Module.Mod6, 68.7,0.0);
        this.add("Carl", "Finehart", "54 Ecclesfield Gardens","Lymehill","Birmingham","BM12 9RT","United Kingdom", "0121 453 299","c.finehart@somewhere.zzz", Student.CourseType.CS5, Student.Module.Mod1, 49.2, Student.Module.Mod2, 65.4, Student.Module.Mod3, 72.6, Student.Module.Mod4, 71.3, Student.Module.Mod5, 82.8, Student.Module.Mod6, 85.1,0.0);
        this.add("Donald", "Mannings", "91 Illy Road","Queensleigh","Sheffield","SD45 2PT","United Kingdom","0114 786 211","d.mannings@somewhere.zzz", Student.CourseType.CS1, Student.Module.Mod1, 30.3, Student.Module.Mod2, 49.4, Student.Module.Mod3, 55.2, Student.Module.Mod4, 50.9, Student.Module.Mod5, 58.3, Student.Module.Mod6, 53.9,0.0);
        this.add("Earon", "O'Neil", "72 Nayhurst Drive", "Kiddering","Nottingham","NM10 5WE","United Kingdom","0115 987 320","e.oneil@somewhere.zzz", Student.CourseType.CS5, Student.Module.Mod1, 52.4, Student.Module.Mod2, 59.3, Student.Module.Mod3, 60.1, Student.Module.Mod4, 50.2, Student.Module.Mod5, 55.3, Student.Module.Mod6, 61.7,0.0);
        this.add("Frank", "Knottings", "98 Briggs Street","Ottersbridge","Bradford","BD18 4PX","United Kingdom","01274 561 115","f.knottings@somewhere.zzz", Student.CourseType.CS3, Student.Module.Mod1, 25.1, Student.Module.Mod2, 33.7, Student.Module.Mod3, 50.2, Student.Module.Mod4, 33.5, Student.Module.Mod5, 39.7, Student.Module.Mod6, 40.1,0.0);
        this.add("Graham", "Potter", "1 Queensbury Ave","Yandon","Newcastle","NC67 7BN","Australia","0061 123 233","g.potter@somewhere.zzz", Student.CourseType.CS2, Student.Module.Mod1, 80.2, Student.Module.Mod2, 87.3, Student.Module.Mod3, 79.6, Student.Module.Mod4, 77.9, Student.Module.Mod5, 83.8, Student.Module.Mod6, 90.3,0.0);
        this.add("Harry", "Richardson", "66 Stibbingsworth Ave","Norrington","Bath","BA22 9YQ","United Kingdom","01225 786 541","h.richardson@somewhere.zzz", Student.CourseType.CS4, Student.Module.Mod1, 49.5, Student.Module.Mod2, 58.6, Student.Module.Mod3, 65.9, Student.Module.Mod4, 62.3, Student.Module.Mod5, 69.3, Student.Module.Mod6, 63.4,0.0);
        this.add("Ian", "Davidson", "77 Farning Street","Ripefield","Liverpool","LL13 3PT","United Kingdom","0151 977 599","i.davidson@somewhere.zzz", Student.CourseType.CS5, Student.Module.Mod1, 57.1, Student.Module.Mod2, 63.8, Student.Module.Mod3, 70.2, Student.Module.Mod4, 67.9, Student.Module.Mod5, 77.3, Student.Module.Mod6, 71.3,0.0);
        this.add("Javin", "Queensford", "60 Pilotsail Road","Ashford Park","London","NW5 7TN","United Kingdom","0207 321 788","j.queensford@somewhere.zzz", Student.CourseType.CS1, Student.Module.Mod1, 89.2, Student.Module.Mod2, 90.2, Student.Module.Mod3, 92.3, Student.Module.Mod4, 95.5, Student.Module.Mod5, 89.1, Student.Module.Mod6, 98.1,0.0);
        this.add("Kevin", "Vanright", "45 Richgreen Close","Jennington", "Manchester","MN25 7HX","United Kingdom","0161 993 462","k.vanright@somewhere.zzz", Student.CourseType.CS4, Student.Module.Mod1, 29.1, Student.Module.Mod2, 39.4, Student.Module.Mod3, 35.1, Student.Module.Mod4, 32.3, Student.Module.Mod5, 28.7, Student.Module.Mod6, 40.8,0.0);
        this.add("Liam", "Churning", "89 Harlton Drive","Stridmouth","Birmingham","BM55 2YS","U.S.A.","001 968-421-936","l.churning@somewhere.zzz",  Student.CourseType.CS2, Student.Module.Mod1, 94.2, Student.Module.Mod2, 68.8, Student.Module.Mod3, 57.2, Student.Module.Mod4, 73.4, Student.Module.Mod5, 80.0, Student.Module.Mod6, 78.1,0.0);
        this.add("Marvin", "Urqsbridge", "34 Avon Road", "Pilkhurst","Newcastle","NC33 6JK","United Kingdom","01915 323 788","m.urqsbridge@somewhere.zzz", Student.CourseType.CS5, Student.Module.Mod1, 57.1, Student.Module.Mod2, 63.8, Student.Module.Mod3, 70.2, Student.Module.Mod4, 67.9, Student.Module.Mod5, 77.3, Student.Module.Mod6, 71.3,0.0);
        this.add("Nigel", "Harting", "12 Carlisle Road","Britsand","Hull","HL30 2WR","United Kingdom","01482 905 781","n.hartiing@somewhere.zzz", Student.CourseType.CS3, Student.Module.Mod1, 89.1, Student.Module.Mod2, 91.7, Student.Module.Mod3, 92.8, Student.Module.Mod4, 88.7, Student.Module.Mod5, 92.5, Student.Module.Mod6, 91.3,0.0);
        this.add("Osmond", "Xandner", "33 Thanett Drive","Ittering", "Norwich","NH9 5ZR","United Kingdom","01603 929 561","o.xander@somewhere.zzz",Student.CourseType.CS1, Student.Module.Mod1, 60.8, Student.Module.Mod2, 59.2, Student.Module.Mod3, 66.9, Student.Module.Mod4, 75.2, Student.Module.Mod5, 69.1, Student.Module.Mod6, 68.9,0.0);
        this.add("Paul", "Zillings", "27 Millers Street","Tillington","Sunderland","SD39 1H5","New Zealand","064 198 234 546","p.zillings@somewhere.zzz", Student.CourseType.CS4, Student.Module.Mod1, 30.7, Student.Module.Mod2, 40.7, Student.Module.Mod3, 42.2, Student.Module.Mod4, 54.0, Student.Module.Mod5, 29.3, Student.Module.Mod6, 38.2,0.0);
        this.add("Quentin", "Tangott", "6 Yander Drive", "Xirencester","Manchester","MN41 7KR","United Kingdom","0161 709 785","q.tangott@somewhere.zzz",Student.CourseType.CS2, Student.Module.Mod1, 20.1, Student.Module.Mod2, 29.3, Student.Module.Mod3, 30.1, Student.Module.Mod4, 27.2, Student.Module.Mod5, 19.8, Student.Module.Mod6, 22.3,0.0);
        this.add("Richard", "Jennford", "82 Larkington Rise","Houndsburry","Sheffield","SD12 9QV","United Kingdom","0114 985 732","r.jennford@somewhere.zzz",  Student.CourseType.CS5, Student.Module.Mod1, 15.7, Student.Module.Mod2, 35.1, Student.Module.Mod3, 25.2, Student.Module.Mod4, 51.8, Student.Module.Mod5, 55.0, Student.Module.Mod6, 56.1,0.0);
        this.add("Stephen", "Billings", "3 Zippenhurst Drive","Waleburton","New York","NY10 4YP","U.S.A","001 897-432-459","s.billings@somewhere.zzz", Student.CourseType.CS1, Student.Module.Mod1, 80.4, Student.Module.Mod2, 75.1, Student.Module.Mod8, 74.7, Student.Module.Mod4, 79.3, Student.Module.Mod5, 85.8, Student.Module.Mod6, 89.4,0.0);
        this.add("Thomas", "Nettles", "14 Dunesberry Ave","Crankton","London","NE11 9DR","United Kingdom","0208 355 134","t.nettles@somewhere.zzz", Student.CourseType.CS1, Student.Module.Mod1, 98.7, Student.Module.Mod2, 86.3, Student.Module.Mod8, 85.8, Student.Module.Mod4, 77.6, Student.Module.Mod9, 89.3, Student.Module.Mod6, 88.3,0.0);
        this.add("Uriah", "Ellings", "5 Xyleuhurst ","Uxley","Brighton","BN45 7FL","United Kingdom","01273 455 989","u.ellings@somewhere.zzz", Student.CourseType.CS4, Student.Module.Mod1, 60.3, Student.Module.Mod2, 70.5, Student.Module.Mod8, 80.1, Student.Module.Mod4, 62.9, Student.Module.Mod5, 70.3, Student.Module.Mod6, 82.6,0.0);
        this.add("Victor", "Yellings", "20 Gatestone Road", "Farringdon","Exeter","EX19 5JN","United Kingdom", "01392 767 443","v.yellings@somewhere.zzz", Student.CourseType.CS2, Student.Module.Mod1, 84.3, Student.Module.Mod2, 79.7, Student.Module.Mod3, 81.4, Student.Module.Mod4, 72.5, Student.Module.Mod5, 76.8, Student.Module.Mod6, 89.1,0.0);
        this.add("Walter", "Adamson", "11 Utterington Road", "Midstone","Bournemouth","BH30 7DP","United Kingdom","01202 509 603","w.adamson@somewhere.zzz", Student.CourseType.CS4, Student.Module.Mod1, 40.6, Student.Module.Mod2, 48.5, Student.Module.Mod3, 47.7, Student.Module.Mod8, 49.9, Student.Module.Mod9, 50.3, Student.Module.Mod6, 58.9,0.0);
        this.add("Xuland", "Gillings", "112 Waddle Lane", "Dalsford","Yarmouth","YH14 8RT","United Kingdom","01493 677 308","x.gillings@somewhere.zzz", Student.CourseType.CS3, Student.Module.Mod1, 60.1, Student.Module.Mod2, 74.7, Student.Module.Mod3, 69.1, Student.Module.Mod4, 77.6, Student.Module.Mod5, 79.1, Student.Module.Mod6, 78.3,0.0);
        this.add("Yuzu", "Welters", "56 Kitterhurst Road","Valedon","London","SW5 9UT","United Kingdom","0208 565 477","y.welters@somewhere.zzz", Student.CourseType.CS1, Student.Module.Mod1, 90.1, Student.Module.Mod2, 88.7, Student.Module.Mod7, 79.3, Student.Module.Mod8, 70.3, Student.Module.Mod9, 90.0, Student.Module.Mod6, 98.2,0.0);
        this.add("Zach", "Stibbings", "101 Victoria Close","Stritford","Brighton","BN11 6AT","United Kingdom","01273 786 059","z.stibbings@somewhere.zzz", Student.CourseType.CS3, Student.Module.Mod1, 65.8, Student.Module.Mod2, 69.3, Student.Module.Mod3, 72.4, Student.Module.Mod4, 78.3, Student.Module.Mod5, 81.4, Student.Module.Mod6, 89.7,0.0);






        //System.out.println(studentsList.toString());

        printRegister();
        numberOfStudents();




    }//end constructor


        /*
        public ArrayList<String> studentSearch() {

            return result;
        }


         */





    public void numberOfStudents() {

        int count;

        System.out.println("==================");
        System.out.println("Number of students:");
        System.out.println(studentsList.stream().count());




    }//end numberOfStudents()


    public void totalAge() {

        System.out.println("======================");
        System.out.println("Age Total:");
        //System.out.println(studentsList.stream().reduce(s, Integer -> s.age()));



    }//end totalAge()


    /***
     * returns next ID number
     */
    private int newID() {

        int newID = this.idCounter;     //set newID to idCounter
        this.idCounter ++;              //increment id counter, ready for next use.

        return newID;
    }






    /***
     *  Adds a new student to the register
     */
    public void add(String firstName,
                    String lastName,
                    String addressLn1,
                    String addressLn2,
                    String city,
                    String postCode,
                    String country,
                    String phoneNumber,
                    String email,
                    Student.CourseType courseType,
                    Student.Module module1,
                    Double module1Score,
                    Student.Module module2,
                    Double module2Score,
                    Student.Module module3,
                    Double module3Score,
                    Student.Module module4,
                    Double module4Score,
                    Student.Module module5,
                    Double module5Score,
                    Student.Module module6,
                    Double module6Score,
                    Double queryResult
    )
    {

        System.out.println("StudentRegister.add()");



        //create hashmap of modules:scores...
        HashMap<Student.Module, Double> modules = new HashMap<>();

        modules.put(module1, module1Score);
        modules.put(module2, module2Score);
        modules.put(module3, module3Score);
        modules.put(module4, module4Score);
        modules.put(module5, module5Score);
        modules.put(module6, module6Score);


        //create and populate new student, then add to studentsList...
        studentsList.add(new Student(newID(),
                firstName,
                lastName,
                addressLn1,
                addressLn2,
                city,
                postCode,
                country,
                phoneNumber,
                email,
                courseType,
                modules,
                queryResult));                  //insert created modules hashmap

        System.out.println(studentsList);

    }


    /***
     *  Updates a student...
     */
    public void update() {
        System.out.println("StudentRegister.update()");

        //To update a student will require the creation of a new
        //student record as Java Records are immutable - they cannot be changed once created.
        //You will need to find the array position of the student with that ID
        //and then use ArrayList.set(index, newStudentObj); to replace
        //student with new student at that position in studentList

        //to find the index position, you will probably have to iterate
        //over the student ArrayList looking at each ID. When matched,
        //use ArrayList.set(index, newStudentObj); to replace with new student record



    }









    /***
     * Deletes a student...
     */
    public boolean delete(int deleteID) {

        //TODO: delete user from ArrayList
        System.out.println("StudentRegister.delete(int id)");


        ListIterator<Student> iterator = studentsList.listIterator();   //iterator for moving through studentLists

        boolean deletedFlag = false;    //flag for successful deletion
        Student myStudent;              //student placeholder

        while(iterator.hasNext()) { //loop while next student exists...

            //read next student
            myStudent = iterator.next();

            if(myStudent.getId() == deleteID) {    //student found...

                iterator.remove();      //delete student from studentsList
                deletedFlag = true;     //set delete success flag true
                break;                  //exit loop
            }


        }//end while

        return deletedFlag;     //return success/failure flag

    }




    //=====================================
    //              query
    //=====================================
    /***
     * Executes queries on the Student data
     * @return list of students matching query
     */
    public ArrayList<Student> query(String filter1_field, String filter1_operator, String filter1_value,      //filter 1 input
                                    String filter2_field, String filter2_operator, String filter2_value,      //filter 2 input
                                    String filter3_field, String filter3_operator, String filter3_value,      //filter 3 input
                                    String filter4_field, String filter4_operator, String filter4_value,      //filter 4 input
                                    String filter5_field, String filter5_operator, String filter5_value) {    //filter 5 input


        //Debug... check input...
        System.out.println("******************************");
        System.out.println("   StudentRegister.query()");
        System.out.println("******************************");
        System.out.println("filter1_field: " + filter1_field + "  filter1_operator: " + filter1_operator + "  filter1_value: " + filter1_value);
        System.out.println("filter2_field: " + filter2_field + "  filter2_operator: " + filter2_operator + "  filter2_value: " + filter2_value);
        System.out.println("filter3_field: " + filter3_field + "  filter3_operator: " + filter3_operator + "  filter3_value: " + filter3_value);
        System.out.println("filter4_field: " + filter4_field + "  filter4_operator: " + filter4_operator + "  filter4_value: " + filter4_value);
        System.out.println("filter5_field: " + filter5_field + "  filter5_operator: " + filter5_operator + "  filter5_value: " + filter5_value);



        //NOTE: could take in an ArrayList<Student> of students to perform the query on. Each recursive call
        //      can keep working on the list passed in. Would just need to run the appropriate command
        //      specified as an argument
        //      e.g.      public ArrayList<Student> query(ArrayList<Student> theList, filterType, opperandA, opperandB)




        /*

        //future possibility...
        //get stream of students...
        Stream<Student> studentStream = studentsList.stream();          //list of all students

        Stream<Student> streamResult = studentsList.stream();           //the resulting Students stream after filtering. ( has to be initialised to something )

        */

        //ArrayList<Student> resultsList = new ArrayList<>();   //holder for the resulting list of students to return


        //ArrayList<Student> resultsList = studentsList;   //holder for the resulting list of students. Filled with all students to begin with. NOTE: does this make a copy? Or just point to the original?

        //a copy can be made by passing the one ArrayList into the constructor of another...  from: https://www.delftstack.com/howto/java/copy-arraylist-java/  taken 04/01/24
        ArrayList<Student> resultsList = new ArrayList<>(studentsList);  // a complete independent copy.



        //----------------------------------------
        // clear previous queryResults (if any)
        //----------------------------------------
        //NOTE: can be done this way by converting to Stream and using our clearQueryResult function
        //resultsList = resultsList.stream().map(clearQueryResult).collect(Collectors.toCollection(ArrayList::new));
        resultsList.forEach(s -> s.queryResult = 0.00);




        //--------
        //filter 1
        //--------

        //is filter active?
        if(! filter1_operator.equals("--")) {          //operator NOT blank "--" - filter is active...

            //peform filter...
            resultsList = filter(resultsList, filter1_field, filter1_operator, filter1_value);   //pass in the full students list, with filter 1 fields


        }


        //--------
        //filter 2
        //--------
        //is filter active?
        if(! filter2_operator.equals("--")) {      //operator NOT blank "--" - filter is active...

            resultsList = filter(resultsList, filter2_field, filter2_operator, filter2_value);  //pass in resultsList and filter 2 fields

        }


        //--------
        //filter 3
        //--------
        //is filter active?
        if(! filter3_operator.equals("--")) {      //operator NOT blank "--" - filter is active...

            resultsList = filter(resultsList, filter3_field, filter3_operator, filter3_value);  //pass in resultsList and filter 3 fields

        }


        //--------
        //filter 4
        //--------
        //is filter active?
        if(! filter4_operator.equals("--")) {      //operator NOT blank "--" - filter is active...

            resultsList = filter(resultsList, filter4_field, filter4_operator, filter4_value);  //pass in resultsList and filter 4 fields

        }



        //--------
        //filter 5
        //--------
        //is filter active?
        if(! filter5_operator.equals("--")) {      //operator NOT blank "--" - filter is active...

            resultsList = filter(resultsList, filter5_field, filter5_operator, filter5_value);  //pass in resultsList and filter 5 fields

        }





        //this code returns all students in the list
        /*
        studentsList.stream()
                //.filter(s -> s.age() < 25)
                //.filter(s -> s.firstName().contains("c"))
                .forEach(s -> resultList.add(s));
        */

        //streamResult.forEach(student -> resultList.add(student));


        //=============================================
        //OVERIDE TO DISPLAY ALL STUDENTS (UN-FILTERED)
        //=============================================
        //display students list...
        //resultsList = this.studentsList;
        //=============================================

        return resultsList;      //return ArrayList<Students>



    }





    //===========
    //Filter
    //===========
    private ArrayList<Student> filter(ArrayList<Student> studentsList, String field, String operator, String value) {

        System.out.println("**************************");
        System.out.println("StudentRegister.filter()");
        System.out.println("**************************");
        System.out.println("studentsList: " + studentsList);
        System.out.println("field: " +field);
        System.out.println("operator: " + operator);
        System.out.println("value: " + value);

        //ArrayList<Student> resultsList = new ArrayList<>();     //holder for resultingList   empty initialisation

        ArrayList<Student> resultsList = studentsList;     //holder for resultingList          studentsList initialisation


        if(! operator.contentEquals("")) { //operator selected...


            //determine filter operator...
            switch(operator) {
                case "=":
                    System.out.println("inside case: '=' ");

                    //StudentQuery sq = new StudentQuery(field, operator, value, studentsList);   //wrapper for studentList

                    //resultsList = sq.studentList.stream().filter(s -> (s.firstName == sq.queryValue)).collect(Collectors.toCollection(ArrayList::new));

                    //collectors code came from:  https://www.java67.com/2016/03/how-to-get-arraylist-from-stream-in-java8-example.html  Soma Sharma 2021-2023 taken 04/01/23
                    //String myName = ("Frank");
                    //WORKING:
                    //resultsList = studentsList.stream().filter(s -> (s.firstName.contentEquals(value))).collect(Collectors.toCollection(ArrayList::new));

                    resultsList = filter_Equals(studentsList, field, value);


                    break;

                case "contains":
                    System.out.println("inside case: 'contains' ");

                    resultsList = filterContains(studentsList, field, value);
                    break;

                case ">":
                    System.out.println("inside case: 'GreaterThan >' ");

                    resultsList = filterGreaterThan(studentsList, field, value);
                    break;

                case "<":
                    System.out.println("inside case: 'LessThan <' ");

                    resultsList = filterLessThan(studentsList, field, value);
                    break;
                case "sort_Asc":
                    System.out.println("inside case: 'sort_Asc' ");

                    resultsList = filterSortAsc(studentsList, field, value);
                    break;
                case "sort_Dsc":
                    System.out.println("inside case: 'sort_Dsc' ");

                    resultsList = filterSortDsc(studentsList, field, value);
                    break;


            }//end switch()









        }else { //operator missing...
            //Error
            System.out.println("Error: - StudentRegister.filter(): operator missing");

        }


        //debug...
        System.out.println("studentRegister.filter().return: ");
        System.out.println("--------------------------------");
        System.out.println("" + resultsList);

        //return the resulting list of students...
        return resultsList;


    }



    //FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF
    //FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF

    //=========================================
    //F<> FUNCTIONAL PROGRAMMING FUNCTIONS F<>
    //=========================================
    BiPredicate<String, String> equalsString = (s1,s2) -> s1.contentEquals(s2);


    /***
     * ---------------------------
     * Function clearQueryResult
     * ---------------------------
     * Clears the queryResult field of a Student object
     */
    Function <Student, Student> clearQueryResult = s -> {   s.queryResult = 0.00;  return s;   };       // set the Student.queryResult to 0.00







    /***
     * ------------------------------
     * Function calculateHighScore
     * ------------------------------
     * Takes a Student object, finds highest module score, sets 'queryResult' field to highest score. Returns modified student.
     *
     */
    Function<Student, Student> calculateHighScore = s -> {

        Collection<Double> moduleScores = s.modules.values();   //get a collection of doubles. Collections do NOT have order i.e. 1, 2, 3, 4... etc. cannot be indexed like an array

        Double highestScore = 0.00;   //holder for this students highest score

        //loop for all Collection scores
        for(Double score: moduleScores) {

            if(score > highestScore) {

                highestScore = score;

            }

        }//end for


        s.queryResult = highestScore;       //set students queryResult field to highest score


        return s;   //return modified student
    };








    /***
     * --------------------------
     * Function lowestScore
     * ---------------------------
     */
    Function<Student, Student> calculateLowScore = s -> {
        Collection<Double> moduleScores = s.modules.values();   //get a collection of doubles. Collections do NOT have order i.e. 1, 2, 3, 4... etc. cannot be indexed like an array
        //TODO : could stream modules score .min() need to check not empty
        Double lowestScore = 100.00;   //holder for Students lowest score. Start at the maximum possible score (100.00%) and work lower...

        //loop for all Collection scores
        for(Double score: moduleScores) {

            if(score < lowestScore) {

                lowestScore = score;

            }

        }//end for

        s.queryResult = lowestScore;       //set students queryResult field to lowest score

        return s;
    };





    Function<Student, Student> calculateAVGScore = s-> {

        Collection<Double> moduleScores = s.modules.values();   //get a collection of doubles. Collections do NOT have order i.e. 1, 2, 3, 4... etc. cannot be indexed like an array

        Double totalScore = 0.00;           //holder for Students total score
        Double averageScore = 0.00;         //holder for calculated score average

        //loop for all Collection scores
        for(Double score: moduleScores) {

            totalScore += score;    //add score to total

        }//end for

        //check not 0. Can't divide by 0
        if(totalScore != 0.00) { //not 0...

            averageScore = totalScore/moduleScores.size();          //divide total score by the number of modules

        }


        s.queryResult = averageScore;       //set students queryResult field to averageScore


        return s;
    };

















    //FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF
    //FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF
    //FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF







    // Design...

    // filter()  -------->   filter_name()

    /***
     * Searches student for exact matching field. Returns resulting ArrayList<Student>
     * @param studentsList the list of students to be searched
     * @param field the field of Student to compare
     * @param value the value to compare the field against
     * @return ArrayList<Student> resultList of those that match criteria
     */
    public ArrayList<Student> filter_Equals(ArrayList<Student> studentsList, String field, String value) {

        ArrayList<Student> resultsList = new ArrayList<>();      //holder for resulting Student list


        //switch which field?
        switch(field) {


            case "id" :             //NOTE: this is an int    has to be treated differently
                //debug...
                System.out.println("filter_Equals() field: id");

                //convert String 'value' to int

                int targetValue = Integer.parseInt(value);

                resultsList = studentsList.stream().filter(s -> (s.id == targetValue)).collect(Collectors.toCollection(ArrayList::new));

                break;

            case "firstName" :
                //debug...
                System.out.println("filter_Equals() field: firstName");
                resultsList = studentsList.stream().filter(s -> (s.firstName.toLowerCase().contentEquals(value.toLowerCase()))).collect(Collectors.toCollection(ArrayList::new));
                break;

            case "lastName" :
                //debug...
                System.out.println("filter_Equals() field: lastName ");
                resultsList = studentsList.stream().filter(s -> (s.lastName.toLowerCase().contentEquals(value.toLowerCase()))).collect(Collectors.toCollection(ArrayList::new));
                break;

            case "addressLn1" :
                //debug...
                System.out.println("filter_Equals() field: addressLn1");
                resultsList = studentsList.stream().filter(s -> (s.addressLn1.toLowerCase().contentEquals(value.toLowerCase()))).collect(Collectors.toCollection(ArrayList::new));
                break;
            case "addressLn2" :
                //debug...
                System.out.println("filter_Equals() field: addressLn2");
                resultsList = studentsList.stream().filter(s -> (s.addressLn2.toLowerCase().contentEquals(value.toLowerCase()))).collect(Collectors.toCollection(ArrayList::new));
                break;
            case "city" :
                //debug...
                System.out.println("filter_Equals() field: city");
                resultsList = studentsList.stream().filter(s -> (s.city.toLowerCase().contentEquals(value.toLowerCase()))).collect(Collectors.toCollection(ArrayList::new));
                break;
            case "postCode" :
                //debug...
                System.out.println("filter_Equals() field: postCode");
                resultsList = studentsList.stream().filter(s -> (s.postCode.toLowerCase().contentEquals(value.toLowerCase()))).collect(Collectors.toCollection(ArrayList::new));
                break;
            case "country" :
                //debug...
                System.out.println("filter_Equals() field: country");
                resultsList = studentsList.stream().filter(s -> (s.country.toLowerCase().contentEquals(value.toLowerCase()))).collect(Collectors.toCollection(ArrayList::new));
                break;
            case "phoneNumber" :
                //debug...
                System.out.println("filter_Equals() field: phoneNumber");
                resultsList = studentsList.stream().filter(s -> (s.phoneNumber.toLowerCase().contentEquals(value.toLowerCase()))).collect(Collectors.toCollection(ArrayList::new));
                break;
            case "email" :
                //debug...
                System.out.println("filter_Equals() field: email");
                resultsList = studentsList.stream().filter(s -> (s.email.toLowerCase().contentEquals(value.toLowerCase()))).collect(Collectors.toCollection(ArrayList::new));
                break;
            case "courseType" :  //NOTE: ENUMERATED LIST - NEEDS TREATMENT
                //debug...
                System.out.println("filter_Equals() field: courseType");
                System.out.println("studentList.get(1).courseType.toString(): " +  studentsList.get(1).courseType.toString());

                resultsList = studentsList.stream().filter(s -> (s.courseType.toString().toLowerCase().contentEquals(value.toLowerCase()))).collect(Collectors.toCollection(ArrayList::new));

                break;
            case "modules" :    //NOTE: MAP<> - NEEDS TREATMENT     NEEDS SEARCH FOR KEY EXISTS, IF TRUE - THEN A MATCH      student.module is an Enumerated list value
                //debug...
                System.out.println("filter_Equals() field: modules");

                //convert String module selection to Student.Module enumeration...
                Student.Module studentModuleConverted = Student.Module.valueOf(value);       //convert the String 'value' field to an enumerated Student.Module value

                resultsList = studentsList.stream().filter(s -> (s.modules.containsKey(studentModuleConverted))).collect(Collectors.toCollection(ArrayList::new));


                //Working...
                            /*
                            resultsList = studentsList.stream().filter(s -> {
                                                                            Boolean result = false;
                                                                            if (s.modules.containsKey(myModule)) {
                                                                                result = true;
                                                                            }
                                                                            return result;

                                                                                            }).collect(Collectors.toCollection(ArrayList::new));

                            */


                break;
            case "HIGH_Score" :
                //debug...
                System.out.println("filter_Equals() field: HIGH_Score");

                //convert 'value' String to primitive double
                double targetHighScore = stringTo_double(value);

                //calculateHighScore for each Student and store in each Student's 'queryResult' field. Filter by queryResult == targetScore
                resultsList = studentsList.stream().map(calculateHighScore).filter(s -> (s.queryResult == targetHighScore)).collect(Collectors.toCollection(ArrayList::new));

                break;
            case "LOW_Score" :
                //debug...
                System.out.println("filter_Equals() field: LOW_Score");

                //convert 'value' String to primitive double
                double targetLowScore = stringTo_double(value);

                //calculateLowScore for each Student and store in each Student's 'queryResult' field. Filter by queryResult == targetScore
                resultsList = studentsList.stream().map(calculateLowScore).filter(s -> (s.queryResult == targetLowScore)).collect(Collectors.toCollection(ArrayList::new));


                break;

            case "AVG_Score" :
                //debug...
                System.out.println("filter_Equals() field: AVG_Score");

                //convert 'value' String to primitive double
                double targetAVGScore = stringTo_double(value);

                //calculateAVGScore for each Student and store in each Student's 'queryResult' field. Filter by queryResult == targetScore
                resultsList = studentsList.stream().map(calculateAVGScore).filter(s -> (s.queryResult == targetAVGScore)).collect(Collectors.toCollection(ArrayList::new));

                //Display all averages:
                //resultsList = studentsList.stream().map(calculateAVGScore).collect(Collectors.toCollection(ArrayList::new));

        }




        return resultsList;


    }











    /***
     * Searches student for field containing value. Returns resulting ArrayList<Student>
     * @param studentsList the list of students to be searched
     * @param field the field of Student to compare
     * @param value the value to compare the field against
     * @return ArrayList<Student> resultList of those that match criteria
     */
    public ArrayList<Student> filterContains(ArrayList<Student> studentsList, String field, String value) {

        ArrayList<Student> resultsList = new ArrayList<>();      //holder for resulting Student list


        //switch which field?
        switch(field) {


            case "id" :             //NOTE: this is an int    has to be treated differently
                //debug...
                System.out.println("filterContains() field: id");

                resultsList = studentsList.stream().filter(s -> {
                    String idString = ("" + s.id);          //convert int id to String

                    boolean contains = idString.contains(value);    //check if idString contains value

                    return contains;    //return result

                }).collect(Collectors.toCollection(ArrayList::new));


                break;

            case "firstName" :
                //debug...
                System.out.println("filterContains() field: firstName");

                resultsList = studentsList.stream().filter(s -> {

                    boolean contains = s.firstName.toLowerCase().contains(value.toLowerCase()); // convert to lowercase, check if contains value

                    return contains;  //return result

                }).collect(Collectors.toCollection(ArrayList::new));
                break;

            case "lastName" :
                //debug...
                System.out.println("filterContains() field: lastName ");

                resultsList = studentsList.stream().filter(s -> {

                    boolean contains = s.lastName.toLowerCase().contains(value.toLowerCase()); // convert to lowercase, check if contains value

                    return contains;  //return result

                }).collect(Collectors.toCollection(ArrayList::new));





                break;

            case "addressLn1" :
                //debug...
                System.out.println("filterContains() field: addressLn1");

                resultsList = studentsList.stream().filter(s -> {

                    boolean contains = s.addressLn1.toLowerCase().contains(value.toLowerCase()); // convert to lowercase, check if contains value

                    return contains;  //return result

                }).collect(Collectors.toCollection(ArrayList::new));



                break;
            case "addressLn2" :
                //debug...
                System.out.println("filterContains() field: addressLn2");


                resultsList = studentsList.stream().filter(s -> {

                    boolean contains = s.addressLn2.toLowerCase().contains(value.toLowerCase()); // convert to lowercase, check if contains value

                    return contains;  //return result

                }).collect(Collectors.toCollection(ArrayList::new));



                break;
            case "city" :
                //debug...
                System.out.println("filterContains() field: city");

                resultsList = studentsList.stream().filter(s -> {

                    boolean contains = s.city.toLowerCase().contains(value.toLowerCase()); // convert to lowercase, check if contains value

                    return contains;  //return result

                }).collect(Collectors.toCollection(ArrayList::new));

                break;
            case "postCode" :
                //debug...
                System.out.println("filterContains() field: postCode");

                resultsList = studentsList.stream().filter(s -> {

                    boolean contains = s.postCode.toLowerCase().contains(value.toLowerCase()); // convert to lowercase, check if contains value

                    return contains;  //return result

                }).collect(Collectors.toCollection(ArrayList::new));



                break;
            case "country" :
                //debug...
                System.out.println("filterContains() field: country");

                resultsList = studentsList.stream().filter(s -> {

                    boolean contains = s.country.toLowerCase().contains(value.toLowerCase()); // convert to lowercase, check if contains value

                    return contains;  //return result

                }).collect(Collectors.toCollection(ArrayList::new));


                break;
            case "phoneNumber" :
                //debug...
                System.out.println("filterContains() field: phoneNumber");

                resultsList = studentsList.stream().filter(s -> {

                    boolean contains = s.phoneNumber.toLowerCase().contains(value.toLowerCase()); // convert to lowercase, check if contains value

                    return contains;  //return result

                }).collect(Collectors.toCollection(ArrayList::new));




                break;
            case "email" :
                //debug...
                System.out.println("filterContains() field: email");


                resultsList = studentsList.stream().filter(s -> {

                    boolean contains = s.email.toLowerCase().contains(value.toLowerCase()); // convert to lowercase, check if contains value

                    return contains;  //return result

                }).collect(Collectors.toCollection(ArrayList::new));





                break;
            case "courseType" :  //NOTE: ENUMERATED LIST - NEEDS TREATMENT
                //debug...
                System.out.println("filterContains() field: courseType");

                resultsList = studentsList.stream().filter(s -> {

                    boolean contains = s.courseType.toString().toLowerCase().contains(value.toLowerCase());

                    return contains;

                }).collect(Collectors.toCollection(ArrayList::new));



                break;
            case "modules" :    //NOTE: MAP<> - NEEDS TREATMENT     NEEDS SEARCH FOR KEY EXISTS, IF TRUE - THEN A MATCH      student.module is an Enumerated list value
                //debug...
                System.out.println("filterContains() field: modules");

                resultsList = studentsList.stream().filter(s -> {

                    boolean contains = false;

                    for(Student.Module moduleKey: s.modules.keySet()) { //loop for all module keys (note: they are enums)

                        //convert module key enum to String
                        String moduleKeyString = moduleKey.toString();


                        //if moduleKeyString contains value, result is true
                        if(moduleKeyString.contains(value)) {
                            contains = true;
                        }

                    }

                    return contains;

                }).collect(Collectors.toCollection(ArrayList::new));
                //get list of all keys in map



                break;
            case "HIGH_Score" :
                //debug...
                System.out.println("filterContains() field: HIGH_Score");


                resultsList = studentsList.stream().map(calculateHighScore).filter(s -> {
                    boolean contains = false;

                    //convert highscore (queryResult) double to String
                    String highScoreString = s.queryResult.toString();

                    //check if highScoreString contains value String
                    contains = highScoreString.contains(value);

                    return contains;

                }).collect(Collectors.toCollection(ArrayList::new));


                break;
            case "LOW_Score" :
                //debug...
                System.out.println("filterContains() field: LOW_Score");


                resultsList = studentsList.stream().map(calculateLowScore).filter(s -> {
                    boolean contains = false;

                    //convert low score (queryResult) double to String
                    String lowScoreString = s.queryResult.toString();

                    //check if lowScoreString contains value String
                    contains = lowScoreString.contains(value);

                    return contains;

                }).collect(Collectors.toCollection(ArrayList::new));



                break;

            case "AVG_Score" :
                //debug...
                System.out.println("filterContains() field: AVG_Score");

                resultsList = studentsList.stream().map(calculateAVGScore).filter(s -> {
                    boolean contains = false;

                    //convert avgScore (queryResult) double to String
                    String avgScoreString = s.queryResult.toString();

                    //check if avgScoreString contains value String
                    contains = avgScoreString.contains(value);

                    return contains;

                }).collect(Collectors.toCollection(ArrayList::new));






        }




        return resultsList;


    }




























    /***
     * Searches student for field with greater than '>' value. Returns resulting ArrayList<Student>
     * @param studentsList the list of students to be searched
     * @param field the field of Student to compare
     * @param value the value to compare the field against
     * @return ArrayList<Student> resultList of those that match criteria
     */
    public ArrayList<Student> filterGreaterThan(ArrayList<Student> studentsList, String field, String value) {

        ArrayList<Student> resultsList = new ArrayList<>();      //holder for resulting Student list


        //switch which field?
        switch(field) {


            case "id" :             //NOTE: this is an int    has to be treated differently
                //debug...
                System.out.println("filterGreaterThan() field: id");

                //convert String 'value' to int
                int targetValue = Integer.parseInt(value);

                resultsList = studentsList.stream().filter(s -> (s.id > targetValue)).collect(Collectors.toCollection(ArrayList::new));

                break;

            case "firstName" :
                //debug...
                System.out.println("filterGreaterThan() field: firstName");

                //get all student first names in lowercase...
                ArrayList<String> arrayListFirstNames = studentsList.stream().map(s -> s.firstName.toLowerCase()).collect(Collectors.toCollection(ArrayList::new));

                //add 'value' to first names list in lowercase...
                arrayListFirstNames.add(value.toLowerCase());

                //sort the list including 'value' and reassign
                arrayListFirstNames = arrayListFirstNames.stream().sorted((n1, n2) -> n1.compareTo(n2)).collect(Collectors.toCollection(ArrayList::new));

                //convert list to final, for compatible use in stream api
                final ArrayList<String> finalArrayListFirstNames = arrayListFirstNames.stream().collect(Collectors.toCollection(ArrayList::new));

                //filter students list based on position in sorted list > than 'value' position
                resultsList = studentsList.stream().filter(s -> (finalArrayListFirstNames.indexOf(s.firstName.toLowerCase()) > finalArrayListFirstNames.indexOf(value.toLowerCase()))).collect(Collectors.toCollection(ArrayList::new));



                break;

            case "lastName" :
                //debug...
                System.out.println("filterGreaterThan() field: lastName ");

                //get all student last names in lowercase...
                ArrayList<String> arrayListLastNames = studentsList.stream().map(s -> s.lastName.toLowerCase()).collect(Collectors.toCollection(ArrayList::new));

                //add 'value' to last names list in lowercase...
                arrayListLastNames.add(value.toLowerCase());

                //sort the list including 'value' and reassign
                arrayListLastNames = arrayListLastNames.stream().sorted((n1, n2) -> n1.compareTo(n2)).collect(Collectors.toCollection(ArrayList::new));

                //convert list to final, for compatible use in stream api
                final ArrayList<String> finalArrayListLastNames = arrayListLastNames.stream().collect(Collectors.toCollection(ArrayList::new));

                //filter students list based on position in sorted list > than 'value' position
                resultsList = studentsList.stream().filter(s -> (finalArrayListLastNames.indexOf(s.lastName.toLowerCase()) > finalArrayListLastNames.indexOf(value.toLowerCase()))).collect(Collectors.toCollection(ArrayList::new));


                break;

            case "addressLn1" :
                //debug...
                System.out.println("filterGreaterThan() field: addressLn1");

                //get all student addressLn1 in lowercase...
                ArrayList<String> arrayListAddressLn1 = studentsList.stream().map(s -> s.addressLn1.toLowerCase()).collect(Collectors.toCollection(ArrayList::new));

                //add 'value' to address list in lowercase...
                arrayListAddressLn1.add(value.toLowerCase());

                //sort the list including 'value' and reassign
                arrayListAddressLn1 = arrayListAddressLn1.stream().sorted((n1, n2) -> n1.compareTo(n2)).collect(Collectors.toCollection(ArrayList::new));

                //convert list to final, for compatible use in stream api
                final ArrayList<String> finalArrayListAddressLn1 = arrayListAddressLn1.stream().collect(Collectors.toCollection(ArrayList::new));

                //filter students list based on  position in sorted list > than 'value' position
                resultsList = studentsList.stream().filter(s -> (finalArrayListAddressLn1.indexOf(s.addressLn1.toLowerCase()) > finalArrayListAddressLn1.indexOf(value.toLowerCase()))).collect(Collectors.toCollection(ArrayList::new));


                break;
            case "addressLn2" :
                //debug...
                System.out.println("filterGreaterThan() field: addressLn2");

                //get all student addressLn2 in lowercase...
                ArrayList<String> arrayListAddressLn2 = studentsList.stream().map(s -> s.addressLn2.toLowerCase()).collect(Collectors.toCollection(ArrayList::new));

                //add 'value' to address list in lowercase...
                arrayListAddressLn2.add(value.toLowerCase());

                //sort the list including 'value' and reassign
                arrayListAddressLn2 = arrayListAddressLn2.stream().sorted((n1, n2) -> n1.compareTo(n2)).collect(Collectors.toCollection(ArrayList::new));

                //convert list to final, for compatible use in stream api
                final ArrayList<String> finalArrayListAddressLn2 = arrayListAddressLn2.stream().collect(Collectors.toCollection(ArrayList::new));

                //filter students list based on  position in sorted list > than 'value' position
                resultsList = studentsList.stream().filter(s -> (finalArrayListAddressLn2.indexOf(s.addressLn2.toLowerCase()) > finalArrayListAddressLn2.indexOf(value.toLowerCase()))).collect(Collectors.toCollection(ArrayList::new));


                break;
            case "city" :
                //debug...
                System.out.println("filterGreaterThan() field: city");

                //get all student city in lowercase...
                ArrayList<String> arrayListCity = studentsList.stream().map(s -> s.city.toLowerCase()).collect(Collectors.toCollection(ArrayList::new));

                //add 'value' to city list in lowercase...
                arrayListCity.add(value.toLowerCase());

                //sort the list including 'value' and reassign
                arrayListCity = arrayListCity.stream().sorted((n1, n2) -> n1.compareTo(n2)).collect(Collectors.toCollection(ArrayList::new));

                //convert list to final, for compatible use in stream api
                final ArrayList<String> finalArrayListCity = arrayListCity.stream().collect(Collectors.toCollection(ArrayList::new));

                //filter students list based on  position in sorted list > than 'value' position
                resultsList = studentsList.stream().filter(s -> (finalArrayListCity.indexOf(s.city.toLowerCase()) > finalArrayListCity.indexOf(value.toLowerCase()))).collect(Collectors.toCollection(ArrayList::new));


                break;
            case "postCode" :
                //debug...
                System.out.println("filterGreaterThan() field: postCode");


                //get all student postCodes in lowercase...
                ArrayList<String> arrayListPostCode = studentsList.stream().map(s -> s.postCode.toLowerCase()).collect(Collectors.toCollection(ArrayList::new));

                //add 'value' to postCode list in lowercase...
                arrayListPostCode.add(value.toLowerCase());

                //sort the list including 'value' and reassign
                arrayListPostCode = arrayListPostCode.stream().sorted((n1, n2) -> n1.compareTo(n2)).collect(Collectors.toCollection(ArrayList::new));

                //convert list to final, for compatible use in stream api
                final ArrayList<String> finalArrayListPostCode = arrayListPostCode.stream().collect(Collectors.toCollection(ArrayList::new));

                //filter students list based on  position in sorted list > than 'value' position
                resultsList = studentsList.stream().filter(s -> (finalArrayListPostCode.indexOf(s.postCode.toLowerCase()) > finalArrayListPostCode.indexOf(value.toLowerCase()))).collect(Collectors.toCollection(ArrayList::new));


                break;
            case "country" :
                //debug...
                System.out.println("filterGreaterThan() field: country");

                //get all student addressLn1 in lowercase...
                ArrayList<String> arrayListCountry = studentsList.stream().map(s -> s.country.toLowerCase()).collect(Collectors.toCollection(ArrayList::new));

                //add 'value' to country list in lowercase...
                arrayListCountry.add(value.toLowerCase());

                //sort the list including 'value' and reassign
                arrayListCountry = arrayListCountry.stream().sorted((n1, n2) -> n1.compareTo(n2)).collect(Collectors.toCollection(ArrayList::new));

                //convert list to final, for compatible use in stream api
                final ArrayList<String> finalArrayListCountry = arrayListCountry.stream().collect(Collectors.toCollection(ArrayList::new));

                //filter students list based on  position in sorted list > than 'value' position
                resultsList = studentsList.stream().filter(s -> (finalArrayListCountry.indexOf(s.country.toLowerCase()) > finalArrayListCountry.indexOf(value.toLowerCase()))).collect(Collectors.toCollection(ArrayList::new));




                break;
            case "phoneNumber" :
                //debug...
                System.out.println("filterGreaterThan() field: phoneNumber");

                //get all student phoneNumber in lowercase...
                ArrayList<String> arrayListPhoneNumber = studentsList.stream().map(s -> s.phoneNumber.toLowerCase()).collect(Collectors.toCollection(ArrayList::new));

                //add 'value' to phoneNumber list in lowercase...
                arrayListPhoneNumber.add(value.toLowerCase());

                //sort the list including 'value' and reassign
                arrayListPhoneNumber = arrayListPhoneNumber.stream().sorted((n1, n2) -> n1.compareTo(n2)).collect(Collectors.toCollection(ArrayList::new));

                //convert list to final, for compatible use in stream api
                final ArrayList<String> finalArrayListPhoneNumber = arrayListPhoneNumber.stream().collect(Collectors.toCollection(ArrayList::new));

                //filter students list based on  position in sorted list > than 'value' position
                resultsList = studentsList.stream().filter(s -> (finalArrayListPhoneNumber.indexOf(s.phoneNumber.toLowerCase()) > finalArrayListPhoneNumber.indexOf(value.toLowerCase()))).collect(Collectors.toCollection(ArrayList::new));




                break;
            case "email" :
                //debug...
                System.out.println("filterGreaterThan() field: email");

                //get all student email in lowercase...
                ArrayList<String> arrayListEmail = studentsList.stream().map(s -> s.email.toLowerCase()).collect(Collectors.toCollection(ArrayList::new));

                //add 'value' to email list in lowercase...
                arrayListEmail.add(value.toLowerCase());

                //sort the list including 'value' and reassign
                arrayListEmail = arrayListEmail.stream().sorted((n1, n2) -> n1.compareTo(n2)).collect(Collectors.toCollection(ArrayList::new));

                //convert list to final, for compatible use in stream api
                final ArrayList<String> finalArrayListEmail = arrayListEmail.stream().collect(Collectors.toCollection(ArrayList::new));

                //filter students list based on  position in sorted list > than 'value' position
                resultsList = studentsList.stream().filter(s -> (finalArrayListEmail.indexOf(s.email.toLowerCase()) > finalArrayListEmail.indexOf(value.toLowerCase()))).collect(Collectors.toCollection(ArrayList::new));



                break;
            case "courseType" :  //NOTE: ENUMERATED LIST - NEEDS SPECIAL TREATMENT
                //debug...
                System.out.println("filterGreaterThan() field: courseType");

                //get all student courseType in lowercase...
                ArrayList<String> arrayListCourseType = studentsList.stream().map(s -> s.courseType.toString().toLowerCase()).collect(Collectors.toCollection(ArrayList::new));

                //add 'value' to courseType list in lowercase...
                arrayListCourseType.add(value.toLowerCase());

                //sort the list including 'value' and reassign
                arrayListCourseType = arrayListCourseType.stream().sorted((n1, n2) -> n1.compareTo(n2)).collect(Collectors.toCollection(ArrayList::new));

                //convert list to final, for compatible use in stream api
                final ArrayList<String> finalArrayListCourseType = arrayListCourseType.stream().collect(Collectors.toCollection(ArrayList::new));

                //filter students list based on  position in sorted list > than 'value' position
                resultsList = studentsList.stream().filter(s -> (finalArrayListCourseType.indexOf(s.courseType.toString().toLowerCase()) > finalArrayListCourseType.indexOf(value.toLowerCase()))).collect(Collectors.toCollection(ArrayList::new));


                break;
            case "modules" :    //NOTE: MAP<> - NEEDS SPECIAL TREATMENT     NEEDS SEARCH FOR KEY EXISTS, IF TRUE - THEN A MATCH      student.module is an Enumerated list value
                //debug...
                System.out.println("filterGreaterThan() field: modules");


                //check all of Student modules for a module name greater than 'value'

                resultsList = studentsList.stream().filter(s -> {

                    boolean greaterThan = false;    //flag - does this student have a module that is named greater than 'value'

                    ArrayList<String> moduleNames = new ArrayList<>();  // array list for holding moduleName keys

                    //add all module name keys to moduleNames list...
                    for(Student.Module moduleKey: s.modules.keySet()) { //loop for all Student module keys. (Note: moduleKey is an enum)

                        moduleNames.add(moduleKey.toString().toLowerCase());  //add module name key in lowercase to moduleNames list

                    }

                    //insert 'value' in lowercase into moduleNames list
                    moduleNames.add(value.toString().toLowerCase());

                    //sort moduleNames list including 'value' and reassign
                    moduleNames = moduleNames.stream().sorted((mod1, mod2) -> mod1.compareTo(mod2)).collect(Collectors.toCollection(ArrayList::new));

                    //loop for all modules, check module index for greater than 'value' index
                    for(Student.Module moduleKey: s.modules.keySet()){     //loop all modules...

                        //module index position greater than 'value'?
                        if(moduleNames.indexOf(moduleKey.toString().toLowerCase()) > moduleNames.indexOf(value.toString().toLowerCase())) {   //module key index > 'value' index...

                            greaterThan = true;     //set greaterThan flag true

                        }


                    }

                    return greaterThan;      //flag result



                }).collect(Collectors.toCollection(ArrayList::new));




                break;
            case "HIGH_Score" :
                //debug...
                System.out.println("filterGreaterThan() field: HIGH_Score");

                //convert 'value' String to primitive double
                double targetHighScore = stringTo_double(value);

                //calculateHighScore for each Student and store in each Student's 'queryResult' field. Filter by queryResult > targetScore
                resultsList = studentsList.stream().map(calculateHighScore).filter(s -> (s.queryResult > targetHighScore)).collect(Collectors.toCollection(ArrayList::new));

                break;

            case "LOW_Score" :
                //debug...
                System.out.println("filterGreaterThan() field: LOW_Score");


                //convert 'value' String to primitive double
                double targetLowScore = stringTo_double(value);

                //calculateLowScore for each Student and store in each Student's 'queryResult' field. Filter by queryResult > targetLowScore
                resultsList = studentsList.stream().map(calculateLowScore).filter(s -> (s.queryResult > targetLowScore)).collect(Collectors.toCollection(ArrayList::new));

                break;


            case "AVG_Score" :
                //debug...
                System.out.println("filterGreaterThan() field: AVG_Score");

                //convert 'value' String to primitive double
                double targetAVGScore = stringTo_double(value);

                //calculateAVGScore for each Student and store in each Student's 'queryResult' field. Filter by queryResult field > targetAVGScore
                resultsList = studentsList.stream().map(calculateAVGScore).filter(s -> (s.queryResult > targetAVGScore)).collect(Collectors.toCollection(ArrayList::new));

                break;

        }




        return resultsList;


    }




























    /***
     * Searches student for field with less than '<' value. Returns resulting ArrayList<Student>
     * @param studentsList the list of students to be searched
     * @param field the field of Student to compare
     * @param value the value to compare the field against
     * @return ArrayList<Student> resultList of those that match criteria
     */
    public ArrayList<Student> filterLessThan(ArrayList<Student> studentsList, String field, String value) {

        ArrayList<Student> resultsList = new ArrayList<>();      //holder for resulting Student list


        //switch which field?
        switch(field) {


            case "id" :             //NOTE: this is an int    has to be treated differently
                //debug...
                System.out.println("filterLessThan() field: id");

                //convert String 'value' to int
                int targetValue = Integer.parseInt(value);

                resultsList = studentsList.stream().filter(s -> (s.id < targetValue)).collect(Collectors.toCollection(ArrayList::new));

                break;


            case "firstName" :
                //debug...
                System.out.println("filterLessThan() field: firstName");

                //get all student first names in lowercase...
                ArrayList<String> arrayListFirstNames = studentsList.stream().map(s -> s.firstName.toLowerCase()).collect(Collectors.toCollection(ArrayList::new));

                //add 'value' to first names list in lowercase...
                arrayListFirstNames.add(value.toLowerCase());

                //sort the list including 'value' and reassign
                arrayListFirstNames = arrayListFirstNames.stream().sorted((n1, n2) -> n1.compareTo(n2)).collect(Collectors.toCollection(ArrayList::new));

                //convert list to final, for compatible use in stream api
                final ArrayList<String> finalArrayListFirstNames = arrayListFirstNames.stream().collect(Collectors.toCollection(ArrayList::new));

                //filter students list based on  position in sorted list < than 'value' position
                resultsList = studentsList.stream().filter(s -> (finalArrayListFirstNames.indexOf(s.firstName.toLowerCase()) < finalArrayListFirstNames.indexOf(value.toLowerCase()))).collect(Collectors.toCollection(ArrayList::new));


                break;

            case "lastName" :
                //debug...
                System.out.println("filterLessThan() field: lastName ");
                //resultsList = studentsList.stream().filter(s -> (s.lastName.contentEquals(value))).collect(Collectors.toCollection(ArrayList::new));

                //get all student first names in lowercase...
                ArrayList<String> arrayListLastNames = studentsList.stream().map(s -> s.lastName.toLowerCase()).collect(Collectors.toCollection(ArrayList::new));

                //add 'value' to last names list in lowercase...
                arrayListLastNames.add(value.toLowerCase());

                //sort the list including 'value' and reassign
                arrayListLastNames = arrayListLastNames.stream().sorted((n1, n2) -> n1.compareTo(n2)).collect(Collectors.toCollection(ArrayList::new));

                //convert list to final, for compatible use in stream api
                final ArrayList<String> finalArrayListLastNames = arrayListLastNames.stream().collect(Collectors.toCollection(ArrayList::new));

                //filter students list based on  position in sorted list < than 'value' position
                resultsList = studentsList.stream().filter(s -> (finalArrayListLastNames.indexOf(s.lastName.toLowerCase()) < finalArrayListLastNames.indexOf(value.toLowerCase()))).collect(Collectors.toCollection(ArrayList::new));


                break;


            case "addressLn1" :
                //debug...
                System.out.println("filterLessThan() field: addressLn1");

                //get all student addressLn1 in lowercase...
                ArrayList<String> arrayListAddressLn1 = studentsList.stream().map(s -> s.addressLn1.toLowerCase()).collect(Collectors.toCollection(ArrayList::new));

                //add 'value' to address list in lowercase...
                arrayListAddressLn1.add(value.toLowerCase());

                //sort the list including 'value' and reassign
                arrayListAddressLn1 = arrayListAddressLn1.stream().sorted((n1, n2) -> n1.compareTo(n2)).collect(Collectors.toCollection(ArrayList::new));

                //convert list to final, for compatible use in stream api
                final ArrayList<String> finalArrayListAddressLn1 = arrayListAddressLn1.stream().collect(Collectors.toCollection(ArrayList::new));

                //filter students list based on  position in sorted list < than 'value' position
                resultsList = studentsList.stream().filter(s -> (finalArrayListAddressLn1.indexOf(s.addressLn1.toLowerCase()) < finalArrayListAddressLn1.indexOf(value.toLowerCase()))).collect(Collectors.toCollection(ArrayList::new));

                break;


            case "addressLn2" :
                //debug...
                System.out.println("filterLessThan() field: addressLn2");

                //get all student addressLn1 in lowercase...
                ArrayList<String> arrayListAddressLn2 = studentsList.stream().map(s -> s.addressLn2.toLowerCase()).collect(Collectors.toCollection(ArrayList::new));

                //add 'value' to address list in lowercase...
                arrayListAddressLn2.add(value.toLowerCase());

                //sort the list including 'value' and reassign
                arrayListAddressLn2 = arrayListAddressLn2.stream().sorted((n1, n2) -> n1.compareTo(n2)).collect(Collectors.toCollection(ArrayList::new));

                //convert list to final, for compatible use in stream api
                final ArrayList<String> finalArrayListAddressLn2 = arrayListAddressLn2.stream().collect(Collectors.toCollection(ArrayList::new));

                //filter students list based on  position in sorted list < than 'value' position
                resultsList = studentsList.stream().filter(s -> (finalArrayListAddressLn2.indexOf(s.addressLn2.toLowerCase()) < finalArrayListAddressLn2.indexOf(value.toLowerCase()))).collect(Collectors.toCollection(ArrayList::new));

                break;



            case "city" :
                //debug...
                System.out.println("filterLessThan() field: city");

                //get all student addressLn1 in lowercase...
                ArrayList<String> arrayListCity = studentsList.stream().map(s -> s.city.toLowerCase()).collect(Collectors.toCollection(ArrayList::new));

                //add 'value' to address list in lowercase...
                arrayListCity.add(value.toLowerCase());

                //sort the list including 'value' and reassign
                arrayListCity = arrayListCity.stream().sorted((n1, n2) -> n1.compareTo(n2)).collect(Collectors.toCollection(ArrayList::new));

                //convert list to final, for compatible use in stream api
                final ArrayList<String> finalArrayListCity = arrayListCity.stream().collect(Collectors.toCollection(ArrayList::new));

                //filter students list based on  position in sorted list < than 'value' position
                resultsList = studentsList.stream().filter(s -> (finalArrayListCity.indexOf(s.city.toLowerCase()) < finalArrayListCity.indexOf(value.toLowerCase()))).collect(Collectors.toCollection(ArrayList::new));

                break;

            case "postCode" :
                //debug...
                System.out.println("filterLessThan() field: postCode");

                //get all student postCode in lowercase...
                ArrayList<String> arrayListPostCode = studentsList.stream().map(s -> s.postCode.toLowerCase()).collect(Collectors.toCollection(ArrayList::new));

                //add 'value' to postCode list in lowercase...
                arrayListPostCode.add(value.toLowerCase());

                //sort the list including 'value' and reassign
                arrayListPostCode = arrayListPostCode.stream().sorted((n1, n2) -> n1.compareTo(n2)).collect(Collectors.toCollection(ArrayList::new));

                //convert list to final, for compatible use in stream api
                final ArrayList<String> finalArrayListPostCode = arrayListPostCode.stream().collect(Collectors.toCollection(ArrayList::new));

                //filter students list based on  position in sorted list < than 'value' position
                resultsList = studentsList.stream().filter(s -> (finalArrayListPostCode.indexOf(s.postCode.toLowerCase()) < finalArrayListPostCode.indexOf(value.toLowerCase()))).collect(Collectors.toCollection(ArrayList::new));

                break;


            case "country" :
                //debug...
                System.out.println("filterLessThan() field: country");

                //get all student country in lowercase...
                ArrayList<String> arrayListCountry = studentsList.stream().map(s -> s.country.toLowerCase()).collect(Collectors.toCollection(ArrayList::new));

                //add 'value' to country list in lowercase...
                arrayListCountry.add(value.toLowerCase());

                //sort the list including 'value' and reassign
                arrayListCountry = arrayListCountry.stream().sorted((n1, n2) -> n1.compareTo(n2)).collect(Collectors.toCollection(ArrayList::new));

                //convert list to final, for compatible use in stream api
                final ArrayList<String> finalArrayListCountry = arrayListCountry.stream().collect(Collectors.toCollection(ArrayList::new));

                //filter students list based on  position in sorted list < than 'value' position
                resultsList = studentsList.stream().filter(s -> (finalArrayListCountry.indexOf(s.country.toLowerCase()) < finalArrayListCountry.indexOf(value.toLowerCase()))).collect(Collectors.toCollection(ArrayList::new));

                break;

            case "phoneNumber" :
                //debug...
                System.out.println("filterLessThan() field: phoneNumber");

                //get all student phoneNumber in lowercase...
                ArrayList<String> arrayListPhoneNumber = studentsList.stream().map(s -> s.phoneNumber.toLowerCase()).collect(Collectors.toCollection(ArrayList::new));

                //add 'value' to phoneNumber list in lowercase...
                arrayListPhoneNumber.add(value.toLowerCase());

                //sort the list including 'value' and reassign
                arrayListPhoneNumber = arrayListPhoneNumber.stream().sorted((n1, n2) -> n1.compareTo(n2)).collect(Collectors.toCollection(ArrayList::new));

                //convert list to final, for compatible use in stream api
                final ArrayList<String> finalArrayListPhoneNumber = arrayListPhoneNumber.stream().collect(Collectors.toCollection(ArrayList::new));

                //filter students list based on  position in sorted list < than 'value' position
                resultsList = studentsList.stream().filter(s -> (finalArrayListPhoneNumber.indexOf(s.phoneNumber.toLowerCase()) < finalArrayListPhoneNumber.indexOf(value.toLowerCase()))).collect(Collectors.toCollection(ArrayList::new));

                break;

            case "email" :
                //debug...
                System.out.println("filterLessThan() field: email");

                //get all student email in lowercase...
                ArrayList<String> arrayListEmail = studentsList.stream().map(s -> s.email.toLowerCase()).collect(Collectors.toCollection(ArrayList::new));

                //add 'value' to email list in lowercase...
                arrayListEmail.add(value.toLowerCase());

                //sort the list including 'value' and reassign
                arrayListEmail = arrayListEmail.stream().sorted((n1, n2) -> n1.compareTo(n2)).collect(Collectors.toCollection(ArrayList::new));

                //convert list to final, for compatible use in stream api
                final ArrayList<String> finalArrayListEmail = arrayListEmail.stream().collect(Collectors.toCollection(ArrayList::new));

                //filter students list based on  position in sorted list < than 'value' position
                resultsList = studentsList.stream().filter(s -> (finalArrayListEmail.indexOf(s.email.toLowerCase()) < finalArrayListEmail.indexOf(value.toLowerCase()))).collect(Collectors.toCollection(ArrayList::new));

                break;

            case "courseType" :  //NOTE: ENUMERATED LIST - NEEDS SPECIAL TREATMENT
                //debug...
                System.out.println("filterLessThan() field: courseType");

                //get all student courseType in lowercase...
                ArrayList<String> arrayListCourseType = studentsList.stream().map(s -> s.courseType.toString().toLowerCase()).collect(Collectors.toCollection(ArrayList::new));

                //add 'value' to courseType list in lowercase...
                arrayListCourseType.add(value.toLowerCase());

                //sort the list including 'value' and reassign
                arrayListCourseType = arrayListCourseType.stream().sorted((n1, n2) -> n1.compareTo(n2)).collect(Collectors.toCollection(ArrayList::new));

                //convert list to final, for compatible use in stream api
                final ArrayList<String> finalArrayListCourseType = arrayListCourseType.stream().collect(Collectors.toCollection(ArrayList::new));

                //filter students list based on  position in sorted list < than 'value' position
                resultsList = studentsList.stream().filter(s -> (finalArrayListCourseType.indexOf(s.courseType.toString().toLowerCase()) < finalArrayListCourseType.indexOf(value.toLowerCase()))).collect(Collectors.toCollection(ArrayList::new));

                break;


            case "modules" :    //NOTE: MAP<> - NEEDS SPECIAL TREATMENT     NEEDS SEARCH FOR KEY EXISTS, IF TRUE - THEN A MATCH      student.module is an Enumerated list value
                //debug...
                System.out.println("filterLessThan() field: modules");

                resultsList = studentsList.stream().filter(s -> {

                    boolean lessThan = false;    //flag - does this student have a module that is named less than 'value'

                    ArrayList<String> moduleNames = new ArrayList<>();  // array list for holding moduleName keys

                    //add all module name keys to moduleNames list...
                    for(Student.Module moduleKey: s.modules.keySet()) { //loop for all Student module keys. (Note: moduleKey is an enum)

                        moduleNames.add(moduleKey.toString().toLowerCase());  //add module name key in lowercase to moduleNames list

                    }

                    //insert 'value' in lowercase into moduleNames list
                    moduleNames.add(value.toString().toLowerCase());

                    //sort moduleNames list including 'value' and reassign
                    moduleNames = moduleNames.stream().sorted((mod1, mod2) -> mod1.compareTo(mod2)).collect(Collectors.toCollection(ArrayList::new));

                    //loop for all modules, check module index for less than 'value' index
                    for(Student.Module moduleKey: s.modules.keySet()){     //loop all modules...

                        //module index position less than 'value'?
                        if(moduleNames.indexOf(moduleKey.toString().toLowerCase()) < moduleNames.indexOf(value.toString().toLowerCase())) {   //module key index < 'value' index...

                            lessThan = true;     //set lessThan flag true

                        }


                    }

                    return lessThan;      //flag result



                }).collect(Collectors.toCollection(ArrayList::new));


                break;


            case "HIGH_Score" :
                //debug...
                System.out.println("filterLessThan() field: HIGH_Score");

                //convert 'value' String to primitive double
                double targetHighScore = stringTo_double(value);

                //calculateHighScore for each Student and store in each Student's 'queryResult' field. Filter by queryResult < targetScore
                resultsList = studentsList.stream().map(calculateHighScore).filter(s -> (s.queryResult < targetHighScore)).collect(Collectors.toCollection(ArrayList::new));

                break;


            case "LOW_Score" :
                //debug...
                System.out.println("filterLessThan() field: LOW_Score");


                //convert 'value' String to primitive double
                double targetLowScore = stringTo_double(value);

                //calculateLowScore for each Student and store in each Student's 'queryResult' field. Filter by queryResult < targetLowScore
                resultsList = studentsList.stream().map(calculateLowScore).filter(s -> (s.queryResult < targetLowScore)).collect(Collectors.toCollection(ArrayList::new));

                break;

            case "AVG_Score" :
                //debug...
                System.out.println("filterLessThan() field: AVG_Score");

                //convert 'value' String to primitive double
                double targetAVGScore = stringTo_double(value);

                //calculateAVGScore for each Student and store in each Student's 'queryResult' field. Filter by queryResult < targetAVGScore
                resultsList = studentsList.stream().map(calculateAVGScore).filter(s -> (s.queryResult < targetAVGScore)).collect(Collectors.toCollection(ArrayList::new));

                //Display all averages:
                //resultsList = studentsList.stream().map(calculateAVGScore).collect(Collectors.toCollection(ArrayList::new));

                break;

        }



        return resultsList;


    }




























    /***
     * Sorts student list by chosen field ascending. Returns sorted ArrayList<Student>
     * @param studentsList the list of students to be sorted
     * @param field the field of Student to sort by
     * @param value the value to compare the field against - NOT USED. Will sort just by the field type
     * @return ArrayList<Student> sorted list of Students
     */
    public ArrayList<Student> filterSortAsc(ArrayList<Student> studentsList, String field, String value) {

        ArrayList<Student> resultsList = new ArrayList<>();      //holder for resulting Student list


        //switch which field?
        switch(field) {


            case "id" :             //NOTE: this is an int    has to be treated differently
                //debug...
                System.out.println("filterSortAsc() field: id");

                //sort the list ascending by id and reassign. NOTE: the int id had to be converted to Integer in order for the stream comparison to work
                resultsList = studentsList.stream().sorted((s1, s2) -> Integer.valueOf(s1.id).compareTo(s2.id)).collect(Collectors.toCollection(ArrayList::new));

                break;

            case "firstName" :
                //debug...
                System.out.println("filterSortAsc() field: firstName");


                //sort the list ascending by firstName and assign.
                resultsList = studentsList.stream().sorted((s1, s2) -> s1.firstName.compareTo(s2.firstName)).collect(Collectors.toCollection(ArrayList::new));

                break;

            case "lastName" :
                //debug...
                System.out.println("filterSortAsc() field: lastName ");

                //sort the list ascending by lastName and assign.
                resultsList = studentsList.stream().sorted((s1, s2) -> s1.lastName.compareTo(s2.lastName)).collect(Collectors.toCollection(ArrayList::new));

                break;

            case "addressLn1" :
                //debug...
                System.out.println("filterSortAsc() field: addressLn1");

                //sort the list ascending by addressLn1 and assign.
                resultsList = studentsList.stream().sorted((s1, s2) -> s1.addressLn1.compareTo(s2.addressLn1)).collect(Collectors.toCollection(ArrayList::new));

                break;

            case "addressLn2" :
                //debug...
                System.out.println("filterSortAsc() field: addressLn2");

                //sort the list ascending by addressLn2 and assign.
                resultsList = studentsList.stream().sorted((s1, s2) -> s1.addressLn2.compareTo(s2.addressLn2)).collect(Collectors.toCollection(ArrayList::new));

                break;

            case "city" :
                //debug...
                System.out.println("filterSortAsc() field: city");

                //sort the list ascending by city and assign.
                resultsList = studentsList.stream().sorted((s1, s2) -> s1.city.compareTo(s2.city)).collect(Collectors.toCollection(ArrayList::new));

                break;

            case "postCode" :
                //debug...
                System.out.println("filterSortAsc() field: postCode");

                //sort the list ascending by postCode and assign.
                resultsList = studentsList.stream().sorted((s1, s2) -> s1.postCode.compareTo(s2.postCode)).collect(Collectors.toCollection(ArrayList::new));

                break;

            case "country" :
                //debug...
                System.out.println("filterSortAsc() field: country");
                //resultsList = studentsList.stream().filter(s -> (s.country.contentEquals(value))).collect(Collectors.toCollection(ArrayList::new));

                //sort the list ascending by lastName and assign.
                resultsList = studentsList.stream().sorted((s1, s2) -> s1.country.compareTo(s2.country)).collect(Collectors.toCollection(ArrayList::new));

                break;

            case "phoneNumber" :
                //debug...
                System.out.println("filterSortAsc() field: phoneNumber");
                //resultsList = studentsList.stream().filter(s -> (s.phoneNumber.contentEquals(value))).collect(Collectors.toCollection(ArrayList::new));

                //sort the list ascending by phoneNumber and assign.
                resultsList = studentsList.stream().sorted((s1, s2) -> s1.phoneNumber.compareTo(s2.phoneNumber)).collect(Collectors.toCollection(ArrayList::new));

                break;

            case "email" :
                //debug...
                System.out.println("filterSortAsc() field: email");

                //sort the list ascending by email and assign.
                resultsList = studentsList.stream().sorted((s1, s2) -> s1.email.compareTo(s2.email)).collect(Collectors.toCollection(ArrayList::new));

                break;

            case "courseType" :  //NOTE: ENUMERATED LIST - NEEDS SPECIAL TREATMENT
                //debug...
                System.out.println("filterSortAsc() field: courseType");

                //sort the list ascending by courseType and assign.
                resultsList = studentsList.stream().sorted((s1, s2) -> s1.courseType.toString().compareTo(s2.courseType.toString())).collect(Collectors.toCollection(ArrayList::new));

                break;

            case "modules" :    //NOTE: MAP<> - NEEDS TREATMENT     NEEDS SEARCH FOR KEY EXISTS, IF TRUE - THEN A MATCH      student.module is an Enumerated list value
                //debug...
                System.out.println("filterSortAsc() field: modules - Multiple Values can't sort");

                break;

            case "HIGH_Score" :
                //debug...
                System.out.println("filterSortAsc() field: HIGH_Score");

                //calculateHighScore for each Student and store in each Student's 'queryResult' field. Then sort by 'queryResult' field
                resultsList = studentsList.stream().map(calculateHighScore).sorted((s1, s2) -> s1.queryResult.compareTo(s2.queryResult)).collect(Collectors.toCollection(ArrayList::new));

                break;

            case "LOW_Score" :
                //debug...
                System.out.println("filterSortAsc() field: LOW_Score");

                //calculateLOWScore for each Student and store in each Student's 'queryResult' field. Then sort by 'queryResult' field
                resultsList = studentsList.stream().map(calculateLowScore).sorted((s1, s2) -> s1.queryResult.compareTo(s2.queryResult)).collect(Collectors.toCollection(ArrayList::new));

                break;

            case "AVG_Score" :
                //debug...
                System.out.println("filterSortAsc() field: AVG_Score");


                //calculateAVGScore for each Student and store in each Student's 'queryResult' field. Then sort by 'queryResult' field
                resultsList = studentsList.stream().map(calculateAVGScore).sorted((s1, s2) -> s1.queryResult.compareTo(s2.queryResult)).collect(Collectors.toCollection(ArrayList::new));

                break;

        }




        return resultsList;


    }




































    /***
     * Sorts student list by chosen field descending. Returns sorted ArrayList<Student>
     * @param studentsList the list of students to be sorted
     * @param field the field of Student to sort by
     * @param value the value to compare the field against - NOT USED. Will sort just by the field type
     * @return ArrayList<Student> sorted list of Students
     */
    public ArrayList<Student> filterSortDsc(ArrayList<Student> studentsList, String field, String value) {

        ArrayList<Student> resultsList = new ArrayList<>();      //holder for resulting Student list


        //switch which field?
        switch(field) {


            case "id" :             //NOTE: this is an int    has to be treated differently
                //debug...
                System.out.println("filterSortDsc() field: id");

                //sort the list descending (s2, s1) by id and reassign. NOTE: the int id had to be converted to Integer in order for the stream comparison to work
                resultsList = studentsList.stream().sorted((s1, s2) -> Integer.valueOf(s2.id).compareTo(s1.id)).collect(Collectors.toCollection(ArrayList::new));

                break;

            case "firstName" :
                //debug...
                System.out.println("filterSortDsc() field: firstName");


                //sort the list descending by firstName and assign.
                resultsList = studentsList.stream().sorted((s1, s2) -> s2.firstName.compareTo(s1.firstName)).collect(Collectors.toCollection(ArrayList::new));

                break;

            case "lastName" :
                //debug...
                System.out.println("filterSortDsc() field: lastName ");

                //sort the list descending by lastName and assign.
                resultsList = studentsList.stream().sorted((s1, s2) -> s2.lastName.compareTo(s1.lastName)).collect(Collectors.toCollection(ArrayList::new));

                break;

            case "addressLn1" :
                //debug...
                System.out.println("filterSortDsc() field: addressLn1");


                //sort the list descending by addressLn1 and assign.
                resultsList = studentsList.stream().sorted((s1, s2) -> s2.addressLn1.compareTo(s1.addressLn1)).collect(Collectors.toCollection(ArrayList::new));

                break;

            case "addressLn2" :
                //debug...
                System.out.println("filterSortDsc() field: addressLn2");

                //sort the list descending by addressLn2 and assign.
                resultsList = studentsList.stream().sorted((s1, s2) -> s2.addressLn2.compareTo(s1.addressLn2)).collect(Collectors.toCollection(ArrayList::new));

                break;

            case "city" :
                //debug...
                System.out.println("filterSortDsc() field: city");


                //sort the list descending by city and assign.
                resultsList = studentsList.stream().sorted((s1, s2) -> s2.city.compareTo(s1.city)).collect(Collectors.toCollection(ArrayList::new));

                break;

            case "postCode" :
                //debug...
                System.out.println("filterSortDsc() field: postCode");

                //sort the list descending by postCode and assign.
                resultsList = studentsList.stream().sorted((s1, s2) -> s2.postCode.compareTo(s1.postCode)).collect(Collectors.toCollection(ArrayList::new));

                break;

            case "country" :
                //debug...
                System.out.println("filterSortDsc() field: country");

                //sort the list descending by country.
                resultsList = studentsList.stream().sorted((s1, s2) -> s2.country.compareTo(s1.country)).collect(Collectors.toCollection(ArrayList::new));

                break;

            case "phoneNumber" :
                //debug...
                System.out.println("filterSortDsc() field: phoneNumber");

                //sort the list descending by phoneNumber and assign.
                resultsList = studentsList.stream().sorted((s1, s2) -> s2.phoneNumber.compareTo(s1.phoneNumber)).collect(Collectors.toCollection(ArrayList::new));

                break;

            case "email" :
                //debug...
                System.out.println("filterSortDsc() field: email");

                //sort the list Descending by email and assign.
                resultsList = studentsList.stream().sorted((s1, s2) -> s2.email.compareTo(s1.email)).collect(Collectors.toCollection(ArrayList::new));

                break;

            case "courseType" :  //NOTE: ENUMERATED LIST - NEEDS TREATMENT
                //debug...
                System.out.println("filterSortDsc() field: courseType");

                //sort the list descending by courseType and assign.
                resultsList = studentsList.stream().sorted((s1, s2) -> s2.courseType.toString().compareTo(s1.courseType.toString())).collect(Collectors.toCollection(ArrayList::new));

                break;

            case "modules" :    //NOTE: MAP<> - NEEDS SPECIAL TREATMENT     NEEDS SEARCH FOR KEY EXISTS, IF TRUE - THEN A MATCH      student.module is an Enumerated list value
                //debug...
                System.out.println("filterSortDsc() field: modules - Multiple Values can't sort");

                break;

            case "HIGH_Score" :
                //debug...
                System.out.println("filterSortDsc() field: HIGH_Score");

                //calculateHighScore for each Student and store in each Student's 'queryResult' field. Then sort by 'queryResult' field descending
                resultsList = studentsList.stream().map(calculateHighScore).sorted((s1, s2) -> s2.queryResult.compareTo(s1.queryResult)).collect(Collectors.toCollection(ArrayList::new));

                break;

            case "LOW_Score" :
                //debug...
                System.out.println("filterSortDsc() field: LOW_Score");

                //calculateLOWScore for each Student and store in each Student's 'queryResult' field. Then sort by 'queryResult' field descending
                resultsList = studentsList.stream().map(calculateLowScore).sorted((s1, s2) -> s2.queryResult.compareTo(s1.queryResult)).collect(Collectors.toCollection(ArrayList::new));

                break;

            case "AVG_Score" :
                //debug...
                System.out.println("filterSortDsc() field: AVG_Score");

                //calculateAVGScore for each Student and store in each Student's 'queryResult' field. Then sort by 'queryResult' field descending
                resultsList = studentsList.stream().map(calculateAVGScore).sorted((s1, s2) -> s2.queryResult.compareTo(s1.queryResult)).collect(Collectors.toCollection(ArrayList::new));

                break;

        }




        return resultsList;


    }

































































    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Template filter_ method

    /*




    public ArrayList<Student> filter_Equals(ArrayList<Student> studentsList, String field, String value) {

            ArrayList<Student> resultsList = new ArrayList<>();      //holder for resulting Student list


                    //switch which field?
                    switch(field) {


                        case "id" :
                            //debug...
                            System.out.println("filter_Equals() field: id");

                            //resultsList = studentsList.stream().filter(s -> (s.firstName.contentEquals(value))).collect(Collectors.toCollection(ArrayList::new));
                            break;

                        case "firstName" :
                            //debug...
                            System.out.println("filter_Equals() field: firstName");

                            break;

                        case "lastName" :
                            //debug...
                            System.out.println("filter_Equals() field: lastName ");

                            break;

                        case "addressLn1" :
                            //debug...
                            System.out.println("filter_Equals() field: addressLn1");

                            break;
                        case "addressLn2" :
                            //debug...
                            System.out.println("filter_Equals() field: addressLn2");

                            break;
                        case "city" :
                            //debug...
                            System.out.println("filter_Equals() field: city");

                            break;
                        case "postCode" :
                            //debug...
                            System.out.println("filter_Equals() field: postCode");

                            break;
                        case "country" :
                            //debug...
                            System.out.println("filter_Equals() field: country");

                            break;
                        case "phoneNumber" :
                            //debug...
                            System.out.println("filter_Equals() field: phoneNumber");

                            break;
                        case "email" :
                            //debug...
                            System.out.println("filter_Equals() field: email");

                            break;
                        case "courseType" :
                            //debug...
                            System.out.println("filter_Equals() field: courseType");

                            break;
                        case "modules" :
                            //debug...
                            System.out.println("filter_Equals() field: modules");

                            break;
                        case "HIGH_Score" :
                            //debug...
                            System.out.println("filter_Equals() field: HIGH_Score");

                            break;
                        case "LOW_Score" :
                            //debug...
                            System.out.println("filter_Equals() field: LOW_Score");

                            break;

                        case "AVG_Score" :
                            //debug...
                            System.out.println("filter_Equals() field: AVG_Score");


                    }




            return resultsList;


    }













     */

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    /***
     *
     * @param string the String number to be converted to a primitive double
     * @return the converted primitive double
     */
    private double stringTo_double(String string) {

        Double result_Double = 0.00;                    //new blank Double object

        result_Double = Double.valueOf(string);         // convert String to Double object

        double result = result_Double;                  //convert Double object to primitive double


        return result;
    }























    private Stream<Student> equalsFilter(Stream<Student> s, String field, String value) {


        Stream<Student> resultStream = s;   //result to return


        switch(field) {         //determine which field of Student to search for...

            case "firstName":   resultStream = s.filter(student -> student.getFirstName() == value);


        }



        return resultStream;       //the resulting Stream<Student>

    }




    /***
     * Returns an ArrayList<Student> of all the current Students.
     * @return list of all current students
     */
    public ArrayList<Student> getAll() {


        ArrayList<Student> resultList = new ArrayList<>();


        studentsList.stream()
                //.filter(s -> s.age() < 25)
                .forEach(s -> resultList.add(s));





        return resultList;



    }








/*
    public static void main(String[] args) {

        //create the StudentRegister
        StudentRegister sR = new StudentRegister();

        //create the gui...
        GUI_Main gui = new GUI_Main(sR);    //pass in the StudentRegister controller reference 'sR' for interacting with





    }//end main()
*/




    /***
     *  Prints StudentRegister to console window...
     */

    public void printRegister() {


        System.out.println("***********************************************");
        System.out.println("               R E G I S T E R ");
        System.out.println("************************************************");

        studentsList.stream().forEach((student) -> System.out.println(student.getId() + " " + student.getFirstName() + " " + student.getLastName()));


    }//end printRegister()












}//end StudentRegister Class
