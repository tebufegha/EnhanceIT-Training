import scala.collection.mutable.ListBuffer
import scala.io.Source

object CountCountries {

def main(args: Array[String]): Unit =
{
  val CountryList: List[String] = List("China" , "Cuba", "-1", "Cuba", "-1", "-1", "Cuba", "Germany", "Germany", "China")
  val CountryList2: List[String] = List("Bolivia","-1","-1","Cuba","China","Cuba","Argentina","Bolivia","China","-1")
  var CountryMap: Map[String,String] = Map()
  def FormatList(officiallist:List[String]): Unit =
  {
    val returnList: ListBuffer[String] = ListBuffer()
    var count: ListBuffer[Integer] = ListBuffer()
    val countString: ListBuffer[String] = ListBuffer()
    for (x <- 0 to officiallist.length -1)
    {
      if (returnList.contains(officiallist(x)))
        {
          var index:Int = returnList.indexOf(officiallist(x))
          count(index) = count(index) + 1
        }
      else
      {
        returnList += officiallist(x)
        count += 1
      }
    }
    for (j <- 0 to count.length - 1)
    {
      countString += count(j).toString
      CountryMap += (returnList(j) -> countString(j))
    }

    var MapArray :Array[(String,String)] =  CountryMap.toArray
    scala.util.Sorting.quickSort(MapArray)
    for (s <- 0 to MapArray.length - 1)
      {
        if (MapArray(s)._1.matches("^\\-?[1-9]\\d{0,2}(\\.\\d*)?$"))
          {
            MapArray(s)= null
          }
      }
    for (c <- 0 to MapArray.length-1)
      {
        print(MapArray(c))
      }

  }
  FormatList(CountryList)
  print("\nEnd of list 1")
  print("\n")
  FormatList(CountryList2)
  print("\nEnd of List 2")
}
}
