package cabanas.garcia.ismael.examples.rest.request;

import lombok.*;

/**
 * Created by XI317311 on 03/02/2017.
 */
@Builder
@EqualsAndHashCode
@ToString
@Getter
@Setter
public class UserRequest {

    private String id;

    private String name;

}
