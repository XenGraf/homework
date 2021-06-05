package lesson7.project.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Night {
    @JsonProperty(value = "IconPhrase")
    private String description;

    public Night() {}

    public Night(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Night{" +
                "description='" + description + '\'' +
                '}';
    }
}
