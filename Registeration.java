import java.util.regex.*;//helps us check patterns in strings(passwords and phone numbers)
public class Registeration {
    public static boolean checkUsername(String username){
     return username.contains("_") && username.length() <=5;//a valid name that include underscore(_) and be 5 characters or less
    }
    public static boolean checkPasswordcomplexity(String password){//this method check if the password is strong enough which must be at 8 characters long and contain a capital letter, a number, and a special character
     return password.matches("(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$&!=+])(?=\\s+$).{8,}");//it checks all the required rules
    }
    //assisted from chatgpt
    public static boolean checkCellPhoneNumber(String cellPhone){//register using South africa cellphone number that start with +27
        return cellPhone.matches("\\+27\\d{9}$");
    }
    // this system is trying to register the user and returns a message based on what went wrong or right
    public static String registerUser(String username, String password, String cellPhone){
        boolean isUsernameOkay = checkUsername(username);
        boolean isPasswordOkay = checkPasswordcomplexity(password);
        boolean isPhoneOkay = checkCellPhoneNumber(cellPhone);
        if(!isUsernameOkay){
            return"Username is not correctly formatted.please ensure that it contains an underscore and is no more than five characters in length.";
        }
        if (!isPasswordOkay){
            return"password is not correctly formatted. It must be at least 8 characters long and include a capital letter, a number, and a special character.";
        }
        if (!isPhoneOkay){
            return"Cell phone number is incorrectly formatted or does not contain the international code. please correct it and try again.";
        }
        // if all was succcessful and passed
        return "user has been registered successfully!";
    }
    //method checks if the login details match what the user originally registered
    public static boolean loginUser(String inputUsername, String inputPassword, String storedUsername, String storedPassword){
        return inputUsername.equals(storedUsername) && inputPassword.equals(storedPassword);
    }
    //the system gives back the feedback to the user based on whether they logged in successfully or not//reffered from capilot
    public static String returnLoginstatus(boolean loggedIn, String lastName){
        if (loggedIn){
            return"Welcome" + firstName + "" + lastName +",it is great to see you again";
        }else{ 
            return"Username or password incorrect. Please try again.";//when the log in was not succesful
        }
    }
    public static void main(String[]args){//this is the main method where everything start
        String username = "Gum_3";
        String password = "Ch&&8sec@ke9!";//assistance from chatgpt
        String cellPhone = "+27670443229";
        String fisrtname = "Tshimangadzo";
        String lastName = "Gumbu";
    String registerationMessage = registerUser(username, password,cellPhone);//Sep 1 register the user
    System.out.println(registerationMessage);
    boolean loginSuccess = loginUser("Gum_3", "Ch&&8sec@ke9!", username, password);
    String loginMessage = returnLoginStatus(loginSuccess, firstName, lastName);
System.out.println(loginMessage);
    }
}