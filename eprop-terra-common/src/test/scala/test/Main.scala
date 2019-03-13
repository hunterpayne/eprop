
package test

import org.eprop.CommonFixture

import org.terra.common._
import electro._
import energy.{ WattsPerCubicMeter => EWattsPerCubicMeter, _ }
import information._
import market._
import mass._
import motion._
import photo._
import radio._
import space._
import thermal._
import time._

object Main extends App with CommonFixture {

  epropSpec
  println("Terra Common eProp tests passed")

  def epropSpec: Unit = {

    assert(container.mass == Some(Kilograms(0.01)))
    assert(container.length == Some(Meters(10.0)))
    assert(container.area == Some(SquareMeters(15.2)))

    assert(
      container2.dimensionless.get * container2.dimensionless.get == 
        Percent(25))

    assert(container2.electricCurrent.get == Milliamperes(100))
    assert(container2.capacitance.get == Farads(7))
    assert(container2.conductivity.get == SiemensPerMeter(6))
    assert(container2.electricCharge.get == Coulombs(5))
    assert(container2.electricPotential.get == Volts(4))
    assert(container2.electricalConductance.get == Siemens(3))
    assert(container2.electricalResistance.get == Kilohms(2))
    assert(container2.inductance.get == Henry(15))
    assert(container2.magneticFlux.get == Webers(14))
    assert(container2.magneticFluxDensity.get == Teslas(13))
    assert(container2.resistivity.get == OhmMeters(12))

    assert(container2.energy.get == Joules(11))
    assert(
      container2.powerDensity.get == EWattsPerCubicMeter(10))
    assert(container2.energyDensity.get == JoulesPerCubicMeter(9))
    assert(container2.energyAreaDensity.get == JoulesPerSquareMeter(9))
    assert(container2.power.get == Watts(8))
    assert(container2.powerRamp.get == WattsPerHour(7))
    assert(container2.specificEnergy.get == JoulesPerKilogram(6))
    assert(container2.molarEnergy.get == JoulesPerMole(5))

    assert(container2.dataRate.get == BytesPerSecond(7000000))
    assert(container2.information.get == Bytes(100000))

    assert(container2.money.get == USD(1000000))
    assert(container2.employee.get == People(10))
    assert(container2.labor.get == PersonHours(200000))

    assert(container2.areaDensity.get == GramsPerSquareCentimeter(5))
    assert(container2.density.get == KilogramsPerCubicMeter(4))
    assert(container2.mass.get == Grams(3000))
    assert(container2.chemicalAmount.get == Moles(2))
    assert(container2.molarMass.get == KilogramsPerMole(71))
    assert(container2.molarity.get == MolesPerKilogram(71))
    assert(container2.concentration.get == MolesPerCubicMeter(72))
    assert(container2.catalyticActivity.get == Katals(73))

    assert(container2.acceleration.get == MetersPerSecondSquared(35))
    assert(container2.angularAcceleration.get == DegreesPerSecondSquared(34))
    assert(container2.angularVelocity.get == RadiansPerSecond(34))
    assert(container2.force.get == Newtons(33))
    assert(container2.jerk.get == MetersPerSecondCubed(32))
    assert(container2.massFlow.get == KilogramsPerSecond(31))
    assert(container2.momentum.get == NewtonSeconds(30))
    assert(container2.pressureChange.get == PascalsPerSecond(29))
    assert(container2.pressure.get == Bars(28))
    assert(container2.velocity.get == KilometersPerHour(27))
    assert(container2.volumeFlow.get == CubicMetersPerSecond(26))
    assert(container2.yank.get == NewtonsPerSecond(25))
    assert(container2.surfaceTension.get == NewtonsPerMeter(25))
    assert(container2.viscosity.get == PascalSeconds(25))

    assert(container2.illuminance.get == Lux(24))
    assert(container2.luminance.get == CandelasPerSquareMeter(23))
    assert(container2.luminousEnergy.get == LumenSeconds(22))
    assert(container2.luminousExposure.get == LuxSeconds(21))
    assert(container2.luminousFlux.get == Lumens(20))
    assert(container2.luminousIntensity.get == Candelas(19))

    assert(container2.irradiance.get == ErgsPerSecondPerSquareCentimeter(18))
    assert(container2.radiance.get == WattsPerSteradianPerSquareMeter(17))
    assert(container2.spectralIntensity.get == WattsPerSteradianPerMeter(16))
    assert(
      container2.spectralIrradiance.get == 
        ErgsPerSecondPerSquareCentimeterPerAngstrom(9))
    assert(container2.spectralPower.get == WattsPerMeter(15))
    assert(container2.activity.get == Becquerels(21))
    assert(container2.particleFlux.get == BecquerelsPerSquareMeterSecond(22))
    assert(container2.dose.get == Sieverts(23))
    assert(container2.areaTime.get == SquareMeterSeconds(24))
    assert(container2.absorbedDose.get == Grays(25))

    assert(container2.angle.get == Degrees(14))
    assert(container2.length.get == Meters(13))
    assert(container2.area.get == SquareMeters(12))
    assert(container2.volume.get == CubicMeters(11))
    assert(container2.solidAngle.get == SquareRadians(10))
    assert(container2.specificVolume.get == CubicMetersPerKilogram(11))
    assert(container2.molarVolume.get == CubicMetersPerMole(11))

    assert(container2.temperature.get == Celsius(0.0))
    assert(container2.thermalCapacity.get == JoulesPerKelvin(8))

    assert(container2.time.get == Seconds(7))
    assert(container2.frequency.get == Hertz(6))
    assert(container2.timeSquared.get == SecondsSquared(5))
  }
}
