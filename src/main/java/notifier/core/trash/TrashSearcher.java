package notifier.core.trash;

import static java.time.DayOfWeek.*;
import static notifier.core.trash.stract.TrashType.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import notifier.core.trash.stract.StructedTrash;

public class TrashSearcher {
  /** ごみ出し一覧・・・多すぎるんだが？？？？？？？ */
  private static final List<StructedTrash> TRASH_LIST = Arrays.asList(
      new StructedTrash(burnable, Arrays.asList(MONDAY, THURSDAY), Collections.emptyList()),
      new StructedTrash(petbottle, Arrays.asList(FRIDAY), Arrays.asList(1, 3)),
      new StructedTrash(tray, Arrays.asList(WEDNESDAY), Collections.emptyList()),
      new StructedTrash(can, Arrays.asList(WEDNESDAY), Arrays.asList(2)),
      new StructedTrash(bin, Arrays.asList(TUESDAY), Arrays.asList(2)),
      new StructedTrash(unburnable, Arrays.asList(TUESDAY), Arrays.asList(3)),
      new StructedTrash(spray, Arrays.asList(TUESDAY), Arrays.asList(4)),
      new StructedTrash(paper, Arrays.asList(SATURDAY), Arrays.asList(2, 4)));

  private TrashSearcher() {
  }

  public static String getMessageIfTrashDay(LocalDate localDate) {
    // 2020/1/1～3は正月休みらしい
    if (LocalDate.of(2020, 1, 1).isEqual(localDate) || LocalDate.of(2020, 1, 2).isEqual(localDate)
        || LocalDate.of(2020, 1, 3).isEqual(localDate)) {
      return StringUtils.EMPTY;
    }

    List<String> trashes = TRASH_LIST.stream()
        .filter(equalsDayOfWeek(localDate))
        .filter(equalsWeekOfMonth(localDate))
        .map(trash -> trash.getTrashType().getJapaneseName())
        .collect(Collectors.toList());

    if (trashes.isEmpty()) {
      return StringUtils.EMPTY;
    } else if (trashes.size() > 1) {
      return String.join("と", trashes);
    } else {
      return trashes.get(0);
    }
  }

  /**
   * 曜日があっているか
  * @param localDate 日付
  * @return 関数型インターフェース
  */
  private static Predicate<StructedTrash> equalsDayOfWeek(LocalDate localDate) {
    return trash -> trash.getDayOfWeeks().contains(localDate.getDayOfWeek());
  }

  /**
      * 週があっているか
   * @param localDate 日付
   * @return 関数型インターフェース
   */
  private static Predicate<StructedTrash> equalsWeekOfMonth(LocalDate localDate) {
    return trash -> {
      // 週の何番目かの指定がないときは、必ずtrueを返す
      if (trash.getWeekOfMonths().isEmpty()) {
        return true;
      } else {
        return trash.getWeekOfMonths().contains(getWeekOfMonth(localDate));
      }
    };
  }

  /**
   * 何番目の週か
   * @param localDate 日付
   * @return 何番目の週
   */
  private static int getWeekOfMonth(LocalDate localDate) {
    return (int) Math.ceil(localDate.getDayOfMonth() / 7.0);
  }
}
