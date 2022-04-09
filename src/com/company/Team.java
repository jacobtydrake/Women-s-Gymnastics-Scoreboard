package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This class will contain all gymnasts for each team (college).
 * Note: The Apparatus list has the players already arranged by order.
 */

public class Team implements Serializable, Comparable {
    private String teamName;
    private String teamLogo;                        //Contain like the path for the logo
    private List<Player> vaultGymnasts;
    private List<Player> barGymnasts;
    private List<Player> beamGymnasts;
    private List<Player> floorGymnasts;
    private List<Player> allGymnasts;
    private TeamScore teamScore;

    //Constructor
    public Team(String teamName, String teamLogo) {
        this.teamName = teamName;
        this.teamLogo = teamLogo;
        this.allGymnasts = new ArrayList<>();
        this.vaultGymnasts = new ArrayList<>();
        this.barGymnasts = new ArrayList<>();
        this.beamGymnasts = new ArrayList<>();
        this.floorGymnasts = new ArrayList<>();
        this.teamScore = new TeamScore();
    }

    //getters
    public String getTeamName(){return teamName;}
    public String getTeamLogo(){return teamLogo;}
    public List<Player> getVaultGymnasts() {return vaultGymnasts;}
    public List<Player> getBarGymnasts() {return barGymnasts;}
    public List<Player> getBeamGymnasts() {return beamGymnasts;}
    public List<Player> getFloorGymnasts() {return floorGymnasts;}
    public List<Player> getAllGymnasts() {return allGymnasts;}
    public TeamScore getTeamScore() {return teamScore;}

    //setters
    public void setTeamName(String teamName) {this.teamName = teamName;}
    public void setTeamLogo(String teamLogo) {this.teamLogo = teamLogo;}
    public void setTeamScore(TeamScore teamScore) {this.teamScore = teamScore;}

    //methods
    //Method that will add players to allGymnasts. This will automatically add gymnast to the participating apparatus their in. Arrange the list by order
    public void addGymnasts(Player p){
        allGymnasts.add(p);
       updateApparatusLists();
    }
    //Method that will delete player to allGymnasts. This will automatically remove to the apparatus list.
    public void deleteGymnasts(Player p){
       for(int i = 0; i < this.allGymnasts.size(); i++){
           if(allGymnasts.get(i).equals(p)){
               allGymnasts.remove(i);
           }
       }
        updateApparatusLists();
    }
    //Method that updates all apparatus' list
    public void updateApparatusLists(){
        populateVaultGymnasts();
        arrangeByOrderList(vaultGymnasts, ApparatusIndex.VT);
        populateBarGymnasts();
        arrangeByOrderList(barGymnasts, ApparatusIndex.UB);
        populateBeamGymnasts();
        arrangeByOrderList(beamGymnasts, ApparatusIndex.BB);
        populateFloorGymnasts();
        arrangeByOrderList(floorGymnasts, ApparatusIndex.FX);
    }
    //Method that will get all Vault Gymnasts and sets it to vaultGymnast list
    public void populateVaultGymnasts() {
        List<Player> temp = new ArrayList<>();
        this.allGymnasts.stream().forEach(
                gymnast ->{
                    if(gymnast.getApparatusStatus(ApparatusIndex.VT)){
                        temp.add(gymnast);
                    }
                }
        );
        this.vaultGymnasts = temp;
    }
    //Method that will get all Bars Gymnasts and sets it to barGymnast list
    public void populateBarGymnasts() {
        List<Player> temp = new ArrayList<>();
        this.allGymnasts.stream().forEach(
                gymnast ->{
                    if(gymnast.getApparatusStatus(ApparatusIndex.UB)){
                        temp.add(gymnast);
                    }
                }
        );
        this.barGymnasts = temp;
    }
    //Method that will get all Beam Gymnasts and sets it to beamGymnast list
    public void populateBeamGymnasts() {
        List<Player> temp = new ArrayList<>();
        this.allGymnasts.stream().forEach(
                gymnast ->{
                    if(gymnast.getApparatusStatus(ApparatusIndex.BB)){
                        temp.add(gymnast);
                    }
                }
        );
        this.beamGymnasts = temp;
    }
    //Method that will get all Floor Gymnasts and sets it to floorGymnast list
    public void populateFloorGymnasts() {
        List<Player> temp = new ArrayList<>();
        this.allGymnasts.stream().forEach(
                gymnast ->{
                    if(gymnast.getApparatusStatus(ApparatusIndex.FX)){
                        temp.add(gymnast);
                    }
                }
        );
        this.floorGymnasts = temp;
    }
    //Method that will arrange the passed in (vaults, bars, beams, floor) list to arrange by order
    public void arrangeByOrderList(List<Player> list, int appIdx){
        Collections.sort(list, new Comparator<Player>() {
            public int compare(Player p1, Player p2) {
                if (p1.getApparatusOrder()[appIdx] > p2.getApparatusOrder()[appIdx])
                    return 1;
                if (p1.getApparatusOrder()[appIdx] < p2.getApparatusOrder()[appIdx])
                    return -1;
                return 0;
            }
        });

    }

