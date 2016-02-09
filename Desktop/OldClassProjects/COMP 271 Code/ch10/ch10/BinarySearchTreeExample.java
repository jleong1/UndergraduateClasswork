public class BinarySearchTreeExample
{
  public static void main (String[ ] args)
  {
    new BinarySearchTreeExample().run();
  } // method main
  
  public void run()
  {
    BinarySearchTree<String> tree1 = new BinarySearchTree<String>();
    
    tree1.add ("yes");
    tree1.add ("no");
    tree1.add ("maybe");
    tree1.add ("always");
    tree1.add ("no"); // not added: duplicate element
    if (tree1.remove ("often"))
      System.out.println ("How did that happen?");
    else
      System.out.println (tree1.remove ("maybe"));
    System.out.println (tree1);
    
    BinarySearchTree<String> tree2 = new BinarySearchTree<String> (tree1);
    System.out.println (tree2);
    
    BinarySearchTree<Student> tree3 = new BinarySearchTree<Student>();
    tree3.add (new Student ("Jones", 3.17));
    tree3.add (new Student ("Smith", 3.82));
    tree3.add (new Student ("Jones", 3.4));                 
    if (tree3.contains (new Student ("Jones", 10.0 - 6.6)))
     System.out.println ("The number of elements in tree3 is " + tree3.size());
    System.out.println (tree3);
  } // method run
  
} // class BinarySearchTreeExample

class Student implements Comparable<Student>
{
  String name;
  double gpa;
  
  public Student() { }
  
  /**
   * Initializes this Student object from a specified name and gpa.
   *
   * @param name – the specified name.
   * @param gpa – the specified gpa.
   *
   */
  public Student (String name, double gpa)
  {
    this.name = name;
    this.gpa = gpa;
  } // constructor
  
  /**
   * Compares this Student object with a specified Student object.
   * The comparison is alphabetical; for two objects with the same name,
   * the comparison is by grade point averages.
   *
   * @param otherStudent – the specified Student object that this Student
   * object is being compared to.
   *
   * @return -1, if this Student object’s name is alphabetically less than
   *             otherStudent’s name, or if the names are equal and this
   *             Student object’s grade point average is at least DELTA 
   *             greater than otherStudent's grade point average;
   *          0, if this Student object’s name is the same as
   *             otherStudent’s name and the grade point
   *             averages are within DELTA;
   *          1, if this Student object’s name is alphabetically greater
   *             than otherStudent’s name, or if the names are equal and
   *             otherStudent's grade point average is at least DELTA
   *             greater than this Student object’s grade point average.
   *
   */
  public int compareTo (Student otherStudent)
  {
    final double DELTA = 0.0000001;
    
    if (name.compareTo (otherStudent.name) < 0)
      return -1;
    if (name.compareTo (otherStudent.name) > 0)
      return 1;
    if (gpa - otherStudent.gpa > DELTA)
      return -1;
    if (otherStudent.gpa - gpa > DELTA)
      return 1;
    return 0;
  } // method compareTo
  
  /**
   * Determines if this Student object’s name and grade point average are
   * the same as some specified object's.
   *
   * @param obj – the specified object that this Student object is being
   * compared to.
   *
   * @return true – if obj is a Student object and this Student object has the
   * same name and almost (that is, within DELTA) the same grade point average as obj.
   *
   */
  public boolean equals (Object obj)
  {
    if (! (obj instanceof Student))
      return false;   
    return this.compareTo ((Student)obj) == 0;
  } // method equals
  
  /**
   * Returns a String representation of this Student object.
   *
   * @return a String representation of this Student object: name, blank,
   *         grade point average.
   *
   */
  public String toString()
  {
    return name + " " + gpa;
  } // method toString
  
} // class Student