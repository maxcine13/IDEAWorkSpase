package http
import org.apache.spark.sql._
import spark._
import _root_.utils.Constants

object readJson {

  def main(args: Array[String]): Unit = {
//    readJson
    val conf = SparkSession.builder().appName("testHttp").getOrCreate()
    val sql = conf.sqlContext
    val df = sql.read.jdbc(Constants.url,Constants.table,Constants.connectionProperties)
    val json = df.select("id","user_name","diff","name")
    //    readJson(df,1)
    try {

      Spark.port(7188)
      Spark.get("/skbJson",(req,resp)=>new Route {
        override def handle(request: Request, response: Response): AnyRef = {
          readJson(json,0)
        }
      })

      Spark.get("/hello", new Route {
        override def handle(request: Request, response: Response): AnyRef = {
          //val s= request.queryParams("page").toInt
          "hello ,scala spark"
        }
      })
    } catch {
      case e:Exception =>println("server run fail"+e)
    }
  }
  def readJson(json:DataFrame, page:Int):String={
    json.cache()
    val json1 = json.repartition(12).toJSON.collect()
    var result="["
    json1.foreach(x=>{
      result+=x+","
    })
    result.substring(0,result.length-1)+"]"
  }
}
