/*
Randomly generates the birthdays for 18975 people (the capacity of the CenturyLink Center)
Note: this ignores leap days
Prints the number of people that have birthdays on each day
Prints the days that have the highest number of birthdays
Prints the days that have the lowest number of birthdays
Note: there may be multiple days with the highest or lowest number of birthdays, all have to be printed
 */

import java.util.Random

fun main(args: Array<String>) {
    val random = Random();
    var birthdays = Array<Int>(365) {0}
    // fill array
    for (n in 1..18975) {
        val day = random.nextInt(365);
        birthdays[day]++
    }
    // print all birthdays
    for (n in 1..365) {
        println("Day %d : %d people\n".format(n, birthdays[n-1]))
    }
    // print the days that have the most birthdays
    val max = birthdays.max()
    // probably not the best way to do this
    // but it works and I wanted to try something other than a for loop
    println("Days with %d birthdays:\n%s\n".format(max,
            birthdays.mapIndexed {index, value -> if (value == max) index+1 else null}
                    .filter {it != null}.joinToString(" ")))
    // print the days that have the least birthdays
    val min = birthdays.min()
    println("Days with %d birthdays:\n%s".format(min,
            birthdays.mapIndexed {index, value -> if (value == min) index+1 else null}
                    .filter {it != null}.joinToString(" ")))
}