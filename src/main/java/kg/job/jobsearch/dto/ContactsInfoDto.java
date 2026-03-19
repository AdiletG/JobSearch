package kg.job.jobsearch.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactsInfoDto {
   private Integer id;
   private Integer type_id;
   private Integer resume_id;
   private String contactValue;

   @Override
   public String toString() {
      return "ContactsInfoDto{" +
              "id=" + id +
              ", type_id=" + type_id +
              ", resume_id=" + resume_id +
              ", value='" + contactValue + '\'' +
              '}';
   }
}