import org.example.CongressFinder;
import org.example.CongressPerson;
import org.example.CongressPersonLoader;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;


public class Testing {

    // First unit test for congress member
    @Test
    public void firstMemberUnitTest() throws IOException {
        CongressPerson[] members = CongressPersonLoader.load_from_file("/legislators-current.json");
        assertEquals(538, members.length, "Received wrong number of members for legislators-current.json");

        CongressPerson firstMember = members[0];

        assertEquals("Sherrod", firstMember.getFirstname(), "Received a wrong first name back for legislators-current.json first member for"  + firstMember.getFirstname() + " " + firstMember.getLastname());

        assertEquals("Brown", firstMember.getLastname(),"Received a wrong lastname back for legislators-current.json first member for "  + firstMember.getFirstname() + " " + firstMember.getLastname());

        assertEquals("M", firstMember.getGender(), "Received a wrong gender back for legislators-current.json first member for " + firstMember.getFirstname() + " " + firstMember.getLastname());

        assertEquals(LocalDate.of(1952,11,9), firstMember.getBirthDate(), "Received a wrong birthdate back for legislators-current.json first member for "  + firstMember.getFirstname() + " " + firstMember.getLastname());

        assertEquals("rep", firstMember.getTerms().get(0).getTermType(), "Wrong type was received for " + firstMember.getFirstname() + " " + firstMember.getLastname());

        assertEquals(LocalDate.of(1993,1,5), firstMember.getTerms().get(0).getTermStart(), "Wrong start date was received for " + firstMember.getFirstname() + " " + firstMember.getLastname());

        assertEquals(LocalDate.of(1995,1,3), firstMember.getTerms().get(0).getTermEnd(), "Wrong end date was received for "  + firstMember.getFirstname() + " " + firstMember.getLastname());

        assertEquals("OH", firstMember.getTerms().get(0).getTermState(), "Wrong state was received for " + firstMember.getFirstname() + " " + firstMember.getLastname());

        assertEquals("Democrat", firstMember.getTerms().get(0).getTermParty(), "Wrong party was received for " + firstMember.getFirstname() + " " + firstMember.getLastname());


        // toString()
        assertEquals("CongressPerson{" +
                "firstname='" + firstMember.getFirstname() + '\'' +
                ", lastname='" + firstMember.getLastname() + '\'' +
                ", gender='" + firstMember.getGender() + '\'' +
                ", birthDate=" + firstMember.getBirthDate() +
                ", terms=" + firstMember.getTerms() +
                '}', firstMember.toString(), "A wrong toString() method was received for legislators json file!");
    }


    // Second unit test for congress member
    @Test
    public void SecondMemberUnitTest() throws IOException {
        CongressPerson[] members = CongressPersonLoader.load_from_file("/legislators-current.json");
        assertEquals(538, members.length, "Received wrong number of members for legislators-current.json");

        CongressPerson secondMember = members[1];

        assertEquals("Maria", secondMember.getFirstname(), "Received a wrong first name back for legislators-current.json second member " + secondMember.getFirstname() + " " + secondMember.getLastname());

        assertEquals("Cantwell", secondMember.getLastname(), "Received a wrong lastname back for legislators-current.json second member " + secondMember.getFirstname() + " " + secondMember.getLastname());

        assertEquals("F", secondMember.getGender(), "Received a wrong gender back for legislators-current.json second member " + secondMember.getFirstname() + " " + secondMember.getLastname());;

        assertEquals(LocalDate.of(1958,10,13), secondMember.getBirthDate(), "Received a wrong birthdate back for legislators-current.json second member " + secondMember.getFirstname() + " " + secondMember.getLastname());

        assertEquals("rep", secondMember.getTerms().get(0).getTermType(), "Received a wrong type back for legislators-current.json second member " + secondMember.getFirstname() + " " + secondMember.getLastname());

        assertEquals(LocalDate.of(1993,1,5), secondMember.getTerms().get(0).getTermStart(), "Received a wrong start date back for legislators-current.json second member " + secondMember.getFirstname() + " " + secondMember.getLastname());

        assertEquals(LocalDate.of(1995,1,3), secondMember.getTerms().get(0).getTermEnd(), "Received a wrong end date back! for legislators-current.json second member " + secondMember.getFirstname() + " " + secondMember.getLastname());

        assertEquals("WA", secondMember.getTerms().get(0).getTermState(), "Received a wrong state back for legislators-current.json second member " + secondMember.getFirstname() + " " + secondMember.getLastname());

        assertEquals("Democrat", secondMember.getTerms().get(0).getTermParty(), "Received a wrong party back for legislators-current.json second member " + secondMember.getFirstname() + " " + secondMember.getLastname());


        // toString()
        assertEquals("CongressPerson{" +
                "firstname='" + secondMember.getFirstname() + '\'' +
                ", lastname='" + secondMember.getLastname() + '\'' +
                ", gender='" + secondMember.getGender() + '\'' +
                ", birthDate=" + secondMember.getBirthDate() +
                ", terms=" + secondMember.getTerms() +
                '}', secondMember.toString(), "A wrong toString() method was received for legislators json file for "  + secondMember.getFirstname() + " " + secondMember.getLastname());

    }

