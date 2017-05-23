package com.launcher.test

import android.app.Activity
import android.view.{LayoutInflater, View, ViewGroup}

trait TypedViewHolder[T <: View] {
  val rootViewId: Int
  val rootView: T
}

trait TypedViewHolderFactory[T <: TypedLayout[_]] {
  type V <: View
  type VH <: TypedViewHolder[V]
  def create(view: V): VH
}

object TypedViewHolderFactory {
  implicit val main_ViewHolderFactory: TypedViewHolderFactory[TR.layout.main.type] { type VH = TypedViewHolder.main } = new TypedViewHolderFactory[TR.layout.main.type] {
    type V = android.widget.FrameLayout
    type VH = TypedViewHolder.main
    def create(v: V): TypedViewHolder.main = TypedViewHolder.main(v)
  }
}

object TypedViewHolder {
  def setContentView(activity: Activity, layout: TypedLayout[_])
  (implicit ev: TypedViewHolderFactory[layout.type]): ev.VH = {
    val contentView = activity.getWindow.getDecorView.findViewById(
      android.R.id.content).asInstanceOf[ViewGroup]
    val holder = inflate(activity.getLayoutInflater, layout, contentView, false)
    activity.setContentView(holder.rootView, holder.rootView.getLayoutParams)
    holder.asInstanceOf[ev.VH] // harmless cast, appease intellij
  }

  def inflate(inflater: LayoutInflater, layout: TypedLayout[_], parent: ViewGroup, attach: Boolean)
  (implicit ev: TypedViewHolderFactory[layout.type]): ev.VH = {
    ev.create(inflater.inflate(layout.id, parent, attach).asInstanceOf[ev.V])
  }
  def from(view: View, layout: TypedLayout[_])
  (implicit ev: TypedViewHolderFactory[layout.type]): ev.VH = {
    val vh = view.getTag(layout.id)
    if (vh == null) throw new IllegalStateException("ViewHolder not set for " + layout)
    vh.asInstanceOf[ev.VH]
  }
  final case class main(rootView: android.widget.FrameLayout) extends TypedViewHolder[android.widget.FrameLayout] {
    val rootViewId = -1
    rootView.setTag(R.layout.main, this)
    lazy val text = rootView.findViewById(R.id.text).asInstanceOf[android.widget.TextView]

  }
}
