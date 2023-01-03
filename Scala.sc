
//scala 2.13.1

object task_a extends App {

   //1.1 выводит фразу «Hello, Scala!» справа налево
      val s = "Hello, Scala!"
      //println((for(i <- s.length - 1 to 0 by -1) yield s(i)).mkString)
      //for (elem <- it) println(elem)
      println(s.reverse)


  //1.2 переводит всю фразу в нижний регистр
       println(s.toLowerCase())


   //1.3. удаляет символ !
       val res = s.replace("!", "")
       println(res)
    
    
   //1.4 добавляет в конец фразы «and goodbye python!»
       println(s.concat(" and goodbye python!"))  
    
 }


 //2.1
 //Напишите программу, которая вычисляет ежемесячный оклад сотрудника после вычета налогов. На вход вашей программе подается 
 //значение годового дохода до вычета налогов, размер премии – в процентах от годового дохода и компенсация питания.

object task_b {

  def main(args: Array[String]): Unit = {

    println("Enter gross value:")
    val g: Float = scala.io.StdIn.readFloat()

    println("Enter premium percent:")
    val p: Float = scala.io.StdIn.readFloat()

    println("Enter compensation value:")
    val c: Float = scala.io.StdIn.readFloat()

    var tax: Float = 13
    var base: Float = g - g * ( tax / 100 )
    var base_p: Float = base - base * ( p / 100 )
    var base_c: Float = base_p - c
    var salary: Float = base_c / 12

    println("The monthly salary is " + salary)

  }

}


//2.2
// Напишите программу, которая рассчитывает для каждого сотрудника отклонение (в процентах) от среднего
// значения оклада на уровень всего отдела. В итоговом значении должно учитываться в большую или меньшую
// сторону отклоняется размер оклада. На вход вышей программе подаются все значения, аналогичные
// предыдущей программе, а также список со значениями окладов сотрудников отдела 100, 150, 200, 80, 120, 75.

object task_c {

  def main(args: Array[String]): Unit = {

    val salaries: Array[Int] = Array(100, 150, 200, 80, 120, 75)

    //Sum using for loop
    var total = 0.0;
    for (i <- 0 to (salaries.length - 1)) {
      total += salaries(i);
    }
    val salary_mean: Double = (total/salaries.length).round
    val salary_percent: Double = (salary_mean/100)

    for (i <- 0 to (salaries.length - 1)) {
      println(s"\nEmployee number: ${i} has salary ${salaries(i)}, which is ${((salaries(i) - salary_mean)/salary_percent).round}% than mean ($salary_mean).");
    }


  }

}


//2.3
// Попробуйте рассчитать новую зарплату сотрудника, добавив(или отняв, если сотрудник плохо себя вел)
// необходимую сумму с учетом результатов прошлого задания. Добавьте его зарплату в список и вычислите
// значение самой высокой зарплаты и самой низкой.

import scala.io.StdIn.readLine
import scala.util.control.Breaks.break

object task_d {

  def main(args: Array[String]): Unit = {

    val salaries: Array[Int] = Array(100, 150, 200, 80, 120, 75)

    val salary_total: Float = salaries.sum
    val salary_mean: Double = (salary_total/salaries.length).round

    while(true) {

      // Вывод информации об уровне зарплат
      for (i <- 0 to (salaries.length - 1)) {
        println(s"Employee number: ${i} has salary ${salaries(i)}, which is ${(salaries(i) - salary_mean)} than mean ($salary_mean).");
      }

      println("Do you want to change some salary? (Y/N)")
      val answer: String = readLine()

      if (answer.toLowerCase == 'n'.toString) {
        println("Exit.")
        break
      }

      // Изменение зарплаты
      println("Choose employee:")
      val employee: Int = scala.io.StdIn.readInt()

      if (employee > salaries.length) {
        println(s"Employee num must be at 0 - ${salaries.length - 1}. Exit.")
        break
      }

      println("Change salary:")
      val ch_salary: Float = scala.io.StdIn.readFloat()

      salaries(employee) = salaries(employee) + ch_salary.toInt

      // Вычисление максимальной и минимальной зарплаты
      println(s"\nMax salary ${salaries.max}")
      println(s"Min salary ${salaries.min}")

    }

  }

}

