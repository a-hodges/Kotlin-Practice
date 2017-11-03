/*
Prompts the user for a number n then outputs
the nth item of the fibonacci sequence
 */

fun fib(n: Int): Int {
    // Negative case handled poorly, but it's fine for practice
    if (n <= 0) {
        return n;
    }
    else {
        var a = 0;
        var b = 1;
        for (x in 1..n) {
            val temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
}

fun main(args: Array<String>) {
    var n: Int;
    do {
        print("Please enter a positive integer: ");
        n = readLine()!!.toInt();
    } while (n < 0);
    println("The fibonacci number %d is %d".format(n, fib(n)));
}