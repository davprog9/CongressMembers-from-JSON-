package org.example;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.util.List;

public class Term{

    @JsonProperty("type")
    private String termType;
    @JsonProperty("state")
    private String termState;
    @JsonProperty("party")
    private String termParty;
    @JsonProperty("start")
    private LocalDate termStart;
    @JsonProperty("end")
    private LocalDate termEnd;

    @JsonProperty("terms")
    private List<Term> innerTerms; // Might be deleting at the end of the project


    public Term(){
        this.termType = "Nontype";
        this.termState = "NA";
        this.termParty = "NOPARTY";
        this.termStart = LocalDate.MIN;
        this.termEnd = LocalDate.MAX;
    }

    public Term(String termType, String termState, String termParty, LocalDate termStart, LocalDate termEnd){
        this.termType = termType;
        this.termState = termState;
        this.termParty = termParty;
        this.termStart = termStart;
        this.termEnd = termEnd;
    }

    public String getTermType() {
        return termType;
    }

    public String getTermState() {
        return termState;
    }

    public String getTermParty() {
        return termParty;
    }

    public LocalDate getTermStart() {
        return termStart;
    }

    public LocalDate getTermEnd() {
        return termEnd;
    }

    public List<Term> getInnerTerms() {
        return innerTerms;
    }

    @Override
    public String toString() {
        return "Term{" +
                "termType='" + termType + '\'' +
                ", termState='" + termState + '\'' +
                ", termParty='" + termParty + '\'' +
                ", termStart=" + termStart +
                ", termEnd=" + termEnd +
                '}';
    }
}
