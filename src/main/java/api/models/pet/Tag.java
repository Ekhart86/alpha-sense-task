package api.models.pet;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tag {
    @Builder.Default
    public Integer id = 0;
    @Builder.Default
    public String name = "Tag " + System.currentTimeMillis();
}
