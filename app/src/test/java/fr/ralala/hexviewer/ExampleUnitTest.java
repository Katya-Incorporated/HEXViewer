package fr.ralala.hexviewer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import fr.ralala.hexviewer.models.LineEntry;
import fr.ralala.hexviewer.utils.SysHelper;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(value = Parameterized.class)
public class ExampleUnitTest {
  private final int mShiftOffset;
  private final String mLine1;
  private final String mLine2;

  public ExampleUnitTest(int shiftOffset, String line1, String line2) {
    mShiftOffset = shiftOffset;
    mLine1 = line1;
    mLine2 = line2;
  }
  // name attribute is optional, provide an unique name for test
  // multiple parameters, uses Collection<Object[]>
  @Parameters(name = "{index}: testFormatBufferShift({0}, {1}, {2})")
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {0, "00 01 02 03 04 05 06 07  ........", "08                       ."},
        {1, "   00 01 02 03 04 05 06   .......", "07 08                    .."},
        {2, "      00 01 02 03 04 05    ......", "06 07 08                 ..."},
        {3, "         00 01 02 03 04     .....", "05 06 07 08              ...."},
        {4, "            00 01 02 03      ....", "04 05 06 07 08           ....."},
        {5, "               00 01 02       ...", "03 04 05 06 07 08        ......"},
        {6, "                  00 01        ..", "02 03 04 05 06 07 08     ......."},
        {7, "                     00         .", "01 02 03 04 05 06 07 08  ........"}
    });
  }

  @Test
  public void testFormatBuffer1() {
    byte[] bytes = {0};
    List<LineEntry> list = SysHelper.formatBuffer(bytes, null, SysHelper.MAX_BY_ROW_16);

    assertEquals(1, list.size());
    assertEquals("00                                               .", list.get(0).getPlain());
  }

  @Test
  public void testFormatBuffer2() {
    byte[] bytes = {0, 1};
    List<LineEntry> list = SysHelper.formatBuffer(bytes, null, SysHelper.MAX_BY_ROW_16);

    assertEquals(1, list.size());
    assertEquals("00 01                                            ..", list.get(0).getPlain());
  }

  @Test
  public void testFormatBuffer3() {
    byte[] bytes = {0, 1, 2};
    List<LineEntry> list = SysHelper.formatBuffer(bytes, null, SysHelper.MAX_BY_ROW_16);

    assertEquals(1, list.size());
    assertEquals("00 01 02                                         ...", list.get(0).getPlain());
  }

  @Test
  public void testFormatBuffer4() {
    byte[] bytes = {0, 1, 2, 3};
    List<LineEntry> list = SysHelper.formatBuffer(bytes, null, SysHelper.MAX_BY_ROW_16);

    assertEquals(1, list.size());
    assertEquals("00 01 02 03                                      ....", list.get(0).getPlain());
  }

  @Test
  public void testFormatBuffer5() {
    byte[] bytes = {0, 1, 2, 3, 4};
    List<LineEntry> list = SysHelper.formatBuffer(bytes, null, SysHelper.MAX_BY_ROW_16);

    assertEquals(1, list.size());
    assertEquals("00 01 02 03 04                                   .....", list.get(0).getPlain());
  }

  @Test
  public void testFormatBuffer6() {
    byte[] bytes = {0, 1, 2, 3, 4, 5};
    List<LineEntry> list = SysHelper.formatBuffer(bytes, null, SysHelper.MAX_BY_ROW_16);

    assertEquals(1, list.size());
    assertEquals("00 01 02 03 04 05                                ......", list.get(0).getPlain());
  }

  @Test
  public void testFormatBuffer7() {
    byte[] bytes = {0, 1, 2, 3, 4, 5, 6};
    List<LineEntry> list = SysHelper.formatBuffer(bytes, null, SysHelper.MAX_BY_ROW_16);

    assertEquals(1, list.size());
    assertEquals("00 01 02 03 04 05 06                             .......", list.get(0).getPlain());
  }

  @Test
  public void testFormatBuffer8() {
    byte[] bytes = {0, 1, 2, 3, 4, 5, 6, 7};
    List<LineEntry> list = SysHelper.formatBuffer(bytes, null, SysHelper.MAX_BY_ROW_16);

    assertEquals(1, list.size());
    assertEquals("00 01 02 03 04 05 06 07                          ........", list.get(0).getPlain());
  }

  @Test
  public void testFormatBuffer9() {
    byte[] bytes = {0, 1, 2, 3, 4, 5, 6, 7, 8};
    List<LineEntry> list = SysHelper.formatBuffer(bytes, null, SysHelper.MAX_BY_ROW_16);

    assertEquals(1, list.size());
    assertEquals("00 01 02 03 04 05 06 07 08                       .........", list.get(0).getPlain());
  }

  @Test
  public void testFormatBuffer10() {
    byte[] bytes = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    List<LineEntry> list = SysHelper.formatBuffer(bytes, null, SysHelper.MAX_BY_ROW_16);

    assertEquals(1, list.size());
    assertEquals("00 01 02 03 04 05 06 07 08 09                    ..........", list.get(0).getPlain());
  }

  @Test
  public void testFormatBuffer11() {
    byte[] bytes = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    List<LineEntry> list = SysHelper.formatBuffer(bytes, null, SysHelper.MAX_BY_ROW_16);

    assertEquals(1, list.size());
    assertEquals("00 01 02 03 04 05 06 07 08 09 0a                 ...........", list.get(0).getPlain());
  }

  @Test
  public void testFormatBuffer12() {
    byte[] bytes = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    List<LineEntry> list = SysHelper.formatBuffer(bytes, null, SysHelper.MAX_BY_ROW_16);

    assertEquals(1, list.size());
    assertEquals("00 01 02 03 04 05 06 07 08 09 0a 0b              ............", list.get(0).getPlain());
  }

  @Test
  public void testFormatBuffer13() {
    byte[] bytes = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    List<LineEntry> list = SysHelper.formatBuffer(bytes, null, SysHelper.MAX_BY_ROW_16);

    assertEquals(1, list.size());
    assertEquals("00 01 02 03 04 05 06 07 08 09 0a 0b 0c           .............", list.get(0).getPlain());
  }

  @Test
  public void testFormatBuffer14() {
    byte[] bytes = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    List<LineEntry> list = SysHelper.formatBuffer(bytes, null, SysHelper.MAX_BY_ROW_16);

    assertEquals(1, list.size());
    assertEquals("00 01 02 03 04 05 06 07 08 09 0a 0b 0c 0d        ..............", list.get(0).getPlain());
  }

  @Test
  public void testFormatBuffer15() {
    byte[] bytes = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    List<LineEntry> list = SysHelper.formatBuffer(bytes, null, SysHelper.MAX_BY_ROW_16);

    assertEquals(1, list.size());
    assertEquals("00 01 02 03 04 05 06 07 08 09 0a 0b 0c 0d 0e     ...............", list.get(0).getPlain());
  }

  @Test
  public void testFormatBuffer16() {
    byte[] bytes = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    List<LineEntry> list = SysHelper.formatBuffer(bytes, null, SysHelper.MAX_BY_ROW_16);

    assertEquals(1, list.size());
    assertEquals("00 01 02 03 04 05 06 07 08 09 0a 0b 0c 0d 0e 0f  ................", list.get(0).getPlain());
  }

  @Test
  public void testFormatBuffer17() {
    byte[] bytes = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
    List<LineEntry> list = SysHelper.formatBuffer(bytes, null, SysHelper.MAX_BY_ROW_16);

    assertEquals(2, list.size());
    assertEquals("00 01 02 03 04 05 06 07 08 09 0a 0b 0c 0d 0e 0f  ................", list.get(0).getPlain());
    assertEquals("10                                               .", list.get(1).getPlain());
  }

  @Test
  public void testFormatBuffer18() {
    byte[] bytes = {0};
    List<LineEntry> list = SysHelper.formatBuffer(bytes, null, SysHelper.MAX_BY_ROW_8);

    assertEquals(1, list.size());
    assertEquals("00                       .", list.get(0).getPlain());
  }

  @Test
  public void testFormatBuffer19() {
    byte[] bytes = {0, 1};
    List<LineEntry> list = SysHelper.formatBuffer(bytes, null, SysHelper.MAX_BY_ROW_8);

    assertEquals(1, list.size());
    assertEquals("00 01                    ..", list.get(0).getPlain());
  }

  @Test
  public void testFormatBuffer20() {
    byte[] bytes = {0, 1, 2};
    List<LineEntry> list = SysHelper.formatBuffer(bytes, null, SysHelper.MAX_BY_ROW_8);

    assertEquals(1, list.size());
    assertEquals("00 01 02                 ...", list.get(0).getPlain());
  }

  @Test
  public void testFormatBuffer21() {
    byte[] bytes = {0, 1, 2, 3};
    List<LineEntry> list = SysHelper.formatBuffer(bytes, null, SysHelper.MAX_BY_ROW_8);

    assertEquals(1, list.size());
    assertEquals("00 01 02 03              ....", list.get(0).getPlain());
  }

  @Test
  public void testFormatBuffer22() {
    byte[] bytes = {0, 1, 2, 3, 4};
    List<LineEntry> list = SysHelper.formatBuffer(bytes, null, SysHelper.MAX_BY_ROW_8);

    assertEquals(1, list.size());
    assertEquals("00 01 02 03 04           .....", list.get(0).getPlain());
  }

  @Test
  public void testFormatBuffer23() {
    byte[] bytes = {0, 1, 2, 3, 4, 5};
    List<LineEntry> list = SysHelper.formatBuffer(bytes, null, SysHelper.MAX_BY_ROW_8);

    assertEquals(1, list.size());
    assertEquals("00 01 02 03 04 05        ......", list.get(0).getPlain());
  }

  @Test
  public void testFormatBuffer24() {
    byte[] bytes = {0, 1, 2, 3, 4, 5, 6};
    List<LineEntry> list = SysHelper.formatBuffer(bytes, null, SysHelper.MAX_BY_ROW_8);

    assertEquals(1, list.size());
    assertEquals("00 01 02 03 04 05 06     .......", list.get(0).getPlain());
  }

  @Test
  public void testFormatBuffer25() {
    byte[] bytes = {0, 1, 2, 3, 4, 5, 6, 7};
    List<LineEntry> list = SysHelper.formatBuffer(bytes, null, SysHelper.MAX_BY_ROW_8);

    assertEquals(1, list.size());
    assertEquals("00 01 02 03 04 05 06 07  ........", list.get(0).getPlain());
  }

  @Test
  public void testFormatBuffer26() {
    byte[] bytes = {0, 1, 2, 3, 4, 5, 6, 7, 8};
    List<LineEntry> list = SysHelper.formatBuffer(bytes, null, SysHelper.MAX_BY_ROW_8);

    assertEquals(2, list.size());
    assertEquals("00 01 02 03 04 05 06 07  ........", list.get(0).getPlain());
    assertEquals("08                       .", list.get(1).getPlain());
  }

  @Test
  public void testFormatBuffer37() {
    byte[] bytes = {0, 1, 2, 3};
    List<LineEntry> list = new ArrayList<>();
    SysHelper.formatBuffer(list, bytes, bytes.length, null, SysHelper.MAX_BY_ROW_8, 1);

    assertEquals(1, list.size());
    assertEquals("   00 01 02 03           ....", list.get(0).getPlain());
  }

  @Test
  public void testFormatBufferShift() {
    byte[] bytes = {0, 1, 2, 3, 4, 5, 6, 7, 8};
    List<LineEntry> list = new ArrayList<>();
    SysHelper.formatBuffer(list, bytes, bytes.length, null, SysHelper.MAX_BY_ROW_8, mShiftOffset);

    assertEquals(2, list.size());
    assertEquals(mLine1, list.get(0).getPlain());
    assertEquals(mLine2, list.get(1).getPlain());
  }
}
