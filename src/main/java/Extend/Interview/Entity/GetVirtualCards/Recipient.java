package Extend.Interview.Entity.GetVirtualCards;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Recipient {
    @JsonProperty("id")
    String id;
    @JsonProperty("firstName")
    String firstName;
    @JsonProperty("lastName")
    String lastName;

    public Recipient(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Recipient() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
