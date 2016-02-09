import java.util.*;
import java.io.*;
/**
 * Write a description of class FileEdit here.
 * Due 11/17 by 5pm on sakai
 * @author Julie Leong 
 * @version (a version number or a date)
 */
public class Edit 
{
    ArrayList<String> content = new ArrayList<String>();
    Scanner reader = null;
    HashSet<String> dict = new HashSet<String>();
    public static void main(String[]args){
        Edit e = new Edit();
        e.getFile();
        e.createDictionary();
        HashMap<Integer, String> method = new HashMap<Integer, String>();
        method.put(1,"Find");
        method.put(2,"FindReplace");
        method.put(3,"FindInsert");
        method.put(4,"Delete");
        method.put(5,"SpellCheck");
        method.put(6,"SpellCheckAll");
        method.put(7,"Save");
        method.put(8,"Print");
        method.put(9,"Quit");
        
        Scanner sc = new Scanner (System.in);
        System.out.println("List of Methods:");
        System.out.println(method.entrySet());
            
        while(!method.isEmpty()){
        System.out.println("What method would you like to use? Please enter the corresponding number.");
        int choice = sc.nextInt();
        if(choice ==1){
            System.out.print("What word would you like to find?");  
            String a = sc.next(); 
            e.Find(a);
       }
      
       if(choice ==2){
            System.out.println("What word do you want to change?");
            String b = sc.next();
            System.out.println("What should be the new word?");
            String c = sc.next();
            e.FindReplace(b,c);
       }
       
       if(choice ==3){
        System.out.println("What word would you like to insert?");
        String d = sc.next();
        System.out.println("After what word would you insert it?");
            String g = sc.next();
            e.FindInsert(g,d);
       }
       
       if(choice ==4){
            System.out.println("What word would you like to delete?");
            String f = sc.next();
            e.Delete(f);
       }
       
       if(choice ==5){
            System.out.println(e.spellCheck());
       }
       
       if(choice ==6){
            e.spellCheckAll();
       }
       
       if(choice ==7){
            e.save();
       }
       
       if(choice ==8){
            e.print();
       }
       
       if(choice ==9){
           System.out.println("Please press enter to exit.");
            e.quit();
       }
    }
}

    
    public HashSet createDictionary(){
        //later usage for spell check methods, only need to do it once
         try { reader = new Scanner(new File("EnglishWordList.txt"));
           }catch ( FileNotFoundException ex){
               System.out.println(ex+"file not found");
            }
        while (reader.hasNext()){
                String str = reader.nextLine();
                dict.add(str);
            }
        return dict;
    }
    
    public ArrayList getFile(){
        // for testing, need to be able have data to work with, and put in array list structure
         try { reader = new Scanner(new File("2city10.txt"));
           }
            catch ( FileNotFoundException ex)
            {System.out.println(ex+"file not found");
            }
         while (reader.hasNext()){
                String str = reader.nextLine();
                ArrayList<String> temp = new ArrayList<String>(Arrays.asList(str.split("\\s+")));
                for(String e: temp){
                    content.add(e);
                }
            }
            return content;
    }
    
    public boolean Find (String x){ 
        // Looks for a word "x" in the file and returns true if found or false otherwise.
        //check item in list if it contains string
        if(content.contains(x)){
            return true;
        }else{
            return false;
        }
      
    }
    
    public boolean FindReplace (String x, String y){
        // looks for the first occurrence of word "x" in the file and replaces it with word "y" if found returning true, false otherwise
        // have to find if string x exists before can replace, if cannot find,return false, other wise replace
        if(content.contains(x)){
            int i = content.indexOf(x);
            content.remove(i);
            content.add(i,y);
            return true;
        }else{
            return false;
        }
       
    }
    
    public boolean FindInsert (String x, String y){
        // looks for the first occurrence of word "x" in the file and then insert "y" right after "x", if x is found, returning true, false otherwise.  
       // find string, if true, then add string afterwards, otherwise false
        if(content.contains(x)){
            int i = content.indexOf(x);
            content.add(i+1,y);
            return true;
        }else{
            return false;
        }
    }
    
    public boolean Delete (String x){
        // looks for the first occurrence of word "x" in the file and deletes it from the file, returning true if x is found, returning false otherwise.
        // have to find string first before delete, then remove it
        if(content.contains(x)){
            int i = content.indexOf(x);
            content.remove(x);
            return true;
        }else{
            return false;
        }
    }
    
    public String spellCheck (){
        // finds the first occurrence of spelling error and returns the misspelled word. If no word is misspelled returns "Spell Check Passed".
        //compare contents of file to dictionary, use listiterator to go through list, check if file contents match any of the word, return only the one time it doesn't
        ListIterator<String> i = content.listIterator();
        while(i.hasNext()){
            String s = i.next().trim().replaceAll("[\\[\\]_:\"'`?;0-9;()-/.,*! ]", "").toLowerCase();
            if(dict.contains(s)){
                i.next();
            }else{
                return s;
            }
        }
        return "Spell Check Passed.";
    }
    
    public void spellCheckAll(){
        // find all misspelled words and output them to the screen.  
        // same as before, but go through all contents and place all mispelled words in a data structure and print them by loop
        ArrayList<String> badWords = new ArrayList<String>();
        ListIterator<String> i = content.listIterator();
        while(i.hasNext()){
            String s = i.next().trim().replaceAll("[\\[\\]_:\"'`?;0-9;()-/.,*! ]", "").toLowerCase();
            if(dict.contains(s)){
                i.next();
            }else{
                badWords.add(s);
                i.next();
            }
        }
        
        if(badWords.size()!=0){
            System.out.println("Here is a list of all mispelled words:");
            for(int j = 0; badWords.size() <= j; j++){
            System.out.println(badWords.get(j));
            }
        }else{
            System.out.println("No spelling errors.");
        }
        
    }
    
    public void save(){
        // saves file with the changes made.
        // create new file and write the list of content to there
        try {
          File file = new File("example.txt");
          BufferedWriter output = new BufferedWriter(new FileWriter(file));
          ListIterator<String> c = content.listIterator();
          StringBuilder result = new StringBuilder();
          String sep = "";
          for(String s: content) {
              result.append(sep).append(s);
              sep = " ";
          }
          output.write(result.toString());
          output.close();
        
        }catch ( IOException e ) {
           e.printStackTrace();
        }
 
    }
    
    public void print(){
        // saves file with the changes and outputs the contents of the file to the screen.
        // loop and print each line, just call save()
        save();
        try { reader = new Scanner(new File("example.txt"));
            
        }catch ( FileNotFoundException ex)
            {System.out.println(ex+"file not found");
            }
        while (reader.hasNext()){
                String str = reader.nextLine();
                System.out.println(str);
            }
    }
    
    public void quit(){
        //should save() the file and exit.
        save();
        System.exit(0);
    }

}

