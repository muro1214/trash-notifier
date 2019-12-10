package notifier.core.trash.stract;

import java.time.DayOfWeek;
import java.util.List;

public class StructedTrash {
  private TrashType trashType;
  private List<DayOfWeek> dayOfWeeks;
  private List<Integer> weekOfMonths;

  public StructedTrash(TrashType trashType, List<DayOfWeek> dayOfWeeks, List<Integer> weekOfMonths) {
    this.trashType = trashType;
    this.dayOfWeeks = dayOfWeeks;
    this.weekOfMonths = weekOfMonths;
  }

  public TrashType getTrashType() {
    return trashType;
  }

  public List<DayOfWeek> getDayOfWeeks() {
    return dayOfWeeks;
  }

  public List<Integer> getWeekOfMonths() {
    return weekOfMonths;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();

    builder.append("StructedTrash [trashType=").append(trashType).append(", dayOfWeeks=").append(dayOfWeeks)
        .append(", weekOfMonths=").append(weekOfMonths).append("]");

    return builder.toString();
  }

}
