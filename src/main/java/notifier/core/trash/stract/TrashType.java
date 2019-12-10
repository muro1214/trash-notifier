package notifier.core.trash.stract;

public enum TrashType {
  burnable("燃せるごみ"),
  petbottle("ペットボトル"),
  tray("トレー類"),
  can("かん類"),
  bin("びん類"),
  unburnable("燃せないごみ"),
  spray("スプレー缶など"),
  paper("紙・布類");

  private String japaneseName;

  private TrashType(String japaneseName) {
    this.japaneseName = japaneseName;
  }

  public String getJapaneseName() {
    return japaneseName;
  }
}
