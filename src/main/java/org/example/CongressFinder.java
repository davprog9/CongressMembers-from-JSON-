package org.example;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class CongressFinder{

    private final CongressPerson[] ListOfCongressMembers;


    /**
     * Default controller
     * @param ListOfCongressMembers defines the list of the congress members
     * @author David Arzumanyan
     */
    public CongressFinder(CongressPerson[] ListOfCongressMembers){
        this.ListOfCongressMembers = ListOfCongressMembers;

    }


    /**
     * Below method allows us to find a person by providing a first and a last name.
     * @param first_name defines the name of the member
     * @param last_name defines the last name of the member
     * @return Returns data type String
     * @author David Arzumanyan
     */
    public String getByName(String first_name, String last_name){
        for (int i = 0; i < ListOfCongressMembers.length; i++){
            if (ListOfCongressMembers[i].getFirstname().equals(first_name) && ListOfCongressMembers[i].getLastname().equals(last_name)){
                return ListOfCongressMembers[i].toString();
            }
        }
        return new CongressPerson("NoFirstName", "NoLastName", "NoGender", LocalDate.MIN).toString();
   }


    /**
     * Below method will allow us to get the number of people in our provided party.
     * @param party defines the party name
     * @return Returns data type int
     * @author David Arzumanyan
     */
   public int NumberOfPeopleInEachParty(String party){
        int democrats = 0;
        int republicans = 0;

        for (int i = 0; i < ListOfCongressMembers.length; i++){
            if (ListOfCongressMembers[i].getRecentParty().equals("Democrat")){
                democrats += 1;
            } else if (ListOfCongressMembers[i].getRecentParty().equals("Republican")) {
                republicans += 1;
            }

        }

        if (party.equals("democrat")){
            return democrats;
        } else if (party.equals("republican")) {
            return republicans;
        }else{
            return 0;
        }
   }


    /**
     * Below method is a helper method, which allows to sort an array. The method swaps two values places.
     * @param array defines the array of Congress people
     * @param first_index defines the first index
     * @param second_index defines the second index
     * @author David Arzumanyan
     */
    public static void swapTwoPlaces(CongressPerson[] array, int first_index, int second_index) {
        //Save the item from the "first" slot into a temporary variable
        //move the "second" item into the "first" slot
        //move the first item (from the "temporary" variable) into the "second" slot
        CongressPerson first_thing = array[first_index];
        CongressPerson second_thing = array[second_index];

        array[first_index] = second_thing;
        array[second_index] = first_thing;

    }


    /**
     * Below method sorts the ListOfCongressMembers by checking their age. Returns a new sorted CongressPeople[] list.
     * @return Returns an array of CongressPerson objects
     * @author David Arzumanyan
     */
   public CongressPerson[] SortedListOfOldestPeople(){

        CongressPerson[] InitialListOfMembers = this.ListOfCongressMembers;

        for (int i = 0; i < ListOfCongressMembers.length; i++){
            for (int z = i + 1; z < ListOfCongressMembers.length; z++){
                if (ListOfCongressMembers[i].LocalDateParser() > ListOfCongressMembers[z].LocalDateParser()){
                    swapTwoPlaces(InitialListOfMembers, i, z);

                }
            }
        }

        return InitialListOfMembers;
   }

    /**
     * Below method takes already a sorted list of CongressMembers,
     * and gets the requested N oldest people from the list. Returns list of CongressMembers.
     * @param N defines the number of oldest people that needs to be returned
     * @return Returns list of CongressPerson objects
     * @author David Arzumanyan
     */
   public List<CongressPerson> CustomSortedListOfOldestPeople(int N){

        int lastNumber = SortedListOfOldestPeople().length - 1;
        int nRangeNumber = lastNumber - N;

        List<CongressPerson> topNMembers = List.of(SortedListOfOldestPeople()).subList(nRangeNumber, lastNumber);

        return topNMembers;

   }

    /**
     * Below code returns a map of average ages for democrats and republicans
     * @return Returns a data type HashMap
     * @author David Arzumanyan
     */
    public HashMap<String, Integer> averageAgeCalculator(){

        List<Long> agesOfDemocrats = new ArrayList<>();
        List<Long> agesOfRepublicans = new ArrayList<>();

        for (int i = 0; i < ListOfCongressMembers.length - 1; i++){
            if (ListOfCongressMembers[i].getRecentParty().equals("Democrat")){
                long age = ListOfCongressMembers[i].LocalDateParser();
                agesOfDemocrats.add(age);

            } else if (ListOfCongressMembers[i].getRecentParty().equals("Republican")) {
                long age = ListOfCongressMembers[i].LocalDateParser();
                agesOfRepublicans.add(age);
            }

        }

        int sumOfDemocrats = 0;
        // Average age of democrats
        for (int i = 0; i < agesOfDemocrats.size(); i++){
            sumOfDemocrats += agesOfDemocrats.get(i);
        }
        int averageAgeOfDemocrats = sumOfDemocrats / agesOfDemocrats.size();


        int sumOfRepublicans = 0;
        // Average age of republicans
        for (int i = 0; i < agesOfRepublicans.size(); i++){
            sumOfRepublicans += agesOfRepublicans.get(i);
        }
        int averageAgeOfRepublicans = sumOfRepublicans / agesOfRepublicans.size();

        HashMap<String, Integer> averageAges = new HashMap<>();
        averageAges.put("Democrats", averageAgeOfDemocrats);
        averageAges.put("Republicans", averageAgeOfRepublicans);

        return averageAges;


    }

    /**
     * A helper method which swaps places not in array as we did above but in a list
     * @param list defines the List of CongressPerson objects
     * @param first_index defines the first index
     * @param second_index defines the second index
     * @author David Arzumanyan
     */
    public static void swapTwoPlacesForLists(List<CongressPerson> list, int first_index, int second_index) {
        //Save the item from the "first" slot into a temporary variable
        //move the "second" item into the "first" slot
        //move the first item (from the "temporary" variable) into the "second" slot
        CongressPerson first_thing = list.get(first_index);
        CongressPerson second_thing = list.get(second_index);

        list.set(first_index, second_thing);
        list.set(second_index, first_thing);

    }

    /**
     * Below code filters all democrats into a new list, then uses linear sorting,
     * then gets the youngest member who has democrat party
     * @return Returns type CongressPerson
     * @author David Arzumanyan
     */
    public CongressPerson youngestDemocrat(){

        List<CongressPerson> listOfDemocrats = new ArrayList<>();

        for (int i = 0; i < ListOfCongressMembers.length; i++){
            if (ListOfCongressMembers[i].getRecentParty().equals("Democrat")){
                listOfDemocrats.add(ListOfCongressMembers[i]);

            }
        }

        for (int i = 0; i < listOfDemocrats.size(); i++){
            for (int z = i + 1; z < listOfDemocrats.size(); z++){
                if(ListOfCongressMembers[i].LocalDateParser() > ListOfCongressMembers[z].LocalDateParser()){
                    swapTwoPlacesForLists(listOfDemocrats, i, z);
                }
            }
        }

        return listOfDemocrats.get(0);
    }


    /**
     * Returns a sorted CongressMembers list based on the time they have been in congress.
     * @return Returns an array of CongressPerson
     * @author David Arzumanyan
     */
    public CongressPerson[] sortedLengthOfTimeForMembers(){

        CongressPerson[] sortedListBasedOnLenght = ListOfCongressMembers;

        for (int i = 0; i < ListOfCongressMembers.length; i++){
            for (int z = i + 1; z < ListOfCongressMembers.length; z++){
                if (ListOfCongressMembers[i].lengthOfTimeForMember() > ListOfCongressMembers[z].lengthOfTimeForMember()){
                    swapTwoPlaces(sortedListBasedOnLenght, i, z);
                }
            }
        }

        return sortedListBasedOnLenght;
    }

}
