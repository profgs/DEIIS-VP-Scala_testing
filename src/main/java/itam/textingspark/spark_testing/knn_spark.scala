package itam.textingspark.spark_testing

import org.apache.spark.mllib.clustering.KMeans
import org.apache.spark.SparkContext
import SparkContext._


object knn_spark {
  def main(args: Array[String]) {
    //helloWorld en Scala
    //print("ya please!!")
    
    //spark environment
    val sc = new SparkContext("local","knn_spark","/usr/local/Cellar/spark-0.9.1/")
    
    //parse data
    val data = sc.textFile("data/example.sift")
    val parsedData = data.map(_.split(',').map(_.toDouble))
    
    //cluster using Kmeans
    val maxIter = 20
    val k = 2
    val clusters = KMeans.train(parsedData, k, maxIter)
    /*for (x<-k){
      clusters.clusterCenters
    }*/
    
    //Evaluate clustering by computing within Set Sum of Squared Errors
    val WSSSE = clusters.computeCost(parsedData)
    println("WSSE = " + WSSSE)
  }

}