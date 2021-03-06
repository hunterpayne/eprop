
package org.eprop

import org.junit.BeforeClass
import org.junit.runner.RunWith
import org.junit.runners.{ Suite => JUnit4Suite }

import com.carrotgarden.sjs.junit.{ 
  LinkerImpl, SuiteSetupImpl, TestInit, ScalaJS_ScalatestSuite }
import ClassicSuiteTest._

object Linker extends LinkerImpl
class SuiteSetup extends SuiteSetupImpl(Linker)
object SuiteSetup extends SuiteSetup

@RunWith(classOf[JUnit4Suite])
@JUnit4Suite.SuiteClasses(Array(classOf[JSSuite]))
class ClassicSuiteTest

object ClassicSuiteTest {

  @BeforeClass
  def setup: Unit = TestInit.setup(SuiteSetup)

  @RunWith(classOf[ScalaJS_ScalatestSuite])
  @JUnit4Suite.SuiteClasses(Array(classOf[TerraClassicSpec]))
  class JSSuite
}
