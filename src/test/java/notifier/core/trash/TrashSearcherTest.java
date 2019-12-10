package notifier.core.trash;

import static notifier.core.trash.stract.TrashType.*;

import java.time.LocalDate;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

public class TrashSearcherTest {

  @Test
  public void getMessageIfTrashDayTest() {
    // 2019年12月
    Assert.assertEquals(StringUtils.EMPTY, TrashSearcher.getMessageIfTrashDay(LocalDate.of(2019, 12, 1)));
    Assert.assertEquals(burnable.getJapaneseName(), TrashSearcher.getMessageIfTrashDay(LocalDate.of(2019, 12, 2)));
    Assert.assertEquals(StringUtils.EMPTY, TrashSearcher.getMessageIfTrashDay(LocalDate.of(2019, 12, 3)));
    Assert.assertEquals(tray.getJapaneseName(), TrashSearcher.getMessageIfTrashDay(LocalDate.of(2019, 12, 4)));
    Assert.assertEquals(burnable.getJapaneseName(), TrashSearcher.getMessageIfTrashDay(LocalDate.of(2019, 12, 5)));
    Assert.assertEquals(petbottle.getJapaneseName(), TrashSearcher.getMessageIfTrashDay(LocalDate.of(2019, 12, 6)));
    Assert.assertEquals(StringUtils.EMPTY, TrashSearcher.getMessageIfTrashDay(LocalDate.of(2019, 12, 7)));
    Assert.assertEquals(StringUtils.EMPTY, TrashSearcher.getMessageIfTrashDay(LocalDate.of(2019, 12, 8)));
    Assert.assertEquals(burnable.getJapaneseName(), TrashSearcher.getMessageIfTrashDay(LocalDate.of(2019, 12, 9)));
    Assert.assertEquals(bin.getJapaneseName(), TrashSearcher.getMessageIfTrashDay(LocalDate.of(2019, 12, 10)));
    Assert.assertEquals(tray.getJapaneseName() + "と" + can.getJapaneseName(),
        TrashSearcher.getMessageIfTrashDay(LocalDate.of(2019, 12, 11)));
    Assert.assertEquals(burnable.getJapaneseName(), TrashSearcher.getMessageIfTrashDay(LocalDate.of(2019, 12, 12)));
    Assert.assertEquals(StringUtils.EMPTY, TrashSearcher.getMessageIfTrashDay(LocalDate.of(2019, 12, 13)));
    Assert.assertEquals(paper.getJapaneseName(), TrashSearcher.getMessageIfTrashDay(LocalDate.of(2019, 12, 14)));
    Assert.assertEquals(StringUtils.EMPTY, TrashSearcher.getMessageIfTrashDay(LocalDate.of(2019, 12, 15)));
    Assert.assertEquals(burnable.getJapaneseName(), TrashSearcher.getMessageIfTrashDay(LocalDate.of(2019, 12, 16)));
    Assert.assertEquals(unburnable.getJapaneseName(), TrashSearcher.getMessageIfTrashDay(LocalDate.of(2019, 12, 17)));
    Assert.assertEquals(tray.getJapaneseName(), TrashSearcher.getMessageIfTrashDay(LocalDate.of(2019, 12, 18)));
    Assert.assertEquals(burnable.getJapaneseName(), TrashSearcher.getMessageIfTrashDay(LocalDate.of(2019, 12, 19)));
    Assert.assertEquals(petbottle.getJapaneseName(), TrashSearcher.getMessageIfTrashDay(LocalDate.of(2019, 12, 20)));
    Assert.assertEquals(StringUtils.EMPTY, TrashSearcher.getMessageIfTrashDay(LocalDate.of(2019, 12, 21)));
    Assert.assertEquals(StringUtils.EMPTY, TrashSearcher.getMessageIfTrashDay(LocalDate.of(2019, 12, 22)));
    Assert.assertEquals(burnable.getJapaneseName(), TrashSearcher.getMessageIfTrashDay(LocalDate.of(2019, 12, 23)));
    Assert.assertEquals(spray.getJapaneseName(), TrashSearcher.getMessageIfTrashDay(LocalDate.of(2019, 12, 24)));
    Assert.assertEquals(tray.getJapaneseName(), TrashSearcher.getMessageIfTrashDay(LocalDate.of(2019, 12, 25)));
    Assert.assertEquals(burnable.getJapaneseName(), TrashSearcher.getMessageIfTrashDay(LocalDate.of(2019, 12, 26)));
    Assert.assertEquals(StringUtils.EMPTY, TrashSearcher.getMessageIfTrashDay(LocalDate.of(2019, 12, 27)));
    Assert.assertEquals(paper.getJapaneseName(), TrashSearcher.getMessageIfTrashDay(LocalDate.of(2019, 12, 28)));
    Assert.assertEquals(StringUtils.EMPTY, TrashSearcher.getMessageIfTrashDay(LocalDate.of(2019, 12, 29)));
    Assert.assertEquals(burnable.getJapaneseName(), TrashSearcher.getMessageIfTrashDay(LocalDate.of(2019, 12, 30)));
    Assert.assertEquals(StringUtils.EMPTY, TrashSearcher.getMessageIfTrashDay(LocalDate.of(2019, 12, 31)));

    // 2020年年始
    Assert.assertEquals(StringUtils.EMPTY, TrashSearcher.getMessageIfTrashDay(LocalDate.of(2020, 1, 1)));
    Assert.assertEquals(StringUtils.EMPTY, TrashSearcher.getMessageIfTrashDay(LocalDate.of(2020, 1, 2)));
    Assert.assertEquals(StringUtils.EMPTY, TrashSearcher.getMessageIfTrashDay(LocalDate.of(2020, 1, 3)));
    Assert.assertEquals(StringUtils.EMPTY, TrashSearcher.getMessageIfTrashDay(LocalDate.of(2020, 1, 4)));
    Assert.assertEquals(StringUtils.EMPTY, TrashSearcher.getMessageIfTrashDay(LocalDate.of(2020, 1, 5)));
    Assert.assertEquals(burnable.getJapaneseName(), TrashSearcher.getMessageIfTrashDay(LocalDate.of(2020, 1, 6)));
  }
}
