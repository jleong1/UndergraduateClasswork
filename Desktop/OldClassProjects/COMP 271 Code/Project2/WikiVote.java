import java.util.*;
import java.io.*;
/**
 * Write a description of class WikiVote here.
 * 
 * Julie Leong
 * Due Nov. 21
 * 1. Given a user id or a screen name, write a Java program to output the total number of times 
 * the user has voted to support or be neutral or oppose the candidate considered for promotion. 
 * As an example, let us the user id was 5, your answer should be:
  User with ID 5 voted to support 123 times, voted neutral 50 times, and voted to oppose 30 times.
2. Given user id or a screen name, write a Java program to do the following:
(i) Whether the user was ever considered for promotion and if so how many votes the user got in
 support, neutral and in opposition
 (a)  total number of votes (in the support, neutral and against categories) over all his/her elections.  
or
(b) the number of votes (in the support, neutral and against categories) in any one of his/her elections.  
(ii) If not, just say that the user was never considered for promotion. 
*/
public class WikiVote
{
    LinkedList<String> wiki = new LinkedList<String>();
    HashMap<String,LinkedList<String>> canidateVoters = new HashMap<String,LinkedList<String>>();
    HashMap<Integer,Integer> vVotes = new HashMap<Integer,Integer>();
    LinkedList<String> allElect = new LinkedList<String>();
    HashMap<Integer,Integer> cVotes = new HashMap<Integer,Integer>();
    public static void main(String[]args){
        WikiVote e = new WikiVote();
        e.WikiInfo();
        
        Scanner sc = new Scanner (System.in);
        System.out.println("Please type the user id or username of the voter");
        String voter = sc.nextLine();
        
        System.out.println("Please type the user id or username of the canidate that the voter voted for");
        String canidate = sc.nextLine();
        
        e.separateElections();
        e.findVoterVotes(canidate,voter);
        
       System.out.println("User with username/id "+voter+" voted to support "+e.vVotes.get(1)+" times, voted neutral "+e.vVotes.get(0)+" times, and voted to oppose "+e.vVotes.get(-1)+" times.");
        
       System.out.println("Please enter the canidate's name in order to access their promotion history");
        String canidate1 = sc.nextLine();
        
        e.FindCanidateElections(canidate1);
        e.canidatePromotion();
         System.out.println("Over all elections"+canidate1+" earned "+e.cVotes.get(1)+" positive votes, "+e.cVotes.get(0)+" neutral votes, and "+e.cVotes.get(-1)+" negative votes.");
    }
    
    public void WikiInfo(){
        // scanning in the wiki information
        Scanner reader=null;
        try {reader = new Scanner(new File("Wiki.txt"),"UTF-8");
           }
            catch ( FileNotFoundException ex)
            {System.out.println(ex+"file not found");
            }
        ArrayList<String> sepElection = new ArrayList<String>();
        while (reader.hasNext()){
                String str = reader.nextLine();
                wiki.add(str);
        }
        
    }
    

    public HashMap separateElections(){
        //separates each election and then adds it to hashmap that can find the canidate associated with the election
        //a represents user name, b represents id number
        String a = null;
        String b = null;
        LinkedList<String> election = new LinkedList<String>();
        for(String s: wiki){
            ArrayList<String> t = new ArrayList<String>(Arrays.asList(s.split("\\s+")));
           if(t.contains("E")){
               election.add(s);
               canidateVoters.put(a, election);
               canidateVoters.put(b, election);
               election.clear();
           }else if(t.contains("U")){// create different keys for user name and id
                a = t.get(1);
                b = t.get(2);
           }else{//all other lines, ex V, T, N
                election.add(s);
           }
        }
        return canidateVoters;
    }


public HashMap findVoterVotes(String canidate, String name){
        //finds canidate and then checks to see if voter voted for said person, then a hash map can associate positive, neutral, etc votes with key and value(representing #votes
        ListIterator<String> iter = canidateVoters.get(canidate).listIterator();
        LinkedList<Integer> voteCount = new LinkedList<Integer>(); // chose to tally votes in an array list because it easier to manipulate
        int nVotes = 0;
        int pVotes = 0;
        int oVotes =0;
        //voteCount.get(0) represents -1, .get(1) represents 0, .get(2) represents 1
        while(iter.hasNext()){
            LinkedList<String> temp = new LinkedList<String>(Arrays.asList(iter.next().split("\\s+")));
            if(iter.next().contains(name)){
                if(temp.get(1).contains("-1")){
                    voteCount.add(0,oVotes++);
                }else if (temp.get(1).contains("0")){
                    voteCount.add(1,nVotes++);
                }else if(temp.get(1).contains("1")){
                    voteCount.add(2,pVotes++);
                }else{
                    iter.next();
                }
        }
        vVotes.put(-1, voteCount.get(0));
        vVotes.put(0, voteCount.get(1));
        vVotes.put(1, voteCount.get(2));
    }
    return vVotes;
    
}

    public LinkedList FindCanidateElections(String canidate){
        // method finds all elections if applicable that the canidate participated in
        if(canidateVoters.containsKey(canidate)){
            for(int i=0;i<=canidateVoters.get(canidate).size();i++){
                allElect.add(canidateVoters.get(canidate).get(i));
            }
        }else{
            System.out.println(canidate +" was never considered for promotion");
        }
        return allElect;
    }
    
    public HashMap canidatePromotion(){
        // method counts the total number of votes over all elections
        ListIterator<String> iter = allElect.listIterator();
        ArrayList<Integer> voteCount = new ArrayList<Integer>();
        int nVotes = 0;
        int pVotes = 0;
        int oVotes =0;
        //voteCount.get(0) represents -1, .get(1) represents 0, .get(2) represents 1
        while(iter.hasNext()){
            ArrayList<String> temp = new ArrayList<String>(Arrays.asList(iter.next().split("\\s+")));
                if(temp.get(1).contains("-1")){
                    voteCount.add(0,oVotes++);
                }else if (temp.get(1).contains("0")){
                    voteCount.add(1,nVotes++);
                }else if(temp.get(1).contains("1")){
                    voteCount.add(2,pVotes++);
                }else{
                    iter.next();
                }
        
        cVotes.put(-1, voteCount.get(0));
        cVotes.put(0, voteCount.get(1));
        cVotes.put(1, voteCount.get(2));
       }
       return cVotes;
    }

}