    @Test // First integration test
    public void FirstLoaderIntegrationTest() throws IOException {
        CongressPerson[] members = CongressPersonLoader.load_from_file("/first-json-test-file.json");
        assertEquals(4, members.length, "Received wrong number of members for first-json-test-file.json");

        CongressPerson firstMember = members[0];

        assertEquals("Brad", firstMember.getFirstname(), "Received a wrong first name back for first-json-test-file first member " + firstMember.getFirstname() + " " + firstMember.getLastname());

        assertEquals("Finstad", firstMember.getLastname(), "Received a wrong lastname back for first-json-test-file first member " + firstMember.getFirstname() + " " + firstMember.getLastname());

        assertEquals("M", firstMember.getGender(), "Received a wrong gender back for first-json-test-file first member " + firstMember.getFirstname() + " " + firstMember.getLastname());

        assertEquals(LocalDate.of(1976,5,30), firstMember.getBirthDate(), "Received a wrong birthdate back for first-json-test-file first member " + firstMember.getFirstname() + " " + firstMember.getLastname());

        assertEquals("rep", firstMember.getTerms().get(0).getTermType(), "Received a wrong type back for first-json-test-file first member " + firstMember.getFirstname() + " " + firstMember.getLastname());

        assertEquals("MN", firstMember.getTerms().get(0).getTermState(), "Received a wrong state back for first-json-test-file first member " + firstMember.getFirstname() + " " + firstMember.getLastname());

        assertEquals("Republican", firstMember.getTerms().get(0).getTermParty(), "Received a wrong party back for first-json-test-file first member " + firstMember.getFirstname() + " " + firstMember.getLastname());

        assertEquals(LocalDate.of(2022,8,12), firstMember.getTerms().get(0).getTermStart(), "Received a wrong start date back for first-json-test-file first member " + firstMember.getFirstname() + " " + firstMember.getLastname());

        assertEquals(LocalDate.of(2023,1,3), firstMember.getTerms().get(0).getTermEnd(), "Received a wrong end date back for first-json-test-file first member " + firstMember.getFirstname() + " " + firstMember.getLastname());

        // toString()
        assertEquals("CongressPerson{" +
                "firstname='" + firstMember.getFirstname() + '\'' +
                ", lastname='" + firstMember.getLastname() + '\'' +
                ", gender='" + firstMember.getGender() + '\'' +
                ", birthDate=" + firstMember.getBirthDate() +
                ", terms=" + firstMember.getTerms() +
                '}', firstMember.toString(), "A wrong toString() method was received for legislators json file for "  + firstMember.getFirstname() + " " + firstMember.getLastname());

    }


