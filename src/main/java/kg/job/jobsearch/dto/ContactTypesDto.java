package kg.job.jobsearch.dto;

import kg.job.jobsearch.enums.ContactTypeEnums;
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
   private ContactTypeEnums type;

   @Override
   public String toString() {
      return "Id: " + id +
              "\nType: " + type;
   }
}