package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */



import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
	AlienDictionary ad;
	
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;
        
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    	
    	ad = new AlienDictionary();
    }
  
    
    @FXML
    void doTranslate(ActionEvent event) {
    		String alienWord = new String(); 
    		String translation = new String(); 
    	    	String parola = txtWord.getText();
    	    	String [] array = parola.split(" ");
    	    	alienWord = array[0];
    	    	if(Pattern.matches("[a-zA-Z?]+", alienWord)) {
    	    		if(array.length == 1) {
        	    		System.out.println("Parola insertita: "+alienWord);
        	    		
        	    		txtResult.setText(ad.translateWord(alienWord.toLowerCase()));
        	    	}
        	    	if(array.length == 2) {
        	    		translation = array[1];
        	    		if(Pattern.matches("[a-zA-Z]+", translation)) {
        	    			System.out.println("Parola insertita: "+alienWord+" "+translation);
        	    			ad.addWord(alienWord.toLowerCase(), translation.toLowerCase());
        	    		}
        	    		else
        	    			txtResult.setText(translation+" contiene caratteri non cmpresi in [a-zA-Z]");
        	    	}
    	    	}
    	    	else
    	    		txtResult.setText(alienWord+" parola contiene caratteri non cmpresi in [a-zA-Z?]");
    	    
    	    	
    }
    
    @FXML
    void doReset(ActionEvent event) {
    		ad.reset();
    		txtWord.setText(null);
    		txtResult.setText("Tutti gli elementi nel dizionario sono stati cancellati");
    }
    
}
