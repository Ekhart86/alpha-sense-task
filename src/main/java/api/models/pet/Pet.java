package api.models.pet;

import lombok.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    @Builder.Default
    public Integer id = (int) System.currentTimeMillis() / 1000;
    @Builder.Default
    public Category category = new Category();
    @Builder.Default
    public String name = "New Pet " + System.currentTimeMillis();
    @Builder.Default
    public List<String> photoUrls = Stream.of("link1", "link2").collect(Collectors.toList());
    @Builder.Default
    public List<Tag> tags = Stream.of(new Tag()).collect(Collectors.toList());
    @Builder.Default
    public String status = "available";
}
