//array of the ranking
class TeamRanking {
	
	private String name;
	private String confeder;
	private int rank;
	
	TeamRanking(){
		
	}
	
	TeamRanking(int rank, String name, String conf) {
		this.rank=rank;
		this.name=name;
		this.confeder=conf;
	}

    public String getRName() {
        return name;
    }
	
	public int getRRank() {
        return rank;
    }
	
	public String getRConfederation() {
        return confeder;
    }

	public void setRRank(int crank) {
		rank = crank;
	}
	
	public void setRName(String cname) {
        name = cname;
    }
	
	public void setRConfederation(String cconf) {
		confeder = cconf;
	}
	
	public static void Ranking(TeamRanking[] rank) {
	//	TeamRanking rank[] = new TeamRanking[1];
		
		rank[0] = new TeamRanking(1, "Belgium", "UEFA");
		rank[1] = new TeamRanking(2, "France", "UEFA");
		rank[2] = new TeamRanking(3, "Brazil", "CONMEBOL");
		rank[3] = new TeamRanking(4, "England", "UEFA");
		rank[4] = new TeamRanking(5, "Uruguay", "CONMEBAL");
		rank[5] = new TeamRanking(6, "Croatia", "UEFA");
		rank[6] = new TeamRanking(7, "Portugal", "UEFA");
		rank[7] = new TeamRanking(8, "Spain", "UEFA");
		rank[8] = new TeamRanking(9, "Argentina", "CONMEBAL");
		rank[9] = new TeamRanking(10, "Colombia", "CONMEBAL");
	}

	@Override
	public String toString() {
		return "TeamRanking [name=" + name + ", confeder=" + confeder + ", rank=" + rank + "]";
	}
	
}