    @Test // Second integration test
    public void SecondLoaderIntegrationTest() throws IOException {
        CongressPerson[] members = CongressPersonLoader.load_from_file("/second-json-test-file.json");
        assertEquals(members.length, 3, "Received wrong number of members for second-json-test-file.json");

        CongressPerson secondMember = members[1];

        assertEquals(secondMember.getFirstname(), "Chris", "Received a wrong first name back for second-json-test-file second member " + secondMember.getFirstname() + " " + secondMember.getLastname());

        assertEquals(secondMember.getLastname(), "Jacobs", "Received a wrong lastname back for second-json-test-file second member " + secondMember.getFirstname() + " " + secondMember.getLastname());

        assertEquals(secondMember.getGender(), "M", "Received a wrong gender back for second-json-test-file second member " + secondMember.getFirstname() + " " + secondMember.getLastname());

        assertEquals(secondMember.getBirthDate(), LocalDate.of(1966,11,28), "Received a wrong birthdate back for second-json-test-file second member " + secondMember.getFirstname() + " " + secondMember.getLastname());

        assertEquals(secondMember.getTerms().get(0).getTermType(), "rep", "Received a wrong type back for second-json-test-file second member " + secondMember.getFirstname() + " " + secondMember.getLastname());

        assertEquals(secondMember.getTerms().get(0).getTermState(), "NY", "Received a wrong state back for second-json-test-file second member " + secondMember.getFirstname() + " " + secondMember.getLastname());

        assertEquals(secondMember.getTerms().get(0).getTermParty(), "Republican", "Received a wrong party back for second-json-test-file second member " + secondMember.getFirstname() + " " + secondMember.getLastname());

        assertEquals(secondMember.getTerms().get(0).getTermStart(), LocalDate.of(2020,7,21), "Received a wrong start date back for second-json-test-file second member " + secondMember.getFirstname() + " " + secondMember.getLastname());

        assertEquals(secondMember.getTerms().get(0).getTermEnd(), LocalDate.of(2021,1,3), "Received a wrong end date back for second-json-test-file second member " + secondMember.getFirstname() + " " + secondMember.getLastname());

        // toString()
        assertEquals(secondMember.toString(), "CongressPerson{" +
                "firstname='" + secondMember.getFirstname() + '\'' +
                ", lastname='" + secondMember.getLastname() + '\'' +
                ", gender='" + secondMember.getGender() + '\'' +
                ", birthDate=" + secondMember.getBirthDate() +
                ", terms=" + secondMember.getTerms() +
                '}', "A wrong toString() method was received for legislators json file for "  + secondMember.getFirstname() + " " + secondMember.getLastname());

    }

    // Below test allows to make sure that the system will handle the case properly if a wrong file was provided.
    @Test
    public void NonExistingFileTest() throws IOException {
        try {
            CongressPerson[] members = CongressPersonLoader.load_from_file("/nonexistingfile.json");
            fail("Invalid path was provided for file! Please try again!");
        } catch (Exception e) {
            assertNotNull(e);
        }
    }

    // Below comparison works with overriding the equals method only
    @Test
    public void FinderNameUnitTest() throws IOException {
        CongressPerson[] members = CongressPersonLoader.load_from_file("/legislators-current.json");
        CongressFinder finder = new CongressFinder(CongressPersonLoader.load_from_file("/legislators-current.json"));
        CongressPerson aMemberToCheck = members[1];
        assertEquals(finder.getByName("Maria", "Cantwell"), aMemberToCheck.toString(), "No member with provided name was found!" );

    }

    // FOR MYSELF: A unit test to check if the getRecentParty method works in CongressPerson.
    @Test
    public void getRecentPartyMethodUnitTest() throws IOException{
        CongressPerson[] members = CongressPersonLoader.load_from_file("/legislators-current.json");
        CongressPerson member1 = members[10];
        assertEquals("Democrat", member1.getRecentParty(), "Wrong recent party was received!");
    }

    //A unit test to check the amount of democrats/republicans. It does get the most recent info from json file in terms of dates by using the getRecentParty().
    @Test
    public void partyCounterUnitTest() throws IOException{
        CongressFinder members = new CongressFinder(CongressPersonLoader.load_from_file("/first-json-test-file.json"));
        assertEquals(2, members.NumberOfPeopleInEachParty("republican"), "A wrong number of party people received!");

    }

    // FOR MYSELF: Below unit test checks the functionality of ParseLocalDate() function from CongressPerson which calculates the age of a member.
    @Test
    public void ageCounterUnitTest() throws IOException{
        CongressPerson[] members = CongressPersonLoader.load_from_file("/legislators-current.json");
        assertEquals(70, members[0].LocalDateParser(), "Wrong age for " + members[0].getFirstname() + " " + members[0].getLastname());
    }

