package api.models.order;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Builder.Default
    public Integer id = (int) System.currentTimeMillis() / 1000;
    @Builder.Default
    public Integer petId = (int) System.currentTimeMillis() / 1500;
    @Builder.Default
    private Integer quantity = 1;
    @Builder.Default
    private String shipDate = "2021-08-25T17:44:55.989+0000";
    @Builder.Default
    private String status = "in progress";
    @Builder.Default
    private boolean complete = true;
}
