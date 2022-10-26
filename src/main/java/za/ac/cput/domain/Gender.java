package za.ac.cput.domain;


/*
EmployeeAddressAPI.java
AUTHOR Mutamba Prince Bulambo
Student Number 220177767
Date April 11 2022
 */

public class Gender {

  
    private Long genderId;

    private String genderType;
    private String description;

    public void setEmtp(String emtp) {
        this.emtp = emtp;
    }

    public String emtp;

    public Gender(Builder builder)
    {
        this.genderId=builder.genderId;
        this.genderType=builder.genderType;
        this.description=builder.description;
    }

    public Gender() {

    }

    public Long getGenderId() {
        return genderId;
    }

    public String getGenderType() {
        return genderType;
    }

    public String getDescription() {
        return description;
    }


    @Override
    public String toString() {
        return "Gender{" +
                "genderId='" + genderId + '\'' +
                ", genderType='" + genderType + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public static class Builder
    {
        private Long genderId;
        private String genderType;
        private String description;

        public Builder setGenderId(Long genderId) {
            this.genderId =genderId;
            return this;
        }

        public Builder setGenderType(String genderType) {
            this.genderType = genderType;
            return this;
        }

        public Builder setDescription(String description) {
            this.description= description;
            return this;
        }

        public Builder cody(Gender gender)
        {
            this.genderId=gender.genderId;
            this.genderType=gender.genderType;
            this.description=gender.description;

            return this;
        }
        public Gender  Build()
        {
            return new Gender (this);
        }
    }

}
