package ru.smak

import ru.smak.gui.MainWindow
import ru.smak.polynoms.Deverentive
import ru.smak.polynoms.Lagrange
import ru.smak.polynoms.Newton
import ru.smak.polynoms.Polynom

fun main(){
    /*
    val p1 = Polynom(doubleArrayOf(1.0, 0.0, 3.0, 0.0, 0.0))
    val p2 = Polynom(doubleArrayOf(0.0, 0.0, 0.0, 0.0, 0.0))
    val p3 = Polynom(doubleArrayOf(0.0, 0.0, -3.0, 0.0, -1.0))
    val p4 = Polynom(doubleArrayOf(7.0, 0.0, 3.0, 0.0, 0.0))
    val p5 = Polynom(doubleArrayOf(-1.0, 0.0, 0.0, 0.0, 0.0))
    val p6 = Polynom(doubleArrayOf(1.0, 0.0, 0.0, 0.0, 0.0))
    println(p1)
    println(p2)
    println(p3)
    println(p4)
    println(p5)
    println(p6)
    println(p1(2.0))
    val l1 = Newton(mutableMapOf(
            0.0 to 2.117 ,
            0.25 to 2.398,
            0.5 to 2.718,
            0.75 to 3.08

    ))
    l1.addNote(1.0 , 3.49)
    println(l1.invoke(1.0))

     */
    /*
    println("Ньютон вычисление")
    val n1 = Newton(mutableMapOf(
            -1.0 to 7.5,
            1.0 to 1.0,
            2.0 to 12.0,
            3.0 to 6.0
    ))
    println(n1)
    val n2 = Newton(mutableMapOf(
            -1.0 to 7.5,
            1.0 to 1.0
    ))
    println(n2)
    println("Добавляем точку последнюю")
    n2.addNote(2.0,12.0)
    println(n2)
    val n3 = Deverentive(mutableMapOf(
            -1.0 to 7.5,
            1.0 to 1.0
    ))
    println("производный от n2 полином")
    println(n3)
    println("добавим точку в производный класс последнюю")
    n3.addNote(2.0, 12.0)
    println(n3)
    */

    val w = MainWindow()
    w.isVisible = true
}