    // FOR MYSELF: This test allows us to check if the SortedListOfOldestPeople() method from Finder works properly.
    @Test
    public void sortedAgeMethodUnitTest() throws IOException{
        CongressFinder members = new CongressFinder(CongressPersonLoader.load_from_file("/legislators-current.json"));
        assertEquals(85, members.SortedListOfOldestPeople()[530].LocalDateParser(), "Wrong age for the chosen member!"); // The youngest member is 27y/o
    }


    // Below unit test gets us top N oldest people from all congress members.
    @Test
    public void customSortedMethodUnitTest() throws IOException {
        CongressFinder members = new CongressFinder(CongressPersonLoader.load_from_file("/legislators-current.json"));

        // Below list of CongressMembers contains a method from finder which allows us to get top N oldest people. I took two, so it will be easy for me to write a test for it.
        List<CongressPerson> lastTwoMembers = members.CustomSortedListOfOldestPeople(2);
        CongressPerson firstOldestPerson = new CongressPerson("Charles", "Grassley", "M", LocalDate.of(1933,9,17));
        CongressPerson secondOldestPerson = new CongressPerson("James", "Inhofe", "M", LocalDate.of(1934,11,17));

        // secondOldestPerson is the first object from lastTwoMembers list. Which is not the oldest person, the oldest is the first person in that list!
        // Which means that, if we have top 5 oldest people list, the oldest one will be the last value in that list, in our case here it's the 1st value if we will count from 0.
        assertEquals(secondOldestPerson, lastTwoMembers.get(0), "Received wrong data for N oldest people - for " + secondOldestPerson.getFirstname() + " " + secondOldestPerson.getLastname());
        assertEquals(firstOldestPerson, lastTwoMembers.get(1), "Received wrong data for N oldest people - for " + firstOldestPerson.getFirstname() + " " + firstOldestPerson.getLastname());

    }


    // Below test check average ages for democrats and republicans
    @Test
    public void averageAgesForPartiesUnitTest() throws IOException{

        CongressFinder members = new CongressFinder(CongressPersonLoader.load_from_file("/legislators-current.json"));

        // Calls averageAgeCalculator() method from CongressFinder and gets the key Democrats from the returned map
        int expectedAverageAgeForDemocrats = 61;
        assertEquals(expectedAverageAgeForDemocrats, members.averageAgeCalculator().get("Democrats"), "Received a wrong average age for democrats!");

        // Calls averageAgeCalculator() method from CongressFinder and gets the key Republicans from the returned map
        int expectedAverageAgeForRepublicans = 59;
        assertEquals(expectedAverageAgeForRepublicans, members.averageAgeCalculator().get("Republicans"), "Received a wrong average age for republicans!");

    }


    // Below test checks the result for the youngest democrat member.
    @Test
    public void youngestMemberUnitTest() throws IOException{
        CongressFinder members = new CongressFinder(CongressPersonLoader.load_from_file("/legislators-current.json"));

        CongressPerson youngestMember = new CongressPerson("Patrick", "Ryan", "M", LocalDate.of(1982, 3, 28));

        assertEquals(youngestMember, members.youngestDemocrat(), "Received a wrong youngest democrat information! ");

    }


    // Below is a test that checks the very first member from already sorted list (Which was for the time period of congress members) and the very last member from that list.
    // The sorted list starts from a member that have been in congress for not even a year, and ends with a person that have been in congress for already 47 years.
    // We can always debug in order to see how the sortedLengthOfTimeForMembers list gets sorted.
    @Test
    public void length_Of_Time_In_Congress_For_Members_UnitTest() throws IOException{
        CongressFinder members = new CongressFinder(CongressPersonLoader.load_from_file("/legislators-current.json"));

        // Checking the member that been in congress for a short time
        assertEquals(0, members.sortedLengthOfTimeForMembers()[0].lengthOfTimeForMember(), "Received a wrong time period for first member!");

        // Checking the member that been in congress for longest time of period
        assertEquals(47, members.sortedLengthOfTimeForMembers()[535].lengthOfTimeForMember(), "Received a wrong time period for first member!");

    }



}

