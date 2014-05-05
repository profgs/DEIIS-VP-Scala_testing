package itam.textingspark.learning
import java.util.{Date, Locale}
import java.text.DateFormat._

object learningScala {

	def timePrint {
		val now = new Date
				val df = getDateInstance(LONG, Locale.ENGLISH)
				println("------ This is from a Scala Object!! -----")
				println(df format now)
				println("------------------------------")
				//same as:
				//println(df.format(now))
	}

}