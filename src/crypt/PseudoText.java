package crypt;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PseudoText extends Spielsprache {

	private Map <String, String> dict = new HashMap<String, String>();
	private String alphabet = "abcdefghijklmnopqrstuvwxyzäöü ";
	private String [] pseudoText = {"Deus", "Creator", "Conditor", "Opifex", "Dominus", "Dominator", "Consolator", "Arbiter","Iudex","Illuminator","Illustrator","Rector","Rex","Imperator","Gubernator","Factor","Fabricator","Conseruator","Redemptor","Auctor","Princeps", "Pastor", "Moderator", "Salvator", ""};
	
	private void setup(){
		for(int i = 0; i < alphabet.length(); i++) {
			 dict.put(String.valueOf(alphabet.charAt(i)), pseudoText[i]);
			 dict.put(pseudoText[i], String.valueOf(alphabet.charAt(i)));
		}
	}
	@Override
    public String encrypt(String text) {
		setup();
		System.out.println(dict.toString());
		text = text.toLowerCase();
        String out = "";
        for(int i = 0; i < text.length(); i++) {
        	if (alphabet.contains(String.valueOf(text.charAt(i)))){
        		out += dict.get(String.valueOf(text.charAt(i))) + " ";
        	}
        	else{
        		out += " ? ";
        	}
        }
        return out;
	}
    
    @Override
    public String decrypt(String text) {
        setup();
        String out = "";
        String word = "";
        for(int i = 0; i < text.length(); i++) {
        	if ((text.charAt(i) == ' ') || (i ==  text.length()-1)){
        		if (text.charAt(i) != ' '){
        			word += text.charAt(i);
        		}
        		if (Arrays.asList(pseudoText).contains(word)){
        			out += dict.get(word);
        		}
        		else{
        			out += " ? ";
        		}
        		word = "";
        		
        	
        	}
        	else{
        		word += text.charAt(i);
        	}
        }
        return out;
    }
}