package kg.job.jobsearch.dto;


import kg.job.jobsearch.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersDto {
   private int id;
   private String name;
   private String surname;
   private int age;
   private String email;
   private String password;
   private String phone_number;
   private String avatar;
   private AccountType account_type;

   @Override
   public String toString() {
      return "UsersDto{" +
              "id=" + id +
              ", name='" + name + '\'' +
              ", surname='" + surname + '\'' +
              ", age=" + age +
              ", email='" + email + '\'' +
              ", phone_number='" + phone_number + '\'' +
              ", avatar='" + avatar + '\'' +
              ", account_type='" + account_type + '\'' +
              '}';
   }
}