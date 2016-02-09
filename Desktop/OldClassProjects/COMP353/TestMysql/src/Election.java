//this class only matters if we are adding more elections,
public class Election {
	int nominee_id;
	String username;
	int nominator_id;
	String nusername;
	String[][]voters;
	
	public Election(int nominee_id, String username, int nominator_id, String nusername,String[][]voters){
		this.nominee_id=nominee_id;
		this.username=username;
		this.nominator_id=nominator_id;
		this.nusername=nusername;
		this.voters=voters;
	}
	public int getNomineeId(){
		return nominee_id;
	}
	public String getNomineeUsername(){
		return username;
	}
	public int getNominatorId(){
		return nominator_id;
	}
	public String getNominatorUsername(){
		return nusername;
	}
	public String[][] getVoters(){
		return voters;
	}
}
