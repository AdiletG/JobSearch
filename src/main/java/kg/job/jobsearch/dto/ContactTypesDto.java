package kg.job.jobsearch.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactTypesDto {
   private Long id;
   private String type;

   @Override
   public String toString() {
      return "ContactTypeDto{" +
              "id=" + id +
              ", type='" + type + '\'' +
              '}';
   }
}