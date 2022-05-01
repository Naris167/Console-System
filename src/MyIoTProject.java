public class MyIoTProject {
    public static void main(String[] args){
        //LCD.clearScreen();
        LCD.showMainMenu();
        LCD.showLoginMenu();
        LCD.showSystemMenu();
        LCD.confirmRestart();
        LCD.confirmShutdown();
        LCD.showRestart();
        LCD.showShutdown();
    }
}