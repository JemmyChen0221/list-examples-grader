import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;
import java.util.List;




class lenghLargerThan3 implements StringChecker{
    @Override
    public boolean checkString(String s) {
      if(s.length() > 3){
        return true;
      }
      return false;
    }
  }

public class TestListExamples {

  @Test
  public void testFilter(){
    ArrayList<String> expected = new ArrayList<>();
    expected.add("cdef");
    expected.add("cdefg");
    expected.add("cdefgg");
    expected.add("cdeftt");

    List<String> input = new ArrayList<>();
    input.add("a");
    input.add("bb");
    input.add("ccc");
    input.add("cdef");
    input.add("cdefg");
    input.add("cdefgg");
    input.add("cdeftt");
    
    StringChecker sc = new lenghLargerThan3();

    List<String> output = ListExamples.filter(input, sc);
    assertEquals(expected, output);
  }



  @Test
  public void testMerge(){
    ArrayList<String> expected = new ArrayList<>();
    expected.add("a");
    expected.add("b");
    expected.add("c");
    expected.add("d");
    expected.add("e");


    List<String> input = new ArrayList<>();
    input.add("a");
    input.add("c");
    input.add("d");

    List<String> input2 = new ArrayList<>();
    input2.add("b");
    input2.add("e");

    List<String> output = ListExamples.merge(input,input2);

    assertEquals(expected, output);
  }
}
