package com.krishna.java;


import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class SparkDriverProgram {
    public static void main(String[] args) {

        /*Define spark configuration*/
        SparkConf conf = new SparkConf().setAppName("firstsparkapp").setMaster(args[0]);

        /*Create spark context with config*/
        JavaSparkContext sc = new JavaSparkContext(conf);

        //Create RDD from Log File
        // Each line becomes a record in RDD
        JavaRDD<String> dataset = sc.textFile("/media/krishna/1ACE190BCE18E135/Programming/repository/github/practice-workspace/java-spark/src/main/resources/apache-log04-aug-31-aug-2011-nasa.log");
        System.out.println("Total lines in file" + dataset.count());

        JavaRDD<Integer> integerDataset = dataset.map(String::length);
        System.out.println("Total chars in file" + integerDataset.reduce((a, b) -> a + b));

        System.out.println("Total lines with .html" + dataset.filter(data -> data.contains("krishna")).count());

        System.out.println("Total lines with .gif" + dataset.filter(data -> data.contains(".gif")).count());

        sc.close();

    }
}
