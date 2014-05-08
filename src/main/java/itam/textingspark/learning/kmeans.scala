package itam.textingspark.learning

import org.apache.spark.mllib.clustering.KMeans
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import scala.Array.canBuildFrom

	

class kmeans(k: Int, sourceFile:String) {

	//spark environment
	val sc = new SparkContext("local","kmeans_spark","/usr/local/Cellar/spark-0.9.1/")
	// master, appName, sparkHome, jars required

	//parse data
	val data = sc.textFile(sourceFile)
	val parsedData = data.map(_.split(',').map(_.toDouble))

	//cluster using Kmeans
	val maxIter = 25

	//def k() = numClusts
	val clusters = KMeans.train(parsedData, k, maxIter)


	//def printResults(){
	println("Predict:")
	parsedData.foreach{ i => 
    	printf("%d ", clusters.predict(i))
    	println()
    }
   

}