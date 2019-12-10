package notifier.core.lambda;

import java.time.LocalDate;

import org.apache.commons.lang3.StringUtils;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import notifier.core.slack.NotifyToSlack;
import notifier.core.trash.TrashSearcher;

public class LambdaHandler implements RequestHandler<Object, String> {

  @Override
  public String handleRequest(Object input, Context context) {
    String token = System.getenv("SLACK_TOKEN");

    LocalDate tomorrow = LocalDate.now().plusDays(1);
    String message = TrashSearcher.getMessageIfTrashDay(tomorrow);

    if(StringUtils.isBlank(message)) {
      return "明日はなにもない日";
    }

    String text = "明日は" + message + "の日だよ";
    NotifyToSlack.notify(token, text);

    return text;
  }

}
