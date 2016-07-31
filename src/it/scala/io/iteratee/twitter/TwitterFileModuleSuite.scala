package io.iteratee.twitter

import cats.Eq
import com.twitter.conversions.time._
import io.catbird.util.Rerunnable
import io.iteratee.tests.files.FileModuleSuite

class TwitterFileModuleSuite extends FileModuleSuite[Rerunnable] with DefaultFuturePoolTwitterModule {
  def monadName: String = "Rerunnable"

  implicit def eqF[A: Eq]: Eq[Rerunnable[A]] = Rerunnable.rerunnableEqWithFailure[A](2.seconds)
}
