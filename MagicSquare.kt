/*
Prompts the user for a magic square and checks if it is a valid magic square
Only checked for 4x4 magic square since that was the original assignment
The crazy lambdas were not a good idea, they ruin the readability of the code
 */

import javax.naming.SizeLimitExceededException

fun getMagicNumber(size: Int): Int = ((size * size + 1) * size) / 2

fun rowCheck(square: Array<Array<Int>>): Boolean {
    val magic = getMagicNumber(square.size)
    return square.all {it.sum() == magic}
}

fun colCheck(square: Array<Array<Int>>): Boolean {
    val magic = getMagicNumber(square.size)
    return (0 until square.size).all {col -> square.sumBy {row -> row[col]} == magic}
}

fun diagCheck(square: Array<Array<Int>>): Boolean {
    val magic = getMagicNumber(square.size)
    val diag1 = (0 until square.size).sumBy {square[it][it]}
    val diag2 = (0 until square.size).sumBy {square[it][square.size-1-it]}
    return diag1 == magic && diag2 == magic
}

fun main(args: Array<String>) {
    var size: Int;
    do {
        print("Please enter the size of the square: ");
        size = readLine()!!.toInt();
    } while (size <= 0);
    // read in square
    println("Please enter the square with each row of numbers on a single line:")
    val square = Array<Array<Int>>(size) {readLine()!!.split("""\s+""".toRegex()).map {it.toInt()}.toTypedArray()}
    if (!square.all {it.size == size}) {
        // probably the wrong exception type, but it seems to be a good fit without making my own
        throw SizeLimitExceededException()
    }
    var isValid = true;
    if (!rowCheck(square)) {
        println("Rows didn't add up")
        isValid = false;
    }
    if (!colCheck(square)) {
        println("Columns didn't add up")
        isValid = false;
    }
    if (!diagCheck(square)) {
        println("Diagonals didn't add up")
        isValid = false;
    }
    if (isValid) {
        println("Square is a magic square")
    }
    else {
        println("Square is not a magic square")
    }
}