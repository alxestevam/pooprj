/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author 141812
 */
public class GrowlMessage {
    public static void showMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesMessage msg = new FacesMessage(severity, summary, detail);
            FacesContext.getCurrentInstance().
                    addMessage(null, msg);
        
    }
}
