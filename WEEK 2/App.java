import java.util.Scanner;

public class App 
{
    public static void main(String[] args)
    {
      //  Gradingsystem gs = new Gradingsystem();
       // gs.classifyMark();


       
      // LeapYear obj = new LeapYear();
  //boolean result = obj.IsLeapYear();
            //System.out.println(result);//


         //   MenuCalculator obj = new MenuCalculator();

        //double result = obj.Menu();

        //System.out.println("Final Result = " + result); 

       // PrimeNumber obj = new PrimeNumber();

        //boolean result = obj.isPrime();

        //System.out.println(result);

    //   GreatestCommonDivisor obj = new GreatestCommonDivisor();

      // int first = obj.getFirstNumber();

        //int second = obj.getSecondNumber();

       // int result = obj.gcd(first, second);

       // System.out.println("GCD = " + result);

   //    NumberReversal obj = new NumberReversal();
//
  //      int number = obj.getNumber();

    //    int result = obj.reverseNumber(number);

      //  System.out.println("Reversed number = " + result);

// LoopPatterns obj = new LoopPatterns();

  //      obj.run();

  // MarksProcessor obj = new MarksProcessor();

    //    obj.processMarks();

    Scanner input = new Scanner(System.in);

        int number = NumberAnalyzer.readNumber(input);

        boolean even = NumberAnalyzer.isEven(number);

        boolean positive = NumberAnalyzer.isPositive(number);

        int absolute = NumberAnalyzer.absoluteValue(number);

        int digitCount = NumberAnalyzer.countDigits(absolute);

        int digitSum = NumberAnalyzer.sumDigits(absolute);

        NumberAnalyzer.printReport(
                number,
                even,
                positive,
                digitCount,
                digitSum
        );

        input.close();
    
    }
}      
    