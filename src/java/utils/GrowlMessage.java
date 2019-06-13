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
    public enum MessageOption { 
        SAVE("salvo(a)", "salvar"), EDIT("editado(a)", "editar"), REMOVE("removido(a)", "remover");
        
        public String message;
        public String verb;
        
        MessageOption(String message, String verb) {
            this.message = message;
            this.verb = verb;
        }
    
    }
   
    public static void showMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesMessage msg = new FacesMessage(severity, summary, detail);
            FacesContext.getCurrentInstance().
                    addMessage(null, msg);
        
    }
    
    public static void statusMessage(Class classe, MessageOption option, boolean status) {
        if(status)
            showMessage(FacesMessage.SEVERITY_INFO, classe.getSimpleName() + " " + option.message, null);
        else
            showMessage(FacesMessage.SEVERITY_ERROR, "Nao foi possivel " + option.verb + " " + classe.getSimpleName(), null);
    }
    
}
