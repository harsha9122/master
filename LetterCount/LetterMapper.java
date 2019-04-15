import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class LetterMapper
        extends Mapper<LongWritable, Text, Text, IntWritable> {

    private final static IntWritable write = new IntWritable(1);
        private Text data = new Text();

        @Override
        protected void map(LongWritable key, Text value, Context context)
                throws IOException,
                InterruptedException {
            StringTokenizer string = new StringTokenizer(value.toString());
            while (string.hasMoreTokens()) {
                String str = (string.nextToken().replaceAll("[^a-zA-Z]", "").toLowerCase());
                for (int i = 0; i < str.length(); i++) {
                    data.set(new byte[]{
                            (byte) str.charAt(i)
                    });

                    context.write(data, write);
                }
            }
        }
}
