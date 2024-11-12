package ie.atu.projectcicd.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Module {
    private int moduleId;
    private String module;
    private String description;
    private int courseId;
}
