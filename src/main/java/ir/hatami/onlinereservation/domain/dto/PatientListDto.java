package ir.hatami.onlinereservation.domain.dto;

import ir.hatami.onlinereservation.domain.dto.common.BaseReadDto;
import ir.hatami.onlinereservation.domain.dto.common.ListDto;

public class PatientListDto extends BaseReadDto implements ListDto {
      private String firstName;
    private String lastName;
    private String email;

    public PatientListDto() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