    //method for post meet mode sorting
    /*
    public void sortByOverallScore(List<Team> list)
    {
        Collections.sort(list, new Comparator<Team>() {
            public int compare(Team team1, Team team2){
                if (team1.teamScore.getRunningScore() > team2.teamScore.getRunningScore())
                {
                    return 1;
                }
                if (team1.teamScore.getRunningScore() < team2.teamScore.getRunningScore())
                {
                    return -1;
                }
                return 0;
            }
        });
    }
    */
    //Method that insert a player to an order
    //I'M CURRENTLY WORKING ON THIS (4.4.2022)
    public void rearrangePlayerList(Player p, int order, int appIdx){
//       List<Player> temp = new ArrayList<>();
//       List<Player> list = new ArrayList<>();
//       int indexWant = list.size();
//       switch(appIdx){
//           case 0: list = this.vaultGymnasts;break;
//           case 1: list = this.barGymnasts;break;
//           case 2: list = this.beamGymnasts;break;
//           case 3: list = this.floorGymnasts;break;
//       }
//       list.remove(p);
//       for(int i = 0; i < list.size(); i++){
//           if(list.get(i).getApparatusOrder()[appIdx] == order){
//               indexWant = i;
//           }
//       }
//       list.subList(0,indexWant-1);
//       list.add(p);
//       list.add(list.subList(indexWant, list.szi))
//
//
//        switch(appIdx){
//            case 0: this.vaultGymnasts = temp;break;
//            case 1: this.barGymnasts = temp;break;
//            case 2: this.beamGymnasts =  temp;break;
//            case 3: this.floorGymnasts = temp;break;
//        }
    }
    //Prints all info. For testing only.
    public void printAll(){
        System.out.println("-----------------------ALL INFO IN TEAM --------------------------");
        System.out.println("VAULT PLAYERS:");
        this.vaultGymnasts.stream().forEach(
                gymnast ->{
                    gymnast.printAll();
                }
        );
        System.out.println("BAR PLAYERS:");
        this.barGymnasts.stream().forEach(
                gymnast ->{
                    gymnast.printAll();
                }
        );
        System.out.println("BEAM PLAYERS:");
        this.beamGymnasts.stream().forEach(
                gymnast ->{
                    gymnast.printAll();
                }
        );
        System.out.println("FLOOR PLAYERS:");
        this.floorGymnasts.stream().forEach(
                gymnast ->{
                    gymnast.printAll();
                }
        );
        System.out.println("-----------------------END--------------------------");

    }

    //@Override
    public int compareTo(Team o) {
        if (this.teamScore.getRunningScore() > o.teamScore.getRunningScore())
        {
            return 1;
        }
        if (this.teamScore.getRunningScore() < o.teamScore.getRunningScore())
        {
            return -1;
        }
        return 0;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}