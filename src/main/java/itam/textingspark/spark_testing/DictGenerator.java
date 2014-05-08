package itam.textingspark.spark_testing;

/**
 * 
 * calling a class:
 * new kmeans(50,"data/example.sift");
 * object:
 * kmeans_spark$.MODULE$.callAll(50,"data/example.sift");
 *
 */
/*
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;*/

public class DictGenerator{
//public class DictGenerator extends JCasAnnotator_ImplBase{
	
	//@Override
	//public void process(JCas aJCas) throws AnalysisEngineProcessException {

	public static void main( String[] args ){
		int k = 60;
		String sourceFile = "data/example.sift";
		String outFile ="data/out.txt";
		String objectFile = "data/kmeans_model.obj";

		new kmeansCreateDictionary().createDictionary(k, sourceFile, outFile, objectFile);
    }

}