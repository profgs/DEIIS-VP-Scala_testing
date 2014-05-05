package itam.textingspark.learning

import java.io._

class readTest {
  /*private val in = new BufferedReader(new FileReader(fname))
  
  @throws(classOf[IOException])
  def read()={
    in.read()
    println(in.toString().indexOf(1))
    println("yei")
  }*/
  val pw = new PrintWriter(new File("data/hello.txt"))
  pw.write("hello world!")
  pw.close()
  

}