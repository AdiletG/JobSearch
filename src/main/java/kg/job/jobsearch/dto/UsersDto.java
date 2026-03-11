package kg.job.jobsearch.dto;


import lombok.Data;

@Data
public class UsersDto {
   private int id;
   private String name;
   private String surname;
   private int age;
   private String email;
   private String password;
   private String phone_number;
   private String avatar;
   private String account_type;
}