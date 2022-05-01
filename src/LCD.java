public class LCD {
    public static void showMainMenu() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("|                     Welcome to Stamford LCD Library Demo                     |");
        System.out.println("|                                                                              |");
        System.out.println("|                           Select a Function (1-3)                            |");
        System.out.println("|------------------------------------------------------------------------------|");
        System.out.println("|                                                                              |");
        System.out.println("| 1. Login                                                                     |");
        System.out.println("| 2. Restart                                                                   |");
        System.out.println("| 3. Shutdown                                                                  |");
        System.out.println("--------------------------------------------------------------------------------");
    }

    public static void showLoginMenu() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("|                  Login Menu. Press F1 for more information.                  |");
        System.out.println("|------------------------------------------------------------------------------|");
        System.out.println("|                                                                              |");
        System.out.println("| Enter Username:                                                              |");
        System.out.println("--------------------------------------------------------------------------------");
    }

    public static void showSystemMenu() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("|                            Select a Function (1-4).                          |");
        System.out.println("|------------------------------------------------------------------------------|");
        System.out.println("|                                                                              |");
        System.out.println("| 1. Change AC Temperature set point                                           |");
        System.out.println("| 2. Enable/Disable IP Camera                                                  |");
        System.out.println("| 3. Turn anti-theft system on/off.                                            |");
        System.out.println("| 4. Exit                                                                      |");
        System.out.println("--------------------------------------------------------------------------------");
    }

    public static void confirmRestart() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("|                           Restart Confirmation                               |");
        System.out.println("|------------------------------------------------------------------------------|");
        System.out.println("|                                                                              |");
        System.out.println("| Are you sure that you want to restart the system? (Y/N)                      |");
        System.out.println("--------------------------------------------------------------------------------");
    }

    public static void confirmShutdown() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("|                            Shutdown Confirmation                             |");
        System.out.println("|------------------------------------------------------------------------------|");
        System.out.println("|                                                                              |");
        System.out.println("| Are you sure that you want to shutdown the system? (Y/N)                     |");
        System.out.println("--------------------------------------------------------------------------------");
    }

    public static void showRestart() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("|                                Restarting ....                               |");
        System.out.println("|------------------------------------------------------------------------------|");
        System.out.println("|                                                                              |");
        System.out.println("| Please wait while the system is preparing for a restart.                     |");
        System.out.println("--------------------------------------------------------------------------------");
    }

    public static void showShutdown() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("|                              Shutting down ....                              |");
        System.out.println("|------------------------------------------------------------------------------|");
        System.out.println("|                                                                              |");
        System.out.println("| Please wait while the system is preparing for a shutdown.                    |");
        System.out.println("--------------------------------------------------------------------------------");
    }
}