package login;

public class Data {
    public static boolean isPairCorrect(String login, String password, String confirmPassword) {
        try {
            return (isLoginCorrect(login) && isPasswordCorrect(password, confirmPassword));
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    static boolean isLoginCorrect(String login) throws WrongLoginException {
        if (login.matches("[A-Za-z0-9_]{1,20}")) {
            return true;
        } else {
            throw new WrongLoginException("Неверный логин!");
        }
    }

    static boolean isPasswordCorrect(String password, String confirmPassword) throws WrongPasswordException {
        if (password.matches("[A-Za-z0-9_]{1,20}") && password.equals(confirmPassword)) {
            return true;
        } else {
            throw new WrongPasswordException("Неверный пароль!");
        }

    }
}