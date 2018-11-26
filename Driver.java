public class Driver {
  public static void main(String[] args) {

//TEJAS DRIVER
  System.out.println("Tejas's Driver (Thank you Tejas!)");

    String refStr = "antidisestablishmentarianism";
    MyString testStr = new MyString(refStr);
    int c = 0;
    if (testStr.length() != refStr.length()) {
      System.out.println(++c + ". length() is " + testStr.length() + " instead of " + refStr.length());
    }

    for (int i = -1; i <= testStr.length(); i++) {
      try {
        if (testStr.charAt(i) != refStr.charAt(i)) {
          System.out.println(++c + ". charAt() is returning the wrong char");
          break;
        }
        if (i < 0 || i >= testStr.length()) {
          System.out.println(++c + ". charAt(" + i + ") should throw an IndexOutOfBoundsException");
        }
      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println(++c + ". charAt() should not throw an ArrayIndexOutOfBoundsException");
      } catch (IndexOutOfBoundsException e) {
      }
    }

    if (!testStr.toString().equals(refStr)) {
      System.out.println(++c + ". testStr converts to " + testStr + " instead of " + refStr);
    }

    if (!testStr.subSequence(1,7).equals(refStr.subSequence(1,7))) {
      System.out.println(++c + ". subSequence(1,7) is not " + refStr.subSequence(1,7));
    }

    if (testStr.compareTo(refStr) != 0) {
      System.out.println(++c + ". compareTo() should return 0 in this case");
    }

    refStr += "abcd";

    //System.out.println(testStr.length()); to debug
    //System.out.println(refStr.length()); debugging purposes

    if (testStr.compareTo(refStr) >= 0) {
      System.out.println(++c + ". compareTo() should return a negative in this case");
    }

    refStr = refStr.substring(0,20);

    if (testStr.compareTo(refStr) <= 0) {
      System.out.println(++c + ". compareTo() should return a positive in this case");
    }

    if (c == 0) {
      System.out.println("\nYour MyString passed all the tests. Good work!");
    } else {
      System.out.println("\nYour MyString failed " + c + " tests. Keep trying!");
    }

  //ETHAN Driver

  System.out.println("\nEthan's Driver (Thank you Ethan!)\n");

  MyString b,d;
  String a,ca;

  // A list of test cases. Add anything to this list, and it will run through a complete test case on that MyString.
  String[] cases = {
    "",
    "mario",
    "luigi",
    "qwertyuiopasdfghjklzxcvbnm",
    "helpimtrappedinastringfactory"
  };
  // For compareTo(), every string will be compared to every other String (in both directions).

  for (int i = 0; i < cases.length; i++) {
    a = cases[i];
  // Testing Constructor / MyString.toString()
    try {
      b = new MyString(a);
      if (!a.equals(b.toString())) {
          System.out.println("Error in Constructor / toString():");
          System.out.println("\tInput:       \""+a+"\"");
          System.out.println("\tYour result: \""+b+"\"");
          return;
      }
    } catch (Exception e) {
      System.out.println("Unwanted Exception in Constructor:");
      System.out.println("\tInput: \""+a+"\"");
      System.out.println("\nStack Trace:\n");
      e.printStackTrace();
      return;
    }
  // Testing MyString.length()
    if (b.length() != a.length()) {
        System.out.println("Error in length():");
        System.out.println("\tInput:          \""+b+"\"");
        System.out.println("\tDesired result: "+a.length());
        System.out.println("\tYour result:    "+b.length());
        return;
    }
  // Testing MyString.charAt()
    for (int j = 0; j < a.length(); j++) {
      try {
        if (a.charAt(j) != b.charAt(j)) {
          System.out.println("Error in charAt():");
          System.out.println("\tInput:          \""+b+"\".charAt("+j+")");
          System.out.println("\tDesired result: '"+a.charAt(j)+"'");
          System.out.println("\tYour result:    '"+b.charAt(j)+"'");
          return;
        }
      } catch (Exception e) {
        System.out.println("Unwanted Exception in charAt()");
        System.out.println("\tInput:          \""+b+"\".charAt("+j+")");
        System.out.println("\tDesired result: '"+a.charAt(j)+"'");
        System.out.println("\nStack Trace:\n");
        e.printStackTrace();
        return;
      }
    }
  // Testing MyString.subSequence()
      for (int j = 0; j < a.length(); j++) {
        for (int k = j; k <= a.length(); k++) {
          try {
            if (!a.subSequence(j,k).equals(b.subSequence(j,k).toString())) {
              System.out.println("Error in subSequence():");
              System.out.println("\tInput:          \""+b+"\".subsequence("+j+", "+k+")");
              System.out.println("\tDesired result: \""+a.subSequence(j,k)+"\"");
              System.out.println("\tYour result:    \""+b.subSequence(j,k)+"\"");
              return;
            }
          } catch (Exception e) {
            System.out.println("Unwanted Exception in subSequence()");
            System.out.println("\tInput:          \""+b+"\".subsequence("+j+", "+k+")");
            System.out.println("\tDesired result: \""+a.subSequence(j,k)+"\"");
            System.out.println("\nStack Trace:\n");
            e.printStackTrace();
            return;
          }
        }
      }
  // Testing MyString.compareTo()
    for (int j = 0; j < cases.length; j++) {
      ca = cases[j];
      d = new MyString(ca);
      try {
        if (Math.signum(a.compareTo(ca)) != Math.signum(b.compareTo(d))) {
          System.out.println("Unwanted Exception in compareTo()");
          System.out.println("\tInput:          \""+b+"\".compareTo(\""+d+"\")");
          System.out.println("\tDesired result: "+sgn(a.compareTo(ca)));
          System.out.println("\tYour result:    "+sgn(b.compareTo(d)));
          return;
        }
      } catch (Exception e) {
        System.out.println("Unwanted Exception in compareTo()");
        System.out.println("\tInput:          \""+b+"\", \""+d+"\"");
        System.out.println("\tDesired result: "+sgn(a.compareTo(ca)));
        System.out.println("\nStack Trace:\n");
        e.printStackTrace();
        return;
      }
    }
  }
  System.out.println("Your code passed every test. Well done!");
}


private static String sgn(int i) {
  if (i > 0) return "something positive";
  if (i < 0) return "something negative";
  return "0";
  }
}
