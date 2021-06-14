// Importing libraries
import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class EOReducer extends MapReduceBase implements Reducer<Text,
								IntWritable, Text, IntWritable> {

	@Override
	// Reduce Function
	public void reduce(Text key, Iterator<IntWritable> value,
	OutputCollector<Text, IntWritable> output, Reporter rep)

	throws IOException
	{

		int sum = 0;
		if (key.equals("Number"))
		{
			while (value.hasNext())
			{
				IntWritable i = value.next();
				sum += i.get();

			}
		}
		output.collect(key, new IntWritable(sum));
	}
}
