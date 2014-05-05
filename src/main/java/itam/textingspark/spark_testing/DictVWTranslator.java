package itam.textingspark.spark_testing;

/**
 * 
 * calling a class:
 * new kmeans(50,"data/example.sift");
 * object:
 * kmeans_spark$.MODULE$.callAll(50,"data/example.sift");
 *
 */


public class DictVWTranslator {
	public static void main( String[] args )
    {
		int k = 50;
		String sourceFile = "data/example.sift";
		
		new testkm().getVW(k, sourceFile);
    }

}