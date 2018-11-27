public class MyString implements CharSequence,Comparable<CharSequence>{
  private char[] data;
  public MyString(CharSequence s){
    data = new char[s.length()];
    for(int i = 0; i < s.length(); i++){
      data[i] = s.charAt(i); //adding charseq into array
    }
  }
  public char charAt(int index){
    if (index >= length() || index < 0) { //checking if valid index
      throw new IndexOutOfBoundsException("Invalid index at" + index);
    }
    return data[index];
  }
  public int length(){
    return data.length; //return length
  }
  public CharSequence subSequence(int start, int end){
    String newstr = "";
    for(int i = start; i < end; i++){
      newstr += data[i];
    }
    return newstr; //returns substring
  }
  public String toString(){
    String str = "";
    for(int i = 0; i < data.length; i ++){
      str += data[i];
    }
    return str;
  }
  public int compareTo(CharSequence s){
    for(int i = 0; i < s.length() && i < this.length(); i ++){
      if(s.charAt(i) > this.charAt(i)){
        return -1;
      }
      if(s.charAt(i) < this.charAt(i)){
        return 1;
      }
    }
    return this.length() - s.length();
  }

}
