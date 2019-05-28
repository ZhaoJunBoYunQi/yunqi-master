package com.yunqi.chapter01

/**
  * @author: yunqi
  * @createdTime: 2019/5/28
  *               描述 
  */
class Node {

  var id: Int = _
  var name: String = _
  var age: Int = _
  var next: Node = null


  def this(id: Int, name: String, age: Int) {
    this
    this.id = id
    this.name = name
    this.age = age
  }


  override def toString = s"Node($id, $name, $age)"
}
