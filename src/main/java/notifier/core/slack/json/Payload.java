package notifier.core.slack.json;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Payload {
  private String username;
  private String icon_emoji;
  private String text;

  public Payload(String text) {
    this.username = "ごみ出し通知くん";
    this.icon_emoji = ":ghost:";
    this.text = text;
  }

  public String getUsername() {
    return username;
  }

  public String getIcon_emoji() {
    return icon_emoji;
  }

  public String getText() {
    return text;
  }
}
