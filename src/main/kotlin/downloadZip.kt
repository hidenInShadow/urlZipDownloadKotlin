import java.io.BufferedInputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.net.URL

fun downloadZip(listOfUrl: ArrayList<String>) {
        for (element in listOfUrl) {
            val pathname =
                "./" + element.substring(element.lastIndexOf("/")) // I know, this solution with path is sordid, but i can't find better solution
            try {
                BufferedInputStream(URL(element).openStream()).use { inputStream ->
                    FileOutputStream(pathname).use { fileOS ->
                        val data = ByteArray(1024)
                        var byteContent: Int
                        while (inputStream.read(data, 0, 1024).also { byteContent = it } != -1) {
                            fileOS.write(data, 0, byteContent)
                        }
                        val f = File(pathname)
                        if (f.exists()) {
                            println("Name: " + f.name)
                            println("Size: " + f.length() + " bytes")
                        } else {
                            println("The File does not exist")
                        }
                    }
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
