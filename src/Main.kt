

val categories = arrayOf("food", "travel", "bills", "others")


interface Analyzer {
    fun summarize(expenses: List<Expense>)
}


open class Expense(
    val id: Int,
    var title: String,
    var amount: Double,
    var date: String,
    var category: String
) {
    open fun display() {
        println("$id$title$amount$date$category")
    }
}
class RecurringExpense(id: Int, title: String, amount: Double, date: String, category: String, val frequency: String)
    : Expense(id, title, amount, date, category) {
    override fun display() {
        super.display()
        println("Recurring every: $frequency")
    }
}
class SummaryAnalyzer : Analyzer {
    override fun summarize(expenses: List<Expense>) {}
    }

val expenseList = mutableListOf<Expense>()

// Main menu
fun main() {
    val analyzer = SummaryAnalyzer()
    while (true) {
        println("Personal Budget Analyzer")
        println("1. Add Expense")
        println("2. Edit Expense")
        println("3. Delete Expense")
        println("4. View All Expenses")
        println("6. Exit")
        print("Enter choice: ")

        when (readLine()?.toIntOrNull()) {
            1 -> addExpense()//1
            2 -> editExpense()//3
            3 -> deleteExpense()//4
            4 -> viewExpenses()//2
            6 -> break
            else -> println("Invalid option!")
        }
    }
}

fun addExpense() {
    try {
        print("Enter title: ")
        val title = readLine()
        print("Enter amount: ")
        val amount = readLine()

        print("Enter date ")
        val date = readLine()

        println("Select category: ${categories.joinToString()}")
        println("Expense added successfully.")
    } catch (e: Exception) {}

}

fun editExpense() {
    print("Enter ID to edit: ")
    val id = readLine()?.toIntOrNull() ?: return
    val expense = expenseList.find { it.id == id }
    if (expense != null) {
        print("New title (current: ${expense.title}): ")
        expense.title = readLine() ?: expense.title
        println("Expense updated.")
    }

}

fun deleteExpense() {
    print("Enter ID to delete: ")
    val id = readLine()?.toIntOrNull()
    val removed = expenseList.removeIf { id == id }
    if (removed) println(" deleted.")
}

fun viewExpenses() {
    if (expenseList.isEmpty()) println("No expenses found.")}

