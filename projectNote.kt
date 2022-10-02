// Library for linked list
import java.util.LinkedList
// This function will display the format of the list
fun display(i: Int, value: LinkedList<String>) {
    print("  ")
    print(i + 1)
    print(". ")
    println(value[i])
}
// This function will switch two different list
fun switch(num1: String, num2: String, value: LinkedList<String>): LinkedList<String> {
    // Create a new linked list String
    var newValue = LinkedList<String>();
    for (i in 0..value.size - 1){
        if(i == num1.toInt()-1){
            newValue.addLast(value[num2.toInt()-1])
        } else if (i == num2.toInt()-1) {
            newValue.addLast(value[num1.toInt()-1])
        } else {
            newValue.addLast(value[i])
        }
    }
    var value = newValue
    return value
}

fun main(args: Array<String>) {
    // The num variable will receive input and select different function
    var num:String = "0"
    // The value variable is a LinkedList data structure
    var value = LinkedList<String>();
    value.addAll(listOf("Book","Shop"))

    while (num != "5" || num == "0") {

        println("1. Display the note")
        println("2. Add new note")
        println("3. Delete note")
        println("4. Switch note")
        println("5. Quit")
        print("  Input: ")
        var num = readLine()!!

        if (num == "1") { // this will display the note
            println()
            println("Display: ")
            for (i in 0..value.size-1)
            {
                display(i,value)
            }

            println()
        } else if (num == "2") { // add note
            print("Please input the new note: ")
            val input = readLine()!!
            value.addLast(input)
            println()

        } else if (num == "3") { // delete note
            var count = 0
            println("Select the note you want do delete")
            for (i in 0..value.size - 1) {
                display(i, value)
                count = i + 2
            }
            println("  " + count + ". All") // delete all
            print("Input(name or number): ")
            val input = readLine()!!

            print(input)
            if (input.toIntOrNull() == null) { // if input is a String
                value.remove(input)
            }

            if (input.toIntOrNull() != null && input.toIntOrNull() != count) { // if input is integer and is not equal to count
//                while (input.toInt() <= 0){ // || input.toInt() > value.size
//                    print("Invalid value. Input(number between 1 to ${value.size + 1}) ")
//                    val input = readLine()!!
//                }
                value.removeAt(input.toInt() - 1)
            }
            if (input.toInt() == count) {
                value.clear()
            }
            println()
        } else if (num == "4") {
            for (i in 0..value.size-1)
            {
                display(i,value)
            }
            println("Choose two number you want to switch")
            print("First number: ")
            var num1 = readLine()!!
            while (num1.toIntOrNull() == null){ // If input is a String
                println("Number is not valid, Enter the first number: ")
                var num1 = readLine()!!
            }
            print("Second number: ")
            var num2 = readLine()!!
            while (num2.toIntOrNull() == null){ // If input is a String
                println("Number is not valid, Enter the second number: ")
                num2 = readLine()!!
            }
            value = switch(num1,num2,value)

        } else if (num == "5") {
            break
        }
    }
}