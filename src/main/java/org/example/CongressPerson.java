package org.example;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;



public class CongressPerson {

    // SETTERS FOR NESTED KEYS
    @JsonSetter("name")
    public void setName(Map<String, String> nameEntries) {
        this.firstname  = nameEntries.get("first");
        this.lastname = nameEntries.get("last");
    }

    @JsonSetter("bio")
    public void setGender(Map<String,String> bio_entries){
        this.gender = bio_entries.get("gender");
        this.birthDate = LocalDate.parse(bio_entries.get("birthday"));
    }

    private String firstname;

    private String lastname;

    private String gender;

    private LocalDate birthDate;
    @JsonProperty("terms")
    private List<Term> terms;


    /**
     * Default constructor
     * @author David Arzumanyan
     */
    public CongressPerson(){
        this.firstname = "NOBODY";
        this.lastname = "NONE";
        this.gender = "NONE";
        this.birthDate = LocalDate.MIN;

    }

    /**
     * Main constructor
     * @param firstname defines the name of the Congress person
     * @param lastname defines the lastname of the Congress person
     * @param gender defines the gender of the Congress person
     * @param birthDate defines the birthDate of the Congress person
     */
    public CongressPerson(String firstname, String lastname, String gender, LocalDate birthDate){
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.birthDate = birthDate;

    }

    /**
     * Getter for first name
     * @return Returns data type String
     * @author David Arzumanyan
     */
    public String getFirstname() {return firstname;}

    /**
     * Getter for last name
     * @return Returns data type String
     * @author David Arzumanyan
     */
    public String getLastname() {return lastname;}

    /**
     * Getter for gender
     * @return Returns data type String
     * @author David Arzumanyan
     */
    public String getGender() {return gender;}

    /**
     * Getter for birthdate
     * @return Returns data type LocalDate
     * @author David Arzumanyan
     */
    public LocalDate getBirthDate() {return birthDate;}


    /**
     * Getter for list of terms
     * @return Returns type Term
     * @author David Arzumanyan
     */
    public List<Term> getTerms() {return terms;}

    /**
     * Getter for recent party
     * @return Returns data type String
     * @author David Arzumanyan
     */
    public String getRecentParty(){
        return terms.get(terms.size()-1).getTermParty();
    }


    /**
     * LocalDateParser calculates the age of a member
     * @return Returns data type long
     * @author David Arzumanyan
     */
    public long LocalDateParser(){
        LocalDate today = LocalDate.now();
        long years = ChronoUnit.YEARS.between(this.birthDate, today); // ChronoUNIT was found from stackoverflow.

        return years;
    }

    /**
     * Method calculates the amount of time the member have been in congress
     * @return Returns data type long
     * @author David Arzumanyan
     */
    public long lengthOfTimeForMember(){
        LocalDate recentEndDate = terms.get(terms.size()-1).getTermEnd();
        LocalDate startDate = terms.get(0).getTermStart();

        long lengthOfTime = ChronoUnit.YEARS.between(startDate, recentEndDate);

        return lengthOfTime;
    }



    @Override
    public String toString() {
        return "CongressPerson{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", gender='" + gender + '\'' +
                ", birthDate=" + birthDate +
                ", terms=" + terms +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        CongressPerson member = (CongressPerson) obj;

        if (member.getFirstname().equals(this.getFirstname()) && member.getLastname().equals(this.getLastname()) && member.getGender().equals(this.getGender()) && member.getBirthDate().equals(this.getBirthDate())){
            return true;
        }
        else{
            return false;
        }
}
}
