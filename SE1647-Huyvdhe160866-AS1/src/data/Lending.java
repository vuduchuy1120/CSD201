/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author DELL
 */
public class Lending {
    public String bcode;
    public String rcode;
    public int state;

    public Lending() {
    }

    public Lending(String bcode, String rcode, int state) {
        this.bcode = bcode;
        this.rcode = rcode;
        this.state = state;
    }

    @Override
    public String toString() {
        return String.format(
                  "%-10s| %-9s| %8d|",
                 bcode, rcode , state
        );
    }
    
    
}