//2.4
// Также в вашу команду пришли два специалиста с окладами 350 и 90 тысяч рублей. Попробуйте отсортировать
// список сотрудников по уровню оклада от меньшего к большему.

import scala.io.StdIn.readLine

object task_e {

  def main(args: Array[String]): Unit = {

    var salaries: Array[Int] = Array(100, 150, 200, 80, 120, 75, 350, 90)

    // Дополнительно можно добавить еще одного сотрудника
    println("Do you want to add a salary? (Y/N)")
    val answer: String = readLine()

    if (answer.toLowerCase == 'y'.toString) {
      println("Enter salary:")
      val new_salary: Int = scala.io.StdIn.readInt()

      salaries = salaries :+ new_salary

    }

    salaries = salaries.sorted

    // Вывод информации об уровне зарплат
    println(s"Sorted salaries:");
    for (salary <- salaries) {
      println(s"Salary: ${salary}.");
    }

  }

}


//2.5
//  Кажется, вы взяли в вашу команду еще одного сотрудника и предложили ему оклад 130 тысяч.
//  Вычислите самостоятельно номер сотрудника в списке так, чтобы сортировка не нарушилась и добавьте его на это место.

import scala.io.StdIn.readLine

object task_f {

  def main(args: Array[String]): Unit = {

    var salaries: Array[Int] = Array(100, 150, 200, 80, 120, 75, 350, 90)

    salaries = salaries.sorted

    // Добавление еще одного сотрудника
    println("Do you want to add an employee? (Y/N)")
    val answer: String = readLine()

    if (answer.toLowerCase == 'y'.toString) {
      println("Enter salary:")
      val new_salary: Int = scala.io.StdIn.readInt()

      // Вычисление индекса для вставки
      val indx: Int = salaries.indexWhere(element => element > new_salary)
      // Добавление нового значения в массив
      salaries = salaries.patch(indx, Array(new_salary), 0)
    }

    // Вывод информации об уровне зарплат
    println(s"Sorted salaries:");
    for (salary <- salaries) {
      println(s"Salary: ${salary}.");
    }

  }

}


//2.6
// Попробуйте вывести номера сотрудников из полученного списка, которые попадают под категорию middle.
// На входе программе подается «вилка» зарплаты специалистов уровня middle.
import scala.io.StdIn.{readInt, readLine}

object task_g {

  def main(args: Array[String]): Unit = {

    var salaries: Array[Int] = Array(100, 150, 200, 80, 120, 75, 350, 90, 130)

    // Сортировка уровня зарплат
    salaries = salaries.sorted

    // Пользовательский ввод для вилки зарплат уровня middle
    println("Enter middle min salary:")
    val middle_min: Int = readInt()
    println("Enter middle max salary:")
    val middle_max: Int = readInt()

    // Вывод номеров специалистов уровня middle
    for (i <- 0 to (salaries.length - 1)) {
      if ((salaries(i) >= middle_min) && (salaries(i) <= middle_max))
        println(s"Employee number: ${i} has salary ${salaries(i)}.");
    }

  }

}


//2.7
// Однако наступил кризис и ваши сотрудники требуют повысить зарплату. Вам необходимо проиндексировать
// зарплату каждого сотрудника на уровень инфляции – 7%

object task_h {

  def main(args: Array[String]): Unit = {

    var salaries: Array[Int] = Array(100, 150, 200, 80, 120, 75, 350, 90, 130)

    val indexing: Int = 7

    // Индексация
    for (i <- 0 to (salaries.length - 1)) {
      println(s"Employee number: ${i} has old salary ${salaries(i)}.");
      salaries(i) = salaries(i) + ( salaries(i) * indexing / 100 ).toInt
      println(s"Employee number: ${i} has new salary ${salaries(i)}.");
    }

  }

}
