package itam.textingspark.spark_testing

import org.apache.spark.mllib.clustering.KMeans
import org.apache.spark.SparkContext
import SparkContext._


object kmeans_spark {
  def main(args: Array[String]) {
    //helloWorld en Scala
    //print("ya please!!")
    
    //spark environment
    val sc = new SparkContext("local","kmeans_spark","/usr/local/Cellar/spark-0.9.1/")
    // master, appName, sparkHome, jars required
    
    //parse data
    val data = sc.textFile("data/example.sift")
    val parsedData = data.map(_.split(',').map(_.toDouble))
    
    //cluster using Kmeans
    val maxIter = 20
    val k = 10
    val clusters = KMeans.train(parsedData, k, maxIter)
    
    //Evaluate clustering by computing within Set Sum of Squared Errors
    val WSSSE = clusters.computeCost(parsedData)
    
    /*
    println("Predict:")
    parsedData.foreach{ i => 
    	printf("%d : ", clusters.predict(i))
    	for( j <- 0 until i.length) {
    	  printf(" " + i(j))
    	}
    	println()
    }
    */
    println("Total clusters: " + clusters.clusterCenters.length)
    val id = 0
    clusters.clusterCenters.foreach{ c =>
      printf("%d : ", id)
      id = id + 1
      for( j <- 0 until c.length) {
    	  printf("%.2f ", c(j))
    	}
      println();
    }
    
    println("WSSE = " + WSSSE)
  }

}