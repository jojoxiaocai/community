package life.speed.community.demo.dto;

import lombok.Data;

/**
 * @author bee
 * @description
 * @create 2021-07-10 16:27
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
