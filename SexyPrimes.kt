/*
Takes input from the user to determine a range of numbers
and finds all of the "sexy primes" in the range

Sexy primes are prime numbers that are 6 apart
 */

/*
Basic prime array calculation
 */
fun sieve(max: Int): Array<Boolean> {
    val array = Array<Boolean>(max+1) {when (it) {0, 1 -> false else -> true}}
    for (n in 2 until array.size) {
        for (m in n*2 until array.size step n) {
            array[m] = false
        }
    }
    return array
}

fun main(args: Array<String>) {
    // test code for the sieve
    // println(sieve(20).mapIndexed(){index, value -> "%d:%b".format(index, value)}.joinToString(" "))
    var min: Int
    var max: Int
    do {
        print("Please enter a positive integer: ");
        min = readLine()!!.toInt();
    } while (min < 0);
    do {
        print("Please enter an integer greater than %d: ".format(min));
        max = readLine()!!.toInt();
    } while (max <= min);
    val prime = sieve(max);
    var count = 0;
    println("Here are all of the sexy primes from %d to %d:".format(min, max))
    for (n in min..max-6) {
        if (prime[n] && prime[n+6]) {
            println("%d and %d".format(n, n+6))
            count++
        }
    }
    println("There were %d sexy primes".format(count))
}