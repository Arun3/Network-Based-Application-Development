/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelClasses;

import java.io.Serializable;

public class User implements Serializable {

    private String email;
    private String Name;
    private int Coins;
    private int Participants;
    private int Participation;
    private String Password;

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
  

    public User() {
      
    }

      public void setEmail(String email) {
        this.email = email;
        
    }
    public String getEmail() {
        return email;
    }

  public void setName(String Name) {
        this.Name = Name;
    }

    public String getName() {
        return Name;
    }

     public void setCoins(int Coins) {
        this.Coins = Coins;
    }

    public int getCoins() {
        return Coins;
    }

   public void setParticipants(int Participants) {
        this.Participants = Participants;
    }

    public int getParticipants() {
        return Participants;
    }

    public void setParticipation(int Participation) {
        this.Participation = Participation;
    }
    

    public int getParticipation() {
        return Participation;
    }

    

    
}
