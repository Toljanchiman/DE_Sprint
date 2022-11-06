
//scala 2.13.1

object Rextester extends App {

   //1.1 выводит фразу «Hello, Scala!» справа налево
      val s = "Hello, Scala!"
      println((for(i <- s.length - 1 to 0 by -1) yield s(i)).mkString)
      //for (elem <- it) println(elem)


  //1.2 переводит всю фразу в нижний регистр
       println(s.toLowerCase())


   //1.3. удаляет символ !
       val res = s.replace("!", "")
       println(res)
    
    
   //1.4 добавляет в конец фразы «and goodbye python!»
       println(s.concat(" and goodbye python!"))
   
   
   //2.1
   //Напишите программу, которая вычисляет ежемесячный оклад сотрудника после вычета налогов. На вход вашей программе подается 
   //значение годового дохода до вычета налогов, размер премии – в процентах от годового дохода и компенсация питания.
    
    
    
    
    
    
    
    
    
    
    
    
    
 }
