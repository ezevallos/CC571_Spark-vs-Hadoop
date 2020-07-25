package wordcount;

import java.io.IOException;
import java.util.StringTokenizer;

import org.w3c.dom.Text;;

public class WordCount {
    public static class Map extends Mapper<LongWritable, Text, Text, IntWritable>{
        public void map(LongWritable key, Text value, Context context) throws IOException,InterruptedException {
            String line = value.toString();
            StringTokenizer tokenizer = new StringTokenizer(line);

            while(tokenizer.hasMoreTokens()) {
                value.set(tokenizer.nextToken());
                context.write(value, new IntWritable(1));
            }
        }
    }
    public static class Reduce extends Reducer<Text,IntWritable,Text,IntWritable>{
        public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException,InterruptedException {
            int sum=0;
            for(IntWritable x: values) {
                sum+=x.get();
            }
            context.write(key, new IntWritable(sum));
        }
    }

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();

        Job job = new Job(conf,"myWordCount");

        job.setJarByClass(WordCount.class);
        job.setMapperClass(Map.class);
        job.setReducerClass(Reduce.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        outputPath.getFileSystem(conf).delete(outputPath);
    }
}