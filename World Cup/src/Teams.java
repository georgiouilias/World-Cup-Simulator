//array of the teams
public class Teams {
	
	private String name;
	
	Teams(){
		name=null;
	}
	
	public Teams(String tname) {
		name = tname;
	}
	
    public String getTeam() {
        return name;
    }
	
	public void setTeam(String tname) {
        name = tname;
    }
	
	public static boolean isEmpty(Teams[] t) {
		boolean empty = true;
		for (Object ob : t) {
			if (ob != null) {
				empty = false;
				break;	
			}
		}
		return empty;
	}

	public String toString() {
		String s=name;
		return s;
	}
}