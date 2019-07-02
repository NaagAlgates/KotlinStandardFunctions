import java.io.File

fun main() {
    println("Relative Scoping")
    println("Apply: "+applyExample("menu-file.txt"))
    println("Let: "+ letExample(1))
    println("Run: "+runExample("Nagaraj, the great."))
}

fun nameIsLong(name:String) = name.length>=20
fun playerCreateMessage(nameTooLong:Boolean):String{
    return if(nameTooLong){
        "Name is too long"
    }else{
        "Welcome, adventurer"
    }
}

fun runExample(name:String)=
    name
        .run(::nameIsLong)
        .run (::playerCreateMessage)


fun letExample(tickets:Int?):String {
    return tickets?.let {
        "You've entered 5 buckets"
    }?:"Empty not allowed"
}

fun applyExample(path:String)= File(path).apply {
        setReadable(true)
        setWritable(true)
        setExecutable(false)
    }.readLines()
