package cabanas.garcia.ismael.examples.rest.response;

import lombok.*;

/**
 * Created by XI317311 on 03/02/2017.
 */
@Builder
@EqualsAndHashCode
@ToString
@Getter
@AllArgsConstructor
public class UserResponse {
    private String id;

    private String name;

}
