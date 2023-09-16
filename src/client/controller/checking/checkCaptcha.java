package client.controller.checking;

public class checkCaptcha {

    public static boolean checking(String code, int n) {
        boolean isCodeValid = false;
        if(n == 1) {
            if(code.equals("5618")) {
                isCodeValid = true;
            }
        } else if(n == 2) {
            if(code.equals("3498")) {
                isCodeValid = true;
            }
        } else if(n == 3) {
            if(code.equals("4345")) {
                isCodeValid = true;
            }
        } else if(n == 4) {
            if(code.equals("8448")) {
                isCodeValid = true;
            }
        } else if(n == 5) {
            if(code.equals("1149")) {
                isCodeValid = true;
            }
        }
        return isCodeValid;
    }

}
