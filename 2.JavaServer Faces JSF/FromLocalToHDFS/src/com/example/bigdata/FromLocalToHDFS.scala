package com.example.bigdata
import com.alvinalexander.accesslogparser._
import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}
object FromLocalToHDFS {
  def main(args: Array[String]) {
    if (args.length < 2) {
      System.err.println("Usage: <localDirectory> <hdfsDirectory>")
      System.exit(1)
    }
    val sparkConf = new SparkConf().setAppName("FromLocalToHDFS")
    val ssc = new StreamingContext(sparkConf, Seconds(1))
    val parser = new AccessLogParser
    val logLines = ssc.textFileStream("file://" + args(0))
    val logRecords = logLines.map(line => parser.parseRecord(line)).
      filter(rec => rec.isDefined).map(rec => rec.get).
      map(rec => (rec.clientIpAddress, rec.dateTime, rec.request, rec.httpStatusCode, rec.bytesSent))
    logRecords.saveAsObjectFiles(args(1) + "/apacheLog", "obj")
    ssc.start()
    ssc.awaitTermination()
  }
}