import java.util.*;

public class NameChange
{

  /**
   *  Returns a specified full name in the form “last-name first-name middle-initial.”. 
   *
   *  @param fullName – a (non-null reference to a) String object that represents the 
   *                                   specified full name, which should be in the form 
   *                                   “first-name middle-name last-name”.
   * 
   *  @return the name in the form “last-name first-name middle-initial.” if fullName
   *                has three components.  Otherwise, return  
   *            “java.util.NoSuchElementException: the name is not of the form 
   *                "first-name middle-name last-name"".
   *
   */
  public String rearrange (String fullName)
  {
        String result;

         try
         {
             Scanner sc = new Scanner (fullName);
             
             String firstName = sc.next(),
                       middleName = sc.next(),
                       lastName = sc.next();
             
             result = lastName + ", " + firstName + " " + middleName.charAt (0) + ".";
         } // try                  
         catch (NoSuchElementException e)
         {
               result =  e.toString() + ": " + ": The name is not of the form \"first-name " +
                            "middle-name last-name\"";
         } // catch
        return result;                  
  } // method rearrange
  
} // class NameChange

