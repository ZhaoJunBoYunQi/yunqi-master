package com.yunqi.chapter01

/**
  * @author: yunqi
  * @createdTime: 2019/5/28
  *               描述 
  */
object ListMain {
  def main(args: Array[String]): Unit = {
    val  node = new Node(1, "yunqi", 23)
    node.id = 2
    println(node.toString)
  }
}
