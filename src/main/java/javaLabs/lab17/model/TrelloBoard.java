package javaLabs.lab17.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.netty.channel.unix.Limits;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class TrelloBoard {
    private String id;
    private String name;
    private String desc;
    private Object descData;
    private Boolean closed;
    private String idOrganization;
    private Object idEnterprise;
    private Boolean pinned;
    private String url;
    private String shortUrl;
    private Prefs prefs;
    private LabelNames labelNames;
    private Limits limits;
}
