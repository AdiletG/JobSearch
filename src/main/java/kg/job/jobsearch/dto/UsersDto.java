package kg.job.jobsearch.dto;


import kg.job.jobsearch.enums.AccountTypeEnums;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersDto {
   private Long id;
   private String name;
   private String surname;
   private Integer age;
   private String email;
   private String password;
   private String phoneNumber;
   private String avatar;
   private AccountTypeEnums accountType;

   @Override
   public String toString() {
      return "UsersDto{" +
              "id=" + id +
              ", name='" + name + '\'' +
              ", surname='" + surname + '\'' +
              ", age=" + age +
              ", email='" + email + '\'' +
              ", password='" + password + '\'' +
              ", phoneNumber='" + phoneNumber + '\'' +
              ", avatar='" + avatar + '\'' +
              ", accountType=" + accountType +
              '}';
   }
}