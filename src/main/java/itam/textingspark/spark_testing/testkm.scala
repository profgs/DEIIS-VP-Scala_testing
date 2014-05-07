package itam.textingspark.spark_testing

import org.apache.spark.mllib.clustering.KMeans
import org.apache.spark.SparkContext
import SparkContext._
import org.apache.spark.rdd.RDD
import org.apache.spark.mllib.clustering.KMeansModel
import java.io._



class testkm {

	def getVW(k: Int, sourceFile:String){

		//spark environment
		val sc = new SparkContext("local","kmeans_spark","/usr/local/Cellar/spark-0.9.1/")
		// master, appName, sparkHome, jars required

		//parse data
		val data = sc.textFile(sourceFile)
		val parsedData = data.map(_.split(',').map(_.toDouble))

		val maxIter = 50

		//save VW
		val kmModel:KMeansModel = KMeans.train(parsedData, k, maxIter)
		val predData = parsedData.map(x=>kmModel.predict(x))
		predData.saveAsTextFile("data/vw")

		var bw = new BufferedWriter(new FileWriter("data/out.txt"))

		println("Total clusters: " + kmModel.clusterCenters.length)
		var id = 0
		kmModel.clusterCenters.foreach{ c =>
		printf("%d : ", id)
		//val idInc = id + 1
		id=id+1
		for( j <- 0 until c.length) {
			printf("%.2f ", c(j))
			bw.write(c(j).toInt.toString)
			bw.write(" ")
		}
		bw.write("\n")
		println();
		}
		bw.close()

		val kmOut: FileOutputStream = new FileOutputStream("data/kmeans_model.obj")
		val kmObjOut: ObjectOutputStream = new ObjectOutputStream(kmOut)
		kmObjOut.writeObject(kmModel)
		kmObjOut.close()

		/*
		val kmIn: FileInputStream = new FileInputStream("data/kmeans_model.obj")
		val kmObjIn: ObjectInputStream = new ObjectInputStream(kmIn)
		kmObjIn.readObject()
		*/
		
		val kmObject = sc.objectFile("data/kmeans_model.obj")
		
		val data2 = sc.textFile("data/testeg.sift")
		val parsedData2 = data2.map(_.split(',').map(_.toDouble))
		

		//val kmModel2:KMeansModel = kmObject.asInstanceOf[KMeansModel]

		//val kmModel2:KMeansModel = kmObjIn => [KMeansModel]
		
		//val kmModel2 = kmObject.
		
//		val predData2 = parsedData2.map(x=>kmModel2.predict(x))
//		predData2.saveAsTextFile("data/vw2")


		  
		//kmObjOut.close()
		

		sc.stop();
	}


}