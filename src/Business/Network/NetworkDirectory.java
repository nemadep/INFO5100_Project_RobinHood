/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Restaurant.Restaurant;
import java.util.ArrayList;

/**
 *
 * @author urvang
 */
public class NetworkDirectory {

    private ArrayList<Network> networkList;

    public NetworkDirectory() {
        networkList = new ArrayList<>();
    }
    
     public ArrayList<Network> getNetworkList() {
        return networkList;
    }
}
