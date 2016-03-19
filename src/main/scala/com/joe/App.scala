package com.joe

/**
 * Hello world!
 *
 */
object WebsiteAnalyzer {

  private var urlpage: List[String] = Nil

  def reportPageAccess(pageUrl: String) = {
    urlpage =  pageUrl :: urlpage
  }

  def getTopNPages(n: Int) = {

    // create key value pairs

    val kv = urlpage.groupBy(_.toString).map(urlc=> (urlc._1, urlc._2.size)).toList.sortBy(- _._2)
    if (n > kv.length) {
      println("Not enough elements")
      Nil
    } else {
      kv.take(n).map(_._1)
    }
  }

  def generateRandomURLs(count: Int): List[String] = {
    val websiteBaseURL = "https://www.monitoringsite.com/"
    val r = new scala.util.Random
    val pageExt = ".html"

    var listURL: List[String] = Nil

    (1 to count).foreach(_ => {
      import scala.util.Random
      val sb = new StringBuilder
      sb.append(websiteBaseURL)

      Random.alphanumeric.take(10).foreach(sb.append(_))
      //(1 to 10).foreach(sb.append(Random.alphanumeric.take(1)))
      sb.append(pageExt)
      listURL = sb.toString :: listURL
    })

    listURL
  }
  def main(args: Array[String]) = {

    reportPageAccess("url1")
    reportPageAccess("url2")
    reportPageAccess("url2")
    reportPageAccess("url4")
    reportPageAccess("url2")
    reportPageAccess("url2")
    reportPageAccess("url2")
    reportPageAccess("url1")
    reportPageAccess("url3")
    reportPageAccess("url3")
    reportPageAccess("url3")

    generateRandomURLs(10).foreach(reportPageAccess)

    getTopNPages(10).foreach(println)

  }

}
