/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidochat;

import java.io.PrintWriter;

/**
 *
 * @author Antonio
 */
public class Cliente {

    private PrintWriter clientCha;
    private String userName;

    public Cliente() {

    }

    public Cliente(PrintWriter clientCha) {

        this.clientCha = clientCha;
    }

    /**
     * @return the clientCha
     */
    public PrintWriter getClientCha() {
        return clientCha;
    }

    /**
     * @param clientCha the clientCha to set
     */
    public void setClientCha(PrintWriter clientCha) {
        this.clientCha = clientCha;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Metodo de override do equals, para se conseguir comparar os objectos por
     * nome.
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Cliente other = (Cliente) obj;
        if (userName == null) {
            if (other.userName != null) {
                return false;
            }
        } else if (!userName.equals(other.userName)) {
            return false;
        }
        return true;
    }

}
