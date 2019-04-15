import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
//import IntWritable3Values;

public class MaxTemperatureReducer extends Reducer<Text, IntWritable, Text, IntWritable3Values> {
	@Override
	public void reduce(Text key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {
			
		int maxValue = Integer.MIN_VALUE;
		int minValue = Integer.MAX_VALUE;
		int avgValue;
		int sum = 0;
		int count = 0;
		
		
		for (IntWritable value : values) {
		
			sum = sum + value.get();
			maxValue = Math.max(maxValue, value.get());
			minValue = Math.min(minValue, value.get());
			count++;
			
		}
		avgValue = sum/count;
		
		//context.write(key, new IntWritable(maxValue) + " " + new IntWritable(minValue) + " " + new IntWritable(avgValue));
		context.write(key, new IntWritable3Values(maxValue,minValue,avgValue));
	}
}

