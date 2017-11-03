/*
Prompts the user for a number, then outputs the number
followed by NOT PERFECT if the number isn't a perfect number
or a list of factors in descending order if it is perfect

A perfect number is a number equal to the sum of all of its factors
 */

fun factors(n: Int): List<Int> = (1 until n).filter {n % it == 0}

fun testPerfect(n: Int): Boolean = factors(n).sum() == n

fun main(args: Array<String>) {
    var n: Int;
    do {
        print("Please enter a positive integer: ");
        n = readLine()!!.toInt();
    } while (n < 0);
    if (testPerfect(n)) {
        println("%d:%s".format(n, factors(n).reversed().joinToString(" ")))
    }
    else {
        println("%d:%s".format(n, "NOT PERFECT"));
    }
}