package itam.textingspark.spark_testing

import org.apache.spark.mllib.clustering.KMeans
import org.apache.spark.SparkContext
import SparkContext._
import org.apache.spark.rdd.RDD
import org.apache.spark.mllib.clustering.KMeansModel
import java.io._


class visualWordsTranslator {
  
  	//spark environment
	val sc = new SparkContext("local","kmeans_spark","/usr/local/Cellar/spark-0.9.1/")

	def getVW(sourceFile:String, objectFile:String){

		//parse data
		val data = sc.textFile(sourceFile)
		val parsedData = data.map(_.split(',').map(_.toDouble))

		//retrieve kmeans model
		val kmIn: FileInputStream = new FileInputStream(objectFile)
		val kmObjIn: ObjectInputStream = new ObjectInputStream(kmIn)	
		val kmModel2:KMeansModel = kmObjIn.readObject().asInstanceOf[KMeansModel]

		//make predictions - internally uses knn
		val predData = parsedData.map(x=>kmModel2.predict(x))
		
		//save predictions
		predData.saveAsTextFile("data/vw2")
		  
		//finish
		kmObjIn.close()
		sc.stop();
	}


}