package fun.etrandafr.reports.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActivityDto {

    public enum Type {
        CYCLING, RUNNING, BOULDERING, ROCK_CLIMBING, SPIKEBALL
    }

    private Long id;
    private String name;
    private Type type;
    private Integer durationInMinutes;


}
