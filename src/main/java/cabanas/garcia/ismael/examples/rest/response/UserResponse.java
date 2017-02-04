package cabanas.garcia.ismael.examples.rest.response;

/**
 * Created by XI317311 on 03/02/2017.
 */
public class UserResponse {
    private String id;

    private String name;

    public String getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = String.valueOf(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
