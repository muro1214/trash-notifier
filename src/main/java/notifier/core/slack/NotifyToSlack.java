package notifier.core.slack;

import java.net.URI;

import org.springframework.http.RequestEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import notifier.core.slack.json.Payload;

public class NotifyToSlack {
  private static final String BASE_URL = "https://hooks.slack.com/services/";

  private NotifyToSlack() {}

  public static void notify(String token, String message) {
    ObjectMapper mapper = new ObjectMapper();
    try {
      String incomingJsonString = "payload=" + mapper.writeValueAsString(new Payload(message));

      System.out.println(incomingJsonString);

      RequestEntity<?> req = RequestEntity.post(URI.create(BASE_URL + token))
          .header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
          .body(incomingJsonString);

      new RestTemplate().exchange(req, String.class);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
  }
}
