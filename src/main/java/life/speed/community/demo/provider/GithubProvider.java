package life.speed.community.demo.provider;

import com.alibaba.fastjson.JSON;
import life.speed.community.demo.dto.AccessTokenDTO;
import life.speed.community.demo.dto.GithubUser;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author bee
 * @description
 * @create 2021-07-10 16:37
 */
@Data
@Component
@Slf4j
public class GithubProvider {



     public String getAccessToken(AccessTokenDTO accessTokenDTO){
         MediaType mediaType = MediaType.get("application/json; charset=utf-8");
         OkHttpClient client = new OkHttpClient();
         RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
         Request request = new Request.Builder()
                 .url("https://github.com/login/oauth/access_token")
                 .post(body)
                 .build();
         try (Response response = client.newCall(request).execute()) {
             String string = response.body().string();
             String token = string.split("&")[0].split("=")[1];
             System.out.println(token);
             return token;
         } catch (IOException e) {
             e.printStackTrace();
         }
         return null;
     }

//
    public GithubUser getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.github.com/user")
                .header("Authorization","token "+accessToken)
                .build();

        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            return githubUser;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
