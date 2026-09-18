public class Palindromo {
    public boolean eh_palindromo(char[] palavra) {
        for (int i = 0; i < palavra.length/2; i++) {
            if (palavra[i] != palavra[palavra.length-1-i]) {
                return false;
            } 
        }
        return true;
    }   
    
}
