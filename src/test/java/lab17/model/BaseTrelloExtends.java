package lab17.model;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BaseTrelloExtends {
    private String key;
    private String token;

    public BaseTrelloExtends(String key, String token) {
        this.key = key;
        this.token = token;
    }
}
