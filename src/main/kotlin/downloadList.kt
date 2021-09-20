import java.io.IOException
import java.net.URL
import java.util.*
import kotlin.collections.ArrayList

fun downloadList(listOfUrl: ArrayList<String>) {
    try {
        val myObj = URL("http://aloteq-test-tasks.s3-website.eu-central-1.amazonaws.com/list.txt")
        val myReader = Scanner(myObj.openStream())
        while (myReader.hasNextLine()) {
            val data = myReader.nextLine()
            listOfUrl.add(data)
            println(data)
        }
        myReader.close()
        downloadZip(listOfUrl)
    } catch (e: IOException) {
        println("An error occurred")
        e.printStackTrace()
    }
}