package W13_FinalExam;

public class W13T3_ExamWriteBinary {
    public static void main(String[] args) {
        int number = 44; // Number 44 is the input that will convert to the binary number.
        System.out.printf("\nThe result of writeBinary(%d) is ",number); // This line just print the question
        writeBinary(number); // This is the method that will convert the number to binary recursively, and it will also print the binary number.
    }

    public static void writeBinary(int n) { //define the method that will convert a number to binary recursively
        if(n < 2) { // use if statement to control the recursive loop, otherwise it will just loop forever and cause stack overflow to the RAM.
                    // this is not just to control the loop, but it will also print the result.
                    // when the conversion process is done, the binary result must be less than 2 which are 1 and 0 only.
                    // so this stop condition will help to print the result as well.
            System.out.print(n); // just normal print statement when if condition is execute

        } else { // normally, when this method is executed for the first time, the input that is greater than or equal to 2 will go into this else condition.
            writeBinary(n / 2);  // [1st loop] in this case, the input number is 44. I will start to divide by 2 which will give the result of 22.
                                    // [2nd loop] That 22 will be pass into the method and run again which will give a result of 11.
                                    // [3rd loop] The same, that result of 11 will be pass into the method and divide by 2 which will give a result of 5 (because we used INT not FLOAT)
                                    // [4th loop] The same, the result of 5 will pass into this method which its value is 2 after division (because we used INT not FLOAT)
                                    // [5th loop] The same, the result of 2 will pass into this method which its value is 1 after division (because we used INT not FLOAT)
                                    // *******Now this is the change*******
                                    // note that everytime this method is called, it will also check for the if(n < 2), if true it will print n
                                    // however, that is not true yet until [5th loop], that number 1 is passed into the method
                                    // because 1 is less than 2, then it will print the number 1 out
            // the first recursive is done, but when the program go back to the if(n < 2) condition. 2 is not less than 2 in [4th loop]
            // so the program will skip the first recursive because it is done and still left another recursive method to do below here.
            // all the tasks are store in stack also known as Last In First Out.
            // So, basically, it will continue to do the calculation from [4th loop] reverse to [1st loop]
            writeBinary(n % 2);
                                    // [5th loop] This one is done already as stated above, so it will not go in here (its final value is 1)
                                    // [4th loop] the result from previous loop is 2, so 2 % 2 = 0. It will pass the value into the method again.
                                    // This time the result is only 1 and 0 which will always go into the if condition to print the result
                                    // [3rd loop] the result from previous loop is 5, so 2 % 2 = 1. It will pass the value into the method again.
                                    // [2nd loop] the result from previous loop is 11, so 2 % 2 = 1. It will pass the value into the method again.
                                    // [1st loop] the result from previous loop is 22, so 2 % 2 = 0. It will pass the value into the method again.
                                    // however, that is not done yet, there is one more thing left
                                    // This is not from the first recursive anymore, but it is from the input value
                                    // 44 % 2 = 0 . So it will pass that value into the method which will print it out
                                    // the reason that 44 is still here, but not 22 instead, is because this is recursive
                                    // everything will store in stack memory. So 44 is the first thing that does in to the stack
                                    // That's why it got out from the stack the last.
                                    // Now it is DONE!!! Congratulation!!

        }
    }
}
