package uz.najottalim.appexam.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class TeacherUpdateDto {
    Long id;
    String name;
    String subject;
}
