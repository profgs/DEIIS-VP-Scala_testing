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
import org.apache.uima.jcas.JCas;
*/

public class VWTranslator{

	/*public class VWTranslator extends JCasAnnotator_ImplBase{
	
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {*/

	public static void main( String[] args )
    {
		String sourceFile = "data/testeg.sift";
		String objectFile ="data/kmeans_model.obj";

		new visualWordsTranslator().getVW(sourceFile, objectFile);
    }

}