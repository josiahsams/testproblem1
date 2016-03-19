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

    getTopNPages(31).foreach(println)

  }

}
